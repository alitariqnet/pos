package dev.ali.pos.repository;

import dev.ali.pos.entity.Supplier;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepositoryImplementation<Supplier, Long> {
    public Supplier findByName(String name);
}
