package com.example.cbt.controller;

import com.example.cbt.dao.userdao;
import com.example.cbt.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    userdao use;

    @RequestMapping("/user/login")
    public String login(@RequestParam("shenfen")String shenfen,@RequestParam("username")String username, @RequestParam("password")String password, Model model){
        user a=new user(username,password);
        if (shenfen.equals("教师教辅人员") && username.equals("admin")&& use.login(a)==a){
            return "redirect:/msg";
        }
        if (shenfen.equals("学生") && username.equals("cbt")&& use.login(a)==a){
            return "redirect:/msg";
        }
        else {
            System.out.println(shenfen);
            System.out.println(use.login(a));
            model.addAttribute("msg","用户名或密码错误");
            return "index";
        }
    }
    @GetMapping("/login")
    public String login(){
        return "index";
    }
}
