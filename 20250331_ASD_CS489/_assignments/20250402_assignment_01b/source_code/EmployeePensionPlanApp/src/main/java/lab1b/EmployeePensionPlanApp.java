package lab1b;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lab1b.model.Employee;
import lab1b.model.PensionPlan;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EmployeePensionPlanApp {
    public static void main(String[] args) throws Exception {
        System.out.println("I am main");
        // 1. Load employee data
        List<Employee> employees = loadEmployeeData();

        // 2. Task 1::
        // Company requires this list to include the Pension Plan data for each Employee (if it
        // exists) and the list is to be displayed sorted in descending order of the Employees’ Yearly
        // salaries and ascending order of their Last Names
        printEmployeesAsJson(employees);


        // 3. Task 2::
        // print out the data of the Quarterly Upcoming Enrollees report in JSON format
        printQualifyingEmployeesAsJson(employees);
    }

    private static void printEmployeesAsJson(List<Employee> employees) throws JsonProcessingException {
        List<Employee> sortedEmployees = employees.stream()
                                                  .sorted(Comparator.comparing(Employee::getYearlySalary)
                                                                    .reversed()
                                                                    .thenComparing(Employee::getLastName)
                                                         )
                                                  .toList();


        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.registerModule(new JavaTimeModule());
        String json = objectMapper.writeValueAsString(sortedEmployees);
        System.out.println("Printing employees as JSON");
        System.out.println(json);
    }

    private static void printQualifyingEmployeesAsJson(List<Employee> employees) throws JsonProcessingException {
        LocalDate today                 = LocalDate.now();
        int       currentQuarter        = (today.getMonthValue() - 1) / 3 + 1;  // Determine current quarter (1-4)
        int       nextQuarter           = (currentQuarter % 4) + 1;  // Get the next quarter (1-4)
        int       nextQuarterStartMonth = (nextQuarter - 1) * 3 + 1;  // Calculate the first month of next quarter
        int       nextQuarterYear       = (nextQuarter == 1) ?
                                          today.getYear() + 1 :
                                          today.getYear();  // Adjust for year transition

        LocalDate startOfNextQuarter = LocalDate.of(nextQuarterYear, nextQuarterStartMonth, 1);
        LocalDate endOfNextQuarter   = startOfNextQuarter.plusMonths(3).minusDays(1);


        List<Employee> qualifyingEmployees = employees.stream()
                                                      .filter(e -> e.getPensionPlan() == null)
                                                      .filter(e -> e.getEmploymentDate()
                                                                    .plusYears(3)
                                                                    .isAfter(startOfNextQuarter) &&
                                                                   e.getEmploymentDate()
                                                                    .plusYears(3)
                                                                    .isBefore(endOfNextQuarter))
                                                      .sorted(Comparator.comparing(Employee::getEmploymentDate)
                                                                        .reversed())
                                                      .toList();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.registerModule(new JavaTimeModule());
        String json = objectMapper.writeValueAsString(qualifyingEmployees);
        System.out.println("Printing all the employees qualifying for pension on next quarter as JSON");
        System.out.println(json);
    }

    private static List<Employee> loadEmployeeData() {
        return Arrays.asList(new Employee(1L, "Daniel", "Agar", LocalDate.of(2018, 1, 17), new BigDecimal("105945.50"),
                                          new PensionPlan("EX1089", LocalDate.of(2023, 1, 17), new BigDecimal("100.00"))
                             ), new Employee(2L, "Benard", "Shaw", LocalDate.of(2022, 9, 3), new BigDecimal("197750.00"), null),
                             new Employee(3L, "Carly", "Agar", LocalDate.of(2014, 5, 16), new BigDecimal("842000.75"),
                                          new PensionPlan("SM2307", LocalDate.of(2019, 11, 4),
                                                          new BigDecimal("1555.50")
                                          )
                             ), new Employee(4L, "Wesley", "Schneider", LocalDate.of(2022, 7, 21),
                                             new BigDecimal("74500.00"), null
                ), new Employee(5L, "Anna", "Wiltord", LocalDate.of(2022, 6, 15), new BigDecimal("85750.00"), null),
                             new Employee(6L, "Yosef", "Tesfalem", LocalDate.of(2022, 10, 31),
                                          new BigDecimal("100000.00"), null
                             )
                            );
    }
}
