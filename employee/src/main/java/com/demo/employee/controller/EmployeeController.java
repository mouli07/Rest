package com.demo.employee.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import com.demo.employee.pojo.Employee;
import com.demo.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/employees/{start}/{count}")
	public Resources getEmployeeByPage(@PathVariable("start") int start,
			@PathVariable("count") int count) 
	{
		List<Employee> tempEmployees = employeeService.getAllEmployee();
		List<Employee> employees=new ArrayList<Employee>();
		
		for(int i=start; i<start+count ; i++)
		{
			employees.add(tempEmployees.get(i-1));
		}
		
		Link nextLink = linkTo(methodOn(this.getClass()).getEmployeeByPage(start+count ,count)).withRel("nextLink");
		Link previousLink = linkTo(methodOn(this.getClass()).getEmployeeByPage(start-count>=0?start-count:1,count)).withRel("previousLink");
		
		Resources resources = new Resources(employees,nextLink,previousLink);
		
		return resources;
		
	}
	
	@RequestMapping("/employees/{id}")
	public Resource getEmployeeById(@PathVariable() int id) {
		
		Link nxtLink = linkTo(methodOn(this.getClass()).getAllEmployee()).withRel("View All");
		
		Resource resource = new Resource(employeeService.getEmployee(id), nxtLink);
		return resource;
	}
	
	@RequestMapping("/employees")
	public List<Employee> getAllEmployee()
	{
		return employeeService.getAllEmployee();
	}
	
	/*@RequestMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable int id)
	{
		return employeeService.getEmployee(id);
	}*/
	
	@RequestMapping(method=RequestMethod.POST, value="/employees")
	public void addEmployee(@RequestBody Employee employee) 
	{
		employeeService.addEmployee(employee);;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/employees/{id}")
	public void updateEmployee(@RequestBody int id,@PathVariable Employee employee) 
	{
		employeeService.updateEmployee(id, employee);;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/employees/{id}")
	public void deleteEmployee(@PathVariable int id)
	{
		employeeService.deleteEmployee(id);;
	}

}
