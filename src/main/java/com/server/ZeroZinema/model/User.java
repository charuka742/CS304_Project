package com.server.ZeroZinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.server.ZeroZinema.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "user")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId;

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "dob")
    private LocalDate dob;
    @Column(name = "mobileNo")
    private String mobileNo;
    @Column(name = "city")
    private String city;
    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "User_movie",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Movie> movies;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Promotion> promotions;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Payment payment;

    @OneToMany(mappedBy="user" ,cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;

    /*@OneToOne(mappedBy = "user" , cascade = CascadeType.ALL)
    private Login login;*/
}
