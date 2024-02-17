package com.app.controller;

import java.util.List;

import com.app.dto.ErrorResponse;
import com.app.dto.TicketDto;
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
@RequestMapping("/vehicles")
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
			Ticket ticket= new Ticket();
			ticket=ticketService.parkVehicle(vehicle);
			TicketDto obj=new TicketDto(ticket.getId(),ticket.getDate(),ticket.getVehicleNumber(),ticket.getSlotNumber(),ticket.getType());
			return new ResponseEntity<>(obj, HttpStatus.CREATED);
		}
		catch (RuntimeException e) {
			System.out.println("error occured " + e);
			return new ResponseEntity<>(new ErrorResponse("Adding vehicle failed", e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/* @GetMapping("/getVehicles")
	  public List<Vehicle> getAllVehicles(){

		  List<Vehicle> vehicles = vehicleService.getAllVehicles();
		
		 *//* System.out.println(vehicles);
		  vehicles.stream().forEach(vehicle -> System.out.println(vehicle)); // printing the vehicle list
		*//*
		  return vehicleService.getAllVehicles();
	  }*/

	@GetMapping
	public ResponseEntity<List<Vehicle>> getAllVehicles() {

		List<Vehicle> vehicles = vehicleService.getAllVehicles();
		vehicles.stream().forEach(vehicle -> System.out.println(vehicle)); // printing the vehicle list
		return ResponseEntity.ok(vehicles);
	}

	@DeleteMapping("/removeVehicle/{id}")
	public ResponseEntity<String> removeVehicleById(@PathVariable int id) {
		System.out.println("in getVehicle " + id);
		try {
			int amount = returnAmount(id);
			vehicleService.removeVehicleById(id);

			return new ResponseEntity<>("vehicle removed successfully, Amount to pay="+amount,HttpStatus.OK);
		} catch (RuntimeException e) {
			System.out.println("error occured " + e);
			return new ResponseEntity<>("error occured",HttpStatus.BAD_REQUEST);
		}
	}

	//@GetMapping("/amount/{vehicleId}")
	public int returnAmount(@PathVariable int vehicleId){
		return amountService.AmountPerVehicle(vehicleId);
	}

}
