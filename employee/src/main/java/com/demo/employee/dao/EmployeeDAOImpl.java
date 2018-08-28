package com.demo.employee.dao;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.employee.pojo.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	private List<Employee> employees=new ArrayList<>();
	
	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employees;
	}

	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return employees.stream().filter(emp -> emp.getEmpId()==(id)).findFirst().get();
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employees.add(employee);
		
	}

	@Override
	public void updateEmployee(int id, Employee employee) {
		// TODO Auto-generated method stub
		for(int i=0;i<employees.size();i++)
		{
			Employee emp= employees.get(i);
			if(emp.getEmpId()==(id));
			employees.set(i, employee);
				return;
		}
		
		
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		employees.removeIf(emp -> emp.getEmpId()==(id));
	}
	
	 

}
