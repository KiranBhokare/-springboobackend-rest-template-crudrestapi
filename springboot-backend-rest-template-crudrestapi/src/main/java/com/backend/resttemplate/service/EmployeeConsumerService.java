package com.backend.resttemplate.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.backend.resttemplate.entities.Employee;

public interface EmployeeConsumerService 
{
	public ResponseEntity<Employee> getEmployeeById(int id);
	
	public List<Employee>  getEmployees();
	
	public ResponseEntity<?> addEmployee(Employee emp);
	
	public ResponseEntity<?> updateEmployee(Employee emp, int id);
	
}
