package com.example.masaimailapp.controller;


import com.example.masaimailapp.dto.SendEmailDTO;
import com.example.masaimailapp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    // Send email
    @PostMapping("/masaimail/mail")
    public ResponseEntity sendEmail(@RequestBody SendEmailDTO sendEmailDTO){
        boolean isSent = emailService.sendEmail(sendEmailDTO);

        return isSent ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Star an email
    @PostMapping("/masaimail/starred/{id}")
    public ResponseEntity starAnEmail(@@PathVariable Long id){
        boolean isStarred = emailService.starAnEmail(id);

        return isStarred ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
