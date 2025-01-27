package dev.ali.pos.repository;

import dev.ali.pos.entity.User;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepositoryImplementation<User, Long> {
    Optional<User> findByUsername(String username);
}
