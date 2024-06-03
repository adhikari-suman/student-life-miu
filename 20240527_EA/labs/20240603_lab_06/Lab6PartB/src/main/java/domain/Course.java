package domain;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    private long id;

    private String name;

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


}
