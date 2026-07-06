package com.fleet.backend.controller;

import com.fleet.backend.dto.DriverRequestDTO;
import com.fleet.backend.dto.DriverResponseDTO;
import com.fleet.backend.service.DriverService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    // CREATE
    @PostMapping
    public ResponseEntity<DriverResponseDTO> create(
            @Valid @RequestBody DriverRequestDTO dto
    ) {
        return ResponseEntity.ok(driverService.create(dto));
    }

    // LIST
    @GetMapping
    public List<DriverResponseDTO> list() {
        return driverService.list();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<DriverResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(driverService.findById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<DriverResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody DriverRequestDTO dto
    ) {
        return ResponseEntity.ok(driverService.update(id, dto));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        driverService.delete(id);
        return ResponseEntity.noContent().build();
    }
}