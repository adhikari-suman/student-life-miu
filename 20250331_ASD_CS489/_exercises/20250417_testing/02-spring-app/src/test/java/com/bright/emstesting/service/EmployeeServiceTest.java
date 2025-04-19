package com.bright.emstesting.service;

import com.bright.emstesting.dto.request.EmployeeRequestDto;
import com.bright.emstesting.dto.response.EmployeeResponseDto;
import com.bright.emstesting.exception.employee.DuplicateEmailException;
import com.bright.emstesting.model.Employee;
import com.bright.emstesting.repository.EmployeeRepository;
import com.bright.emstesting.service.impl.EmployeeServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    // Mock employeeRepository
    @Mock private EmployeeRepository employeeRepository;

    @InjectMocks private EmployeeServiceImpl employeeService;

    private Employee           employee;
    private EmployeeRequestDto employeeRequestDto;

    @BeforeEach
    void setUp() {
        // an employe
        employee = Employee.builder()
                           .firstName("John")
                           .lastName("Doe")
                           .email("john.doe@gmail.com")
                           .departmentCode("IT")
                           .build();

        // an employeeRequestDto
        employeeRequestDto = new EmployeeRequestDto(
                employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getDepartmentCode());
    }

    @Test
    @DisplayName("Create employee when email does not exist")
    void givenEmployeeRequestDto_whenCreateEmployee_thenReturnEmployeeResponseDto() {
        // given
        // set the Mockito behavior
        Mockito.when(employeeRepository.findByEmail(employeeRequestDto.email())).thenReturn(Optional.empty());
        Mockito.when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(employee);

        // when
        EmployeeResponseDto employeeResponseDto = employeeService.createEmployee(employeeRequestDto);

        // then
        Assertions.assertThat(employeeResponseDto)
                  .isEqualTo(new EmployeeResponseDto(
                          employeeRequestDto.firstName(), employeeRequestDto.lastName(),
                          employeeRequestDto.departmentCode()
                  ));

        Mockito.verify(employeeRepository, Mockito.times(1)).findByEmail(Mockito.any());
        Mockito.verify(employeeRepository, Mockito.times(1)).save(Mockito.any(Employee.class));
    }

    @Test
    @DisplayName("Create employee with existing email should throw DuplicateEmailException")
    void givenEmployeeRequestDtoWithExistingEmail_whenCreateEmployee_thenThrowsDuplicateEmailException() {
        // set the Mockito behavior
        Mockito.when(employeeRepository.findByEmail(employeeRequestDto.email())).thenReturn(Optional.of(employee));
        assertThrows(DuplicateEmailException.class, () -> employeeService.createEmployee(employeeRequestDto));

        Mockito.verify(employeeRepository, Mockito.times(1)).findByEmail(employeeRequestDto.email());
        Mockito.verify(employeeRepository, Mockito.never()).save(Mockito.any(Employee.class));
    }

    @Test
    @DisplayName("Find all employees should return all employees available in the list")
    void givenNothing_whenGetAllEmployees_thenReturnEmployeeResponseDtoList() {
        // given
        Mockito.when(employeeRepository.findAll()).thenReturn(List.of(employee));

        // when
        List<EmployeeResponseDto> employeeResponseDtoList = employeeService.getAllEmployees();

        // then
        assertEquals(1, employeeResponseDtoList.size(), "There should be one employee");
        Assertions.assertThat(employeeResponseDtoList.get(0))
                  .isEqualTo(new EmployeeResponseDto(
                          employeeRequestDto.firstName(), employeeRequestDto.lastName(),
                          employeeRequestDto.departmentCode()
                  ));
    }

    @Test
    @DisplayName("Updating an existing employee should succeed")
    void givenExistingEmployee_whenUpdate_thenReturnEmployeeResponseDto() {
        // Set the Mockito behavior
        Mockito.when(employeeRepository.findByEmail(employeeRequestDto.email())).thenReturn(Optional.of(employee));
        Mockito.when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(employee);

        // when
        EmployeeResponseDto employeeResponseDto = employeeService.updateEmployee(
                employeeRequestDto.email(),
                employeeRequestDto
                                                                                );

        // then
        Mockito.verify(employeeRepository, Mockito.times(1)).findByEmail(employeeRequestDto.email());
        Mockito.verify(employeeRepository, Mockito.times(1)).save(Mockito.any(Employee.class));
        Assertions.assertThat(employeeResponseDto)
                  .isEqualTo(new EmployeeResponseDto(
                          employeeRequestDto.firstName(), employeeRequestDto.lastName(),
                          employeeRequestDto.departmentCode()
                  ));
    }

    @Test
    @DisplayName("Delete an existing employee should succeed")
    void givenExistingEmployee_whenDelete_thenDeleted() {
        // set the Mockito behavior
        Mockito.when(employeeRepository.findByEmail(employeeRequestDto.email())).thenReturn(Optional.of(employee));
        Mockito.doNothing().when(employeeRepository).deleteByEmail(employeeRequestDto.email());

        // when
        employeeRepository.deleteByEmail(employeeRequestDto.email());

        // then
        Mockito.verify(employeeRepository, Mockito.times(1)).findByEmail(employeeRequestDto.email());
        Mockito.verify(employeeRepository, Mockito.times(1)).deleteByEmail(employeeRequestDto.email());


    }

}