package edu.cafeteria.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cafeteria.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
}
