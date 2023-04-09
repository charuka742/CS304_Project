package com.server.ZeroZinema.payloads;



import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class MovieDto {

    private int movieId;
    private String title;
    private String language;
    private String description;
    private double rating;
    /*private Set<String> genre;
    private Set<String> crew;*/
    private String trailerLink;
    private String banner;
    private String director;
    private LocalDate releaseDate;
    private int runtime;
}
