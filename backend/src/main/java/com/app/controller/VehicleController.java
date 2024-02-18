package com.app.controller;

import java.util.List;
import java.util.Optional;

import com.app.dto.AmountMessageDto;
import com.app.dto.ErrorResponse;
import com.app.dto.TicketDto;
import com.app.dto.VehicleEntriesDto;
import com.app.pojo.Ticket;
import com.app.service.AmountService;
import com.app.service.TicketService;
import com.app.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.pojo.Vehicle;

@RestController
@CrossOrigin
@RequestMapping("api/vehicles")
public class VehicleController {

    // getting the instances of the service layers
    private VehicleService vehicleService;
    private TicketService ticketService;
    private AmountService amountService;

    // adding the dependencies using constructor injection method
    @Autowired
    public VehicleController(VehicleService vehicleService, TicketService ticketService,
                             AmountService amountService) {
        System.out.println("inside the vehicle conroller");
        this.vehicleService = vehicleService;
        this.ticketService = ticketService;
        this.amountService = amountService;
    }


    @PostMapping("/addVehicle")
    public ResponseEntity<?> addNewVehicle(@RequestBody Vehicle vehicle) {
        System.out.println("in add New Vehicle" + vehicle.toString());
        try {
            Ticket ticket = new Ticket();
            ticket = ticketService.parkVehicle(vehicle);
            TicketDto obj = new TicketDto(ticket.getId(), ticket.getDate(), ticket.getVehicleNumber(), ticket.getSlotNumber(), ticket.getType());
            return new ResponseEntity<>(obj, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            System.out.println("error occured " + e);
            return new ResponseEntity<>(new ErrorResponse("Adding vehicle failed", e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {

        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        vehicles.forEach(System.out::println); // printing the vehicle list
        return ResponseEntity.ok(vehicles.reversed());
    }

    @DeleteMapping("/removeVehicle/{id}")
    public ResponseEntity<?> removeVehicleById(@PathVariable int id) {
        System.out.println("in getVehicle " + id);
        try {
            int amount = returnAmount(id);
            vehicleService.removeVehicleById(id);

            AmountMessageDto response = new AmountMessageDto("vehicle removed successfully", amount);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RuntimeException e) {
            System.out.println("error occured " + e);
            return new ResponseEntity<>(new ErrorResponse("Adding vehicle failed", e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> searchById(@PathVariable int id) {
        System.out.println("in getVehicle " + id);
        Vehicle newVehicle = null;
        try {
            Optional<Vehicle> vehicle = vehicleService.searchById(id);
            if (vehicle.isPresent()) {
                newVehicle = vehicle.get();
                return new ResponseEntity<>(newVehicle, HttpStatus.OK);
            } else return new ResponseEntity<>("vehicle Not found", HttpStatus.NOT_FOUND);
        } catch (RuntimeException e) {
            System.out.println("error occured " + e);
            return new ResponseEntity<>("error occured", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/totalEntries")
    public ResponseEntity<?> getTotalVehicleEntries() {
        try {
            int vehicles = vehicleService.getAllVehicles().stream().toList().size();
            int vehiclesFromAmountTable = amountService.getTotalNumberOfVehicles();
            int totalNumberOfVehicles = vehicles + vehiclesFromAmountTable;
            VehicleEntriesDto dtoResponse = new VehicleEntriesDto("Total Vehicle Entries", totalNumberOfVehicles);
            return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
        } catch (RuntimeException e) {
            System.out.println("error occured " + e);
            return new ResponseEntity<>("error occured", HttpStatus.BAD_REQUEST);
        }
    }

    public int returnAmount(@PathVariable int vehicleId) {
        return amountService.AmountPerVehicle(vehicleId);
    }


    @GetMapping("/lasSevenDaysAmount")
    public ResponseEntity<?> lastSevenDaysAmount() {
        int amount = amountService.lastSevenDaysAmount();
        AmountMessageDto response = new AmountMessageDto("Last 7 Days Vehicle Amount", amount);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/lasThirtyDaysAmount")
    public ResponseEntity<?> lastThirtyDaysAmount() {
        int amount = amountService.lastThirtyDaysAmount();
        AmountMessageDto response = new AmountMessageDto("Last 30 Days Vehicle Amount", amount);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
