package edu.abdullah.cafeteria.Repos;

import edu.abdullah.cafeteria.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepo extends JpaRepository<Menu,Long> {
}
