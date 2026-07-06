package com.fleet.backend.service;

import com.fleet.backend.dto.DriverRequestDTO;
import com.fleet.backend.dto.DriverResponseDTO;
import com.fleet.backend.dto.VehicleResponseDTO;
import com.fleet.backend.entity.Driver;
import com.fleet.backend.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    // ENTITY -> RESPONSE DTO
    private DriverResponseDTO toDTO(Driver driver) {

        DriverResponseDTO dto = new DriverResponseDTO();

        dto.setId(driver.getId());
        dto.setName(driver.getName());
        dto.setLicenseNumber(driver.getLicenseNumber());

        if (driver.getVehicles() != null) {
            dto.setVehicles(
                    driver.getVehicles().stream().map(v -> {

                        VehicleResponseDTO vdto = new VehicleResponseDTO();
                        vdto.setId(v.getId());
                        vdto.setNome(v.getNome());
                        vdto.setPlaca(v.getPlaca());
                        vdto.setModelo(v.getModelo());

                        if (v.getDriver() != null) {
                            vdto.setDriverId(v.getDriver().getId());
                        }

                        return vdto;

                    }).collect(Collectors.toList())
            );
        }

        return dto;
    }

    // DTO -> ENTITY
    private Driver toEntity(DriverRequestDTO dto) {

        Driver driver = new Driver();
        driver.setName(dto.getName());
        driver.setLicenseNumber(dto.getLicenseNumber());

        return driver;
    }

    // CREATE
    public DriverResponseDTO create(DriverRequestDTO dto) {

        Driver saved = driverRepository.save(toEntity(dto));

        return toDTO(saved);
    }

    // LIST
    public List<DriverResponseDTO> list() {

        return driverRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // FIND BY ID
    public DriverResponseDTO findById(Long id) {

        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver não encontrado"));

        return toDTO(driver);
    }

    // DELETE
    public void delete(Long id) {
        driverRepository.deleteById(id);
    }

    // UPDATE
    public DriverResponseDTO update(Long id, DriverRequestDTO dto) {

        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver não encontrado"));

        driver.setName(dto.getName());
        driver.setLicenseNumber(dto.getLicenseNumber());

        return toDTO(driverRepository.save(driver));
    }
}