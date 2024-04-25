package lab_20240416_w3d2.level_3.school_lab.level1;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private double GPA;

    private final List<Course> courses;

    public Student(String name, String phone, int age, double gpa) {
        super(name, phone, age);
        this.GPA = gpa;

        courses = new ArrayList<>();
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public List<Course> getCourses() {
        return courses;
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
