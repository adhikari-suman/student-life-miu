package lab_20240416_w3d2.level_3.lab_3_2;

import java.util.ArrayList;
import java.util.Arrays;
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


        departments.stream().forEach(
                Department::print
        );

//        for (var d : departments) {
//            d.print();
//        }
    }

    public double getSalary() {
       return departments.stream().map(Department::getSalary).reduce(0d,Double::sum);
//        double totalSalary = 0.0;
//
//        for (var d : departments) {
//            totalSalary += d.getSalary();
//        }
//
//        return totalSalary;
    }
}
