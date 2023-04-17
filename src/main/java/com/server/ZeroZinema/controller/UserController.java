package com.server.ZeroZinema.controller;

import com.server.ZeroZinema.model.User;
import com.server.ZeroZinema.payloads.ApiResponse;
import com.server.ZeroZinema.payloads.UserDto;
import com.server.ZeroZinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    /* ADD USER */
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody User user){
        UserDto createdUserDto = this.userService.createUser(user);
        return  new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    /* UPDATED USER */
    @PutMapping("{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userId") Integer uid){
       UserDto updatedUser = this.userService.updateUser(userDto, uid);
        return ResponseEntity.ok(updatedUser);
    }

    /* DELETE USER */
    @DeleteMapping("{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid){
        this.userService.deleteUser(uid);
        return  new ResponseEntity<>(new ApiResponse("User deleted Successfully", true), HttpStatus.OK);

    }

    /* GET ALL USERS */
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }


    /* GET SINGLE USER */
    @GetMapping("{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable("userId") Integer userId){
        return ResponseEntity.ok(this.userService.getById(userId));
    }


}
