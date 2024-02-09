package com.app.pojo;


import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Vehicle")
public class Vehicle extends BaseEntity {
@Column(length=15)
private String vehicleNo;
@Column(length=30)
private String companyName;
@Column(length=30)
private String model;
@Column(length=10)
private String color;
@Column(length=20)
private String vehicleType;
@Column(length=20)
private LocalDateTime inTime;
public Vehicle() {
	super();
	this.inTime = LocalDateTime.now();
}
public Vehicle(String vehicleNo, String companyName, String model, String color, String vehicleType) {
	this();
	this.vehicleNo = vehicleNo;
	this.companyName = companyName;
	this.model = model;
	this.color = color;
	this.vehicleType = vehicleType;
}

public String getVehicleNo() {
	return vehicleNo;
}
public void setVehicleNo(String vehicleNo) {
	this.vehicleNo = vehicleNo;
}
public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public LocalDateTime getInTime() {
	return inTime;
}
public void setInTime(LocalDateTime inTime) {
	this.inTime = inTime;
}


public String getVehicleType() {
	return vehicleType;
}


public void setVehicleType(String vehicleType) {
	this.vehicleType = vehicleType;
}

@Override
public String toString() {
	return "Vehicle [vehicleNo=" + vehicleNo + ", companyName=" + companyName + ", model=" + model + ", color=" + color
			+ ", vehicleType=" + vehicleType + ", inTime=" + inTime + "]";
}




}
