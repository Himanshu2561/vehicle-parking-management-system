package com.app.dto;

import lombok.Getter;

import java.time.LocalDateTime;


public class ErrorResponse {
private String message;
private String errorDetials;
private LocalDateTime timeStamp;
public ErrorResponse() {
	super();
}
public ErrorResponse(String message, String errorDetials) {
	super();
	this.message = message;
	this.errorDetials = errorDetials;
	timeStamp=LocalDateTime.now();
}

	public void setMessage(String message) {
	this.message = message;
}

	public void setErrorDetials(String errorDetials) {
	this.errorDetials = errorDetials;
}

	public void setTimeStamp(LocalDateTime timeStamp) {
	this.timeStamp = timeStamp;
}


}
