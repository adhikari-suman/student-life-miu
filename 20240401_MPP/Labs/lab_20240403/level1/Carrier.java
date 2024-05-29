package lab_20240403.level1;

public abstract  class Carrier implements ICarrier{

private final int id;

private final String name;

    public Carrier(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public final double getShippingPrice(Package p) {
        return p.getWeightInLbs() * getRate(p);
    }
}
