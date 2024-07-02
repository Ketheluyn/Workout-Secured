package com.fitness.tracker.Tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import com.fitness.tracker.Functions.AuthService;
import org.junit.Test;

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
