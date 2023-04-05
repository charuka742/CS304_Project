package com.server.ZeroZinema.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class TheatreDto {

    private int id;
    private String theatreName;
    private String email;
    private String city;
    private int noOfTotalSeats;
    private int standardSeats;
    private int premiumSeats;
    private int vipSeats;

    /*private String teleNo;
    private String managerName;
    private String managerNo;*/
}
