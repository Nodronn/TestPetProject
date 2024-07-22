package com.example.SpringTestProject.controller;

import com.example.SpringTestProject.entity.User;
import com.example.SpringTestProject.exception.ClientException;
import com.example.SpringTestProject.security.SecurityUser;
import com.example.SpringTestProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@PreAuthorize("hasAuthority('unsecure')")
@RequestMapping("edit")
public class UserEditController {

    @Autowired
    private UserService userService;

    private User user;
    @GetMapping("{id}")
    public String findUser(@PathVariable("id") long id, Model model){
        model.addAttribute("user", userService.findOneUserInDatabase(id));
        return "userEdit";
    }
    @PostMapping
    public String updateUser(@ModelAttribute("user") User user, @AuthenticationPrincipal SecurityUser securityUser) throws ClientException {
        this.user = user;
        securityUser.setUsername(user.getEmail());
        userService.updateUserInDatabase(user);
        return "redirect:/account";
    }
}
