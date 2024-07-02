package edu.cafeteria.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cafeteria.model.*;

public interface MenuRepo extends JpaRepository<Menu,Long> {
}
