package com.server.ZeroZinema.payloads;


import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class MovieDto {

    private int movieId;
    private String title;
    private String language;
    private Date releaseDate;
    private int runtime;
}
