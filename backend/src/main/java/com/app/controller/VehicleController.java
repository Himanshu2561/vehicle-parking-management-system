package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Vehicle;
import com.app.service.IVehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
	public VehicleController() {
		System.out.println("inside the vehicle conroller");
	}

	@Autowired
	public IVehicleService vehicleService;

	@GetMapping
	public List<Vehicle> getAllVehicles() {
		return vehicleService.getAllVehicles();
	}

	
	  @PostMapping public Vehicle addNewVehicle(@RequestBody Vehicle obj)
	  { 
		  System.out.println("in add New Vehicle"); 
		  return vehicleService.addVehicle(obj); 
	  }
	 

	/*
	 * @PostMapping public ResponseEntity<?> addNewVehicle(@RequestBody Vehicle obj)
	 * { System.out.println("in add New Vehicle"); return new ResponseEntity<>(
	 * vehicleService.addVehicle(obj),HttpStatus.CREATED); }
	 */
}
