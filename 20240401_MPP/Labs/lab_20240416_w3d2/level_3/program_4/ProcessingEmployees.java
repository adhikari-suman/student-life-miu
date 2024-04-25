package lab_20240416_w3d2.level_3.program_4;
// Program 4: ProcessingEmployees.java
// Processing streams of Employee objects.

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProcessingEmployees {
    public static void main(String[] args) {
        // initialize array of Employees
        Employee[] employees = {
                new Employee("Jason", "Red", 5000, "IT"),
                new Employee("Ashley", "Green", 7600, "IT"),
                new Employee("Matthew", "Indigo", 3587.5, "Sales"),
                new Employee("James", "Indigo", 4700.77, "Marketing"),
                new Employee("Luke", "Indigo", 6200, "IT"),
                new Employee("Jason", "Blue", 3200, "Sales"),
                new Employee("Wendy", "Brown", 4236.4, "Marketing")};

        // get List view of the Employees
        List<Employee> list = Arrays.asList(employees);

        // display all Employees
        System.out.println("Complete Employee list:");
        list.stream().forEach(System.out::println);   //A method reference.

        // Predicate (boolean-valued function) that returns true for salaries
        //in the range $4000-$6000
        Predicate<Employee> fourToSixThousand =
                e -> (e.getSalary() >= 4000 && e.getSalary() <= 6000);

        // Display Employees with salaries in the range $4000-$6000
        // sorted into ascending order by salary
        System.out.printf(
                "%nEmployees earning $4000-$6000 per month sorted by salary:%n");

        list.stream()
                .filter(fourToSixThousand)
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);

        // Display first Employee with salary in the range $4000-$6000
        System.out.printf("%nFirst employee who earns $4000-$6000:%n%s%n",
                list.stream()
                        .filter(fourToSixThousand)
                        .findFirst()
                        .get());

        // Functions for getting first and last names from an Employee
        Function<Employee, String> byFirstName = Employee::getFirstName;
        Function<Employee, String> byLastName = Employee::getLastName;

        // Comparator for comparing Employees by first name then last name
        Comparator<Employee> lastThenFirst =
                Comparator.comparing(byLastName).thenComparing(byFirstName);

        // sort employees by last name, then first name
        System.out.printf(
                "%nEmployees in ascending order by last name then first:%n");
        list.stream()
                .sorted(lastThenFirst)
                .forEach(System.out::println);

        // sort employees in descending order by last name, then first name
        System.out.printf(
                "%nEmployees in descending order by last name then first:%n");
        list.stream()
                .sorted(lastThenFirst.reversed())
                .forEach(System.out::println);

        // display unique employee last names sorted
        System.out.printf("%nUnique employee last names:%n");
        list.stream()
                .map(Employee::getLastName)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        // display only first and last names
        System.out.printf(
                "%nEmployee names in order by last name then first name:%n");
        list.stream()
                .sorted(lastThenFirst)
                .map(Employee::getName)
                .forEach(System.out::println);

        // group Employees by department
        System.out.printf("%nEmployees by department:%n");
        Map<String, List<Employee>> groupedByDepartment =
                list.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment));

        groupedByDepartment.forEach(
                (department, employeesInDepartment) ->
                {
                    System.out.println(department);
                    employeesInDepartment.forEach(
                            employee -> System.out.printf("   %s%n", employee));
                }
        );


        // count number of Employees in each department
        System.out.printf("%nCount of Employees by department:%n");

        Map<String, Long> employeeCountByDepartment =
                list.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment,
                                TreeMap::new, Collectors.counting()));

        employeeCountByDepartment.forEach(
                (department, count) -> System.out.printf(
                        "%s has %d employee(s)%n", department, count));

