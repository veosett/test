package com.example.quote.controller;

import com.example.quote.enitity.*;
import com.example.quote.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Validated
@RestController
@RequestMapping("/quote")
public class QuoteController {
    QuoteService quoteService;


    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @PostMapping("/add")
    public Quote add(@RequestBody Quote quote) {
        return quoteService.save(quote);
    }

    @GetMapping("/getAll")
    public Iterable<Quote> getAll() {
        return quoteService.findAll();
    }

    @PostMapping("/saveAll")
    public Iterable<Quote> getAll(@RequestBody List<Quote> quotes) {
        return quoteService.saveAll(quotes);
    }

    @PostMapping("/save")
    public Quote getAll(@Valid @RequestBody Quote quote) {
        return quoteService.save(quote);
    }

    @GetMapping("/get/{id}")
    public Optional<Quote> get(@PathVariable Long id) {
        return quoteService.findById(id);
    }


    @RequestMapping("/")
    public String index() {
        return "Hello";
    }
}
