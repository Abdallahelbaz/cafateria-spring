package edu.cafeteria.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import edu.cafeteria.model.*;

import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<User,Long> {

	 Optional<User> findByEmailAndPassword(String email, String password);
}
