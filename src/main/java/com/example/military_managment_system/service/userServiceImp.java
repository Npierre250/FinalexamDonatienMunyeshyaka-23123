package com.example.military_managment_system.service;


import com.example.military_managment_system.DataTransferObject.UserRegistartionDto;
import com.example.military_managment_system.model.Role;
import com.example.military_managment_system.model.User;
import com.example.military_managment_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class userServiceImp implements UserInterface {

    private BCryptPasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    @Autowired
    public void setDependencies(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User saveAccount(UserRegistartionDto userRegistartionDto) {
        User user = new User(userRegistartionDto.getfName(), userRegistartionDto.getlName(),
                userRegistartionDto.getEmail(),
                passwordEncoder.encode(userRegistartionDto.getPassword()), Arrays.asList(new Role("ROLE_ADMIN")));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("invalid username or password");
        } else
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                    mapRoleToGrantedAuthority(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRoleToGrantedAuthority(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    public User findByEmail(String email) {
      
        return userRepository.findByEmail(email);
    }

}
