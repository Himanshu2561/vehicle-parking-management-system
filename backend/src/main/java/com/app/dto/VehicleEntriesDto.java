package com.app.dto;

public class VehicleEntriesDto {
    String message;
    Integer noOfVehicles;

    public VehicleEntriesDto() {
    }

    public VehicleEntriesDto(String message, Integer noOfVehicles) {
        this.message = message;
        this.noOfVehicles = noOfVehicles;
    }

    @Override
    public String toString() {
        return "VehicleEntriesDto{" +
                "message='" + message + '\'' +
                ", noOfVehicles=" + noOfVehicles +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getNoOfVehicles() {
        return noOfVehicles;
    }

    public void setNoOfVehicles(Integer noOfVehicles) {
        this.noOfVehicles = noOfVehicles;
    }
}
