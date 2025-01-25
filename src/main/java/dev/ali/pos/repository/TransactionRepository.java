package dev.ali.pos.repository;

import dev.ali.pos.entity.Transaction;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepositoryImplementation<Transaction, Long> {
}
