package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Employee;
import com.app.service.EmployeeService;

import custom_exceptions.ResourceNotFoundException;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
		
	public EmployeeController() {
		System.out.println("in def ctor " + getClass());
	}
	
	@GetMapping
	public  List<Employee> getAllEmps() {
		System.out.println("in get all emps");
		return empService.getAllEmpDetails();
	}
	
	@PostMapping
	public Employee saveEmpDetails(@RequestBody Employee transientEmp) {
		return empService.addEmpDetails(transientEmp);
	}

	@DeleteMapping("/{empId}")
	public String deleteEmpDetails(@PathVariable Long empId) {
		System.out.println("in del emp "+empId);
		return empService.deleteEmpDetails(empId);
	}
	
	@GetMapping("/{empId}")
	public Optional<Employee> getEmpDetails(@PathVariable Long empId) throws Exception {
		return empService.fetchEmpDetails(empId);
	}
	
	@PutMapping
	public Employee updateEmpDetails(@RequestBody Employee detachedEmp) throws ResourceNotFoundException {
		
		return empService.updateEmpDetails(detachedEmp);
	}
	
	
	
	
	
	
}
