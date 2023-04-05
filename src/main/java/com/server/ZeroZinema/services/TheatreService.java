package com.server.ZeroZinema.services;

import com.server.ZeroZinema.model.Theatre;
import com.server.ZeroZinema.payloads.TheatreDto;

import java.util.List;

public interface TheatreService {

    TheatreDto createTheatre(Theatre theatre);
    TheatreDto updateTheatre(Theatre theatre, Integer theatreId);
    TheatreDto getById(Integer theatreId);
    List<TheatreDto> getAllTheatre();
    void deleteTheatre(Integer theatreId);

}
