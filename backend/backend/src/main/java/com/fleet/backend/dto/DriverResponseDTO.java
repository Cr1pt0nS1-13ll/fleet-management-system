package com.fleet.backend.dto;

import java.util.List;
import com.fleet.backend.dto.VehicleResponseDTO;

public class DriverResponseDTO {

    private Long id;
    private String name;
    private String licenseNumber;
    private List<VehicleResponseDTO> vehicles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public List<VehicleResponseDTO> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleResponseDTO> vehicles) {
        this.vehicles = vehicles;
    }
}