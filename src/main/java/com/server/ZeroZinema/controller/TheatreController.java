package com.server.ZeroZinema.controller;

import com.server.ZeroZinema.model.Theatre;
import com.server.ZeroZinema.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TheatreController {
    @Autowired
    private TheatreRepository theatreRepository;

    @PostMapping("/addTheatre")
    Theatre newTheatre(@RequestBody Theatre newTheatre){
        return theatreRepository.save(newTheatre);

    }

    @GetMapping("/allTheatres")
    List<Theatre> getAllTheatres(){
        return theatreRepository.findAll();
    }
}
