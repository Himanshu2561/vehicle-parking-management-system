package com.app.service;
import com.app.pojo.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    public List<Vehicle> getAllVehicles();  // method to return all the vehicles
    public void removeVehicleById(int ticketId);

    public Optional<Vehicle> searchById(int vehicleId);

}