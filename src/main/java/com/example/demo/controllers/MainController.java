package com.example.demo.controllers;

import com.example.demo.domain.User;
import com.example.demo.repos.UserRepo;
import com.example.demo.repos.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserService userService;

    @GetMapping("/update_amount")
    @ResponseBody
    public void updateAmount(Principal principal) {
        String currentUsername =  principal.getName();
        User user = userRepo.findByUsername(currentUsername);
        userService.updateAmount(user);
    }

    @GetMapping("/get_amount")
    @ResponseBody
    public int getAmount(Principal principal) {
        String currentUsername =  principal.getName();
        User user = userRepo.findByUsername(currentUsername);
        return user.getAmount();
    }

}
