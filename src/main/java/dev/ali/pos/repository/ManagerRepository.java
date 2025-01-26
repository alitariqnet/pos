package dev.ali.pos.repository;

import dev.ali.pos.entity.Manager;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepositoryImplementation<Manager, Long> {
}
