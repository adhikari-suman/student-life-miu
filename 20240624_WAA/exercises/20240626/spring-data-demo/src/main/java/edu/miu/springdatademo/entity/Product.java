package edu.miu.springdatademo.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    private String color;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews = new ArrayList<>();
}
