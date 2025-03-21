package com.example.passwordvalidator.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordServiceTest {

    private final PasswordService passwordService = new PasswordService();

    @Test
    public void testValidPassword() {
        assertTrue(passwordService.isPasswordValid("AbTp9!fok"));
    }

    @Test
    public void testShortPassword() {
        assertFalse(passwordService.isPasswordValid("AbTp9!fo"));
    }

    @Test
    public void testNoDigit() {
        assertFalse(passwordService.isPasswordValid("AbTp!fok"));
    }

    @Test
    public void testNoLowercase() {
        assertFalse(passwordService.isPasswordValid("ABTP9!FOK"));
    }

    @Test
    public void testNoUppercase() {
        assertFalse(passwordService.isPasswordValid("abtp9!fok"));
    }

    @Test
    public void testNoSpecialChar() {
        assertFalse(passwordService.isPasswordValid("AbTp9fok"));
    }

    @Test
    public void testRepeatedChar() {
        assertFalse(passwordService.isPasswordValid("AbTp9!foo"));
    }

    @Test
    public void testWhitespace() {
        assertFalse(passwordService.isPasswordValid("AbTp9 fok"));
    }
}