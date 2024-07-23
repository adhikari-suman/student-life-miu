package repositories;

import domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT DISTINCT s FROM Student s JOIN FETCH s.department d JOIN " +
            "FETCH s.grades g JOIN FETCH g.course c WHERE d.name = :name")
    public Collection<Student> findAllByDepartmentName(String name);

    @Query("SELECT DISTINCT s FROM Student s JOIN FETCH s.department JOIN " +
            "FETCH s.grades g JOIN FETCH g.course c WHERE c.name= :name")
    public Collection<Student> findAllStudentsWithCourseName(
            @Param("name") String courseName);
}
