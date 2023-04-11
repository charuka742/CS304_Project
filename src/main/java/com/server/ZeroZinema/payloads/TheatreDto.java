package com.server.ZeroZinema.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class TheatreDto {

    private int theatreId;
    private String theatreName;
    private String email;
    private String city;
    private String teleNo;
    private String managerName;
    private String managerNo;
    private int noOfTotalSeats;
    private int standardSeats;
    private int premiumSeats;
    private int vipSeats;

}
