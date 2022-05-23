package com.example.cbt.controller;

import com.example.cbt.dao.gradedao;
import com.example.cbt.dao.studentdao;
import com.example.cbt.pojo.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class ChaController {
    @Autowired
    gradedao gd;
    @Autowired
    studentdao std;

    @RequestMapping("/msg")
    public String msg(Model model){
        Collection<student>stu=std.getall();
        model.addAttribute("msg",stu);
        return "StudentIndex";
    }
    @RequestMapping("/kechen")
    public String kechen(Model model){
        model.addAttribute("mst",gd.get());
        return "Stuto";
    }
    @RequestMapping("/gra")
    public String grade(Model model){
        model.addAttribute("mss",std.getall());
        return "grade";
    }
}
