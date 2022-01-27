package com.cabBooking.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;
import com.cabBooking.dbutil.MySqlDbConnection;
import com.cabBooking.exception.CabException;
import com.cabBooking.model.Admin;
import com.cabBooking.model.Cab;
import com.cabBooking.model.Employee;
import com.cabBooking.service.BookingSystem;
import com.cabBooking.service.BookingSystemImpl;
public class BookingDaoImpl implements BookingDao {
	// UserRegistration
	public int  adminRegisterService(Admin admin)throws CabException{
		int success=0;
		try(Connection connection=MySqlDbConnection.getConnection())
		{
			String sql="insert into admin values(?,?,?)";
		     PreparedStatement preparedStatement=connection.prepareStatement(sql);
		     preparedStatement.setInt(1,admin.getAdminId());
		     preparedStatement.setString(2, admin.getAdminPassword());
		     preparedStatement.setString(3, admin.getAdminName());
		     success=preparedStatement.executeUpdate();
		    System.out.println("Admin Successfully Registered");
		}
		catch(ClassNotFoundException | SQLException e){
			System.out.println(e);
		}
		return success;
	}	
		
	public int  empRegisterService(Employee emp)throws CabException{
		int success=0;
		try(Connection connection=MySqlDbConnection.getConnection())
		{
			String sql="insert into Employee values(?,?,?,?,?)";
		     PreparedStatement preparedStatement=connection.prepareStatement(sql);
		     preparedStatement.setInt(1,emp.getEmpId());
		     preparedStatement.setString(2, emp.getEmpName());
		     preparedStatement.setBoolean(3, emp.getIsManager());
		     preparedStatement.setString(4, emp.getDept());
		     preparedStatement.setString(5, emp.getEmppassword());
		     success=preparedStatement.executeUpdate();
		    System.out.println("Employee Successfully Registered");
		}
		catch(ClassNotFoundException | SQLException e){
			System.out.println(e);
		}
		return success;
	}	
			public int adminLoginService(Integer adminId,String adminPassword)throws CabException {
			Admin admin=new Admin();
			int success=0;
			try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select adminId,adminPassword from Admin where adminId=? and adminPassword=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1,adminId);
			preparedStatement.setString(2, adminPassword);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(!resultSet.next()){
				System.out.println("login fail");
				return 0;
			}
			else {
				System.out.println("login successful");
				return 1;
			}
		}
			catch(ClassNotFoundException | SQLException e){
				System.out.println(e);
				throw new CabException("Internal Error");
			}
			
		}
			public int empLoginService(Integer empId, String empPassword) throws CabException {
				Employee emp=new Employee();
				int success=0;
				try(Connection connection=MySqlDbConnection.getConnection()){
				String sql="select empId,empPassword from Employee where empId=? and empPassword=?";
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setInt(1,empId);
				preparedStatement.setString(2,empPassword);
				ResultSet resultSet=preparedStatement.executeQuery();
				if(!resultSet.next()) {
				System.out.println("login fail");
				return 0;
				}
				else {
					System.out.println("Successful login");
					return 1;
					}
				}
				catch(ClassNotFoundException | SQLException e){
					System.out.println(e);
					throw new CabException("Internal Error");
				}
				
			}

				public void viewEmployees() throws CabException {
				//Employee emp=new Employee();
				try (Connection con=MySqlDbConnection.getConnection()){
					String sql="select * from Employee";
					PreparedStatement prepareStatement=con.prepareStatement(sql);
					ResultSet rs=prepareStatement.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getInt("empId")+"  "+rs.getString("empName"));
				}
				}catch(ClassNotFoundException | SQLException e){
					System.out.println(e);
					throw new CabException("Internal Error");
				}
				}

				
				public int addCab(Cab cab) throws CabException {
					int success=0;
					try(Connection connection=MySqlDbConnection.getConnection())
					{
						String sql="insert into Cab values(?,?,?,?)";
					     PreparedStatement preparedStatement=connection.prepareStatement(sql);
					     preparedStatement.setString(1,cab.getCabNo());
					     preparedStatement.setString(2, cab.getDriverName());
					     preparedStatement.setInt(3, cab.getDriverPhno());
					     preparedStatement.setBoolean(4, cab.getIsBooked());
					     success=preparedStatement.executeUpdate();
					    System.out.println("Cab details are added successfully");
					}
					catch(ClassNotFoundException | SQLException e){
						System.out.println(e);
					}
					return success;
				}

				public void viewCabs() throws CabException {
					Cab cab=new Cab();
					try (Connection con=MySqlDbConnection.getConnection()){
						String sql="select * from Cab";
						PreparedStatement prepareStatement=con.prepareStatement(sql);
						ResultSet rs=prepareStatement.executeQuery();
					while(rs.next()) {
						System.out.println(rs.getString("CabNo")+"  "+rs.getString("driverName")+" "+rs.getInt("driverPhno")+" "+rs.getBoolean("isBooked"));
					}
					}catch(ClassNotFoundException | SQLException e){
						System.out.println(e);
						throw new CabException("Internal Error");
					}
					
				}

				public void viewAvailableCabs() throws CabException {
					Cab cab=new Cab();
					try (Connection con=MySqlDbConnection.getConnection()){
						String sql="select *from Cab where isBooked=false";
						PreparedStatement prepareStatement=con.prepareStatement(sql);
						ResultSet rs=prepareStatement.executeQuery();
					while(rs.next()) {
						System.out.println(rs.getString("CabNo")+"  "+rs.getString("driverName")+" "+rs.getInt("driverPhno")+" "+rs.getBoolean("isBooked"));
					}
					}catch(ClassNotFoundException | SQLException e){
						System.out.println(e);
						throw new CabException("Internal Error");
					}
				}
				public String requestCab(String cabNo) throws CabException, ClassNotFoundException, Exception {
					Cab cab=new Cab();
					int success=0;
					try(Connection connection=MySqlDbConnection.getConnection()){
					String sql="select cabNo,isBooked from Cab where cabNo=?";
					PreparedStatement preparedStatement=connection.prepareStatement(sql);
					preparedStatement.setString(1,cabNo);
					ResultSet resultSet=preparedStatement.executeQuery();
					if(!resultSet.next()) {
					System.out.println("Cab is not vailable");
					}
					else {
						BookingSystem bookingSystem=new BookingSystemImpl();
						System.out.println("cab is available");
						
						}
					}
					catch(ClassNotFoundException | SQLException e){
						System.out.println(e);
						throw new CabException("Internal Error");
					}
					return cabNo;
				}
				/*public String approveCabRequest(String cabNo) throws CabException {
					Cab cab=new Cab();
					try(Connection connection=MySqlDbConnection.getConnection()){
						int flag=0;
						String sql="UPDATE Cab SET isBooked = 'true' WHERE cabNo=?";
						PreparedStatement preparedStatement=connection.prepareStatement(sql);
						preparedStatement.setString(1, cabNo);
						flag=preparedStatement.executeUpdate();
						if(flag>=1) {
						/*System.out.println("Cab booked successfully");
						sql="insert into Cab values(?,?,?,?)";
						preparedStatement=connection.prepareStatement(sql);
						preparedStatement.setString(1,cabNo);
						preparedStatement.setString(2,driverName);
						preparedStatement.setInt(3,driverPhno);
						preparedStatement.setBoolean(4,"True");
						ResultSet rs=preparedStatement.executeQuery();
						System.out.println("the booked cab details are: "+rs.getString("CabNo")+"  "+rs.getString("driverName")+" "+rs.getInt("driverPhno")+" "+rs.getBoolean("isBooked"));
						}
					}
					catch(ClassNotFoundException | SQLException e){
					System.out.println(e);
					throw new CabException("Internal Error");
					}
					return cabNo;
					}*/

				
	}
				

			
			
 



	
	
