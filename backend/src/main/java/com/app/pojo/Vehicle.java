package com.app.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vehicle")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "vehicle_number", length = 200, nullable = false)
	private String vehicleNumber;  // displays the number on the number plate of the vehicle

	@Enumerated(EnumType.STRING)
	@Column(name = "vehicle_Type", length = 200, nullable = false)
	private VehicleType vehicleType; // determines the type of the vehicle [two, four wheeler] from the enum class

	@Column(name = "creation_date", nullable = false)
	private Date ticketDate;

	@OneToOne(mappedBy = "vehicle", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Ticket ticket;

	public Vehicle(){}  // creating the no args constructor

	public Vehicle(int id, String vehicleNumber, VehicleType vehicleType, Date ticketDate) {
		this.id = id;
		this.vehicleNumber = vehicleNumber;
		this.vehicleType = vehicleType;
		this.ticketDate = ticketDate;
	}

	// creating the constructor with the arguments needed
	public Vehicle(String vehicleNumber, VehicleType vehicleType) {
		this.vehicleNumber = vehicleNumber;
		this.vehicleType = vehicleType;
	}

	public Vehicle(int id, String vehicleNumber, VehicleType vehicleType) {
		this.id = id;
		this.vehicleNumber = vehicleNumber;
		this.vehicleType = vehicleType;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Date getTicketDate() {
		return ticketDate;
	}

	public void setTicketDate(Date ticketDate) {
		this.ticketDate = ticketDate;
	}

	@Override
	public String toString() {
		return "Vehicle{" +
				"id=" + id +
				", vehicleNumber='" + vehicleNumber + '\'' +
				", vehicleType=" + vehicleType +
				", ticketDate=" + ticketDate +
				'}';
	}
}
