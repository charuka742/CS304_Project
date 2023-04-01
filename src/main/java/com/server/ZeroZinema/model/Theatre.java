package com.server.ZeroZinema.model;

/*import com.server.ZeroZinema.enums.Seats;*/
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "theatre")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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

    /*@ElementCollection(targetClass = Seats.class)
    @Enumerated(EnumType.STRING)
    @Column(name = "seats")
    private Set<Seats> seats;*/
    @Column(name = "noOfCol")
    private int noOfCol;
    @Column(name = "noOfRow")
    private int noOfRow;
    @Column(name = "standardSeats")
    private int standardSeats;
    @Column(name = "premiumSeats")
    private int premiumSeats;
    @Column(name = "vipSeats")
    private int vipSeats;



}
