package com.fitness.tracker.Tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.fitness.tracker.Functions.AuthService;
import org.junit.jupiter.api.Test;

public class AuthServiceTest {
    @Test
    public void testLoginSuccess() {
        AuthService authService = new AuthService();
        assertTrue(authService.login("john_doe", "password123"));
    }

    @Test
    public void testLoginFailure() {
        AuthService authService = new AuthService();
        assertFalse(authService.login("john_doe", "wrongpassword"));
    }
}
