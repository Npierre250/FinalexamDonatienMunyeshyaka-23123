package com.example.military_managment_system.controller;

import com.example.military_managment_system.DataTransferObject.UserRegistartionDto;
import com.example.military_managment_system.model.User;
import com.example.military_managment_system.service.UserInterface;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserController {
    private final UserInterface userInterface;

    public UserController(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @GetMapping
    public String showRegistrationForm(){
        return "registration";
    }


    @ModelAttribute("user")
    public UserRegistartionDto userRegistartionDto(){
        return new UserRegistartionDto();
    }
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user")UserRegistartionDto dto){
        User foundUser=userInterface.findByEmail(dto.getEmail());
        if (foundUser!=null &&  (foundUser.getEmail().equalsIgnoreCase(dto.getEmail()))) {
               return "redirect:/registration?error";   
        }
        userInterface.saveAccount(dto);
        return "redirect:/registration?success";
    }
}
