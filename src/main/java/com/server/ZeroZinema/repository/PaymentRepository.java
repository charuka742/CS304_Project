package com.server.ZeroZinema.repository;

import com.server.ZeroZinema.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
