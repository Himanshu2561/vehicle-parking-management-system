package com.app.service;

import com.app.dao.SlotRepository;
import com.app.dao.TicketRepository;
import com.app.dao.VehicleRepository;
import com.app.pojo.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImplementation implements VehicleService{

    private VehicleRepository vehicleRepository;
    private TicketRepository ticketRepository;
    private SlotRepository slotRepository;

    @Autowired
    public VehicleServiceImplementation(VehicleRepository vehicleRepository,
                                        TicketRepository ticketRepository,
                                        SlotRepository slotRepository){
        this.vehicleRepository = vehicleRepository;
        this.ticketRepository = ticketRepository;
        this.slotRepository = slotRepository;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Transactional
    @Override
    public void removeVehicleById(int id) {
      vehicleRepository.deleteAllById(id);
       /* Vehicle vehicle = ticket.getVehicle();
        Slots slot = slotRepository.findByVehicleId(vehicle.getId());

        // Delete the associated slot and ticket
        if (slot != null) {
            slotRepository.delete(slot);
        }
        ticketRepository.delete(ticket);
        // delete the associated vehicle
        vehicleRepository.delete(vehicle);*/
    }

    @Override
    public Optional<Vehicle> searchById(int vehicleId) {
        return vehicleRepository.findById(vehicleId);
    }


}