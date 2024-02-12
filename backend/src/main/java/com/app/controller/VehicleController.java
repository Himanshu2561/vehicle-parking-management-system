package com.app.controller;

import java.util.List;

import com.app.pojo.Ticket;
import com.app.service.TicketService;
import com.app.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.pojo.Vehicle;
import com.app.service.IVehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

	// getting the instances of the service layers
	private VehicleService vehicleService;
    private TicketService ticketService;

	// adding the dependencies using constructor injection method
	@Autowired
	public VehicleController(VehicleService vehicleService, TicketService ticketService) {
		System.out.println("inside the vehicle conroller");
		this.vehicleService = vehicleService;
        this.ticketService = ticketService;
	}

	/*@GetMapping
	public List<Vehicle> getAllVehicles() {
		return vehicleService.getAllVehicles();
	}

	
	  @PostMapping public Vehicle addNewVehicle(@RequestBody Vehicle obj)
	  { 
		  System.out.println("in add New Vehicle"); 
		  return vehicleService.addVehicle(obj); 
	  }*/




	// code for adding a new vehicle getting all the vehicles and removing the vehicle
	  
	  // generates a newticket with the appropriate slot number allocated to it
	  @PostMapping("/addVehicle")
	  public void addVehicle(@RequestBody Vehicle vehicle){
		  Ticket ticket = ticketService.parkVehicle(vehicle);
		  System.out.println(ticket);
	  }
  
	  @GetMapping("/getVehicles")
	  public List<Vehicle> getAllVehicles(){
		  List<Vehicle> vehicles = vehicleService.getAllVehicles();
		  vehicles.stream().forEach(vehicle -> System.out.println(vehicle)); // printing the vehicle list
		  return vehicles;
	  }
  
	  @DeleteMapping("/removeVehicle/{ticketId}")
	  public ResponseEntity<String> removeVehicleByTicketId(@PathVariable Integer ticketId) {
		  try {
			  vehicleService.removeVehicleByTicketId(ticketId);
			  return ResponseEntity.ok("Vehicle removed successfully");
		  } catch (Exception e) {
			  return ResponseEntity.badRequest().body("Failed to remove vehicle: " + e.getMessage());
		  }
	  }
	 

	/*
	 * @PostMapping public ResponseEntity<?> addNewVehicle(@RequestBody Vehicle obj)
	 * { System.out.println("in add New Vehicle"); return new ResponseEntity<>(
	 * vehicleService.addVehicle(obj),HttpStatus.CREATED); }
	 */
}
