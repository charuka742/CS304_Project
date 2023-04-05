package com.server.ZeroZinema.services;

import com.server.ZeroZinema.model.Movie;
import com.server.ZeroZinema.payloads.MovieDto;

import java.util.List;

public interface MovieService {

    MovieDto createMovie(Movie movie);
    MovieDto updateMovie(MovieDto movie, Integer movieId);
    MovieDto getById(Integer movieId);
    /*Movie getByIdFulMovie(Integer movieId);*/
    List<MovieDto> getAllMovies();
    void deleteMovie(Integer movieId);
}
