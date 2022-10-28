package com.igor.homework;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.igor.homework.models.Employee;
import com.igor.homework.service.implementation.EmployeeServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeContollerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper mapper;

	@MockBean
	EmployeeServiceImpl service;

	private Employee empl = new Employee("Predrag", "Development", "Mirko");

	@Test
	public void getAllEmployees_success() throws Exception {

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/v1/employees")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(mockRequest).andExpect(status().isOk());

	}

	@Test
	public void getAllEmployees_badEndPoint() throws Exception {

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/v1/employeess")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(mockRequest).andExpect(status().isNotFound());

	}

	@Test
	public void createEmployee_success() throws Exception {

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/v1/employees")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(empl)

				);

		mockMvc.perform(mockRequest).andExpect(status().isCreated());

	}

	@Test
	public void deleteEmployee_success() throws Exception {

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.delete("/v1/employees/" + empl.getPersonalId()).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(empl.getPersonalId())

				);

		mockMvc.perform(mockRequest).andExpect(status().isOk());

	}

	@Test
	public void getEmployeeById_success() throws Exception {

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/v1/employees/" + empl.getPersonalId())
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(empl)

				);

		mockMvc.perform(mockRequest).andExpect(status().isOk());

	}
}
