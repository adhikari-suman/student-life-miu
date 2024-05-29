package lab_20240401.level3;

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

    public void addCourse(Course course){
        courses.add(course);
    }
    public List<Course> getCourses() {
        return courses;
    }
    public int getTotalUnits() {
        return courses.stream()
                .map(Course::getUnits)
                .reduce(0, Integer::sum);
    }
}
