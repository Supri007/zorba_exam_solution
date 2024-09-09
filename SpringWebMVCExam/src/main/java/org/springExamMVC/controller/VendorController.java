package org.springExamMVC.controller;

import org.springExamMVC.Exception.UserDataException;
import org.springExamMVC.Service.VendorService;
import org.springExamMVC.dao.IVendor;
import org.springExamMVC.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/Vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @GetMapping()
    public ModelAndView vendorForm() {
        ModelAndView modelAndView = new ModelAndView("VendorLogin");
        return modelAndView;
    }

    @PostMapping("/validateVendor")
    public String saveStudent(@ModelAttribute UserModel userModel, Model model) throws UserDataException {
        String response = this.vendorService.ValidateVendor(userModel);
        model.addAttribute("message", response);
        return "Inventory";
    }

    @ExceptionHandler(UserDataException.class)
    public ModelAndView handleUserException(UserDataException exception) {
        ModelAndView modelAndView = new ModelAndView("UserError");
        modelAndView.addObject("exceptionDetails", exception.getMessage());
        return modelAndView;
    }
}
