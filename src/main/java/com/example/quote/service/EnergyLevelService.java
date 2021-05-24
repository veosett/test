package com.example.quote.service;

import com.example.quote.enitity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.*;

@Service
@Validated
public class EnergyLevelService {
    final EnergyLevelRepository repository;

    @Autowired
    public EnergyLevelService(EnergyLevelRepository repository) {
        this.repository = repository;
    }

    public Optional<EnergyLevel> findById(String isin) {
        return repository.findById(isin);
    }

    public Iterable<EnergyLevel> findAll() {
        return repository.findAll();
    }
}
