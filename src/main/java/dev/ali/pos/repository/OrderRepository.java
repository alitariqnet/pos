package dev.ali.pos.repository;

import dev.ali.pos.entity.Order;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepositoryImplementation<Order, Long> {
    public List<Order> findByTransactionId(Long id);
    public List<Order> findByCashierId(Long id);
}
