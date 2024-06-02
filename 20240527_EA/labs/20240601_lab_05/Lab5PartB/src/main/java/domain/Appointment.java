package domain;


import jakarta.persistence.*;

@Entity
@Table(name = "Appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "APPDATE")
    private String appDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PATIENT", nullable = false)
    private Patient patient;

    @Embedded()
    private Payment payment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DOCTOR", nullable = false)
    private Doctor doctor;

    public Appointment() {
    }

    public Appointment(String appDate, Patient patient, Payment payment,
                       Doctor doctor) {
        this.appDate = appDate;
        this.patient = patient;
        this.payment = payment;
        this.doctor = doctor;
    }

    public String getAppDate() {
        return appDate;
    }

    public void setAppDate(String appDate) {
        this.appDate = appDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n\n------------------ Appointment ------------------");
        sb.append("\nDate: " + appDate);
        sb.append("\nPatient: " + patient);
        sb.append(("\nDoctor: " + doctor));
        sb.append("\nPayment: " + payment);

        return sb.toString();
    }
}
