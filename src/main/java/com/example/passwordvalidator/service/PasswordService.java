package com.example.passwordvalidator.service;

import org.springframework.stereotype.Service;
import java.util.regex.Pattern;

@Service
public class PasswordService {

    public boolean isPasswordValid(String password) {
        if (password.length() < 9) {
            return false;
        }
        if (!Pattern.compile("[0-9]").matcher(password).find()) {
            return false;
        }
        if (!Pattern.compile("[a-z]").matcher(password).find()) {
            return false;
        }
        if (!Pattern.compile("[A-Z]").matcher(password).find()) {
            return false;
        }
        if (!Pattern.compile("[!@#$%^&*()\\-+]").matcher(password).find()) {
            return false;
        }
        if (password.chars().distinct().count() != password.length()) {
            return false;
        }
        if (password.contains(" ")) {
            return false;
        }
        return true;
    }
}