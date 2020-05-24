package com.lpras.springboot.restapi.service;



import com.lpras.lombok.model.Employee;
import com.lpras.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceimpl implements EmployeeService {
    // The dao repository will use the Mongodb-Repository to perform the database operations.
    @Autowired
    private EmployeeRepository employeeRepository;

    /* (non-Javadoc)
     * @see com.assignment.springboot.mongo.service.Employeeservice#createEmployee(java.util.List)
     */
    @Override
    public void createEmployee(List<Employee> emp) {
        employeeRepository.saveAll(emp);
    }

    /* (non-Javadoc)
     * @see com.assignment.springboot.mongo.service.Employeeservice#getAllEmployees()
     */
    @Override
    public Collection<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    /* (non-Javadoc)
     * @see com.assignment.springboot.mongo.service.Employeeservice#findEmployeeById(int)
     */
    @Override
    public Optional<Employee> findEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    /* (non-Javadoc)
     * @see com.assignment.springboot.mongo.service.Employeeservice#deleteEmployeeById(int)
     */
    @Override
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }

    /* (non-Javadoc)
     * @see com.assignment.springboot.mongo.service.Employeeservice#updateEmployee(int)
     */
    @Override
    public void updateEmployee(Employee emp) {
        employeeRepository.save(emp);
    }

    /* (non-Javadoc)
     * @see com.assignment.springboot.mongo.service.Employeeservice#deleteAllEmployees()
     */
    @Override
    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }

}
