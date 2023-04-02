package com.server.ZeroZinema.controller;

import com.server.ZeroZinema.model.Show;
import com.server.ZeroZinema.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShowController {
    @Autowired
    private ShowRepository showRepository;

    @PostMapping("/addShow")
    Show newShow(@RequestBody Show newShow){
        return showRepository.save(newShow);
    }
    @GetMapping("/shows")
    List<Show> getAllShow(){
        return showRepository.findAll();
    }
}
