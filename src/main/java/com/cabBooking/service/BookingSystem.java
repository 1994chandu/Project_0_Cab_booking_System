package com.cabBooking.service;

import java.util.Set;

import com.cabBooking.exception.CabException;
import com.cabBooking.model.Admin;
import com.cabBooking.model.Cab;
import com.cabBooking.model.Employee;

public interface BookingSystem {
	public int adminRegisterService(Admin admin)throws CabException;
	public int adminLoginService(Integer a,String b)throws CabException;
	public int empRegisterService(Employee emp)throws CabException;
	public int empLoginService(Integer a,String b)throws CabException;
	public int addCab(Cab cab)throws CabException;	
	public void viewEmployees()throws CabException;
	public void viewCabs()throws CabException ;
	public void viewAvailableCabs()throws CabException ;
	//public String approveCabRequest(String cabNo) throws CabException;
	public String requestCab(String c) throws CabException;



}
