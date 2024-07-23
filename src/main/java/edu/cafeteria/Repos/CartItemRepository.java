package edu.cafeteria.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.cafeteria.model.CartItem; 

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long>   {

	
	@Query("SELECT COUNT (c) FROM CartItem  c WHERE c.cart.user.id = :idd")
	int countByUserId(Long idd);
	
}
