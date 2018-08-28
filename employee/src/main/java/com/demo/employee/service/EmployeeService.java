package com.demo.employee.service;

import java.util.List;

import com.demo.employee.dao.EmployeeDAOImpl;
import com.demo.employee.pojo.Employee;

public class EmployeeService {
	
	EmployeeDAOImpl dao = new EmployeeDAOImpl();
	
	public List<Employee> getAllEmployee() {
	
		return dao.getAllEmployee();
	}
	
	public Employee getEmployee(int id) {
		
		return dao.getEmployee(id);
	}
	
	public void addEmployee(Employee employee) {
		
		dao.addEmployee(employee);
	}
	
	public void updateEmployee(int id, Employee employee) {
		
		dao.updateEmployee(id,employee);
	}
	
	public void deleteEmployee(int id) {
		dao.deleteEmployee(id);
		
	}
	
}
