package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Employee;

import custom_exceptions.ResourceNotFoundException;

public interface EmployeeService {
	
	List<Employee> getAllEmpDetails();
	
	Employee addEmpDetails(Employee transientEmp);
	
	Optional<Employee> fetchEmpDetails(Long empId) throws Exception ;
	
	String deleteEmpDetails(Long empId);
	
	Employee updateEmpDetails(Employee detachedEmp) throws ResourceNotFoundException;

}
