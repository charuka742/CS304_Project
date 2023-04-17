package com.server.ZeroZinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "movie")
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
    private  String rating;

    @ElementCollection(targetClass = String.class)
    @Column(name = "genre")
    private Set<String> genre;

    @ElementCollection(targetClass = String.class)
    @Column(name = "crew")
    private Set<String> crew;

    @Column(name = "trailerLink")
    private String trailerLink;
    @Column(name = "bannerlink")
    private String bannerlink;
    @Column(name = "director")
    private String director;
    @Column(name = "releaseDate")
    private LocalDate releaseDate;
    @Column(name = "runtime")
    private int runtime;

    @JsonIgnore
    @OneToMany(mappedBy = "movie")
    private List<TheatreMovie> theatreMovies;

    @JsonIgnore
    @ManyToMany(mappedBy = "movies",cascade = CascadeType.ALL)
    private List<User> users;

}
