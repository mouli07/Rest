package com.demo.employee.repo;

import java.util.List;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.stereotype.Repository;

import com.demo.employee.pojo.Employee;

@Repository
public class EmployeeRepository extends JpaRepositoriesAutoConfiguration{
	
	public List<Employee> getAllEmployee()
	{
		return findAll();
	}
	
	public Employee getEmployee(int id)
	{
		return findById(id);
	}
	
	public void addNewEmployee()

}
