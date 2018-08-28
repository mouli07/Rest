package com.demo.employee.dao;

import java.util.List;

import com.demo.employee.pojo.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getAllEmployee();
	public Employee getEmployee(int id);
	public void addEmployee(Employee employee);
	public void updateEmployee(int id,Employee employee);
	public void deleteEmployee(int id);
	
}
