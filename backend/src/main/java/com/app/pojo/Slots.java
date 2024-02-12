package com.app.pojo;

import javax.persistence.*;

@Entity
@Table(name = "slots")
public class Slots {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "slotNumber", nullable = false)
    private int slotNumber;  // setting the number of available slots for the two and four wheeler // user input

    @OneToOne
    @JoinColumn(name = "vehicle_id", unique = true)
    private Vehicle vehicle;

    public Slots(){}
    public Slots(int slotsNumber) {  // setting the number of the slots
        this.slotNumber = slotsNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getSlotsNumber() {
        return slotNumber;
    }

    public void setSlotsNumber(int slotsNumber) {
        this.slotNumber = slotsNumber;
    }

    @Override
    public String toString() {
        return "Slots{" +
                "slotsNumber=" + slotNumber +
                '}';
    }
}
