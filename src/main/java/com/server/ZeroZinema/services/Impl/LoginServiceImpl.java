/*
package com.server.ZeroZinema.services.Impl;

import com.server.ZeroZinema.model.Login;
import com.server.ZeroZinema.model.Movie;
import com.server.ZeroZinema.payloads.LoginDto;
import com.server.ZeroZinema.payloads.MovieDto;
import com.server.ZeroZinema.repository.LoginRepository;
import com.server.ZeroZinema.services.LoginService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginRepository loginRepository;

    private LoginDto loginDto;

    public Login dtoToLogin(@NotNull LoginDto loginDto){
        this.loginDto = loginDto;
        Login login1 = new Login();

        login1.setEmail(loginDto.getEmail());
        login1.setPassword(loginDto.getPassword());

        return login1;

    }

    public LoginDto loginToDto(@NotNull Login login){
        LoginDto loginDto1 = new LoginDto();

        loginDto1.setEmail(login.getEmail());

        loginDto1.setPassword(login.getPassword());

        return loginDto1;

    }

}
*/
