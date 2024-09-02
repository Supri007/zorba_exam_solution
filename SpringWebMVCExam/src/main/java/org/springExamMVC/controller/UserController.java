package org.springExamMVC.controller;

import org.springExamMVC.Service.UserService;
import org.springExamMVC.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/userRegistration")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/saveUserData")
    public String saveStudent(@ModelAttribute UserModel userModel, Model model) {
        String response = userService.addUserData(userModel);
        model.addAttribute("message", response);
        return "InsertionSuccessful";
    }
}
