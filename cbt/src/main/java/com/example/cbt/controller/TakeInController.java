package com.example.cbt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TakeInController {
    @GetMapping("/info")
    public String info(){
        return "StudentInformation";
    }
    @GetMapping("/pub")
    public String pub(){
        return "StudentRevise";
    }
    @GetMapping("/cha")
    public String cha(){
        return "Stu";
    }
    @GetMapping("/back")
    public String back(){
        return "index";
    }
}
