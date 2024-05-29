package lab_20240408.level3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
    private int orderNo;
    private Date orderDate;
    private double orderAmount;

    public Order(int orderNo, Date orderDate, double orderAmount) {
        this.orderNo = orderNo;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

        return String.format("%s Order#%d: $%,.2f", sdf.format(orderDate), orderNo, orderAmount);
    }
}
