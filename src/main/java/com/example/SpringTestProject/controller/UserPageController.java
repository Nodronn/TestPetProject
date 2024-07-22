package com.example.ItisFinalProject.controller;

import com.example.ItisFinalProject.entity.User;
import com.example.ItisFinalProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PreAuthorize("hasAuthority('unsecure')")
@RequestMapping("user")
public class UserPageController {
    @Autowired
    private UserService userService;

    private User user;
    @GetMapping("{id}")
    public String findUser(@PathVariable("id") long id, Model model){
        model.addAttribute("user", userService.findOneUserInDatabase(id));
        return "oneUser";
    }
}
