package lab_20240402.lab_3_3;

import java.util.ArrayList;
import java.util.List;

public class Position {
    private String title;
    private String description;
    private Employee employee;

    private Department department;

    private List<Position> downLines;

    public Position(String title, String description) {
        this(title, description, null, null);
        downLines = new ArrayList<>();
    }

    public Position(String title, String description, Employee employee, Department department) {
        this.title = title;
        this.description = description;
        this.employee = employee;
        this.department = department;
        this.downLines = new ArrayList<>();
    }

    public List<Position> getDownLines() {
        return downLines;
    }

    public boolean isManager(){
        return this.title.toLowerCase().contains("manager");
    }

    public void addDownLine(Position reportedBy) {
        this.downLines.add(reportedBy);
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

    public void printDownLine(){

        print();

        if(downLines.isEmpty()){
            return;
        }



        System.out.println("Reported By these positions:");

        for(Position p: downLines){
            p.print();



            p.printDownLine();
        }
    }

    public double getSalary() {
        Employee e = getEmployee();

        return e == null ? 0 : e.getSalary();
    }
}
