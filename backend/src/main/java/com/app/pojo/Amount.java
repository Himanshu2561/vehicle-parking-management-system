package com.app.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Amount")
public class Amount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(name = "exit_date")
    private Date exitDate;
    @Column(name="amount_to_pay")
    private int amountToPay;
    @Enumerated(EnumType.STRING)
    @Column(name = "vehicle_Type", length = 200, nullable = false)
    private VehicleType vehicleType;
    @Column(name="vehicle_number")
    private String vehicleNumber;

    public Amount(Date exitDate, int amountToPay, VehicleType vehicleType, String vehicleNumber) {
        this.exitDate = exitDate;
        this.amountToPay = amountToPay;
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
    }

    public Amount() {
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }

    public int getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(int amountToPay) {
        this.amountToPay = amountToPay;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "id=" + id +
                ", exitDate=" + exitDate +
                ", amountToPay=" + amountToPay +
                ", vehicleType=" + vehicleType +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                '}';
    }
}
