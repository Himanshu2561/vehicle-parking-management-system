package com.app.service;

public interface AmountService {
    public int AmountPerVehicle(int vehicle_id);  // getting the amount

    int lastSevenDaysAmount();

    int lastThirtyDaysAmount();

    int getTotalNumberOfVehicles();
}
