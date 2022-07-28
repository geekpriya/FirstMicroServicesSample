package com.empdept.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.empdept.model.Employee;

@Repository
public class EmployeeDALImpl implements EmployeeDAL {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Employee> getAllEmployees() {
		return mongoTemplate.findAll(Employee.class);
	}
	
	@Override
	public List<Employee> getEmployeesByDeptId(String depId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("depId").is(depId));
		return mongoTemplate.find(query, Employee.class);

	}

	@Override
	public Employee getEmployeeById(String empId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("empId").is(empId));
		return mongoTemplate.findOne(query, Employee.class);

	}

	@Override
	public Employee addEmployee(Employee employee) {
		mongoTemplate.save(employee);
		return employee;
	}

}
