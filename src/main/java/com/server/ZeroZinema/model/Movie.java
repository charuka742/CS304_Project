package com.server.ZeroZinema.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "Movie")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movieId")
    private int movieId;
    @Column(name = "title")
    private String title;
    @Column(name = "language")
    private String language;
    @Column(name = "description")
    private String description;
    @Column(name = "rating")
    private  double rating;
    @ElementCollection(targetClass = String.class)
    @Column(name = "genre")
    private Set<String> genre;
    @ElementCollection(targetClass = String.class)
    @Column(name = "crew")
    private Set<String> crew;
    @Column(name = "trailerLink")
    private String trailerLink;
    @Column(name = "downloadLink")
    private String downloadLink;
    @Column(name = "director")
    private String director;
    @Column(name = "releaseDate")
    private Date releaseDate;
    @Column(name = "runtime")
    private int runtime;

}
