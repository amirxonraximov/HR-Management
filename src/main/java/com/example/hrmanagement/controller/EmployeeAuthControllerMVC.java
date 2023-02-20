package com.example.hrmanagment.controller;

import com.example.hrmanagment.payload.ApiResponse;
import com.example.hrmanagment.payload.EmployeeLoginDto;
import com.example.hrmanagment.payload.EmployeeRegisterDto;
import com.example.hrmanagment.payload.SetPasswordDto;
import com.example.hrmanagment.service.EmployeeAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/employeeAuth")
public class EmployeeAuthControllerMVC {

    @Autowired
    EmployeeAuthService employeeAuthService;

    @GetMapping("/password-set")
    public String greetingForm(@RequestParam String email, Model model) {
        model.addAttribute("data", new SetPasswordDto(email, "", ""));
        return "password_set";
    }

    @PostMapping("/password-set")
    public String greetingSubmit(@ModelAttribute SetPasswordDto data, Model model) {
        if (!data.getPassword().equals(data.getConfirmPassword())) {
            model.addAttribute("message", "Passwords doesn't match");
            return "result";
        }
        if (data.getPassword().length() < 4) {
            model.addAttribute("message", "Password must be at least 4 characters long");
            return "result";
        }
        employeeAuthService.setPassword(data);
        model.addAttribute("message", "Success");
        return "result";
    }
}


