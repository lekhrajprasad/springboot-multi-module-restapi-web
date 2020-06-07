package com.lpras.springboot.restapi.service;

import com.lpras.springboot.restapi.model.CustomerUserDetails;
import com.lpras.springboot.restapi.repo.CustomerUserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gkatzioura on 9/27/16.
 */
@Service
public class CustomerUserDetailsService implements UserDetailsService {

    /*@Autowired
    private MongoClient mongoClient;*/

    @Autowired
    private CustomerUserDetailsRepository customerUserDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        /*MongoDatabase database = mongoClient.getDatabase("crud");
        MongoCollection<Document> collection = database.getCollection("users");

        Document document = collection.find(Filters.eq("email",email)).first();*/
        List<CustomerUserDetails> customerUserDetailsList = customerUserDetailsRepository.findByEmail(email);
        /*if(document!=null) {

            String name = document.getString("name");
            String surname = document.getString("surname");
            String password = document.getString("password");
            List<String> authorities = (List<String>) document.get("authorities");

            CustomerUserDetails mongoUserDetails = new CustomerUserDetails(email,password,authorities.toArray(new String[authorities.size()]));

            return mongoUserDetails;
        } else {
            throw new UsernameNotFoundException("username not found");
        }*/
        return customerUserDetailsList.get(0);
    }

}
