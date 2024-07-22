package com.example.ItisFinalProject.controller;

import com.example.ItisFinalProject.entity.User;
import com.example.ItisFinalProject.exception.ClientException;
import com.example.ItisFinalProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("register")
public class UserRegisterController {
    @Autowired
    private UserService userService;

    protected PasswordEncoder passwordEncoder;

    private User user;
    @GetMapping
    public String registerNewUser(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }
    @PostMapping
    public String saveUser(@ModelAttribute("user") User user, Model model) throws ClientException {
        Optional<User> optionalUser = userService.findByEmail(user.getEmail());
        if (optionalUser.isPresent()){
            model.addAttribute("registerError", true);
            return "registration";
        }
        this.user = user;
        userService.saveUserInDatabase(user);
        return "redirect:/index";

    }
}
