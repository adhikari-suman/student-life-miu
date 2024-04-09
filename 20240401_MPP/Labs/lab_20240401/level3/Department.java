package lab_20240401.level3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Department {
    private String name;

    private List<Person> members;


    public Department(String name) {
        this.name = name;
        members = new ArrayList<>();
    }

    public double getTotalSalary() {
        /* With polymorphism */
        double totalSalary = 0;

        for (var member : members) {
            totalSalary += member.getSalary();
        }

        return totalSalary;

        /* Without polymorphism */
//        double totalSalary = 0;
//
//        for (var member : members) {
//            if (member instanceof Faculty) {
//                totalSalary += ((Faculty) member).getSalary();
//            } else if (member instanceof Staff) {
//                totalSalary += ((Staff) member).getSalary();
//            }
//        }
//
//        return totalSalary;
    }

    public void showAllMembers() {
        StringBuilder sb = new StringBuilder();

        members.forEach(
                person -> sb.append(String.format("%s\n", person))
        );

        System.out.println(sb);
    }

    public void unitsPerFaculty() {
        /* Without streams */
        for (var person : members) {
            if (person instanceof Faculty) {
                System.out.printf("Name: %-15s Total Units: %-3d\n", person.getName(), ((Faculty) person).getTotalUnits());
            }
        }


        /* With streams */
        // Using instanceof
//        members.stream()
//                .filter(person -> person instanceof Faculty)
//                .forEach(
//                        person -> System.out.printf("Name: %-15s Total Units: %-3d\n", person.getName(), ((Faculty) person).getTotalUnits())
//                );

        // Using getClass()
//        members.stream()
//                .filter(person -> person.getClass().getSimpleName().equals(Faculty.class.getSimpleName()))
//                .forEach(
//                        person -> System.out.printf("Name: %-15s Total Units: %-3d\n", person.getName(), ((Faculty) person).getTotalUnits())
//                );
    }

    public void showStudentsOfFaculty(String name) {
        /* Without Streams */
        Faculty faculty = null;

        for (var person : members) {
            if (person instanceof Faculty && person.getName().equals(name) && faculty == null) {
                faculty = (Faculty) person;
            }
        }

        if (faculty == null) {
            System.out.printf("No faculty with name %s exists.\n%n", name);
            return;
        }

        // Get faculty courses
        var courses = faculty.getCourses();

        // Get list of students
        List<Student> students = new ArrayList<>();

        for (var p : members) {
            if (p instanceof Student && !students.contains(p)) {
                students.add((Student) p);
            }
        }

        List<Student> studentsWithCourses = new ArrayList<>();

        for (var std : students) {
            std.getCourses().forEach(
                    course -> {
                        if (courses.contains(course) && !studentsWithCourses.contains(std)) {
                            studentsWithCourses.add(std);
                        }
                    }


            );
        }

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Students taught by: %s\n",faculty.getName()));

        for (var std : studentsWithCourses) {
            sb.append(String.format("\tStudent: %s\n",std.getName()));
        }

        System.out.println(sb);




        /* With Streams */
        /**
         // 1. Find the faculty
         var result = members.stream().filter(person -> person instanceof Faculty && person.getName().equals(name)).findFirst();

         // faculty does not exist, return
         if (result.isEmpty()) {
         System.out.printf("No faculty with name %s exists.\n%n", name);
         return;
         }

         // Faculty is found and retrieved
         Faculty faculty = (Faculty) result.get();

         // Get the courses the faculty teaches
         var courseList = faculty.getCourses();

         var students = members.stream().filter(person -> person instanceof Student)
         .toList();


         students = students.stream() .filter(student -> {


         return ((Student) student).getCourses().stream().anyMatch(
         courseList::contains
         );


         }).toList();


         StringBuilder sb = new StringBuilder();

         sb.append(String.format("Students taught by: %s\n",faculty.getName()));

         for (var std : students) {
         sb.append(String.format("\tStudent: %s\n",std.getName()));
         }

         System.out.println(sb);
         */
    }

    public void addPerson(Person p) {
        members.add(p);
    }

    public void addStudent(Person s) {
        members.add(s);
    }

    public void addStaff(Person s) {
        members.add(s);
    }

    public void addFaculty(Person f) {
        members.add(f);
    }


}
