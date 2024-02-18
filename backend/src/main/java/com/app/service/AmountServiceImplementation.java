package com.app.service;

import com.app.dao.AmountRepository;
import com.app.dao.VehicleRepository;
import com.app.pojo.Amount;
import com.app.pojo.Vehicle;
import com.app.pojo.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AmountServiceImplementation implements AmountService{

    private AmountRepository amountRepository;
    private VehicleRepository vehicleRepository;

    @Autowired
    public AmountServiceImplementation(AmountRepository amountRepository,
                                       VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
        this.amountRepository = amountRepository;
    }

    @Override
    public int AmountPerVehicle(int vehicle_id) {
        int totalAmount;  // getting the final amount
        int initialAmount = 20;  // initial parking amount
        Vehicle newVehicle = null;
        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicle_id);
        if(vehicle.isPresent()){
            newVehicle = vehicle.get();  // getting the new vehicle with the id
        }

        Date parkedDate = convertToUtilDate(newVehicle.getTicketDate());
        System.out.println(parkedDate);
        Date currentDate = new Date();  // getting the current date
        System.out.println(currentDate);
        int differenceInTime = (int) (currentDate.getTime() - parkedDate.getTime());
        long difference_In_Hours = (differenceInTime / (1000 * 60 * 60)) ;
        System.out.println(difference_In_Hours);

        if(newVehicle.getVehicleType().equals(VehicleType.TWO_WHEELER)){
            int incrementalAmount = 10;
            if(difference_In_Hours <= 3){
                totalAmount = initialAmount*3;
            }
            else {
                totalAmount = (int) ((initialAmount * 3) + (incrementalAmount * (difference_In_Hours - 3)));
            }
            System.out.println(totalAmount);
            //return totalAmount;  // returning the amount
        }
        else{
            int incrementalAmount = 20;
            if(difference_In_Hours <= 3){
                totalAmount = initialAmount*3;
            }
            else {
                totalAmount = (int) ((initialAmount * 3) + (incrementalAmount * (difference_In_Hours - 3)));
            }
            System.out.println(totalAmount);
            //return totalAmount;  // returning the amount
        }

        Amount amount = new Amount(currentDate, totalAmount,newVehicle.getVehicleType(),newVehicle.getVehicleNumber());

        amountRepository.save(amount);  // saving the data in the database
        return totalAmount;
    }

    public static java.util.Date convertToUtilDate(Date sqlDate) {
        return new java.util.Date(sqlDate.getTime());
    }


    @Override
    public int lastSevenDaysAmount() {
        Date dateBeforeSevenDays=new Date(System.currentTimeMillis() - (7 * 24 * 60 * 60 * 1000));
        int totalAmount=0;
        List<Amount> amount= amountRepository.findByExitDateAfter(dateBeforeSevenDays);
        for(Amount i :amount)
        {
            totalAmount=totalAmount+i.getAmountToPay();
        }
        return totalAmount;
    }

    @Override
    public int lastThirtyDaysAmount() {
        Date dateBeforeSevenDays=new Date(System.currentTimeMillis() - (30L * 24 * 60 * 60 * 1000));
        int totalAmount=0;
        List<Amount> amount= amountRepository.findByExitDateAfter(dateBeforeSevenDays);
        for(Amount i :amount)
        {
            totalAmount=totalAmount+i.getAmountToPay();
        }
        return totalAmount;
    }

    @Override
    public int getTotalNumberOfVehicles() {
        return amountRepository.findAll().size();
    }
}
