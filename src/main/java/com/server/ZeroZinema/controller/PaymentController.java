package com.server.ZeroZinema.controller;

import com.server.ZeroZinema.model.Payment;

import com.server.ZeroZinema.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping("/addPayment")
    Payment newPayment(@RequestBody Payment newPayment){
        return paymentRepository.save(newPayment);
    }
    
    @GetMapping("/AllPayment")
    List<Payment> getAllPayment(){

        return paymentRepository.findAll();
    }
}
