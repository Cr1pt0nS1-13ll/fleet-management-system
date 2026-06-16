package com.fleet.backend.service;

import com.fleet.backend.entity.Vehicle;
import com.fleet.backend.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> listarVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle criarVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Optional<Vehicle> buscarVehicle(Long id) {
        return vehicleRepository.findById(id);
    }

    public void deletarVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

    public Vehicle atualizarVehicle(Long id, Vehicle vehicle) {

        Optional<Vehicle> existente = vehicleRepository.findById(id);

        if (existente.isPresent()) {
            Vehicle v = existente.get();

            v.setNome(vehicle.getNome());
            v.setPlaca(vehicle.getPlaca());
            v.setModelo(vehicle.getModelo());

            return vehicleRepository.save(v);
        }

        return null;
    }
}