package com.lpras.springboot.repository;

import com.lpras.lombok.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDetailRepository extends MongoRepository<Employee, Integer> {
}
