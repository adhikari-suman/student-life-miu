package edu.miu.cs489.adswebapp.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bills")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
    @Id
    @EqualsAndHashCode.Include
    private Integer id; // Same as appointment ID

    @OneToOne(mappedBy = "bill")
    private Appointment appointment;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "bill_status", nullable = false)
    private int billStatus = 0;
}
