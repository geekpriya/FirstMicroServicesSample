package com.department.model;

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
	private List<String> empIdList;

	public Department() {
	}

	public List<String> getEmpIdList() {
		return empIdList;
	}

	public void setEmpIdList(List<String> empIdList) {
		this.empIdList = empIdList;
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

	public String getDepartmentId() {
		return deptId;
	}

	public void setDepartmentId(String deptId) {
		this.deptId = deptId;
	}

	public String getDepartmentName() {
		return deptName;
	}

	public void setDepartmentName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Department [deptName=" + deptName + ", deptId=" + deptId + "]";
	}

}
