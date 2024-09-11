package org.springExamMVC.controller;

import org.springExamMVC.Exception.UserDataException;
import org.springExamMVC.Service.UserService;
import org.springExamMVC.entity.User;
import org.springExamMVC.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.util.List;

@Controller
@RequestMapping(path = "/userRegistration")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public ModelAndView first() {
        ModelAndView modelAndView = new ModelAndView("UserRegistrationMVC");
        modelAndView.addObject("responseTxt", "First Spring MVC application...");
        return modelAndView;
    }

    @GetMapping("/addRoles")
    public ModelAndView addRoles(@ModelAttribute UserModel userModel, Model model) {
        ModelAndView modelAndView = new ModelAndView("AddRoles");
        return modelAndView;
    }

    @GetMapping("/removeRoles")
    public ModelAndView removeRoles(@ModelAttribute UserModel userModel, Model model) {
        ModelAndView modelAndView = new ModelAndView("RemoveRole");
        return modelAndView;
    }

    @PostMapping("/saveUserData")
    public String saveStudent(@ModelAttribute UserModel userModel, Model model) throws UserDataException {
        String response = this.userService.addUserData(userModel);
        model.addAttribute("message", response);
        return "InsertionSuccessful";
    }

    @PostMapping("/addRolesForUser")
    public ModelAndView addRolesForUser(@ModelAttribute UserModel userModel, Model model, HttpServletRequest request) throws UserDataException {
        String role = request.getParameter("userRole");
        List<UserModel> um = this.userService.updateUserRole(userModel.getUserId(), role);
        ModelAndView m = new ModelAndView("ViewUsers");
        m.addObject("allUsers",um);
        return m;
    }

    @GetMapping("/getAllUsers")
    public ModelAndView getAllStudent(Model model) throws UserDataException {
        List<UserModel> users = this.userService.getAllUsersData();
        ModelAndView m = new ModelAndView("ViewUsers");
        m.addObject("allUsers",users);
        return m;
    }

    @ExceptionHandler(UserDataException.class)
    public ModelAndView handleUserException(UserDataException exception) {
        ModelAndView modelAndView = new ModelAndView("UserError");
        modelAndView.addObject("exceptionDetails", exception.getMessage());
        return modelAndView;
    }
}
