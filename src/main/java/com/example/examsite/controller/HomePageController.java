package com.example.examsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomePageController {
    @GetMapping("/")
    public String getHome(){
        return "home";
    }
    @GetMapping("/student")
    public String getStudent(){
        return "student";
    }
    @GetMapping("/teacher")
    public String getTeacher(){
        return "teacher";
    }
}
