package com.rentcar.webapp.service;

import com.rentcar.webapp.Exception.NotExistVehicleException;
import com.rentcar.webapp.entity.Vehicle;
import com.rentcar.webapp.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Transactional
    public Vehicle create(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Transactional
    public void delete(Vehicle vehicle) {
        vehicleRepository.delete(vehicle);
    }

    //-------------------------------------------------------------------------------------------------------------
    @Transactional
    public Vehicle update(Vehicle vehicle) {

        Optional<Vehicle> ve = vehicleRepository.findById(vehicle.getVehicleId());
        if (!ve.isPresent())
            throw new NotExistVehicleException("Il veicolo non è presente nel database");

        if (!Objects.isNull(vehicle.getBrand())) ve.get().setBrand(vehicle.getBrand());
        if (!Objects.isNull(vehicle.getLicensePlate())) ve.get().setLicensePlate(vehicle.getLicensePlate());
        if (!Objects.isNull(vehicle.getType())) ve.get().setType(vehicle.getType());
        if (!Objects.isNull(vehicle.getRegistrationYear())) ve.get().setRegistrationYear(vehicle.getRegistrationYear());
        if (!Objects.isNull(vehicle.getModel())) ve.get().setModel(vehicle.getModel());
        if (!Objects.isNull(vehicle.getRentalsList())) ve.get().setRentalsList(vehicle.getRentalsList());

        vehicleRepository.save(ve.get());
        return ve.get();
    }
    //--------------------------------------------------------------------------------------------------------------
    public List<Vehicle> all() {
        return vehicleRepository.findAll();
    }

    //-------------------------------------------------------------------------------------------------------
    public Vehicle find(Long id) {
        return vehicleRepository.getOne(id);
    }

}
