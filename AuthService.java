package com.fitness.tracker;

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
    public boolean login(String username, String password) {
        // Simple authentication logic (for demonstration purposes)
        return "john_doe".equals(username) && "password123".equals(password);
    }
}
