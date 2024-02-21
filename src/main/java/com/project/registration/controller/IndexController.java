package com.project.registration.controller;

import com.project.registration.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {
    String username;
    String email;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    // Collecting user data
    @PostMapping("/register")
    public String userRegistration(@ModelAttribute User user){
        System.out.println(user.toString());
        username = user.getUsername();
        email = user.getEmail();
        return "redirect:/result";
    }

    @GetMapping("/result")
    public String result(Model model){
        model.addAttribute("username" , username);
        model.addAttribute("email" , email);
        return "result";
    }
}
