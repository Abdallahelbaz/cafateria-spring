package edu.cafeteria.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cafeteria.model.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
}
