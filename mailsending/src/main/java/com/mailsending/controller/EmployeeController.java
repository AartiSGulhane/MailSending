package com.mailsending.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mailsending.model.Employee;
import com.mailsending.service.EmployeeServiceI;

@RestController
@RequestMapping("/empcon")
public class EmployeeController {
	@Autowired EmployeeServiceI esi;
	
	@PostMapping("/reg")
	public ResponseEntity<Employee> addEmpData(@RequestBody Employee emp)
	{
		Employee e=esi.addEmployee(emp);
		return new ResponseEntity<Employee>(e,HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<Employee> registerEmployee( @RequestBody Employee employee)
	{
		Employee emp=esi.regEmp(employee);
		return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
	}

}
