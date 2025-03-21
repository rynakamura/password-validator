package com.example.passwordvalidator.controller;

import com.example.passwordvalidator.model.PasswordRequest;
import com.example.passwordvalidator.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/password")
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @PostMapping("/validate")
    public boolean validatePassword(@RequestBody PasswordRequest passwordRequest) {
        return passwordService.isPasswordValid(passwordRequest.getPassword());
    }
}