/*  Output looks something like :

        HR  4
        IT  8
        Sales  12
*/

        // sum of Employee salaries with DoubleStream sum method
        System.out.printf(
                "%nSum of Employees' salaries (via sum method): %.2f%n",
                list.stream()
                        .mapToDouble(Employee::getSalary)
                        .sum());

        // calculate sum of Employee salaries with Stream reduce method
        System.out.printf(
                "Sum of Employees' salaries (via reduce method): %.2f%n",
                list.stream()
                        .mapToDouble(Employee::getSalary)
                        .reduce(0, (value1, value2) -> value1 + value2));

        // average of Employee salaries with DoubleStream average method
        System.out.printf("Average of Employees' salaries: %.2f%n",
                list.stream()
                        .mapToDouble(Employee::getSalary)
                        .average()
                        .getAsDouble());


        /**
         * ========================================================================
         * Answer of 2
         * ========================================================================
         */
        // Solution 2.a.1 -> count Number of Employees whose last name start with B
        long count1 = list.stream().filter(e -> e.getLastName().startsWith("B")).count();
        System.out.println("\nNumber of employees with last name starting with 'B': " + count1);

        // Solution 2.a.2 -> Print out all of the Employee objects whose last name begins with the letter  ‘B’
        // in sorted order.

        System.out.println("\nEmployees whose last name begins with 'B' in sorted order");
        list.stream()
                .filter(e -> e.getLastName().startsWith("B"))
                .sorted(Comparator.comparing(Employee::getLastName))
                .forEach(System.out::println);

        // Solution 2.a.3 -> Print out all of the Employee objects whose last name begins with the letter  ‘B’  and
        // change their first name and last name to be All capital letters.
        // without changing the list
        System.out.println("\nEmployees whose last name begins with 'B' in sorted order, fName and lName ALL CAPS " +
                "without changing list");
        list.stream()
                .filter(e -> e.getLastName().startsWith("B"))
                .map(e -> new Employee(
                        e.getFirstName().toUpperCase(),
                        e.getLastName().toUpperCase(),
                        e.getSalary(),
                        e.getDepartment())
                )
                .sorted(Comparator.comparing(Employee::getLastName))
                .forEach(System.out::println);

        System.out.println("\nOriginal list");
        list.stream()
                .filter(e -> e.getLastName().startsWith("B"))
                .sorted(Comparator.comparing(Employee::getLastName))
                .forEach(System.out::println);

        // commented for task 4
//        System.out.println("\nEmployees whose last name begins with 'B' in sorted order, fName and lName ALL CAPS " +
//                "and changing list");
//
//        list.stream()
//                .filter(e -> e.getLastName().startsWith("B"))
//                .peek(e -> {
//                    e.setFirstName(e.getFirstName().toUpperCase());
//                    e.setLastName(e.getLastName().toUpperCase());
//                })
//                .sorted(Comparator.comparing(Employee::getLastName))
//                .forEach(System.out::println);


        System.out.println("\nOriginal list");
