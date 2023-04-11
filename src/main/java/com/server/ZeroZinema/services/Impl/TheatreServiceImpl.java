package com.server.ZeroZinema.services.Impl;

import com.server.ZeroZinema.exception.ResourceNotFoundException;
import com.server.ZeroZinema.model.Theatre;
import com.server.ZeroZinema.payloads.TheatreDto;
import com.server.ZeroZinema.repository.TheatreRepository;

import com.server.ZeroZinema.services.TheatreService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TheatreServiceImpl implements TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;

    private TheatreDto theatreDto;


    /**********  CREATE THEATRE   ***********/
    @Override
    public TheatreDto createTheatre(Theatre theatre) {
        Theatre savedTheatre = this.theatreRepository.save(theatre);
        return this.theatreToDto(savedTheatre);
    }

    /**********  UPDATE THEATRE   ***********/
    @Override
    public TheatreDto updateTheatre(@NotNull Theatre theatre, Integer theatreId) {
        Theatre theatre1 = this.theatreRepository.findById(theatreId)
                .orElseThrow(()-> new ResourceNotFoundException("Theatre","theatreId", theatreId));

        theatre1.setTheatreName(theatre.getTheatreName());
        theatre1.setCity(theatre.getCity());
        theatre1.setEmail(theatre.getEmail());
        theatre1.setTeleNo(theatre.getTeleNo());
        theatre1.setManagerName(theatre.getManagerName());
        theatre1.setManagerNo(theatre.getManagerNo());
        theatre1.setVipSeats(theatre.getVipSeats());
        theatre1.setStandardSeats(theatre.getStandardSeats());
        theatre1.setPremiumSeats(theatre.getPremiumSeats());
        theatre1.setNoOfTotalSeats(theatre.getNoOfTotalSeats());

        Theatre updatedTheatre = this.theatreRepository.save(theatre1);
        TheatreDto theatreDto = this.theatreToDto(updatedTheatre);

        return theatreDto;
    }


    /**********  GET BY ID THEATRE   ***********/
    @Override
    public TheatreDto getById(Integer theatreId) {
        Theatre theatre = this.theatreRepository.findById(theatreId)
                .orElseThrow(()-> new ResourceNotFoundException("Theatre","theatreId", theatreId));

        return this.theatreToDto(theatre);
    }


    /**********  GET ALL THEATRE   ***********/
    @Override
    public List<TheatreDto> getAllTheatre() {
        List<Theatre> theatres = this.theatreRepository.findAll();
        List<TheatreDto> theatreDtos = theatres.stream().map(theatre -> this.theatreToDto(theatre)).collect(Collectors.toList());

        return theatreDtos;
    }


    /**********  DELETE THEATRE   ***********/
    @Override
    public void deleteTheatre(Integer theatreId) {
        Theatre theatre = this.theatreRepository.findById(theatreId)
                .orElseThrow(()-> new ResourceNotFoundException("Theatre","theatreId",theatreId));

        this.theatreRepository.delete(theatre);

    }

    /**********  DTO TO THEATRE   ***********/
    public Theatre dtoToTheatre(@NotNull TheatreDto theatreDto){
        this.theatreDto = theatreDto;
        Theatre theatre2 = new Theatre();

        theatre2.setTheatreId(theatreDto.getTheatreId());
        theatre2.setTheatreName(theatreDto.getTheatreName());
        theatre2.setCity(theatreDto.getCity());
        theatre2.setEmail(theatreDto.getEmail());
        theatre2.setTeleNo(theatreDto.getTeleNo());
        theatre2.setManagerName(theatreDto.getManagerName());
        theatre2.setManagerNo(theatreDto.getManagerNo());
        theatre2.setNoOfTotalSeats(theatreDto.getNoOfTotalSeats());
        theatre2.setPremiumSeats(theatreDto.getPremiumSeats());
        theatre2.setStandardSeats(theatreDto.getStandardSeats());
        theatre2.setVipSeats(theatreDto.getVipSeats());

        return theatre2;
    }

    /**********   THEATRE TO DTO   ***********/
    public TheatreDto theatreToDto(@NotNull Theatre theatre) {
        TheatreDto theatreDto = new TheatreDto();

        theatreDto.setTheatreId(theatre.getTheatreId());

        theatreDto.setTheatreName(theatre.getTheatreName());
        theatreDto.setCity(theatre.getCity());
        theatreDto.setEmail(theatre.getEmail());
        theatreDto.setTeleNo(theatre.getTeleNo());
        theatreDto.setManagerName(theatre.getManagerName());
        theatreDto.setManagerNo(theatre.getManagerNo());
        theatreDto.setNoOfTotalSeats(theatre.getNoOfTotalSeats());
        theatreDto.setPremiumSeats(theatre.getPremiumSeats());
        theatreDto.setStandardSeats(theatre.getStandardSeats());
        theatreDto.setVipSeats(theatre.getVipSeats());

        return theatreDto;
    }
}
