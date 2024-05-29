package lab_20240416_w3d2.level_3.school_lab.level2;

public class StaffStudent extends Student {

    Staff staff;

    public StaffStudent(Staff staff, double gpa) {
        super(staff.getName(), staff.getPhone(), staff.getAge(), gpa);
        this.staff = staff;
    }

    public StaffStudent(Student  student, double salary) {
        super(student.getName(), student.getPhone(), student.getAge(), student.getGPA());
        this.staff = new Staff(student.getName(), student.getPhone(), student.getAge(), salary);
    }

    public StaffStudent(String name, String phone, int age, double gpa, double salary){
        super(name, phone, age, gpa);
        this.staff = new Staff(name, phone, age, salary);
    }

    @Override
    public double getSalary() {
        return staff.getSalary();
    }

    public void setSalary(double salary){
        staff.setSalary(salary);
    }
}
