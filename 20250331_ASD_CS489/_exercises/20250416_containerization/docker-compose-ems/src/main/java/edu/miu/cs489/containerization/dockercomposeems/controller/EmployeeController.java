package edu.miu.cs489.containerization.dockercomposeems.controller;

import edu.miu.cs489.containerization.dockercomposeems.model.Employee;
import edu.miu.cs489.containerization.dockercomposeems.repository.EmployeeRepository;
import edu.miu.cs489.containerization.dockercomposeems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok(employeeService.findAllEmployees());
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.createEmployee(employee)
                .orElseThrow(() -> new RuntimeException("Employee not created"));

        return ResponseEntity.ok(savedEmployee);
    }
}
