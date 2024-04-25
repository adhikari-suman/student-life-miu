package lab_20240416_w3d2.level_3.lab_3_3;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private String location;
    private Company company;

    private List<Position> positions;

    public Department(String name, String location) {
        this(name, location, null, new ArrayList<>());
    }

    public Department(String name, String location, Company company, List<Position> positions) {
        this.name = name;
        this.location = location;
        this.company = company;
        this.positions = positions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public void addPosition(Position p) {
        positions.add(p);
    }

    public void print() {
        System.out.printf("********************************* %s department details *********************************\n\n", getName());

        for (var p : positions) {
            p.print();
            System.out.println();
        }

    }

    public double getSalary() {
        double totalSalary = 0.0;

        for (var p : positions) {
            totalSalary += p.getSalary();
        }

        return totalSalary;
    }

    public void printReportingHierarchy(){
        Position p = getDepartmentHead();

        if(p != null){
            System.out.println("Reporting Hierarchy::");
            p.printDownLine();
        } else {
            System.out.println("Reporting Hierarchy manager is empty");
        }
    }

    public Position getDepartmentHead() {
        Position head = null;

        for (Position p : positions) {
            if (p != null && p.isManager()) {
                head = p;
                break;
            }
        }

        return head;

    }

    public Position getPositionByTitle(String title){
        Position p = null;

        for(Position pos:positions){
            if(p==null && pos.getTitle().equalsIgnoreCase(title)){
                p = pos;
            }
        }

        return  p;
    }
}
