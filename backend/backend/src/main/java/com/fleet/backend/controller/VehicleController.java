package com.fleet.backend.controller;

import com.fleet.backend.dto.VehicleRequestDTO;
import com.fleet.backend.dto.VehicleResponseDTO;
import com.fleet.backend.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    // CREATE
    @PostMapping
    public ResponseEntity<VehicleResponseDTO> criarVehicle(
            @Valid @RequestBody VehicleRequestDTO dto
    ) {
        return ResponseEntity.ok(vehicleService.criarVehicle(dto));
    }

    // LIST
    @GetMapping
    public List<VehicleResponseDTO> listarVehicles() {
        return vehicleService.listarVehicles();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponseDTO> buscarVehicle(@PathVariable Long id) {

        return vehicleService.buscarVehicle(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<VehicleResponseDTO> atualizarVehicle(
            @PathVariable Long id,
            @Valid @RequestBody VehicleRequestDTO dto
    ) {
        return ResponseEntity.ok(vehicleService.atualizarVehicle(id, dto));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVehicle(@PathVariable Long id) {
        vehicleService.deletarVehicle(id);
        return ResponseEntity.noContent().build();
    }
}