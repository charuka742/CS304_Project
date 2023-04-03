package com.server.ZeroZinema.controller;

import com.server.ZeroZinema.model.Seat;
import com.server.ZeroZinema.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SeatController {
    @Autowired
    private SeatRepository seatRepository;

    @PostMapping("/seat")
    Seat newSeat(@RequestBody Seat newSeat){
        return seatRepository.save(newSeat);
    }

    @GetMapping("/allSeats")
    List<Seat> getAllSeat(){
        return seatRepository.findAll();
    }

}
