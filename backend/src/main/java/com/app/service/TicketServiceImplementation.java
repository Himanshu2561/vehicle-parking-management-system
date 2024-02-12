package com.app.service;

import com.app.dao.SlotRepository;
import com.app.dao.TicketRepository;
import com.app.dao.VehicleRepository;
import com.app.pojo.Slots;
import com.app.pojo.Ticket;
import com.app.pojo.Vehicle;
import com.app.pojo.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
public class TicketServiceImplementation implements TicketService{

    private TicketRepository ticketRepository;
    private VehicleRepository vehicleRepository;
    private SlotRepository slotRepository;

    @Autowired
    public TicketServiceImplementation(TicketRepository ticketRepository, VehicleRepository vehicleRepository,
                                       SlotRepository slotRepository){
        this.ticketRepository = ticketRepository;
        this.vehicleRepository = vehicleRepository;
        this.slotRepository = slotRepository;
    }

    @Transactional
    @Override
    public Ticket parkVehicle(Vehicle newVehicle){
        Integer slotNumber = allocateSlot1(newVehicle.getVehicleType());

        Vehicle vehicle = new Vehicle();

        vehicle.setVehicleNumber(newVehicle.getVehicleNumber());
        vehicle.setVehicleType(newVehicle.getVehicleType());
        vehicle.setTicketDate(new Date());
        vehicleRepository.save(vehicle);  // saving the vehicle object in the database


        // Create a Slot entity and associate it with the vehicle
        Slots slot = new Slots();
        slot.setSlotNumber(slotNumber);
        slot.setVehicle(vehicle);
        slotRepository.save(slot);

        // Create a Ticket entity and associate it with the vehicle
        Ticket newTicket = generateTicket(vehicle, slot);
        ticketRepository.save(newTicket);

        return newTicket;
    }

    private Integer allocateSlot1(VehicleType vehicleType) {
        // Logic to allocate slot based on vehicle type (considering 100 slots for each type)
        int startSlot = (vehicleType == VehicleType.TWO_WHEELER) ? 1 : 101;
        int endSlot = (vehicleType == VehicleType.TWO_WHEELER) ? 100 : 200;

        for (int i = startSlot; i <= endSlot; i++) {
            if (isSlotAvailable(i)) {
                return i;
            }
        }

        // If no available slot is found, you may throw an exception or handle it as per your requirement
        throw new RuntimeException("No available slots in the specified range");
    }

    private boolean isSlotAvailable(int slotNumber) {
        // Check if the slot is already occupied in the database
        Slots existingSlot = slotRepository.findBySlotNumber(slotNumber);
        return existingSlot == null; // Slot is available if not already occupied
    }

    private Ticket generateTicket(Vehicle vehicle, Slots slot) {
        // Generate a ticket based on the vehicle and allocated slot
        Ticket ticket = new Ticket();
        ticket.setDate(new Date());
        ticket.setVehicleNumber(vehicle.getVehicleNumber());
        //ticket.setVehicle(vehicle);
        ticket.setSlotNumber(slot.getSlotsNumber());
        ticket.setType(vehicle.getVehicleType());

        return ticket;
    }
}
