package com.backend.resttemplate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.backend.resttemplate.entities.Employee;
import com.backend.resttemplate.service.EmployeeConsumerService;


@RestController
@RequestMapping("/rest-temp")
public class EmployeeConsumerController 
{    
	    @Autowired
    	EmployeeConsumerService  empconsumerservice;
	        
	  
	 @GetMapping("/employees")  
	public ResponseEntity<List> getEmployees()
	{
		 List<Employee> emplist = empconsumerservice.getEmployees();
		 
		return ResponseEntity.ok(emplist);
	}
	   
	    
//	    @GetMapping("/employees")  
//		public List<Employee> getEmployees()
//		{
//			return (empconsumerservice.getEmployees());
//		}
	    
	    
	    
    @GetMapping("/employees/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("id") int empid)
	{
        return ResponseEntity.ok(empconsumerservice.getEmployeeById(empid));
		  	
	}
    
    @PostMapping("/addemployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp )
    {
          ResponseEntity resemp  =empconsumerservice.addEmployee(emp);
    	        
    	  return resemp;
    }
    
    
    @PutMapping ("/employee/{id}")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee emp , @PathVariable ("id") int empid)
    {
    	
    	ResponseEntity<?> resemp =empconsumerservice.updateEmployee(emp, empid);
    	
    	return resemp;
    }
   
    
    
    
    
    
    
    
    
	
}
