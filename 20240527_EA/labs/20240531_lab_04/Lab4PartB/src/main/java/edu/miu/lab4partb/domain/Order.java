package edu.miu.lab4partb.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNumber;
    private LocalDateTime date;
    private String status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "customer_orders",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "customer_id")}
    )
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "orders_order_lines",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "order_line_id")}
    )
    private Collection<OrderLine> orderLines;

    public Order() {
    }

    public Order(String orderNumber, LocalDateTime date, String status, Collection<OrderLine> orderLines, Customer customer) {
        this.orderNumber = orderNumber;
        this.date = date;
        this.status = status;
        this.orderLines = orderLines;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Collection<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(Collection<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();


        sb.append("--------------- Order Details --------------\n");

        sb.append("\n\nCustomer: " + customer.toString());

        sb.append("\n\nOrder Number: " + orderNumber);
        sb.append("\nOrder Date: " + date);
        sb.append("\nOrder Status: " + status);

        sb.append("\n\n--------------- Order Lines --------------");
        for (OrderLine orderLine : orderLines) {
            sb.append("\n" + orderLine);
        }

        return sb.toString();
    }
}
