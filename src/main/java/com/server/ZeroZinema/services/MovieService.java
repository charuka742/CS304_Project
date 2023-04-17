package com.server.ZeroZinema.services;

import com.server.ZeroZinema.model.Movie;
import com.server.ZeroZinema.payloads.MovieDto;

import java.util.List;

public interface MovieService {


    List<Movie> searchMoviesByTitle(String title);

    List<Movie> searchMoviesByDirector(String director);

  /*  List<Movie> searchMoviesByGenre(String genre);*/

   /* List<Movie> searchMoviesByYear(int year);*/




    MovieDto createMovie(Movie movie);
    MovieDto updateMovie(MovieDto movie, Integer movieId);
    MovieDto getById(Integer movieId);
    /*Movie getByIdFulMovie(Integer movieId);*/
    List<MovieDto> getAllMovies();
    void deleteMovie(Integer movieId);
}
