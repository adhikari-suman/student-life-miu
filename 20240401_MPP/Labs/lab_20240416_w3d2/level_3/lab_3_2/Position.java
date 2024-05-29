package lab_20240416_w3d2.level_3.lab_3_2;

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

    public double getSalary() {
        Employee e = getEmployee();

        return e == null ? 0 : e.getSalary();
    }
}
