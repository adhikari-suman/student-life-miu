package edu.miu.cs489.adswebapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "username", unique = true, nullable = false, length = 50)
    private String username;
    @Column(name = "password_hash")
    private String passwordHash;
    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;
    @Column(name="email", unique = true, nullable = false, length = 100)
    private String email;
}
