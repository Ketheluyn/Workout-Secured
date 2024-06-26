package com.fitness.tracker;

public class Main {
    public static void main(String[] args) {
        User user = new User("john_doe", "password123");
        AuthService authService = new AuthService();
        
        if (authService.login(user.getUsername(), user.getPassword())) {
            System.out.println("Login successful!");
            //create object instance
            CalendarGUI proCalendar = new CalendarGUI();
            
            proCalendar.startApp();

        } else {
            System.out.println("Login failed!");
        }
    }
}
