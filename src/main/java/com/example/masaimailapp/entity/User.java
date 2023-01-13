package com.example.masaimailapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    private String email;

    private String firstName;
    private String lastName;
    private int mobileNumber;
    private Date dateOfBirth;
}
