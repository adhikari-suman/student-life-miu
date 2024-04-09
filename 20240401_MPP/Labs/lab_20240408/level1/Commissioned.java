package lab_20240408.level1;

import java.util.List;

public class Commissioned extends Employee {

    private float commission;
    private double baseSalary;

    private final List<Order> orders;

    public Commissioned(int empId, float commission, double baseSalary, List<Order> orders) {
        super(empId);
        this.commission = commission;
        this.baseSalary = baseSalary;
        this.orders = orders;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order o) {
        orders.add(o);
    }

    public void removeOrder(Order o) {
        orders.remove(o);
    }

    @Override
    public double calcGrossPay(DateRange range) {
        double grossSalary = baseSalary;

        for (Order o : orders) {
            grossSalary += o.getOrderAmount() * commission / 100D;
        }

        return grossSalary;
    }

    @Override
    public void print() {
        String str = "******************************* Commissioned Employee *******************************\n\n" +
                String.format("\tID: #%d\n", getEmpId()) +
                String.format("\tBase salary: $%,.2f\n", getBaseSalary()) +
                String.format("\tCommission: %.2f%%\n", getCommission());

        System.out.println(str);
    }
}
