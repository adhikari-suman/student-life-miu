package edu.miu.lab.repository;

import edu.miu.lab.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
