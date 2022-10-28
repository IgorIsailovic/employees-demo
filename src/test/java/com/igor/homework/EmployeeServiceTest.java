package com.igor.homework;

import org.springframework.boot.test.context.SpringBootTest;

import com.igor.homework.models.Employee;
import com.igor.homework.repository.EmployeeRepository;
import com.igor.homework.service.EmployeeService;
import com.igor.homework.service.implementation.EmployeeServiceImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

@SpringBootTest
public class EmployeeServiceTest {

	EmployeeRepository repo = mock(EmployeeRepository.class);

	EmployeeService service = new EmployeeServiceImpl(repo);

	private String name = "Mirko";
	private String name1 = "Predrag";
	private String name2 = "Igor";
	private String team = "Develompent";
	private String teamLead = "Mirko";

	private Employee empl1 = new Employee(name, team, teamLead);
	private Employee empl2 = new Employee(name1, team, teamLead);
	private Employee empl3 = new Employee(name2, team, teamLead);

	private List<Employee> empList = Arrays.asList(empl1, empl2, empl3);

	@Test
	public void getEmployeesNoParamsPresentTest() {

		// given

		// when

		when(repo.getEmployees(null, null, null)).thenReturn(empList);

		List<Employee> emplList = service.getEmployees(null, null, null);

		// then

		assertEquals(emplList.size(), empList.size());

		verify(repo, times(1)).getEmployees(null, null, null);

	}
	
	@Test
	public void getEmployeesAllParamsPresentTest() {

		// given

		// when

		when(repo.getEmployees(name, team, teamLead)).thenReturn(empList);

		List<Employee> emplList = service.getEmployees(name, team, teamLead);

		// then

		assertEquals(emplList.get(0).getName(), name);
		assertEquals(emplList.get(0).getTeam(), team);
		assertEquals(emplList.get(0).getTeamLead(), teamLead);
		assertEquals(emplList.size(), empList.size());

		verify(repo, times(1)).getEmployees(name, team, teamLead);

	}

	@Test
	public void getEmployeesOnlyNamePresentTest() {

		// given

		// when

		when(repo.getEmployees(name, null, null)).thenReturn(empList);

		List<Employee> emplList = service.getEmployees(name, null, null);

		// then

		assertEquals(emplList.get(0).getName(), name);
		assertEquals(emplList.size(), empList.size());

		verify(repo, times(1)).getEmployees(name, null, null);

	}
	
	@Test
	public void getEmployeesOnlyTeamPresentTest() {

		// given

		// when

		when(repo.getEmployees(null, team, null)).thenReturn(empList);

		List<Employee> emplList = service.getEmployees(null, team, null);

		// then

		assertEquals(emplList.get(0).getTeam(), team);
		assertEquals(emplList.size(), empList.size());

		verify(repo, times(1)).getEmployees(null, team, null);

	}
	
	@Test
	public void getEmployeesOnlyTeamLeadPresentTest() {

		// given

		// when

		when(repo.getEmployees(null, null, teamLead)).thenReturn(empList);

		List<Employee> emplList = service.getEmployees(null, null, teamLead);

		// then

		assertEquals(emplList.get(0).getTeamLead(), teamLead);
		assertEquals(emplList.size(), empList.size());

		verify(repo, times(1)).getEmployees(null, null, teamLead);

	}
	
	@Test
	public void getEmployeesNameAndTeamPresentTest() {

		// given

		// when

		when(repo.getEmployees(name, team, null)).thenReturn(empList);

		List<Employee> emplList = service.getEmployees(name, team, null);

		// then

		assertEquals(emplList.get(0).getName(), name);
		assertEquals(emplList.get(0).getTeam(), team);
		assertEquals(emplList.size(), empList.size());

		verify(repo, times(1)).getEmployees(name, team, null);

	}
	
	@Test
	public void getEmployeesNameAndTeamLeadPresentTest() {

		// given

		// when

		when(repo.getEmployees(name, null, teamLead)).thenReturn(empList);

		List<Employee> emplList = service.getEmployees(name, null, teamLead);

		// then

		assertEquals(emplList.get(0).getName(), name);
		assertEquals(emplList.get(0).getTeamLead(), teamLead);
		assertEquals(emplList.size(), empList.size());

		verify(repo, times(1)).getEmployees(name, null, teamLead);

	}
	
	@Test
	public void getEmployeesTeamAndTeamLeadPresentTest() {

		// given

		// when

		when(repo.getEmployees(null, team, teamLead)).thenReturn(empList);

		List<Employee> emplList = service.getEmployees(null, team, teamLead);

		// then

		assertEquals(emplList.get(0).getTeam(), team);
		assertEquals(emplList.get(0).getTeamLead(), teamLead);
		assertEquals(emplList.size(), empList.size());

		verify(repo, times(1)).getEmployees(null, team, teamLead);

	}
	
	@Test
	public void createEmployeeSuccess() {

		// given


		// when

		when(repo.save(any())).thenAnswer(i -> i.getArguments()[0]);

		Employee saved = service.createEmployee(empl1);
		// then

		assertEquals(saved.getName(), empl1.getName());
		assertEquals(saved.getTeam(), empl1.getTeam());

		verify(repo, times(1)).save(any());
	}
	
	@Test
	public void deleteEmployeeSuccess() {

		// given
		long id = empl1.getPersonalId();
		
		

		// when

		when(repo.findById(id)).thenReturn(Optional.of(empl1));

		doNothing().when(repo).deleteById(id);
		
		long deletedId = service.deleteEmployee(id);
		
		// then

		assertEquals(deletedId, empl1.getPersonalId());

		verify(repo, times(1)).deleteById(any());
		verify(repo, times(1)).findById(any());
	}
	
	@Test
	public void getEmployeeByIdTest() {

		// given

		long id = empl1.getPersonalId();
		// when

		when(repo.findById(id)).thenReturn(Optional.of(empl1));

		Employee empl = service.findEmployeeById(id);
				

		// then

		assertEquals(empl.getPersonalId(), id);

		verify(repo, times(1)).findById(id);

	}
}
