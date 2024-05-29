package lab_20240416_w3d2.level_3.school_lab.level1;

public class Staff extends  Person {
    private double salary;

    public Staff(String name, String phone, int age, double salary) {
        super(name, phone, age);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
