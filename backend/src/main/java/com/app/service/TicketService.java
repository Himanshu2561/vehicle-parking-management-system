package com.app.service;

import com.app.pojo.Ticket;
import com.app.pojo.Vehicle;

import java.util.Optional;

public interface TicketService {
    public Ticket parkVehicle(Vehicle newVehicle);// method to park the new vehicle
    public Optional<Ticket> getById(Integer id);
}
