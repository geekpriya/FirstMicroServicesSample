package com.employee.model;

import java.util.ArrayList;
import java.util.List;

public class DepartmentEmployee {

	private String deptId;
	private String deptName;
	private List<Employee> empList;

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Employee> getEmpList() {
		if (empList == null) {
			empList = new ArrayList();
		}
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}

}
