package com.server.ZeroZinema.controller;

import com.server.ZeroZinema.model.Feedback;
import com.server.ZeroZinema.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @PostMapping("/feedback")
    Feedback newFeedback(@RequestBody Feedback newFeedBack){
        return feedbackRepository.save(newFeedBack);
    }

    @GetMapping("/getAllFeedback")
    List<Feedback> getAllFeedback(){
        return feedbackRepository.findAll();
    }

}
