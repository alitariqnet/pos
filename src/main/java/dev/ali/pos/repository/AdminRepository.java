package dev.ali.pos.repository;

import dev.ali.pos.entity.Admin;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepositoryImplementation<Admin, Long> {
}
