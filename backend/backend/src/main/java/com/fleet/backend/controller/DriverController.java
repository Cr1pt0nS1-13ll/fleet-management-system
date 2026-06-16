package com.fleet.backend.controller;

import com.fleet.backend.entity.Driver;
import com.fleet.backend.repository.DriverRepository;
import org.springframework.web.bind.annotation.*;
import com.fleet.backend.entity.Vehicle;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

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

    @GetMapping("/{id}/vehicles")
    public ResponseEntity<List<Vehicle>> listarVeiculosDoMotorista(@PathVariable Long id) {

        Optional<Driver> driver = repository.findById(id);

        if (driver.isPresent()) {
            return ResponseEntity.ok(driver.get().getVehicles());
        }

        return ResponseEntity.notFound().build();
    }
}