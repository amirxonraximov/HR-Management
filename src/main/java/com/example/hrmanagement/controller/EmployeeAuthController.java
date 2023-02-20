package com.example.hrmanagment.controller;

import com.example.hrmanagment.payload.*;
import com.example.hrmanagment.service.EmployeeAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employeeAuth")
public class EmployeeAuthController {

    @Autowired
    EmployeeAuthService employeeAuthService;

    @PostMapping("/register")
    public HttpEntity<?> registerEmployee(@RequestBody EmployeeRegisterDto employeeRegisterDto) {

        ApiResponse apiResponse = employeeAuthService.registerEmployee(employeeRegisterDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);

    }

    @PostMapping("/login")
    public HttpEntity<?> loginManager(@RequestBody EmployeeLoginDto employeeLoginDto) {
        ApiResponse apiResponse = employeeAuthService.login(employeeLoginDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 401).body(apiResponse);
    }
}


