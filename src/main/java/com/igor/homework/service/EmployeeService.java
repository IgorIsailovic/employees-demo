package com.igor.homework.service;

import java.util.List;

import com.igor.homework.models.Employee;

public interface EmployeeService {
	
	Employee createEmployee(Employee empl);
	
	long deleteEmployee(long id);
	
	Employee findEmployeeById(long id);
	
	List<Employee> getEmployees(String name, String team, String teamLead);

	
}
