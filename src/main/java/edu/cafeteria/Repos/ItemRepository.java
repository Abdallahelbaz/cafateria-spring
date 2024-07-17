package edu.cafeteria.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.cafeteria.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	
	
	
	 @Modifying
	    @Transactional
	    @Query("UPDATE Item i SET i.name = :name, i.photoUrl = :photoUrl, i.price = :price WHERE i.id = :id")
	    void updateItem(@Param("id") Long id, @Param("name") String name, @Param("photoUrl") String photoUrl, @Param("price") float price);

	 List<Item> findByNameContainingIgnoreCase(String name);
	 
	 
	 @Query("SELECT COUNT (c) FROM Item   ")
		int countByUserId( );	
}
 



