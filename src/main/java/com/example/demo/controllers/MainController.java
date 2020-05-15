package com.example.demo.controllers;

import com.example.demo.domain.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @PutMapping("/amount")
    @ResponseBody
    public void updateAmount(Principal principal) {
        String currentUsername = principal.getName();
        User user = userService.findByUsername(currentUsername);
        userService.updateAmount(user);
    }

    @GetMapping("/amount")
    @ResponseBody
    public int getAmount(Principal principal) {
        String currentUsername = principal.getName();
        User user = userService.findByUsername(currentUsername);
        return user.getAmount();
    }

}
