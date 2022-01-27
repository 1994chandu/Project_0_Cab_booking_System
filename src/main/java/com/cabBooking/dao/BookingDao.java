package com.cabBooking.dao;

import java.sql.SQLException;

import com.cabBooking.exception.CabException;
import com.cabBooking.model.Admin;
import com.cabBooking.model.Cab;
import com.cabBooking.model.Employee;

public interface BookingDao {
	public int adminRegisterService(Admin admin)throws CabException;
	public int adminLoginService(Integer a,String b)throws CabException;
	public int empRegisterService(Employee emp)throws CabException;
	public int empLoginService(Integer a,String b)throws CabException;
	public void viewEmployees()throws CabException ;
	public int addCab(Cab cab)throws CabException;
	public void viewCabs()throws CabException ;
	public void viewAvailableCabs()throws CabException ;
	public String requestCab(String cabNo) throws CabException, ClassNotFoundException, SQLException, Exception;
	//public String approveCabRequest(String c) throws CabException ;



	
}
