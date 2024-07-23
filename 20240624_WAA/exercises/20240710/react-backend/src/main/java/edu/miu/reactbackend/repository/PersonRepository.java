package edu.miu.reactbackend.repository;

import edu.miu.reactbackend.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
