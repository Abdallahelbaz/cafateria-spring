package edu.cafeteria.Repos;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; 
import org.springframework.stereotype.Repository;
 
import edu.cafeteria.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findByStatus(String status);
	
	 
	
	@Query("SELECT COUNT (c) FROM Order  c WHERE c.user.id = :idd")
	int countByUserId(Long idd);
	
	
	 @Query("SELECT COUNT (c) FROM Order  c WHERE c.status  = :idd")
		int countByStatus(String idd);
}
