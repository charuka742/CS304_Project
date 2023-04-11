package com.server.ZeroZinema.payloads;


import com.server.ZeroZinema.enums.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;
    private String name;
    private String email;
    private LocalDate birthD;
    private String mobileNo;
    private String city;
    private String password;
    private Role role;

}
