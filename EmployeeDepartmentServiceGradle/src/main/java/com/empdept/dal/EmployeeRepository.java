package com.empdept.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.empdept.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

}
