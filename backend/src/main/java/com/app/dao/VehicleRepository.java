package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.pojo.Vehicle;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {

    void deleteAllById(int id);
}

