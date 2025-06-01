package com.kd.user.portal.user.controller;

import com.kd.user.portal.user.dto.GenericResponse;
import com.kd.user.portal.user.dto.UserDTO;
import com.kd.user.portal.user.dto.UserResponse;
import com.kd.user.portal.user.exception.UserValidationException;
import com.kd.user.portal.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("/")
public class UserController
{

    private final UserService userService;


    public UserController(UserService userService){
        this.userService = userService;
    }


    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody UserDTO userDTO) throws UserValidationException {
        UserResponse userResponse = userService.saveUser(userDTO);
        return  ResponseEntity.ok(userResponse);
    }

    @GetMapping("/users/{user_id}")
    public ResponseEntity getUserById(@PathVariable("user_id") String userId) throws UserValidationException {
        return ResponseEntity.ok(userService.getUserById(userId));
    }


    //TODO: patch method


    /***
     *
     */


    @DeleteMapping("/close")
    public ResponseEntity deleteUser(){
        userService.deleteUser(null);
        return ResponseEntity.ok(new GenericResponse("Account and user successfully removed",null));
    }



}
