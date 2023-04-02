package com.server.ZeroZinema.repository;

import com.server.ZeroZinema.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
