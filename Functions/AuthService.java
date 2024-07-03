package com.fitness.tracker.Functions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * AuthService provides basic authentication functionalities.
 */
public class AuthService {
    /**
     * Validates user login.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @return True if the login is successful, otherwise false.
     */
    public static boolean login(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length > 1 && parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


}
