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

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepository.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User","Id", userId));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setCity(userDto.getCity());
        user.setMobileNo(userDto.getMobileNo());
        user.setPassword(userDto.getPassword());

        User updatedUser = this.userRepository.save(user);
        UserDto userDto1 = this.userToDto(updatedUser);
        return userDto1;
    }



    @Override
    public UserDto getById(Integer userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User","Id", userId));
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {

        User user =this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        this.userRepository.delete(user);
    }

    public  User dtoToUser(@NotNull UserDto userDto){
        this.userDto = userDto;
        User user = new User();

        user.setId(userDto.getId());

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setCity(userDto.getCity());
        user.setMobileNo(userDto.getMobileNo());
        user.setPassword(userDto.getPassword());

        return user;

    }
    public UserDto userToDto(@NotNull User user){
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());

        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setCity(user.getCity());
        userDto.setMobileNo(user.getMobileNo());
        userDto.setPassword(user.getPassword());

        return userDto;

    }

}
