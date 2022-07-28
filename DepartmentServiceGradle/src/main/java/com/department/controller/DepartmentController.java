package com.department.controller;

import java.util.ArrayList;
import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.department.dal.DepartmentDAL;
import com.department.dal.DepartmentRepository;
import com.department.model.Department;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@SuppressWarnings("unused")
	private final DepartmentRepository departmentRepository;

	private final DepartmentDAL departmentDAL;

	public DepartmentController(DepartmentRepository departmentRepository, DepartmentDAL departmentDAL) {
		this.departmentRepository = departmentRepository;
		this.departmentDAL = departmentDAL;
	}

	@RequestMapping(value = "/departments", method = RequestMethod.GET)
	public List<Department> getAllDepartments() {
		return departmentDAL.getAllDepartments();
	}

	@RequestMapping(value = "/departments/{deptId}", method = RequestMethod.GET)
	public Department getdepartmentById(@PathVariable String deptId) {

		return departmentDAL.getDepartmentById(deptId);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Department addDepartment(@RequestBody Department department) {
		return departmentDAL.addDepartment(department);
	}

}
