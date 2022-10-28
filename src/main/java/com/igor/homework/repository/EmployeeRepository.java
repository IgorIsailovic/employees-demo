package com.igor.homework.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.igor.homework.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query(value = "SELECT * FROM employee WHERE (:name is null or name =:name)\r\n"
			+ "	   AND (:team is null or team = :team)\r\n"
			+ "	   AND (:teamLead is null or team_lead = :teamLead)", nativeQuery = true)
	List<Employee> getEmployees(@Param("name") String name, @Param("team") String team,
			@Param("teamLead") String teamLead);

}
