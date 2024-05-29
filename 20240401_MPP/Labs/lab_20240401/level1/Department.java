package lab_20240401.level1;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

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
            totalSalary+= member.getSalary();
        }

        return  totalSalary;

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
        for(var person: members){
            if(person instanceof Faculty ){
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
