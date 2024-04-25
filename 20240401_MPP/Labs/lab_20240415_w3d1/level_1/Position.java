package lab_20240415_w3d1.level_1;

import java.util.Objects;

public class Position {
    private String title;
    private String description;
    private Employee employee;

    private Department department;

    public Position(String title, String description) {
        this(title, description, null, null);
    }

    public Position(String title, String description, Employee employee, Department department) {
        this.title = title;
        this.description = description;
        this.employee = employee;
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    public void print() {
        String format = "Position: %s - %s\n";
        if (employee == null) {
            System.out.printf(format, getTitle(), "UNEMPLOYED");
        } else {
            System.out.printf(format, getTitle(), "EMPLOYED\n");

            employee.print();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(title, position.title) &&
                Objects.equals(description, position.description);
    }


    @Override
    public int hashCode() {
        return Objects.hash(title, description);
    }

    @Override
    public String toString() {
        return "Position{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
