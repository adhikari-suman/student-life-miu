package lab_20240402.lab_3_1;

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

    public void addPosition(Position p){
        positions.add(p);
    }

    public void print(){
        System.out.printf("********************************* %s department details *********************************\n\n", getName());

        for (var p : positions) {
            p.print();
            System.out.println();
        }

    }
}
