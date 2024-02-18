package com.app.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;
@Getter
@Entity
@Table(name = "vehicle")
@JsonIgnoreProperties("ticket")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "vehicle_number", length = 200, nullable = false,unique = true)
	@Pattern(regexp = "^[A-Z]{2}\\d{2}[A-Z]{2}\\d{4}$", message = "Invalid vehicle number format")
	private String vehicleNumber;  // displays the number on the number plate of the vehicle

	@Enumerated(EnumType.STRING)
	@Column(name = "vehicle_Type", length = 200, nullable = false)
	private VehicleType vehicleType; // determines the type of the vehicle [two, four wheeler] from the enum class

	@Column(name = "creation_date", nullable = false)
	private Date ticketDate;

	@OneToOne(mappedBy = "vehicle", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Ticket ticket;

	@OneToOne(mappedBy = "vehicle", cascade = CascadeType.ALL)
	@JsonManagedReference
    private Slots slot;

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

	public Slots getSlot() {
        return slot;
    }

    public void setSlot(Slots slot) {
        this.slot = slot;
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
