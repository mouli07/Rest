package com.demo.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.employee.dao.EmployeeDAOImpl;
import com.demo.employee.pojo.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDAOImpl dao; //= new EmployeeDAOImpl();
	
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
