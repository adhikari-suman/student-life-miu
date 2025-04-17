package edu.miu.cs489.containerization.dockercomposeems.repository;

import edu.miu.cs489.containerization.dockercomposeems.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
