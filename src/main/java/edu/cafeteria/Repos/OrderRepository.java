package edu.cafeteria.Repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.cafeteria.model.Cart;
import edu.cafeteria.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findByStatus(String status);
	
	
//	@Query("SELECT c FROM Orders c WHERE c.user.id = :id")
//	List<Order> getAllOrdersByUserID(@Param("id") Long id);
	
	 
}
