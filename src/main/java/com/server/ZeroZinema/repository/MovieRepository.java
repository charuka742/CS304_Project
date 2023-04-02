package com.server.ZeroZinema.repository;

import com.server.ZeroZinema.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
