package com.server.ZeroZinema.controller;

import com.server.ZeroZinema.payloads.ApiResponse;
import com.server.ZeroZinema.payloads.UserDto;
import com.server.ZeroZinema.repository.UserRepository;
import com.server.ZeroZinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    public UserRepository userRepository;
    @Autowired
    private UserService userService;

    /* add user */
    @PostMapping("/add")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto createdUserDto = this.userService.createUser(userDto);
        return  new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    /* update user */
    @PutMapping("/u/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userId") Integer uid){
       UserDto updatedUser = this.userService.updateUser(userDto, uid);
        return ResponseEntity.ok(updatedUser);
    }

    /* delete user */
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid){
        this.userService.deleteUser(uid);
        return  new ResponseEntity<>(new ApiResponse("User deleted Successfully", true), HttpStatus.OK);

    }

    /* Get All Users */
    @GetMapping("/allUsers")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }


    /* Get Single User */
    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable("userId") Integer userId){
        return ResponseEntity.ok(this.userService.getById(userId));
    }



   /*  @PostMapping("/user")
     User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
     }



     @GetMapping("/users")
     List<User> getAllUsers(){
        return userRepository.findAll();
     }*/
}
