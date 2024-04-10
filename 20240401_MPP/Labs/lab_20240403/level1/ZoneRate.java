package lab_20240403.level1;

public class ZoneRate {

    private  Zone zone;

    private double rate;

    public ZoneRate(Zone zone, double rate) {
        this.zone = zone;
        this.rate = rate;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
