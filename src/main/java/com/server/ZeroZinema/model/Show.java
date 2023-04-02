package com.server.ZeroZinema.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Show")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "movieTitle")
    private String movieTitle;
    @Column(name = "showTime")
    private String showTime;
    @Column(name = "theatreName")
    private String theatreName;
    @Column(name = "duration")
    private int duration;
    @Column(name = "language")
    private String language;
    @Column(name = "rating")
    private double rating;

}
