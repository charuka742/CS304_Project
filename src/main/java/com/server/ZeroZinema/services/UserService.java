package com.server.ZeroZinema.services;

import com.server.ZeroZinema.model.User;
import com.server.ZeroZinema.payloads.UserDto;

import java.util.List;

public interface UserService {


    UserDto createUser(User user);
    UserDto updateUser(UserDto user, Integer userId);
    UserDto getById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);


}
