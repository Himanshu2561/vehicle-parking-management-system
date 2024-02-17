package com.app.dao;

import com.app.pojo.Amount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// amount repository to get the vehicle from vehicle id to store the vehicle and get the amount
// related to the particular vehicle
@Repository
public interface AmountRepository extends JpaRepository<Amount,Integer> {
}
