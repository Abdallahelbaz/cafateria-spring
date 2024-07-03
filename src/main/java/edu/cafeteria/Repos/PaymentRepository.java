package edu.cafeteria.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cafeteria.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
