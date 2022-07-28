package com.empdept.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.http.ResponseEntity;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.empdept.exception.*;
import com.empdept.model.Department;
import com.empdept.model.DepartmentEmployee;
import com.empdept.model.Employee;

@RestController
@RequestMapping("/empdept")
public class EmployeeDepartmentController {

	final String EMP_URI = "http://localhost:8103/employee"; ///employees
	final String DEPT_URI = "http://localhost:8104/department";
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/empbydeptid/{deptId}", method = RequestMethod.GET)
	public DepartmentEmployee getEmployeesByDeptId(@PathVariable String deptId) throws Exception {
		Employee[] resp = restTemplate.getForObject("http://localhost:8103/employee/empbydeptid/"+deptId, Employee[].class);
		DepartmentEmployee departmentEmployee = new DepartmentEmployee();

		departmentEmployee.setDeptId(deptId);

		ResponseEntity<Department> departmentEntity = restTemplate.getForEntity(DEPT_URI + "/departments/" + deptId,
				Department.class);
		departmentEmployee.setDeptName(departmentEntity.getBody().getDeptName());
		List<Employee> empList = Arrays.asList(resp).stream().filter(e -> deptId.equals(e.getDepId()))
				.collect(Collectors.toList());

		departmentEmployee.setEmpList(empList);
		// Get Dept Data
		return departmentEmployee;
	}
	
	@RequestMapping(value = "/employees/{deptId}/{employee}", method = RequestMethod.POST)
	public DepartmentEmployee addEmployeeInDept(@PathVariable String deptId, @RequestBody Employee employee)
			throws Exception {
		Employee resp = restTemplate.postForObject("http://localhost:8103/employee/create/", employee, Employee.class);

		Department departmentEntity = restTemplate.getForObject(DEPT_URI + "/departments/" + deptId, Department.class);

		departmentEntity.getEmpId().add(employee.getEmpId());
		// call delete on dept entity before create
		departmentEntity = restTemplate.postForObject("http://localhost:8104/department/create/", departmentEntity,
				Department.class);
		// Get Dept Data 

		DepartmentEmployee departmentEmployee = new DepartmentEmployee();

		departmentEmployee.setDeptId(deptId);
		departmentEmployee.setDeptName(departmentEntity.getDeptName());
		departmentEmployee.getEmpList().add(resp);
		return departmentEmployee;
	}

	@RequestMapping(value = "/empbyempid/{empId}", method = RequestMethod.GET)
	public Employee getEmpByEmpId(@PathVariable String empId) throws Exception {
		ResponseEntity<Employee> resp = restTemplate.getForEntity("http://localhost:8103/employee/empbyempid/"+empId, Employee.class);
		// Get Dept Data
		return resp.getBody();
	}
	
	@RequestMapping(value = "/department/create", method = RequestMethod.POST)
	public Department addDepartment(@RequestBody Department department) {
		Department dept = restTemplate.postForObject("http://localhost:8104/department/create/", department,
				Department.class);
		return dept;
	}
}
