package com.example.cbt.controller;

import com.example.cbt.dao.gradedao;
import com.example.cbt.dao.studentdao;
import com.example.cbt.pojo.student;
import com.example.cbt.pojo.stugrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
public class AddController {
    @Autowired
    studentdao st;
    @Autowired
    gradedao gd;
    @PostMapping("/add")
    public String add(Integer ID,@RequestParam("stuname")String stuname,Integer cID,@RequestParam("cource")String cource,@RequestParam("classname")String classname,@RequestParam("grade")Integer grade,@RequestParam("teacher")String teacher){
        st.add(new student(ID,cID,stuname,cource,grade,teacher,classname,null));
        return "redirect:/msg";
    }
    @PostMapping("/add2")
    public String add2(@RequestParam("stuname")String stuname,@RequestParam("cource")String cource,@RequestParam("grade")Integer grade){
        st.add(new student(null,null,stuname,cource,grade,null,null,null));
        return "redirect:/msg";
    }
}
