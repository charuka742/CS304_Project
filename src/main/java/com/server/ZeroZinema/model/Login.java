/*
package com.server.ZeroZinema.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loginId;
    @Column(name = "email")
    private  String email;
    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;
}
*/
