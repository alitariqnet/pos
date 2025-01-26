package dev.ali.pos.repository;

import dev.ali.pos.entity.Cashier;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface CashierRepository extends JpaRepositoryImplementation<Cashier, Long> {
}
