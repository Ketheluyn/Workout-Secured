package com.fitness.tracker.Tests;

import com.fitness.tracker.Functions.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("john_doe", "password123");
        user.setUserAge(30);
        user.setHeightInInches(70);
        user.setWeight(180);
        user.setGender("male");
        user.setUserBMI(25.8);
    }

    @AfterEach
    void tearDown() {
        user = null;
    }

    @Test
    void setupUserprofile() {
        User newUser = new User("jane_doe", "password456");
        assertNotNull(newUser);
        assertEquals("jane_doe", newUser.getUsername());
        assertEquals("password456", newUser.getPassword());
    }

    @Test
    void getUsername() {
        assertEquals("john_doe", user.getUsername());
    }

    @Test
    void getPassword() {
        assertEquals("password123", user.getPassword());
    }

    @Test
    void setUsername() {
        user.setUsername("new_username");
        assertEquals("new_username", user.getUsername());
    }

    @Test
    void setPassword() {
        user.setPassword("new_password");
        assertEquals("new_password", user.getPassword());
    }

    @Test
    void getUserAge() {
        assertEquals(30, user.getUserAge());
    }

    @Test
    void setUserAge() {
        user.setUserAge(25);
        assertEquals(25, user.getUserAge());
    }

    @Test
    void getHeightInInches() {
        assertEquals(70, user.getHeightInInches());
    }

    @Test
    void setHeightInInches() {
        user.setHeightInInches(65);
        assertEquals(65, user.getHeightInInches());
    }

    @Test
    void getWeight() {
        assertEquals(180, user.getWeight());
    }

    @Test
    void setWeight() {
        user.setWeight(170);
        assertEquals(170, user.getWeight());
    }

    @Test
    void getGender() {
        assertEquals("male", user.getGender());
    }

    @Test
    void setGender() {
        user.setGender("female");
        assertEquals("female", user.getGender());
    }

    @Test
    void getUserBMI() {
        assertEquals(25.8, user.getUserBMI(), 0.01);
    }

    @Test
    void setUserBMI() {
        user.setUserBMI(22.5);
        assertEquals(22.5, user.getUserBMI(), 0.01);
    }
}
