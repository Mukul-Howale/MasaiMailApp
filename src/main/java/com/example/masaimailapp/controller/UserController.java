package com.example.masaimailapp.controller;

import com.example.masaimailapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    // Login request
    @PostMapping pping("/user/getUser")
    public ResponseEntity getUserDetails(@RequestBody LoginDTO loginDTO){
        Long userId = userService.getUserDetails(loginDTO);

        return new ResponseEntity(userId, HttpStatus.OK);
    }
}
