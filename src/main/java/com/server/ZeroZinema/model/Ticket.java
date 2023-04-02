package com.server.ZeroZinema.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "Ticket")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "price")
    private double price;
    @Column(name = "showTime")
    private String showTime;
    @Column(name = "seatId")
    private String seatId;
    @Column(name = "movieName")
    private String movieName;
    @Column(name = "theatreName")
    private String theatreName;
    @Column(name = "qrCode")
    private String qrCode;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "timeOfPurchase")
    private Timestamp  timeOfPurchase;
    @Column(name = "ticketNo")
    private int ticketNo;

}
