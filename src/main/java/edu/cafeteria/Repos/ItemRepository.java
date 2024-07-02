package edu.cafeteria.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cafeteria.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
