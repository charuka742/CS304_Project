package com.server.ZeroZinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "theatre")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theatreId")
    private int theatreId;

    @Column(name = "theatreName")
    private String theatreName;
    @Column(name = "email")
    private String email;
    @Column(name = "city")
    private String city;
    @Column(name = "teleNo")
    private String teleNo;
    @Column(name = "managerName")
    private String managerName;
    @Column(name = "managerNo")
    private String managerNo;
    @Column(name = "noOfTotalSeats")
    private int noOfTotalSeats;
    @Column(name = "standardSeats")
    private int standardSeats;
    @Column(name = "premiumSeats")
    private int premiumSeats;
    @Column(name = "vipSeats")
    private int vipSeats;


    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<Seat> seats;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<Promotion> promotions;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<User> users;

    @JsonIgnore
    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    private List<TheatreMovie> theatreMovies;

}
