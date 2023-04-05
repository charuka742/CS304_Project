package com.server.ZeroZinema.controller;

import com.server.ZeroZinema.model.Movie;
import com.server.ZeroZinema.payloads.ApiResponse;
import com.server.ZeroZinema.payloads.MovieDto;
import com.server.ZeroZinema.repository.MovieRepository;
import com.server.ZeroZinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieService movieService;


    /* Add a movie */
    @PostMapping("/add")
    public ResponseEntity<MovieDto> createMovie(@RequestBody Movie movie){
        MovieDto createdMovieDto = this.movieService.createMovie(movie);
        return  new ResponseEntity<>(createdMovieDto, HttpStatus.CREATED);
    }

    /* Update Movie */
    @PutMapping("/update/{movieId}")
    public ResponseEntity<MovieDto> updateMovie(@RequestBody MovieDto movieDto, @PathVariable("movieId") Integer movieId){
        MovieDto updateMovie = this.movieService.updateMovie(movieDto, movieId);
        return ResponseEntity.ok(updateMovie);
    }

    /* delete Movie */
    @DeleteMapping("/delete/{movieId}")
    public ResponseEntity<ApiResponse> deleteMovie(@PathVariable("movieId") Integer movieId){
        this.movieService.deleteMovie(movieId);
        return  new ResponseEntity<>(new ApiResponse("Movie deleted Successfully", true), HttpStatus.OK);

    }

    /* Get All Users */
    @GetMapping("/allMovies")
    public ResponseEntity<List<MovieDto>> getAllMovies(){
        return ResponseEntity.ok(this.movieService.getAllMovies());
    }


    /* Get Single User */
    @GetMapping("/single/{movieId}")
    public ResponseEntity<MovieDto> getSingleMovie(@PathVariable("movieId") Integer movieId){
        return ResponseEntity.ok(this.movieService.getById(movieId));
    }



   /* @PostMapping("/addMovie")
    Movie newMovie(@RequestBody Movie newMovie){
        return movieRepository.save(newMovie);
    }

    @GetMapping("/movies")
    List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }*/

}
