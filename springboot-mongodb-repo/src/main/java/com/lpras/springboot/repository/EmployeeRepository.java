package com.lpras.springboot.repository;

import com.lpras.lombok.model.Employee;
import com.lpras.springboot.model.CustomerUserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer> {

}
