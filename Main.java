package com.fitness.tracker;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        User user = new User("john_doe", "password123");
        AuthService authService = new AuthService();
        
        if (authService.login(user.getUsername(), user.getPassword())) {
            System.out.println("Login successful!");
            //create object instance
            Calendar proCalendar = new Calendar();
            
            proCalendar.userSel();

        } else {
            System.out.println("Login failed!");
        }
    }
}
