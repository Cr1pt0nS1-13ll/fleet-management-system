package com.fleet.backend.service;

import com.fleet.backend.dto.VehicleRequestDTO;
import com.fleet.backend.dto.VehicleResponseDTO;
import com.fleet.backend.entity.Driver;
import com.fleet.backend.entity.Vehicle;
import com.fleet.backend.repository.DriverRepository;
import com.fleet.backend.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private DriverRepository driverRepository;

    // DTO -> ENTITY
    private Vehicle toEntity(VehicleRequestDTO dto) {

        Vehicle vehicle = new Vehicle();

        vehicle.setNome(dto.getNome());
        vehicle.setPlaca(dto.getPlaca());
        vehicle.setModelo(dto.getModelo());

        if (dto.getDriverId() != null) {
            Driver driver = driverRepository.findById(dto.getDriverId())
                    .orElseThrow(() -> new RuntimeException("Driver não encontrado"));

            vehicle.setDriver(driver);
        }

        return vehicle;
    }

    // ENTITY -> DTO
    private VehicleResponseDTO toDTO(Vehicle vehicle) {

        VehicleResponseDTO dto = new VehicleResponseDTO();

        dto.setId(vehicle.getId());
        dto.setNome(vehicle.getNome());
        dto.setPlaca(vehicle.getPlaca());
        dto.setModelo(vehicle.getModelo());

        if (vehicle.getDriver() != null) {
            dto.setDriverId(vehicle.getDriver().getId());
        }

        return dto;
    }

    // CREATE
    public VehicleResponseDTO criarVehicle(VehicleRequestDTO dto) {

        Vehicle vehicle = toEntity(dto);

        Vehicle salvo = vehicleRepository.save(vehicle);

        return toDTO(salvo);
    }

    // LIST
    public List<VehicleResponseDTO> listarVehicles() {

        return vehicleRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // FIND BY ID
    public Optional<VehicleResponseDTO> buscarVehicle(Long id) {

        return vehicleRepository.findById(id)
                .map(this::toDTO);
    }

    // DELETE
    public void deletarVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

    // UPDATE
    public VehicleResponseDTO atualizarVehicle(Long id, VehicleRequestDTO dto) {

        Vehicle existente = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle não encontrado"));

        existente.setNome(dto.getNome());
        existente.setPlaca(dto.getPlaca());
        existente.setModelo(dto.getModelo());

        if (dto.getDriverId() != null) {
            Driver driver = driverRepository.findById(dto.getDriverId())
                    .orElseThrow(() -> new RuntimeException("Driver não encontrado"));

            existente.setDriver(driver);
        }

        return toDTO(vehicleRepository.save(existente));
    }
}