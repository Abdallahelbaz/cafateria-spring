package edu.cafeteria.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cafeteria.model.*;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredient , Integer> {
}
