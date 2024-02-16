package com.app.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.pojo.Vehicle;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
	List<Vehicle> findByEntryTimeBetween(LocalDateTime start, LocalDateTime end);
}

