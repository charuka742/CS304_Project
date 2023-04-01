package com.server.ZeroZinema.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "movie")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
    private String title;
    private String language;
    private String description;
    private  double rating;
    @ElementCollection(targetClass = String.class)
    private Set<String> genres;
    @ElementCollection(targetClass = String.class)
    private Set<String> cast;
    private String trailer;
    private String director;
    private Date releaseDate;
    private int runtime;








}
