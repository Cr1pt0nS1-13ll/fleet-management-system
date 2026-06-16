package com.fleet.backend.controller;

import com.fleet.backend.entity.Driver;
import com.fleet.backend.repository.DriverRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    private final DriverRepository repository;

    public DriverController(DriverRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Driver create(@RequestBody Driver driver) {
        return repository.save(driver);
    }

    @GetMapping
    public List<Driver> list() {
        return repository.findAll();
    }
}