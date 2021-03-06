package com.cabBooking.exception;

public class CabException extends Exception{
	public CabException(String s) {
		super(s);
	}

	@Override
	public String toString() {
		return "Currently No Cab is available for booking.\nPlease try again after few minutes.";
	}
	
	@Override
	public String getMessage() {
		return "All cabs are booked";
	}
}
