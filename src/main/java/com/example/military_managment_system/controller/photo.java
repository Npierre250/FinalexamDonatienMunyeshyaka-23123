package com.example.military_managment_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class photo {
    @RequestMapping("/login")
    public String index(){
        return "login";
    }
}
