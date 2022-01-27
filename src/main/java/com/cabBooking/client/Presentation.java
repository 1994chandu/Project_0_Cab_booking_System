package com.cabBooking.client;

import java.util.Scanner;
import com.cabBooking.controller.ControllerImpl;
import com.cabBooking.dao.BookingDao;
import com.cabBooking.dao.BookingDaoImpl;
import com.cabBooking.exception.CabException;
import com.cabBooking.model.Admin;
import com.cabBooking.model.Cab;
import com.cabBooking.model.Employee;
import com.cabBooking.service.BookingSystem;
import com.cabBooking.service.BookingSystemImpl;

public class Presentation {
	public static void main(String[] args) throws CabException {
	BookingDao bookDao=new BookingDaoImpl();
	Scanner sc=new Scanner(System.in);
	System.out.println("Hey,Welcome");
	System.out.println("Please choose from below options");
	int ch=0;
	do {
		System.out.println("-----------------------------");
		System.out.println("1) Login as a Admin");
		System.out.println("2) Login as an Employee ");
		System.out.println("3) Admin registration");
		System.out.println("-----------------------------");
			try {
			ch = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
			}
		switch(ch) {
		case 1:	{
					System.out.println("-----------------------------");
					System.out.println("        Admin Login           ");
					System.out.println("-----------------------------");
					BookingSystem book=new BookingSystemImpl();
					System.out.println("Enter your admin id");
					Integer adminId=sc.nextInt();
					System.out.println("Enter your Password");
					String adminPassword=sc.next();
					int success=0;
					try {
						success=book.adminLoginService(adminId,adminPassword);
					} catch (CabException e) {
						e.printStackTrace();
					}
					if(success==1) {
					System.out.println("-----------------------------");
					System.out.println("Logged-in as: "+adminId);
					System.out.println("-----------------------------");
					System.out.println("Select from below options");
					int op=0;
					do {
					System.out.println("1.add employees");
					System.out.println("2.view all employees");
					System.out.println("3.add cab detals");
					System.out.println("4.view all cab detals");
					System.out.println("5.Approve request");
					try {
						op = Integer.parseInt(sc.next());
						} catch (NumberFormatException e) {
						}
					switch(op) {
					case 1:{//add Employees
						BookingSystem book1=new BookingSystemImpl();
						System.out.println("Employee Registration");
						Employee emp=new Employee();
						System.out.println("enter employee Id");
						emp.setEmpId(sc.nextInt());//  sc.nextLine()
						System.out.println("Enter employee Name");
						emp.setEmpName(sc.next());	
						System.out.println("Whether Employee is Manager");
						emp.setIsManager(sc.nextBoolean());
						System.out.println("enter employee dept");
						emp.setDept(sc.next());
						System.out.println("Enter employee password");
						emp.setEmppassword(sc.next());
						try {
						book1.empRegisterService(emp);
						}
						catch(CabException e){
							System.out.println(e);
						}
						break;
					}	
					case 2:{//view Employee
						BookingDao bookingDao=new BookingDaoImpl();
						try {
							bookingDao.viewEmployees();
						} catch (CabException e) {
							e.printStackTrace();
						}
						break;
						}
					case 3:{//add cab details
						Cab cab=new Cab();
						BookingSystem book1=new BookingSystemImpl();
						System.out.println("Please enter cab number");
						cab.setCabNo(sc.next());
						System.out.println("Please enter driver name");
						cab.setDriverName(sc.next());
						System.out.println("Please enter driver phone number");
						cab.setDriverPhno(sc.nextInt());
						System.out.println("whether the cab is booked");
						cab.setIsBooked(sc.nextBoolean());
						try {
							book1.addCab(cab);
							}
							catch(CabException e){
								System.out.println(e);
							}
							break;
						}
					case 4:{
							System.out.println("total registered cabs are");
							BookingDao bookingDao=new BookingDaoImpl();
							try {
								bookingDao.viewCabs();
							} catch (CabException e) {
								e.printStackTrace();
							}
							System.out.println("total available cabs are");
							try {
								bookingDao.viewAvailableCabs();
							} catch (CabException e) {
								e.printStackTrace();
							}

							break;
						}
						/*case 5:{//approve request for a cab
						System.out.println("enter the cab no to book a cab");
						String c=sc.next();
						Cab cab=new Cab();
						BookingDao bookingDao=new BookingDaoImpl();
						bookingDao.approveCabRequest(c);
						break;
						}*/					
					default:{
						System.out.println("enter valid option");
						break;
					}
				}System.out.println("enter any key");
				op=sc.nextInt();
				}while(op!=4);
				}
				else {
				System.out.println("Invalid Credentials");
				}
				break;
			}
			case 2:{//employee login
					Employee emp=new Employee();
					System.out.println("-----------------------------");
					System.out.println("      Employee Login           ");
					System.out.println("-----------------------------");
					BookingSystem book=new BookingSystemImpl();
					System.out.println("Enter Employee id");
					Integer empId=sc.nextInt();
					System.out.println("Enter Employee Password");
					String empPassword=sc.next();
					int success=0;
					try {
						success = book.empLoginService(empId,empPassword);
					} catch (CabException e) {
						e.printStackTrace();
					}
					if(success==1) {
					System.out.println("-----------------------------");
					System.out.println("Logged-in as: "+empId);
					System.out.println("-----------------------------");
					System.out.println("Select from below options");
					System.out.println("-----------------------------");						
					int x=0;
					do {
						System.out.println("1.view available cabs");
						System.out.println("2.Book a cab");
						try {
							x = Integer.parseInt(sc.next());
						} catch (NumberFormatException e) {
						}
					switch(x) {
					case 1:{//view cab details
						BookingDao bookingDao=new BookingDaoImpl();
						try {
							bookingDao.viewAvailableCabs();
							System.out.println("Available cabs are:");
						} catch (CabException e) {
							e.printStackTrace();
						}
						break;
					}
					case 2:{//book a cab{
						BookingDao bookingDao=new BookingDaoImpl();
						System.out.println("enter cab number that you want to book");
						String cNo=sc.next();
						try {
							bookingDao.requestCab(cNo);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
					default:{
						System.out.println("you are an employee");
					break;
					}
					}
					}while(x!=3);
					System.out.println("......................");
					}
					else {
						System.out.println("Invalid Credentials");
						}
					break;
				}
			case 3:{
					BookingSystem book=new BookingSystemImpl();
					System.out.println("Admin Registration");
					Admin admin=new Admin();
					System.out.println("enter adminId");
					admin.setAdminId(Integer.parseInt(sc.nextLine()));
					System.out.println("Enter admin password");
					admin.setAdminPassword(sc.next());
					System.out.println("Enter Admin Name");
					admin.setAdminName(sc.next());		
					try {
						book.adminRegisterService(admin);
						}
					catch(CabException e){
					System.out.println(e);
					}
					break;
				}	
			
			default:{
			System.out.println("....");
			break;
			}
		}
		System.out.println("press any key to continue");
		ch=sc.nextInt();
	}while (ch!= 5);	
}
}
