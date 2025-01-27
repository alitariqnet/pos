package dev.ali.pos.repository;

import dev.ali.pos.entity.Item;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface ItemRepository extends JpaRepositoryImplementation<Item, Long> {
}
