package edu.cafeteria.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cafeteria.model.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
}
