package edu.cafeteria.Repos;

 

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; 
import org.springframework.stereotype.Repository;

import edu.cafeteria.model.Notification; 

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long> {

	@Query("SELECT c FROM Notification  c WHERE c.order.user.id = :userId")
	Optional<List<Notification>>	 findByUserId(Long userId);

	@Query("SELECT COUNT (c) FROM Notification  c WHERE c.order.user.id = :idd")
	int countByUserId(Long idd);
	 
}