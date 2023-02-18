package com.practice.controller;

import com.practice.controller.dto.LoginRequest;
import com.practice.controller.dto.RegisterRequest;
import com.practice.security.JwtUtils;
import com.practice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping
@AllArgsConstructor
public class UserJwtController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    //*********** Register New User ************

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody RegisterRequest registerRequest){

        userService.registerUser(registerRequest);

        String message= "User registered successfully";

        return new ResponseEntity<>(message, HttpStatus.CREATED);

    }

    //*********** Login User ************
    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequest loginRequest){
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        loginRequest.getUserName(),
                        loginRequest.getPassword()));
        //
        String token = jwtUtils.createToken(authentication);
        return new ResponseEntity<>(token, HttpStatus.CREATED);
    }

}
