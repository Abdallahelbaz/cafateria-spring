package edu.cafeteria.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cafeteria.model.CartItem;
import edu.cafeteria.model.Employee;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long>   {

	
	
	
}
