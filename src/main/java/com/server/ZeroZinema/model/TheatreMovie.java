package com.server.ZeroZinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "theatre_movie")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TheatreMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    @JsonIgnore
    private Theatre theatre;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonIgnore
    private Movie movie;

    @Column(name = "showTime")
    private String showTime;
    @Column(name = "showDate")
    private Date showDate;


}
