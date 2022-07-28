package com.department.dal;

import java.util.List;

import com.department.model.Department;

public interface DepartmentDAL {
	Department getDepartmentById(String deptId);

	Department addDepartment(Department department);

	List<Department> getAllDepartments();

}
