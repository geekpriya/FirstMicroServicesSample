package com.employee.controller;

import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dal.EmployeeDAL;
import com.employee.dal.EmployeeRepository;
import com.employee.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	// private final Logger LOG = LoggerFactory.getLogger(getClass());

	@SuppressWarnings("unused")
	private final EmployeeRepository employeeRepository;

	private final EmployeeDAL employeeDAL;

	public EmployeeController(EmployeeRepository employeeRepository, EmployeeDAL employeeDAL) {
		this.employeeRepository = employeeRepository;
		this.employeeDAL = employeeDAL;
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public List<Employee> getAllEmployees() {
		return employeeDAL.getAllEmployees();
	}

	@RequestMapping(value = "/employees/{empId}", method = RequestMethod.GET)
	public Employee getEmployeeById(@PathVariable String empId) {

		return employeeDAL.getEmployeeById(empId);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeDAL.addEmployee(employee);
	}

}
