package com.server.ZeroZinema.controller;

import com.server.ZeroZinema.model.Promotion;
import com.server.ZeroZinema.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PromotionController {
    @Autowired
    private PromotionRepository promotionRepository;

    @GetMapping("/AllPromotions")
    List<Promotion> getAllPromotions(){
        return promotionRepository.findAll();
    }
}
