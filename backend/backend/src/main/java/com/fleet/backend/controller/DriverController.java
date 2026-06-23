package com.fleet.backend.controller;

import jakarta.validation.Valid;
import com.fleet.backend.entity.Driver;
import com.fleet.backend.repository.DriverRepository;
import org.aspectj.apache.bcel.Repository;
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
    public Driver create(@Valid @RequestBody Driver driver) {
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

    @GetMapping("/{id}")
    public ResponseEntity<Driver> buscarPorId(@PathVariable Long id) {

        Optional<Driver> driver = repository.findById(id);

        if (driver.isPresent()) {
            return ResponseEntity.ok(driver.get());

        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Driver> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody Driver driver
    ){

        Optional<Driver> driverExistente = repository.findById(id);

        if (driverExistente.isPresent()) {

            Driver driverAtualizado = driverExistente.get();

            driverAtualizado.setName(driver.getName());
            driverAtualizado.setLicenseNumber(driver.getLicenseNumber());

            return ResponseEntity.ok(
                    repository.save(driverAtualizado)
            );

        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        if (repository.existsById(id)) {

            repository.deleteById(id);

            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}