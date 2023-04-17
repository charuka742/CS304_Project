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
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieService movieService;

    @GetMapping("/search/title/{title}")
    public ResponseEntity<List<Movie>> searchMoviesByTitle(@PathVariable String title) {
        List<Movie> movies = movieService.searchMoviesByTitle(title);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/search/director/{director}")
    public ResponseEntity<List<Movie>> searchMoviesByDirector(@PathVariable String director) {
        List<Movie> movies = movieService.searchMoviesByDirector(director);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

  /*  @GetMapping("/search/genre/{genre}")
    public ResponseEntity<List<Movie>> searchMoviesByGenre(@PathVariable String genre) {
        List<Movie> movies = movieService.searchMoviesByGenre(genre);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
*/
    /*@GetMapping("/search/year/{year}")
    public ResponseEntity<List<Movie>> searchMoviesByYear(@PathVariable int year) {
        List<Movie> movies = movieService.searchMoviesByYear(year);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }*/






    /* Add a movie */
    @PostMapping
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
    @DeleteMapping("{movieId}")
    public ResponseEntity<ApiResponse> deleteMovie(@PathVariable("movieId") Integer movieId){
        this.movieService.deleteMovie(movieId);
        return  new ResponseEntity<>(new ApiResponse("Movie deleted Successfully", true), HttpStatus.OK);

    }

    /* Get All Users */
    @GetMapping
    public ResponseEntity<List<MovieDto>> getAllMovies(){
        return ResponseEntity.ok(this.movieService.getAllMovies());
    }


    /* Get Single User */
    @GetMapping("{movieId}")
    public ResponseEntity<MovieDto> getSingleMovie(@PathVariable("movieId") Integer movieId){
        return ResponseEntity.ok(this.movieService.getById(movieId));
    }


}
