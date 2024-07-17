package edu.cafeteria.Repos;

import edu.cafeteria.model.Log;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LogRepository extends JpaRepository<Log, Long> {
	
	 

	@Query("SELECT c FROM Log  c WHERE c.role = :role ORDER BY c.timestamp DESC")
	Optional <List<Log>> getEMPlogs(String role);
	@Query("SELECT c FROM Log  c WHERE c.role = :role ORDER BY c.timestamp DESC")
	Optional <List<Log>> getStaffLogs(String role);
	@Query("SELECT c FROM Log  c WHERE c.role = :role ORDER BY c.timestamp DESC")
	Optional <List<Log>> getGuestLogs(String role);
	
}
