package lab_20240402.lab_3_2;

import java.time.LocalDate;

public class Employee {

    private int employeeId;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private LocalDate birthDate;
    private String SSN;
    private double salary;
    private Position position;

    public Employee(int employeeId, String firstName, String middleInitial, String lastName, LocalDate birthDate, String SSN, double salary) {
        this(employeeId, firstName, middleInitial, lastName, birthDate, SSN, salary, null);
    }

    public Employee(int employeeId, String firstName, String middleInitial, String lastName,
                    LocalDate birthDate, String SSN, double salary, Position position) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.SSN = SSN;
        this.salary = salary;
        this.position = position;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        if (getMiddleInitial() == null || getMiddleInitial().isEmpty()) {
            return getFirstName() + " " + getLastName();
        } else {
            return getFirstName() + " " + getMiddleInitial() + " " + getLastName();
        }
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Employee Details::\n\n"));

        sb.append(String.format("Name: %s\n",getFullName()));
        sb.append(String.format("SSN: %s\n",getSSN()));
        sb.append(String.format("Date Of Birth: %s\n",getBirthDate()));
        sb.append(String.format("Salary: $%,.2f\n",getSalary()));
        sb.append(String.format("Position: %s\n",getPosition().getTitle().toUpperCase()));


        System.out.println(sb);
    }
}
