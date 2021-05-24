package com.example.quote.service;

import com.example.quote.enitity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Validated
public class QuoteService {
    final QuoteRepository quoteRepository;
    final EnergyLevelRepository energyLevelRepository;

    @Autowired
    public QuoteService(QuoteRepository quoteRepository, EnergyLevelRepository energyLevelRepository) {
        this.quoteRepository = quoteRepository;
        this.energyLevelRepository = energyLevelRepository;
    }

    public Quote save(Quote quote) {
        return quoteRepository.save(quote);
    }

    public Iterable<Quote> saveAll(List<Quote> quotes) {
        List<EnergyLevel> energyLevels
                = (List<EnergyLevel>) energyLevelRepository.findAllById(quotes.stream().map(Quote::getIsin).collect(Collectors.toList()));
        for (Quote quote : quotes) {
            Optional<EnergyLevel> energyLevel = energyLevels.stream()
                    .filter(it -> it.getIsin().equals(quote.getIsin()))
                    .findFirst();

            double level = energyLevel.map(value -> calcEnergyLevel(quote, value)).orElseGet(() -> calcEnergyLevel(quote));

            energyLevelRepository.save(new EnergyLevel(quote.getIsin(), level));
        }

        return quoteRepository.saveAll(quotes);
    }

    public Optional<Quote> findById(Long id) {
        return quoteRepository.findById(id);
    }

    public Iterable<Quote> findAll() {
        return quoteRepository.findAll();
    }

    private double calcEnergyLevel(Quote quote, EnergyLevel energyLevel) {
        if (quote.getBid() > energyLevel.getLevel()) {
            return quote.getBid();
        }
        if (quote.getAsk() < energyLevel.getLevel()) {
            return quote.getAsk();
        }
        return energyLevel.getLevel();
    }

    private double calcEnergyLevel(Quote quote) {
        if (quote.getBid() == 0) {
            return quote.getAsk();
        }
        return quote.getBid();
    }
}
