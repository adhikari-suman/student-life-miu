package lab_20240403.level2;

public interface ICarrier {
    double getShippingPrice(Package p);
    double getRate(Package p);
    double getDiscountRate(SenderType s);
}
