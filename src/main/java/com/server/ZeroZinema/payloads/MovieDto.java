package com.server.ZeroZinema.payloads;



import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class MovieDto {

    private int movieId;
    private String title;
    private String language;
    private String description;
    private String rating;
    private String trailerLink;
    private String bannerlink;
    private String director;
    private LocalDate releaseDate;
    private int runtime;

}
