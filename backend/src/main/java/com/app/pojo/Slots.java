package com.app.pojo;

public class Slots {
    private int slotsNumber;  // setting the number of available slots for the two and four wheeler // user input
    private boolean isSlotEmpty;  // checking for the empty slots
    private Vehicle parkVehicle;  // vehicle to be parked
    private String floorNumber;

    public Slots(int slotsNumber) {  // setting the number of the slots
        this.slotsNumber = slotsNumber;
        isSlotEmpty = true;  // signifies the slot is empty
    }

    public void setFloor(String floor){
        this.floorNumber = floor;
    }

    public int getSlotsNumber() {
        return slotsNumber;
    }

    public void setSlotsNumber(int slotsNumber) {
        this.slotsNumber = slotsNumber;
    }

    public boolean isSlotEmpty() {
        return isSlotEmpty;
    }

    public void setSlotEmpty(boolean slotEmpty) {
        isSlotEmpty = slotEmpty;
    }

    public Vehicle getParkVehicle() {
        return parkVehicle;
    }  // return the parked vehicle

    public void setParkVehicle(Vehicle parkVehicle) {
        this.parkVehicle = parkVehicle;
    }

    @Override
    public String toString() {
        return "Slots{" +
                "slotsNumber=" + slotsNumber +
                ", isSlotEmpty=" + isSlotEmpty +
                ", parkVehicle=" + parkVehicle +
                ", floorNumber=" + floorNumber +
                '}';
    }

    public void allocateSlot(Vehicle parkedVehicle){
        this.parkVehicle = parkedVehicle;  // assigning the parked vehicle a value
        this.isSlotEmpty = false;  // setting the slot as not empty
    }

    public void vacateSlots(){
        this.parkVehicle = null;  // removing the vehicle from the parking
        this.isSlotEmpty = true;  // freeing up the slot
        this.floorNumber = "null";
    }
}
