package com.igor.homework.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.igor.homework.exception.EmployeeNotFoundException;
import com.igor.homework.models.Employee;
import com.igor.homework.repository.EmployeeRepository;
import com.igor.homework.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepo;

	public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	@Override
	public List<Employee> getEmployees(String name, String team, String teamLead) {
		return employeeRepo.getEmployees(name, team, teamLead);
	}

	@Override
	public Employee createEmployee(Employee empl) {
		return employeeRepo.save(empl);
	}

	@Override
	public Employee findEmployeeById(long id) {
		Employee empl = employeeRepo.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Specified employee does not exist!"));
		return empl;
	}
	
	@Override
	public long deleteEmployee(long id) {
		findEmployeeById(id);
		employeeRepo.deleteById(id);
		return id;
	}

	

}
