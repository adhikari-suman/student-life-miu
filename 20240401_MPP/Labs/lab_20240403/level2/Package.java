package lab_20240403.level2;

public class Package {
    private int id;
    private String description;
    private double weightInLbs;
    private Zone zone;

    private SenderType senderType;

    public Package(int id, String description, double weightInLbs, Zone zone, SenderType senderType) {
        this.id = id;
        this.description = description;
        this.weightInLbs = weightInLbs;
        this.zone = zone;
        this.senderType = senderType;
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

    public SenderType getSenderType() {
        return senderType;
    }

    public void setSenderType(SenderType senderType) {
        this.senderType = senderType;
    }
}
