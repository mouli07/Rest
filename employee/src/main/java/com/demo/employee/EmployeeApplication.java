package com.demo.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.demo.employee.pojo.Employee;
import com.demo.employee.service.EmployeeService;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class EmployeeApplication 
{
    public static void main( String[] args )
    {
      SpringApplication.run(EmployeeApplication.class,args);
    }
    
    @Bean
    public CommandLineRunner dataprovider(EmployeeService service)
    {
    	return (args) -> {
    		
    		service.addEmployee(new Employee(1, "Tony", "Stark"));
    		service.addEmployee(new Employee(2, "Tom", "Riddle"));
    		service.addEmployee(new Employee(3, "Sam", "Smith"));
    		service.addEmployee(new Employee(4, "Harper", "White"));
    		System.out.println("Sample Data Populated to Database");
    	};
    }
}
