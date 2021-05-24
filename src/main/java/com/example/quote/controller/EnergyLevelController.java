package com.example.quote.controller;

import com.example.quote.enitity.*;
import com.example.quote.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 TODO add java docs
 */
@Validated
@RestController
@RequestMapping("/energyLevel")
public class EnergyLevelController {
    EnergyLevelService service;

    @Autowired
    public EnergyLevelController(EnergyLevelService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public Iterable<EnergyLevel> getAll() {
        return service.findAll();
    }

    @GetMapping("/get/{isin}")
    public Optional<EnergyLevel> get(@PathVariable String isin) {
        return service.findById(isin);
    }

    @RequestMapping("/")
    public String index() {
        return "Hello";
    }
}
