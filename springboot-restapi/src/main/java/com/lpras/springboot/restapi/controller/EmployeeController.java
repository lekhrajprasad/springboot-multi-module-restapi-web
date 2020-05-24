package com.lpras.springboot.restapi.controller;


import com.lpras.lombok.model.Employee;
import com.lpras.springboot.restapi.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@CrossOrigin(origins = "http://192.168.43.90:8081")
@RestController
@RequestMapping(value = "/api/emp")
public class EmployeeController {
    @Autowired
    EmployeeService serv;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Method to save employees in the db.
     *
     * @param emp
     * @return
     */
    @PostMapping(value = "/create")
    public String create(@RequestBody List<Employee> emp) {
        //logger.debug("Saving employees.");
        serv.createEmployee(emp);
        return "Employee records created.";
    }

    /**
     * Method to fetch all employees from the db.
     *
     * @return
     */
    @GetMapping(value = "/getall")
    public Collection<Employee> getAll() {
        logger.debug("Getting all employees.");
        return serv.getAllEmployees();
    }
}
