package com.example.masaimailapp.service;

import com.example.masaimailapp.dto.EmailDTO;
import com.example.masaimailapp.dto.LoginDTO;
import com.example.masaimailapp.dto.RegisterDTO;
import com.example.masaimailapp.entity.Email;
import com.example.masaimailapp.entity.User;
import com.example.masaimailapp.entity.UserPassword;
import com.example.masaimailapp.modelmapper.ModelMapperClass;
import com.example.masaimailapp.repository.UserPasswordRepository;
import com.example.masaimailapp.repository.UserRepository;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserPasswordRepository userPasswordRepository;

    @Autowired
    ModelMapperClass modelMapperClass;

    public boolean registerUser(RegisterDTO registerDTO){
        SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter
                .filterOutAllExcept("email","firstName","lastName","mobileNumber","dateOfBirth");

        SimpleFilterProvider filterProvider = new SimpleFilterProvider()
                .addFilter("UserFilter",filter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(registerDTO);

        mappingJacksonValue.setFilters(filterProvider);

        User user = modelMapperClass.modelMapper()
                .map(mappingJacksonValue.getValue(), new TypeToken<User>() {}.getType());

        User newUser = userRepository.save(user);

        return newUser != null;
    }

    public boolean loginUser(LoginDTO loginDTO){
        List<UserPassword> users = userPasswordRepository.findAll();
        for(UserPassword user : users){
            if((user.getEmail().equals(loginDTO.getEmail())) && (user.getPassword().equals(loginDTO.getPassword()))) return true;
        }
        return false;
    }

    public List<Email> getAllMails(EmailDTO emailDTO){
        List<User> users = userRepository.findAll();
        for(User user : users){
            if(user.getEmail().equals(emailDTO.getEmail())) {
                return user.getEmails();
            }
        }
        return null;
    }
}
