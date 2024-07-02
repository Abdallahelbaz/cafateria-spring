package edu.cafeteria.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cafeteria.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
