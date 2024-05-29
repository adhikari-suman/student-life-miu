package lab_20240402.lab_3_2;

import java.time.LocalDate;

public class CompanyApplication {
    public static void main(String[] args) {
        // Create a company
        Company c = new Company("MIU Internationals");

        // Create Departments
        Department d1 = new Department("IT", "1000 N. 4th St., Fairfield, IA, 52557");
        Department d2 = new Department("Sales", "1000 N. 4th St., Fairfield, IA, 52557");

        // Create Positions
        Position d1p1 = new Position("Project Manager", "Handles all the project");
        Position d1p2 = new Position("Software Engineer", "Design and Develops the System");
        Position d1p3 = new Position("DevOps Engineer", "Maintains the infrastructure");

        Position d2p1 = new Position("Sales Manager", "Manages the sales person");
        Position d2p2 = new Position("Vice President", "Handles all the sales managers and reports directly to President");
        Position d2p3 = new Position("Salesperson", "Handles day to day sales");

        // Create Employees
        Employee e1 = new Employee(104, "Ariel", null, "Adhikari", LocalDate.of(1984, 11, 12), "152346", 4500);
        Employee e2 = new Employee(134, "Allen", null, "Walker", LocalDate.of(1989, 10, 1), "167346", 8500);
        Employee e3 = new Employee(159, "Aung", "K.", "Myint", LocalDate.of(1974, 9, 19), "157568", 3500);
        Employee e4 = new Employee(325, "John", "C.", "Rockefeller", LocalDate.of(1991, 1, 23), "453267", 9500);

        // Assign the departments, employees and positions accordingly

        // Assign departments to company and vice-versa
        c.addDepartment(d1);
        c.addDepartment(d2);

        d1.setCompany(c);
        d2.setCompany(c);

        // Assign positions to departments and vice-versa
        d1.addPosition(d1p1);
        d1.addPosition(d1p2);
        d1.addPosition(d1p3);

        d1p1.setDepartment(d1);
        d1p2.setDepartment(d1);
        d1p3.setDepartment(d1);


        d2.addPosition(d2p1);
        d2.addPosition(d2p2);
        d2.addPosition(d2p3);

        d2p1.setDepartment(d2);
        d2p2.setDepartment(d2);
        d2p3.setDepartment(d2);

        // Assign employees to positions and vice-versa
        d1p1.setEmployee(e1);
        d1p3.setEmployee(e3);

        e1.setPosition(d1p1);
        e3.setPosition(d1p3);

        d2p2.setEmployee(e4);
        d2p3.setEmployee(e2);

        e4.setPosition(d2p2);
        e2.setPosition(d2p3);

        // Print company details
        c.print();


        System.out.printf("Company total Salary: "+c.getSalary());
    }
}
