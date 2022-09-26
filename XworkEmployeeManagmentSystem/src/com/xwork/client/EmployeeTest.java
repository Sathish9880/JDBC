package com.xwork.client;

import java.util.List;

import com.xwork.dao.EmployeeDAO;
import com.xwork.dao.EmployeeDAOImpl;
import com.xwork.model.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		// create new data
		employee.setName("kushi");
		employee.setAddress("hassan");
		employee.setEmail("kushi@xworkz.com");
		employee.setSkill("html");
		employee.setTelephone("8907");

		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		// employeeDAO.create(employee);

		//employee = employeeDAO.getEmployeeById(10);
		if (employee != null) {
			System.out.println(employee.getName() + "|" + employee.getAddress() + "|" + employee.getEmail() + "|"
					+ employee.getTelephone() + "|" + employee.getSkill());
		} else {
			System.out.println("not present");
		}
		
		//update
		//employeeDAO.updateEmployeeById("lisha@xwork", 1);
		
		// delete 
		
		employeeDAO.delete(1);
		
		//get all emplist   
		List<Employee> emplist = employeeDAO.getAll();
		
		for(Employee allEmp :emplist) {
			System.out.println(allEmp);
		}
		
	}

}
