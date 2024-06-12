package com.fitness.tracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GoalsTest {

    private User user;
    private Goals goals;

    @BeforeEach
    void setUp() {
        user = new User("john_doe", "password123");
        user.setWeight(180); // in pounds
        user.setHeightInInches(70); // in inches
        user.setUserAge(30); // in years
        user.setGender("male");
        goals = new Goals(user);
    }

    @Test
    void testCalculateDefaultCalorieMaintenance() {
        double expectedCalorieMaintenance = (10 * (180 / 2.204623)) + (6.25 * (70 * 2.54)) - (5 * 30) + 5;
        assertEquals(expectedCalorieMaintenance, goals.getDefaultCalorieMaintenance(), 0.01);
    }

    @Test
    void testSetAndGetUser() {
        User newUser = new User("jane_doe", "password456");
        goals.setUser(newUser);
        assertEquals(newUser, goals.getUser());
    }

    @Test
    void testSetAndGetCalories() {
        goals.setCalories(2000);
        assertEquals(2000, goals.getCalories());
    }

    @Test
    void testSetAndGetProteins() {
        goals.setProteins(150);
        assertEquals(150, goals.getProteins());
    }

    @Test
    void testSetAndGetCarbohydrates() {
        goals.setCarbohydrates(300);
        assertEquals(300, goals.getCarbohydrates());
    }

    @Test
    void testSetAndGetFats() {
        goals.setFats(70);
        assertEquals(70, goals.getFats());
    }

    @Test
    void testSetAndGetSugar() {
        goals.setSugar(50);
        assertEquals(50, goals.getSugar());
    }

    @Test
    void testSetAndGetCaffeine() {
        goals.setCaffeine(100);
        assertEquals(100, goals.getCaffeine());
    }

    @Test
    void testSetAndGetDefaultCalorieMaintenance() {
        goals.setDefaultCalorieMaintenance(2500.0);
        assertEquals(2500.0, goals.getDefaultCalorieMaintenance());
    }

    @Test
    void testConstructorInitialization() {
        assertNotNull(goals.getUser());
        assertEquals(user, goals.getUser());
        assertEquals(goals.calculateDefaultCalorieMaintenance(user.getWeight(), user.getHeightInInches(),
                user.getUserAge(), user.getGender()), goals.getDefaultCalorieMaintenance());
    }
}
