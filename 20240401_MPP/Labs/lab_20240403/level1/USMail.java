package lab_20240403.level1;

public class USMail extends Carrier {

    public USMail(int id) {
        super(id, "US Mail");
    }

    @Override
    public double getRate(Package p) {
        return p.getWeightInLbs() < 3.00 ? 1.00 : 0.55;
    }
}
