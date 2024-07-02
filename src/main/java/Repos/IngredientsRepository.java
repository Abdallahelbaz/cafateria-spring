package edu.abdullah.cafeteria.Repos;

import edu.abdullah.cafeteria.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredient , Integer> {
}
