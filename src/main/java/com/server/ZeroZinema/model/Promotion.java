package com.server.ZeroZinema.model;

import com.server.ZeroZinema.enums.PromotionType;
import jakarta.persistence.*;

@Entity
@Table(name = "Promotion")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Enumerated(EnumType.STRING)
    @Column(name = "promotionType")
    private PromotionType promotionType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;
}
