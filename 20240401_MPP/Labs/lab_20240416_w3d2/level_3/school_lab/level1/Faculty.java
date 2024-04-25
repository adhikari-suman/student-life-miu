package lab_20240416_w3d2.level_3.school_lab.level1;

import java.util.ArrayList;
import java.util.List;

public class Faculty extends Person {
    private double salary;

    private final List<Course> courses;

    public Faculty(String name, String phone, int age, double salary) {
        super(name, phone, age);
        this.salary = salary;

        courses = new ArrayList<>();
    }



    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public double getSalary() {
         return salary;
    }

    public int getTotalUnits() {
//        int totalUnits = 0;
//
//        for (var course : courses) {
//            totalUnits += course.getUnits();
//        }
//
//        return totalUnits;

        /* With Streams */
        return courses.stream()
                .map(Course::getUnits)
                .reduce(0, Integer::sum);
    }
}
