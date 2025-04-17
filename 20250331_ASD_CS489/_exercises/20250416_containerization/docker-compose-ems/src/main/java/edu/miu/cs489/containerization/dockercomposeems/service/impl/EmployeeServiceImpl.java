package edu.miu.cs489.containerization.dockercomposeems.service.impl;

import edu.miu.cs489.containerization.dockercomposeems.model.Employee;
import edu.miu.cs489.containerization.dockercomposeems.repository.EmployeeRepository;
import edu.miu.cs489.containerization.dockercomposeems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> createEmployee(Employee employee) {
        return Optional.of(employeeRepository.save(employee));
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }
}
