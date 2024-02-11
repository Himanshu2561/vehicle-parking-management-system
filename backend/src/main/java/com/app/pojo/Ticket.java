package com.app.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private int id;

    @Column(name = "ticket_date", nullable = false)
    private Date date;  // date for the ticket registration

    @Column(name = "vehicle_number", length = 255 ,nullable = false)
    private String vehicleNumber;  // details of the vehicles such as the number plate of vehicle

    @Column(name = "slot_number", nullable = false)
    private int slotNumber;  // slot number allocated to the vehicle

    @Enumerated(EnumType.STRING)
    @Column(name = "vehicle_type", length = 255, nullable = false)
    private VehicleType type;  // type of the vehicle

    @Column(name = "floor_number", length = 255, nullable = false)
    private String floorNumber;  // floor number for the slot

    @OneToOne
    @JoinColumn(name = "vehicle_id", unique = true)
    private Vehicle vehicle;

    public Ticket(){}

    public Ticket(Date date, String vehicleNumber, int slotNumber, VehicleType type, String floorNumber) {
        this.date = date;
        this.vehicleNumber = vehicleNumber;
        this.slotNumber = slotNumber;
        this.type = type;
        this.floorNumber = floorNumber;
    }

    public Ticket(int id, Date date, String vehicleNumber, int slotNumber, VehicleType type, String floorNumber) {
        this.id = id;
        this.date = date;
        this.vehicleNumber = vehicleNumber;
        this.slotNumber = slotNumber;
        this.type = type;
        this.floorNumber = floorNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public String getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", date=" + date +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", slotNumber=" + slotNumber +
                ", type=" + type +
                ", floorNumber='" + floorNumber + '\'' +
                '}';
    }
}
