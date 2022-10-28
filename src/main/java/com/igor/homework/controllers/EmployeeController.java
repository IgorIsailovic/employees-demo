package com.igor.homework.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.igor.homework.models.Employee;
import com.igor.homework.service.EmployeeService;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping
	public List<Employee> getEmployees(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String team,
			@RequestParam(required = false) String teamLead) {
		return employeeService.getEmployees(name, team, teamLead);
	}

	@GetMapping(value = "/{employeeId}")
	public Employee getEmployeeById(@PathVariable("employeeId") long id) {
		return employeeService.findEmployeeById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Employee addEmployee(@RequestBody Employee empl) {
		return employeeService.createEmployee(empl);
	}

	@DeleteMapping(value = "/{employeeId}")
	public String deleteEmployee(@PathVariable("employeeId") long id) {
		return "Successfully deleted employee with the id: " + employeeService.deleteEmployee(id);

	}

}
