package com.xwork.dao;

import java.util.List;

import com.xwork.model.Employee;

public interface EmployeeDAO {

	public void create(Employee employee);
	public Employee getEmployeeById(int employeeId);
	public void updateEmployeeById(String newEmail, int employeeId);
	public void delete(int employeeId);
	public List<Employee> getAll();
	
	
}
