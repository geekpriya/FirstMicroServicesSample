package com.department.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.department.model.Department;

@Repository
public class DepartmentDALImpl implements DepartmentDAL {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Department> getAllDepartments() {
		return mongoTemplate.findAll(Department.class);
	}

	@Override
	public Department getDepartmentById(String deptId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("deptId").is(deptId));
		return mongoTemplate.findOne(query, Department.class);

	}

	@Override
	public Department addDepartment(Department department) {
		mongoTemplate.save(department);
		return department;
	}

}
