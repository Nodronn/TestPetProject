package com.example.SpringTestProject.controller;

import com.example.SpringTestProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PreAuthorize("hasAuthority('secure')")
@RequestMapping("delete")
public class DeleteController {

    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUserFromDatabase(id);
        return "redirect:/allUsers";
    }

}
