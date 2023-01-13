package com.example.masaimailapp.controller;

import com.example.masaimailapp.dto.LoginDTO;
import com.example.masaimailapp.dto.RegisterDTO;
import com.example.masaimailapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    // Register new user
    @PostMapping ("/masaimail/register")
    public ResponseEntity getUserDetails(@RequestBody RegisterDTO registerDTO){
        boolean isCreated = userService.registerUser(registerDTO);

        return isCreated == true ? new ResponseEntity(HttpStatus.CREATED) : new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Login user
    @PostMapping ("/masaimail/login")
    public ResponseEntity getUserDetails(@RequestBody LoginDTO LoginDTO){
        boolean loginIn = userService.loginUser(LoginDTO);

        return loginIn == true ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
