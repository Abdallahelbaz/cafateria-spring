package edu.cafeteria.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cafeteria.model.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {
}
