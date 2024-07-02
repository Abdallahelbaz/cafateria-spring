package edu.cafeteria.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cafeteria.model.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Integer> {
}
