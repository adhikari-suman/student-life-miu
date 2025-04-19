package edu.miu.cs489.adswebapp.respository;

import edu.miu.cs489.adswebapp.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
