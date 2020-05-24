package com.lpras.springboot.restapi.repo;

import com.lpras.springboot.restapi.model.CustomerUserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerUserDetailsRepository extends MongoRepository<CustomerUserDetails, Integer> {
    List<CustomerUserDetails> findByEmail(String email);
}
