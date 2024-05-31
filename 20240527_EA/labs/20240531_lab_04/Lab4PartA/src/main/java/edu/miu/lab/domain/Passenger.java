package edu.miu.lab.domain;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "passengers")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
          name = "passenger_flights",
          joinColumns = {@JoinColumn(name = "passenger_id")},
          inverseJoinColumns = {@JoinColumn(name = "flight_id")}
    )
    @OrderColumn(name = "sequence")
    private List<Flight> flights;


    public Passenger() {
    }

    public Passenger(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", flights=" + flights +
                '}';
    }
}
