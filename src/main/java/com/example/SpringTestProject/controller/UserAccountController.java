package com.example.SpringTestProject.controller;

import com.example.SpringTestProject.entity.User;
import com.example.SpringTestProject.exception.ClientException;
import com.example.SpringTestProject.exception.ErrorCode;
import com.example.SpringTestProject.security.SecurityUser;
import com.example.SpringTestProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PreAuthorize("hasAuthority('unsecure')")
public class UserAccountController {
    @Autowired
    private UserService userService;


    @RequestMapping("/account")
    public String logged(@AuthenticationPrincipal SecurityUser securityUser,
                         Model model) throws ClientException {
        String userEmail = securityUser.getUsername();
        User loggedUser = (User) userService.findByEmail(userEmail).orElseThrow(()-> new ClientException(ErrorCode.USER_NOT_FOUND));
        model.addAttribute("loggedUser", loggedUser);
        return "userAccount";
    }

}
