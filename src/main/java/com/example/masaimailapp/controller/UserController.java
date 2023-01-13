package com.example.masaimailapp.controller;

import com.example.masaimailapp.dto.EmailDTO;
import com.example.masaimailapp.dto.LoginDTO;
import com.example.masaimailapp.dto.RegisterDTO;
import com.example.masaimailapp.entity.Email;
import com.example.masaimailapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    // Register new user
    @PostMapping ("/masaimail/register")
    public ResponseEntity registerUser(@RequestBody RegisterDTO registerDTO){
        boolean isCreated = userService.registerUser(registerDTO);

        return isCreated == true ? new ResponseEntity(HttpStatus.CREATED) : new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Login user
    @PostMapping ("/masaimail/login")
    public ResponseEntity loginUser(@RequestBody LoginDTO LoginDTO){
        boolean loginIn = userService.loginUser(LoginDTO);

        return loginIn == true ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //Get all mails for a particular user
    @GetMapping("/masaimail/mail")
    public ResponseEntity getAllMails(@RequestBody EmailDTO emailDTO){
        List<Email> email = userService.getAllMails(emailDTO);

        return email != null ? new ResponseEntity(email, HttpStatus.OK) : new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
