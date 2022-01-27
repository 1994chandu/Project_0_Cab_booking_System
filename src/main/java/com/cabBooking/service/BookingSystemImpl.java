package com.cabBooking.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;
import com.cabBooking.dao.BookingDao;
import com.cabBooking.dao.BookingDaoImpl;
import com.cabBooking.dbutil.MySqlDbConnection;
import com.cabBooking.exception.CabException;
import com.cabBooking.model.Admin;
import com.cabBooking.model.Cab;
import com.cabBooking.model.Employee;
public class BookingSystemImpl implements BookingSystem {
	BookingDao bookingDao=new BookingDaoImpl();
	public int adminRegisterService(Admin admin) throws CabException {
		BookingDao bookingDao=new BookingDaoImpl();
		Integer adminId=admin.getAdminId();
		String adminName=admin.getAdminName();
		String adminPassword=admin.getAdminPassword();
		bookingDao.adminRegisterService(admin);
		return 0;
	}
	public int empRegisterService(Employee emp) throws CabException {
		BookingDao bookingDao=new BookingDaoImpl();
		Integer empId=emp.getEmpId();
		String empName=emp.getEmpName();
		Boolean isManager=emp.getIsManager();
		String empPassword=emp.getEmppassword();
		String dept=emp.getDept();
		bookingDao.empRegisterService(emp);
		return 0;
			
	}
	public int adminLoginService(Integer a, String b) throws CabException {
		int flag=0;
		flag=bookingDao.adminLoginService(a,b);
		return flag;
		}
	public int empLoginService(Integer p, String q) throws CabException {
		int flag=0;
		flag=bookingDao.empLoginService(p,q);
		return flag;
		}
		public void viewEmployees() throws CabException {
	}
	
		@SuppressWarnings("unused")
		public int addCab(Cab cab) throws CabException {
			BookingDao bookingDao=new BookingDaoImpl();
			String cabNo=cab.getCabNo();
			String driverName=cab.getDriverName();
			Integer driverPhno=cab.getDriverPhno();
			Boolean isBooked=cab.getIsBooked();
			bookingDao.addCab(cab);
			return 0;
		}
		public void viewCabs() throws CabException {
			
		}
		public void viewAvailableCabs() throws CabException {
			
		}
		public String requestCab(String c) throws CabException{
			BookingDao bookingDao=new BookingDaoImpl();
			try {
				bookingDao.requestCab(c);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return c;

		}
		/*public String approveCabRequest(String c) throws CabException {
			BookingDao bookingDao=new BookingDaoImpl();
			return bookingDao.approveCabRequest(c);
		}*/
		
}