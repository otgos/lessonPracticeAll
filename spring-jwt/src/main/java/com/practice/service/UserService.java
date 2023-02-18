package com.practice.service;

import com.practice.controller.dto.RegisterRequest;
import com.practice.domain.Role;
import com.practice.domain.User;
import com.practice.domain.enums.UserRole;
import com.practice.exception.ConflictException;
import com.practice.exception.ResourceNotFoundException;
import com.practice.repository.RoleRepository;
import com.practice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.SecondaryTable;
import java.nio.file.ReadOnlyFileSystemException;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(RegisterRequest registerRequest) {
        if(userRepository.existsByUserName(registerRequest.getUserName())){

            throw new ConflictException("Username is already in use");

        }
        Role role = roleRepository.findByName(UserRole.ROLE_STUDENT).orElseThrow(
                ()->new ResourceNotFoundException("Role not found")
        );
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        User user = new User();

        user.setFistName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setUserName(registerRequest.getUserName());
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        userRepository.save(user);


    }
}
