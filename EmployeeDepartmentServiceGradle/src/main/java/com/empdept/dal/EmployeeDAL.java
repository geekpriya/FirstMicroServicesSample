package com.empdept.dal;

import java.util.List;

import com.empdept.model.Employee;

public interface EmployeeDAL {

	Employee getEmployeeById(String empId);

	Employee addEmployee(Employee employee);

	List<Employee> getAllEmployees();
	
	List<Employee> getEmployeesByDeptId(String depId);

}
