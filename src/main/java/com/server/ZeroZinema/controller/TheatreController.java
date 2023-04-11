package com.server.ZeroZinema.controller;

import com.server.ZeroZinema.model.Theatre;
import com.server.ZeroZinema.payloads.ApiResponse;
import com.server.ZeroZinema.payloads.TheatreDto;
import com.server.ZeroZinema.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/theatres")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    /* ADD THEATRE */
    @PostMapping
    public ResponseEntity<TheatreDto> createTheatre(@RequestBody Theatre theatre){
        TheatreDto createdTheatreDto = this.theatreService.createTheatre(theatre);
        return new ResponseEntity<>(createdTheatreDto, HttpStatus.CREATED);
    }

    /* UPDATE THEATRE */
    @PutMapping("{theatreId}")
    public ResponseEntity<TheatreDto> updateTheatre(@RequestBody Theatre theatre,@PathVariable("theatreId") Integer theatreId){
        TheatreDto updatedTheatreDto = this.theatreService.updateTheatre(theatre, theatreId);
        return  ResponseEntity.ok(updatedTheatreDto);
    }

    /* DELETE THEATRE */
    @DeleteMapping("{theatreId}")
    public  ResponseEntity<ApiResponse> deleteTheatre(@PathVariable("theatreId") Integer theatreId){
        this.theatreService.deleteTheatre(theatreId);
        return new ResponseEntity<>(new ApiResponse("Theatre Deleted Successfully", true), HttpStatus.OK);
    }

    /* ALL THEATRES */
    @GetMapping
    public ResponseEntity<List<TheatreDto>> getAllTheatres(){
        return ResponseEntity.ok(this.theatreService.getAllTheatre());
    }

    /* SINGLE THEATRE */
    @GetMapping("{theatreId}")
    public ResponseEntity<TheatreDto> getSingleTheatre(@PathVariable("theatreId") Integer theatreId){
        return ResponseEntity.ok(this.theatreService.getById(theatreId));
    }

}
