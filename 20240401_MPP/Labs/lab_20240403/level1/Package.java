package lab_20240403.level1;

public class Package {
    private int id;
    private String description;
    private double weightInLbs;
    private Zone zone;

    public Package(int id, String description, double weightInLbs, Zone zone) {
        this.id = id;
        this.description = description;
        this.weightInLbs = weightInLbs;
        this.zone = zone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWeightInLbs() {
        return weightInLbs;
    }

    public void setWeightInLbs(double weightInLbs) {
        this.weightInLbs = weightInLbs;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }
}
