package lab_20240416_w3d2.level_3.lab_3_3;


import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;

    private List<Department> departments;

    public Company(String name) {
        this(name, new ArrayList<>());
    }

    public Company(String name, List<Department> departments) {
        this.name = name;
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void print() {
        System.out.printf("********************************* %s details *********************************\n\n", getName());

        for (var d : departments) {
            d.print();
        }
    }

    public double getSalary() {
        double totalSalary = 0.0;

        for (var d : departments) {
            totalSalary += d.getSalary();
        }

        return totalSalary;
    }

    public Position getTopExecutive() {
        Position p = null;

        for (Department d : departments) {
            Position head = d.getPositionByTitle("CEO");
            if (head != null && p == null) {
                p = head;
            }

        }

        return p;
    }

    public void printReportingHierarchy() {
        Position p = getTopExecutive();




        if (p != null) {
            System.out.println("Company reporting hierarchy");

            p.printDownLine();
        } else {
            System.out.println("No hierarchy found");
        }
    }
}
