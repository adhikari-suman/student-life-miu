package lab_20240403.level2;

public abstract  class Carrier implements ICarrier {

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
        return (1 - getDiscountRate(p.getSenderType())) * p.getWeightInLbs() * getRate(p);
    }

    @Override
    public final double getDiscountRate(SenderType s) {
        return switch (s){
            case OTHERS -> 0;
            case STUDENT ->  0.10;
            case SENIOR_CITIZEN -> 0.15;
        };
    }
}
