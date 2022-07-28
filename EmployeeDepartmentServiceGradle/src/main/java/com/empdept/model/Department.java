package com.empdept.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Department {
	@Id
	private String deptId;
	private String deptName;
	private List<String> empId;

	public Department() {
	}

	public List<String> getEmpId() {
		if (empId == null) {
			empId = new ArrayList();
		}
		return empId;
	}

	public void setEmpId(List<String> empId) {
		this.empId = empId;
	}

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

	@Override
	public String toString() {
		return "Department [deptName=" + deptName + ", deptId=" + deptId + "]";
	}

}
