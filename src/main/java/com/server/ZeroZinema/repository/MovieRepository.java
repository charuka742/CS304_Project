package com.server.ZeroZinema.repository;

import com.server.ZeroZinema.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {


    @Query("SELECT m FROM Movie m WHERE m.title LIKE %:title%")
    List<Movie> searchMoviesByTitle(@Param("title") String title);

    @Query("SELECT m FROM Movie m WHERE m.director LIKE %:director%")
    List<Movie> searchMoviesByDirector(@Param("director") String director);

  /*  @Query("SELECT m FROM Movie m JOIN m.genres g WHERE g.name LIKE %:genre%")
    List<Movie> searchMoviesByGenre(@Param("genre") String genre);
*/
 /*   List<Movie> findByYear(int year);*/








}
