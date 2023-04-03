package com.server.ZeroZinema.model;

import com.server.ZeroZinema.enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "seat")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "rowNo")
    private int rowNo;
    @Column(name = "colNo")
    private int colNo;
    @Enumerated(EnumType.STRING)
    @Column(name = "seatType")
    private SeatType seatType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;



}
