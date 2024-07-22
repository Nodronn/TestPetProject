package com.example.ItisFinalProject.controller;

import com.example.ItisFinalProject.entity.User;
import com.example.ItisFinalProject.exception.ClientException;
import com.example.ItisFinalProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@PreAuthorize("hasAuthority('secure')")
@RequestMapping("/admin_edit")
public class AdminEditController {

    @Autowired
    private UserService userService;

    private User user;
    @GetMapping("{id}")
    public String findUser(@PathVariable("id") long id, Model model){
        model.addAttribute("user", userService.findOneUserInDatabase(id));
        return "admin/adminEdit";
    }
    @PostMapping
    public String updateUser(@ModelAttribute("user") User user) throws ClientException {
        this.user = user;
        userService.updateUserInDatabase(user);
        return "redirect:/allUsers";
    }

}
