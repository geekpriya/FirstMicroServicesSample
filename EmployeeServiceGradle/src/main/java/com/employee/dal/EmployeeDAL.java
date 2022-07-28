package com.employee.dal;

import java.util.List;

import com.employee.model.Employee;

public interface EmployeeDAL {



	Employee addEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmpByEmpId(String empId);

	

	List<Employee> getEmpByDeptId(String deptId);


}
