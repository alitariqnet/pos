package dev.ali.pos.repository;

import dev.ali.pos.entity.Product;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

// Extending JpaRepositoryImplementation instead of CrudRepository to use Specifications for CriteriaAPI
@Repository
public interface ProductRepository extends JpaRepositoryImplementation<Product, Long> {
}
