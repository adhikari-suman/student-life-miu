package application;

import domain.Course;
import domain.Department;
import domain.Grade;
import domain.Student;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.StudentRepository;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
@EntityScan(basePackages = "domain")
@EnableJpaRepositories(basePackages = {"repositories"})
public class Application implements CommandLineRunner {

    private final StudentRepository studentRepository;


    public Application(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;

    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // seed the database
        // createData();

        Collection<Student> csStudents = studentRepository.findAllByDepartmentName("Computer " + "Science");

        System.out.println("------------------ All Students with CS departments ------------------");

        // Define a formatter for grades to ensure consistent decimal places
        DecimalFormat gradeFormatter = new DecimalFormat("#.##");

        for (Student student : csStudents) {
            System.out.println("Student Name: " + student.getName());
            System.out.println("Student Number: " + student.getStudentNumber());
            System.out.println("Department: " + student.getDepartment().getName());
            System.out.println("Grades:");

            for (Grade grade : student.getGrades()) {
                System.out.println("  Course: " + grade.getCourse().getName() + " - Grade: " + gradeFormatter.format(grade.getGrade()));
            }

            System.out.println("------------------------------------------------------------");

        }


        System.out.println("\n\n------------------ All Students with CS " + "departments ------------------");

        Collection<Student> studentsWithAlgorithms = studentRepository.findAllStudentsWithCourseName("Algorithms");


        for (Student student1 : studentsWithAlgorithms) {
            System.out.println("Student Name: " + student1.getName());
            System.out.println("Student Number: " + student1.getStudentNumber());
            System.out.println("Department: " + student1.getDepartment().getName());
            System.out.println("Grades:");

            for (Grade grade : student1.getGrades()) {
                System.out.println("  Course: " + grade.getCourse().getName() + " - Grade: " + gradeFormatter.format(grade.getGrade()));
            }

            System.out.println("------------------------------------------------------------");

        }

    }

    @Transactional
    public void createData() {
        // Create Departments
        Department deptCS = new Department("Computer Science");
        Department deptMath = new Department("Mathematics");
        Department deptPhysics = new Department("Physics");
        Department deptChemistry = new Department("Chemistry");
        Department deptBiology = new Department("Biology");

        // Create Courses
        Course courseAlgorithms = new Course("Algorithms");
        Course courseDataStructures = new Course("Data Structures");
        Course courseDatabases = new Course("Databases");
        Course courseOperatingSystems = new Course("Operating Systems");
        Course courseNetworks = new Course("Networks");

        // Create Students with different departments and grades
        List<Student> students = new ArrayList<>();

        students.add(new Student("John Doe", "SN001", deptCS, Arrays.asList(new Grade(courseAlgorithms, 3.19), new Grade(courseDataStructures, 3.25), new Grade(courseDatabases, 3.57))));
        students.add(new Student("Jane Smith", "SN002", deptMath, Arrays.asList(new Grade(courseAlgorithms, 3.91), new Grade(courseOperatingSystems, 4.2), new Grade(courseNetworks, 2.96))));
        students.add(new Student("Emily Johnson", "SN003", deptPhysics, Arrays.asList(new Grade(courseDataStructures, 3.45), new Grade(courseDatabases, 3.7), new Grade(courseNetworks, 2.66))));
        students.add(new Student("Michael Brown", "SN004", deptChemistry, Arrays.asList(new Grade(courseAlgorithms, 3.87), new Grade(courseDatabases, 3.27), new Grade(courseOperatingSystems, 4.0))));
        students.add(new Student("Sarah Davis", "SN005", deptBiology, Arrays.asList(new Grade(courseDataStructures, 3.42), new Grade(courseOperatingSystems, 3.89), new Grade(courseNetworks, 2.67))));

        // Add 15 more students
        students.add(new Student("Alice Green", "SN006", deptCS, Arrays.asList(new Grade(courseAlgorithms, 3.45), new Grade(courseDatabases, 3.65), new Grade(courseNetworks, 2.95))));
        students.add(new Student("Bob White", "SN007", deptMath, Arrays.asList(new Grade(courseDataStructures, 3.55), new Grade(courseOperatingSystems, 3.75), new Grade(courseAlgorithms, 3.25))));
        students.add(new Student("Charlie Black", "SN008", deptPhysics, Arrays.asList(new Grade(courseAlgorithms, 3.35), new Grade(courseDatabases, 3.85), new Grade(courseDataStructures, 3.15))));
        students.add(new Student("Diana Blue", "SN009", deptChemistry, Arrays.asList(new Grade(courseOperatingSystems, 3.95), new Grade(courseNetworks, 3.05), new Grade(courseDatabases, 3.25))));
        students.add(new Student("Eve Yellow", "SN010", deptBiology, Arrays.asList(new Grade(courseDataStructures, 3.65), new Grade(courseAlgorithms, 3.75), new Grade(courseOperatingSystems, 3.85))));

        students.add(new Student("Frank Red", "SN011", deptCS, Arrays.asList(new Grade(courseNetworks, 3.15), new Grade(courseDataStructures, 3.55), new Grade(courseDatabases, 3.45))));
        students.add(new Student("Grace Purple", "SN012", deptMath, Arrays.asList(new Grade(courseOperatingSystems, 3.25), new Grade(courseAlgorithms, 3.85), new Grade(courseNetworks, 2.75))));
        students.add(new Student("Hank Orange", "SN013", deptPhysics, Arrays.asList(new Grade(courseDataStructures, 3.35), new Grade(courseDatabases, 3.45), new Grade(courseOperatingSystems, 3.55))));
        students.add(new Student("Ivy Brown", "SN014", deptChemistry, Arrays.asList(new Grade(courseAlgorithms, 3.15), new Grade(courseNetworks, 3.65), new Grade(courseDatabases, 3.75))));
        students.add(new Student("Jack Pink", "SN015", deptBiology, Arrays.asList(new Grade(courseDataStructures, 3.85), new Grade(courseOperatingSystems, 3.25), new Grade(courseAlgorithms, 3.35))));

        students.add(new Student("Kara Lime", "SN016", deptCS, Arrays.asList(new Grade(courseNetworks, 3.55), new Grade(courseDatabases, 3.65), new Grade(courseDataStructures, 3.75))));
        students.add(new Student("Leo Teal", "SN017", deptMath, Arrays.asList(new Grade(courseOperatingSystems, 3.95), new Grade(courseAlgorithms, 3.25), new Grade(courseNetworks, 2.85))));
        students.add(new Student("Mona Silver", "SN018", deptPhysics, Arrays.asList(new Grade(courseDataStructures, 3.45), new Grade(courseDatabases, 3.55), new Grade(courseOperatingSystems, 3.35))));
        students.add(new Student("Nina Gold", "SN019", deptChemistry, Arrays.asList(new Grade(courseAlgorithms, 3.75), new Grade(courseNetworks, 3.35), new Grade(courseDatabases, 3.85))));
        students.add(new Student("Oscar Cyan", "SN020", deptBiology, Arrays.asList(new Grade(courseDataStructures, 3.15), new Grade(courseOperatingSystems, 3.45), new Grade(courseAlgorithms, 3.55))));

        // Save all students
        studentRepository.saveAll(students);
    }
}
