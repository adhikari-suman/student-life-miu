package edu.miu.cs489.userprofilesms.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "profiles")
@Data
@NoArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "profile_id")
    private Long      id;
    @Column(name = "first_name", length = 25)
    private String    firstName;
    @Column(name = "last_name", length = 25)
    private String    lastName;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "email", length = 100, unique = true, nullable = false)
    private String email;
    @Column(name = "phone", length = 15, unique = true, nullable = false)
    private String phoneNumber;
    @Column(name="bio", length = 255)
    private String   bio;
    @OneToOne(mappedBy = "profile", fetch = FetchType.LAZY)
    private User user;
}
