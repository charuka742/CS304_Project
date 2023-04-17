package com.server.ZeroZinema.services.Impl;

import com.server.ZeroZinema.exception.ResourceNotFoundException;
import com.server.ZeroZinema.model.User;
import com.server.ZeroZinema.payloads.UserDto;
import com.server.ZeroZinema.repository.UserRepository;
import com.server.ZeroZinema.services.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    private UserDto userDto;



    /*********** CREATE USER *******/
    @Override
    public UserDto createUser(User user) {
        User savedUser = this.userRepository.save(user);
        return this.userToDto(savedUser);
    }

    /*********** UPDATE USER *******/
    @Override
    public UserDto updateUser(@NotNull UserDto userDto, Integer userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User","Id", userId));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setCity(userDto.getCity());
        user.setMobileNo(userDto.getMobileNo());
        user.setPassword(userDto.getPassword());
        user.setDob(userDto.getDob());
        user.setRole(userDto.getRole());

        User updatedUser = this.userRepository.save(user);
        UserDto userDto1 = this.userToDto(updatedUser);
        return userDto1;
    }


    /*********** GETBYID *******/
    @Override
    public UserDto getById(Integer userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User","Id", userId));
        return this.userToDto(user);
    }

    /*********** GETALLUSER *******/
    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    /*********** DELETEUSER *******/
    @Override
    public void deleteUser(Integer userId) {
        User user =this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        this.userRepository.delete(user);
    }

    /*********** DTO TO USER *******/
    public User dtoToUser(@NotNull UserDto userDto){
        User user = new User();

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setCity(userDto.getCity());
        user.setDob(userDto.getDob());

        user.setMobileNo(userDto.getMobileNo());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());

        return user;
    }

    /*********** USER TO DTO *******/
    public UserDto userToDto(@NotNull User user){
        UserDto userDto = new UserDto();

        userDto.setUserId(user.getUserId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setDob(user.getDob());
        userDto.setCity(user.getCity());
        userDto.setMobileNo(user.getMobileNo());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());

        return userDto;
    }
}
