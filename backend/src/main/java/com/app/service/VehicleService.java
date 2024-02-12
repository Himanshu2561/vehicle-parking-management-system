package com.app.service;
import com.app.pojo.Vehicle;

import java.util.List;

public interface VehicleService {
    public List<Vehicle> getAllVehicles();  // method to return all the vehicles
    public void removeVehicleByTicketId(Integer ticketId);
}