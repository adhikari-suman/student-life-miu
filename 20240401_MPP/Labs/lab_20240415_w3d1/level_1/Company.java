package lab_20240415_w3d1.level_1;

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
}
