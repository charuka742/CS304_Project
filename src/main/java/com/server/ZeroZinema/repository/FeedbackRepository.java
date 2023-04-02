package com.server.ZeroZinema.repository;

import com.server.ZeroZinema.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

}
