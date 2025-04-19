package com.bright.emstesting.repository;

import com.bright.emstesting.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired private EmployeeRepository employeeRepository;

    @Autowired private TestEntityManager entityManager;

    private            Employee          employee;
    @Autowired private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        employee = Employee.builder()
                           .firstName("John")
                           .lastName("Doe")
                           .email("john.doe@gmail.com")
                           .departmentCode("IT")
                           .build();
    }

    @Test
    @DisplayName("Test for creating a new employee")
    void givenNonExistentEmployee_whenCreatingNewEmployee_thenReturnsEmployee() {
        // Given
        // Given employee is not in database

        // When
        Employee savedEmployee = employeeRepository.saveAndFlush(employee);

        // Then
        assertNotNull(savedEmployee, "Employee should not be null");
        assertNotNull(savedEmployee.getId(), "Employee ID should not be null");
        assertEquals("John", savedEmployee.getFirstName(), "First name should be John");
        assertEquals("Doe", savedEmployee.getLastName(), "Last name should be Doe");
        assertEquals("IT", savedEmployee.getDepartmentCode(), "Department code should be IT");
        assertEquals("john.doe@gmail.com", savedEmployee.getEmail(), "Email should be john@doe.com");
    }

    @Test
    @DisplayName("Test for creating an existing employee")
    void givenExistingEmployee_whenCreatingNewEmployee_thenThrowsDataIntegrityViolationException() {
        // given
        Employee savedEmployee = employeeRepository.saveAndFlush(employee);

        Employee newEmployee = Employee.builder()
                                       .firstName("John")
                                       .lastName("Doe")
                                       .email("john.doe@gmail.com")
                                       .departmentCode("IT")
                                       .build();


        // when
        // then
        // throw exception when saving existing employee
        assertThrows(DataIntegrityViolationException.class, () -> employeeRepository.saveAndFlush(newEmployee));

    }

    @Test
    @DisplayName("Test for finding an employee by email")
    void givenExistingEmployee_whenFindingEmployeeByEmail_thenReturnsEmployee() {
        // given
        Employee savedEmployee = employeeRepository.saveAndFlush(employee);

        // when
        Optional<Employee> foundEmployee = employeeRepository.findByEmail(savedEmployee.getEmail());

        // then
        assertTrue(foundEmployee.isPresent(), "Employee should not be null");
        assertEquals("John", foundEmployee.get().getFirstName(), "First name should be John");
        assertEquals("Doe", foundEmployee.get().getLastName(), "Last name should be Doe");
        assertEquals("IT", foundEmployee.get().getDepartmentCode(), "Department code should be IT");
        assertEquals("john.doe@gmail.com", savedEmployee.getEmail(), "Email should be john@doe.com");
    }

    @Test
    @DisplayName("Test for finding an employee by email")
    void givenNonExistentEmployee_whenFindingEmployeeByEmail_thenReturnsOptionalEmpty() {
        // given
        employeeRepository.deleteAll();
        testEntityManager.flush();

        // when
        Optional<Employee> foundEmployee = employeeRepository.findByEmail("john@doe.com");

        // then
        assertFalse(foundEmployee.isPresent(), "No employee should be found");
    }

    @Test
    @DisplayName("")
    void givenExistingDepartmentCode_whenFindingEmployeeByDepartmentCode_thenReturnsEmployeeList() {
        // given
        Employee janeSmith = Employee.builder()
                                     .firstName("Jane")
                                     .lastName("Smith")
                                     .email("jane.smith@gmail.com")
                                     .departmentCode("IT")
                                     .build();

        employeeRepository.save(employee);
        employeeRepository.save(janeSmith);
        testEntityManager.flush();


        // when
        List<Employee> foundEmployees = employeeRepository.findAll();
        List<String>   foundEmails    = foundEmployees.stream().map(Employee::getEmail).toList();

        // then
        assertNotNull(foundEmployees, "Employees should not be null");
        assertEquals(2, foundEmployees.size(), "Incorrect number of employees");
        assertTrue(foundEmployees.stream().allMatch(emp -> emp.getDepartmentCode().equals("IT")));
        Assertions.assertThat(foundEmails).containsExactlyInAnyOrder("jane.smith@gmail.com", "john.doe@gmail.com");
    }

    @Test
    @DisplayName("Test for deleting an existing employee")
    void givenExistingEmployee_whenDeletingEmployee_thenDeleted() {
        // given
        Employee savedEmployee = employeeRepository.saveAndFlush(employee);

        // when
        // for repository methods, save, delete are run in the persistence context, not directly hits
        // db immediately
        employeeRepository.deleteById(savedEmployee.getId());
        testEntityManager.flush();

        // For JPQL, it hits db directly no need to flush
        employeeRepository.deleteById(savedEmployee.getId());

        // then
        Optional<Employee> optionalEmployee = employeeRepository.findById(savedEmployee.getId());

        assertFalse(optionalEmployee.isPresent(), "Employee should not be found");
    }
}