//        list.stream()
//                .filter(e -> e.getLastName().startsWith("B"))
//                .sorted(Comparator.comparing(Employee::getLastName))
//                .forEach(System.out::println);

        // Solution 2.a.4 -> Print out All of the employee objects, but if the last name begins with the letter  ‘B’,
        // then capitalize all the letters in the last name.
        System.out.println("\nAll employees list. Employee with last name starting with B are ALL CAPS for last name");
        list.stream()
                .map(
                        e -> {
                            if (e.getLastName().startsWith("B")) {
                                Employee e1 = new Employee(e.getFirstName(),
                                        e.getLastName().toUpperCase(),
                                        e.getSalary(),
                                        e.getDepartment()
                                );

                                return e1;
                            }

                            return e;
                        }
                )
                .sorted(Comparator.comparing(Employee::getLastName))
                .forEach(System.out::println);

        // 4.1)  Use the  Collectors.joining  method to print out All Employee objects.  (See my  presentation file
        // ‘Do_Last_This_Was_Lesson 9_Streams_E.docx’.)
        System.out.println("\nAll employees list. Employee with last name starting with B are ALL CAPS for last name " +
                "using Collectors.joining()");
        String result = list.stream()
                .map(
                        e -> {
                            if (e.getLastName().startsWith("B")) {
                                Employee e1 = new Employee(e.getFirstName(),
                                        e.getLastName().toUpperCase(),
                                        e.getSalary(),
                                        e.getDepartment()
                                );

                                return e1;
                            }

                            return e;
                        }
                )
                .sorted(Comparator.comparing(Employee::getLastName))
                .map(Employee::toString)
                .collect(
                        Collectors.joining("\n")
                );
        System.out.println(result);

        // 4.2)  Use the  Collectors.joining  method to print out All Employee objects, and separate    each one with a
        // delimeter of  “---\n---“.    (See my  presentation file  ‘Do_Last_This_Was_Lesson 9_Streams_E.docx’.)
        System.out.println("\nAll employees list. Employee with last name starting with B are ALL CAPS for last name " +
                "using Collectors.joining(\"---\\n---\")");
        String result1 = list.stream()
                .map(
                        e -> {
                            if (e.getLastName().startsWith("B")) {
                                Employee e1 = new Employee(e.getFirstName(),
                                        e.getLastName().toUpperCase(),
                                        e.getSalary(),
                                        e.getDepartment()
                                );

                                return e1;
                            }

                            return e;
                        }
                )
                .sorted(Comparator.comparing(Employee::getLastName))
                .map(Employee::toString)
                .collect(
                        Collectors.joining("---\n---")
                );
        System.out.println(result1);

        // Solution 2.a.5 ->  Print out all of the Employee objects’ last names, whose last name begins with the letter
        // ‘I’  in sorted order, and get rid of all the duplicates.  Print out only the last names.
        System.out.println("\nLast name of all employees whoese last name beings with 'I' in distinct sorted order");
        list.stream()
                .map(Employee::getLastName)
                .filter(s -> s.startsWith("I"))
                .distinct()
                .sorted()
                .forEach(System.out::println);

        // Solution 2.a.6 -> Print out the average of all the salaries.
        double averageSalary = list.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
        System.out.printf("\nAverage salary: $%,.2f\n", averageSalary);

        // Solution 2.a.7 -> Print out the total of all the salaries.
        double totalSalary = list.stream().mapToDouble(Employee::getSalary).reduce(0, Double::sum);
        System.out.printf("\nTotal salary: $%,.2f\n", totalSalary);

        // Solution 2.a.8 -> Print out only the first names of all the employees.  Use the  ‘map’  method to accomplish
        // this.
        System.out.println("\nFirst name of all employees");
        list.stream().map(Employee::getFirstName)
                .forEach(System.out::println);

        // Solution 2.a.9 -> Create an infinite stream of even numbers (0, 2, 4, …) and then, eventually print out only
        // the first 20 even numbers from this stream.
        String evenNumbers = IntStream.iterate(0, n -> n + 2)
                .limit(20)
                .mapToObj(String::valueOf)
                .reduce((x, y) -> x + ", " + y).orElse("");
        System.out.println("\nFirst 20 even numbers: " + evenNumbers);


        // Level 3 - Solution 7.a
        System.out.println();
        list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .forEach(
                        (department, eList) -> {
                            System.out.printf("Department: %s Avg. Salary: $%,.2f\n",
                                    department,
                                    eList.stream()
                                            .mapToDouble(Employee::getSalary)
                                            .summaryStatistics()
                                            .getAverage()
                            );
                        }

                );

        // Level 3 - Solution 7.b
        System.out.println();
        list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .forEach(
                        (department, eList) -> {
                            System.out.printf("Department: %s Max. Salary: $%,.2f\n",
                                    department,
                                    eList.stream()
                                            .mapToDouble(Employee::getSalary)
                                            .summaryStatistics()
                                            .getMax()
                            );
                        }
                );

        // Level 3 - Solution 7.b
        System.out.println();
        list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .forEach(
                        (department, eList) -> {
                            System.out.printf("Department: %s\n", department);

                            System.out.println("Employees of " + department);
                            eList.forEach(System.out::println);
                            System.out.println();
                        }
                );

    } // end main
} // end class ProcessingEmployees