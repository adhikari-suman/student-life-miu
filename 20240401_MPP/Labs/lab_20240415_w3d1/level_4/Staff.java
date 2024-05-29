package lab_20240415_w3d1.level_4;

public class Staff extends Person {
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

    @Override
    public void myMethod() {
        System.out.println("Inside Staff myMethod");
    }
}
