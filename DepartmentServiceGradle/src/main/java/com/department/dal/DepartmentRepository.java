package com.department.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.department.model.Department;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {

}
