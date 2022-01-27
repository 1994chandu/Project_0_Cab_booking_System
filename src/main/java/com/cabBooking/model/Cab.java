package com.cabBooking.model;

import java.util.*;

public class Cab {
private String cabNo;
private	String driverName;
private Integer driverPhno;
private	Boolean isBooked;
public Cab(String cabNo, String driverName, Integer driverPhno, Boolean isBooked) {
	super();
	this.cabNo = cabNo;
	this.driverName = driverName;
	this.driverPhno = driverPhno;
	this.isBooked = isBooked;
}
public Cab() {
	// TODO Auto-generated constructor stub
}
public String getCabNo() {
	return cabNo;
}
public void setCabNo(String cabNo) {
	this.cabNo = cabNo;
}
public String getDriverName() {
	return driverName;
}
public void setDriverName(String driverName) {
	this.driverName = driverName;
}
public Integer getDriverPhno() {
	return driverPhno;
}
public void setDriverPhno(Integer driverPhno) {
	this.driverPhno = driverPhno;
}
public Boolean getIsBooked() {
	return isBooked;
}
public void setIsBooked(Boolean isBooked) {
	this.isBooked = isBooked;
}
		
}


