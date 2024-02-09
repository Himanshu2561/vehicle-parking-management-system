package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.VehicleRepository;
import com.app.pojo.Vehicle;

@Service
@Transactional
public class VehicleServiceImpl implements IVehicleService {

	@Autowired
	private VehicleRepository vehicle;
	@Override
	public List<Vehicle> getAllVehicles() {
		
		return vehicle.findAll();
	}
	@Override
	public Vehicle addVehicle(Vehicle v1) {

		return vehicle.save(v1);
	}
	

}
