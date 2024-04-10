package lab_20240403.level1;

public class UPS extends Carrier {

    public UPS(int id) {
        super(id, "UPS");
    }

    @Override
    public double getRate(Package p) {
        return 0.45;
    }
}
