package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.pojo.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {

}

