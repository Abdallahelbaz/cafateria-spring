package edu.cafeteria.Repos;

  

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.cafeteria.model.Cart; 
import edu.cafeteria.model.User;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	Optional<Cart> findByUser(User user);

	@Query("SELECT c FROM Cart c WHERE c.user.email = :userEmail")
    Optional<Cart> findByUserEmail(@Param("userEmail") String userEmail);
	 
}
