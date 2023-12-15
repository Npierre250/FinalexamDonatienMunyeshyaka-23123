package com.example.military_managment_system.service;

import com.example.military_managment_system.DataTransferObject.UserRegistartionDto;
import com.example.military_managment_system.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserInterface extends UserDetailsService {
    public User saveAccount(UserRegistartionDto userRegistartionDto);
    public User findByEmail(String email);
}
