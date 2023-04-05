package com.server.ZeroZinema.services.Impl;

import com.server.ZeroZinema.exception.ResourceNotFoundException;
import com.server.ZeroZinema.model.Movie;
import com.server.ZeroZinema.payloads.MovieDto;
import com.server.ZeroZinema.repository.MovieRepository;
import com.server.ZeroZinema.services.MovieService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    private MovieDto movieDto;

    /*********** CREATE MOVIE *******/
    @Override
    public MovieDto createMovie(Movie movie) {
        Movie savedMovie = this.movieRepository.save(movie);
        return this.movieToDto(savedMovie);
    }

    /*********** UPDATE MOVIE *******/
    @Override
    public MovieDto updateMovie(@NotNull MovieDto movieDto, Integer movieId) {
        Movie movie = this.movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie","movieId", movieId));

        movie.setTitle(movieDto.getTitle());
        movie.setLanguage(movieDto.getLanguage());
        movie.setReleaseDate(movieDto.getReleaseDate());
        movie.setRuntime(movieDto.getRuntime());

        Movie updatedMovie = this.movieRepository.save(movie);
        MovieDto movieDto1 = this.movieToDto(updatedMovie);
        return movieDto1;

    }


    /*********** GET SINGLE MOVIE *******/
    @Override
    public MovieDto getById(Integer movieId) {
        Movie movie = this.movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie","movieId", movieId));
        return this.movieToDto(movie);
    }

    /*********** GET ALL MOVIES *******/
    @Override
    public List<MovieDto> getAllMovies() {
        List<Movie> movies = this.movieRepository.findAll();
        List<MovieDto> movieDtoList = movies.stream().map(user -> this.movieToDto(user)).collect(Collectors.toList());
        return movieDtoList;
    }

    /*********** DELETE a movie *******/
    @Override
    public void deleteMovie(Integer movieId) {
        Movie movie = this.movieRepository.findById(movieId)
                .orElseThrow(()-> new ResourceNotFoundException("Movie","movieId",movieId));
        this.movieRepository.delete(movie);
    }

    /*********** DTO to MOVIE *******/
    public Movie dtoToMovie(@NotNull MovieDto movieDto){
        this.movieDto = movieDto;
        Movie movie = new Movie();

        movie.setMovieId(movieDto.getMovieId());
        movie.setLanguage(movieDto.getLanguage());
        movie.setTitle(movieDto.getTitle());
        movie.setReleaseDate(movieDto.getReleaseDate());
        movie.setRuntime(movieDto.getRuntime());

        return movie;

    }
    /*********** MOVIE TO DTO *******/
    public MovieDto movieToDto(@NotNull Movie movie){
        MovieDto movieDto = new MovieDto();
        movieDto.setMovieId(movie.getMovieId());

        movieDto.setTitle(movie.getTitle());
        movieDto.setLanguage(movie.getLanguage());
        movieDto.setReleaseDate(movie.getReleaseDate());
        movieDto.setRuntime(movie.getRuntime());

        return movieDto;

    }
}
