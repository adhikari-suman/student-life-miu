package edu.miu.cs489.containerization.dockercomposeems.service;

import edu.miu.cs489.containerization.dockercomposeems.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Optional<Employee> createEmployee(Employee employee);
    List<Employee> findAllEmployees();
}
