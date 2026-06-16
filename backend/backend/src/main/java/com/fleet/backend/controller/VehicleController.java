package com.fleet.backend.controller;

import com.fleet.backend.entity.Vehicle;
import com.fleet.backend.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public List<Vehicle> listarVehicles() {
        return vehicleService.listarVehicles();
    }

    @PostMapping
    public Vehicle criarVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.criarVehicle(vehicle);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> buscarVehicle(@PathVariable Long id) {

        Optional<Vehicle> vehicle = vehicleService.buscarVehicle(id);

        return vehicle.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deletarVehicle(@PathVariable Long id) {
        vehicleService.deletarVehicle(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> atualizarVehicle(
            @PathVariable Long id,
            @RequestBody Vehicle vehicle
    ) {

        Vehicle atualizado = vehicleService.atualizarVehicle(id, vehicle);

        if (atualizado != null) {
            return ResponseEntity.ok(atualizado);
        }

        return ResponseEntity.notFound().build();
    }
}