package com.backend.resttemplate.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.backend.resttemplate.entities.Employee;

@Service
public class EmployeeConsumerServiceImpl implements EmployeeConsumerService{


	 RestTemplate template =new RestTemplate();
	
	 public ResponseEntity<Employee> getEmployeeById(int id)
	 {
		  String url = "http://localhost:8080/api/employees/employee/"+id;
		 
		  ResponseEntity<Employee> re =template.getForEntity(url, Employee.class);
		  
		  return re;
		 
	 }
	 
	 public List <Employee> getEmployees()
	 {
		 String url = "http://localhost:8080/api/employees";
		 
		 Object[] list=  template.getForObject(url , Object[].class);
		 
		 List emplist =  Arrays.asList(list);
		     
		 return emplist;
		 		 
	 }
	 
	 
	 public ResponseEntity<?> addEmployee(Employee emp)
	 {
		 String url = "http://localhost:8080/api/addemployee";
		 
		 ResponseEntity<?> re = template.postForEntity(url,emp,Employee.class);        // public <T> ResponseEntity<T> postForEntity(URI url, @Nullable Object request, Class<T> responseType)
		                                                       //or Employee.class
		 return re;
	 }
	
	 
	 
	 
	 public ResponseEntity<?> updateEmployee(Employee emp , int id)
	 {
		String url = "http://localhost:8080/api/employee"+id;
		 
	
		
		return null;
	 }
	 
}
