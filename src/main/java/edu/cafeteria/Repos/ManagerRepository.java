package edu.cafeteria.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cafeteria.model.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
}
