package com.server.ZeroZinema.controller;

import com.server.ZeroZinema.model.Movie;
import com.server.ZeroZinema.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @PostMapping("/addMovie")
    Movie newMovie(@RequestBody Movie newMovie){
        return movieRepository.save(newMovie);
    }

    @GetMapping("/movies")
    List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

}
