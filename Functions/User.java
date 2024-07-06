package com.fitness.tracker.Functions;

import java.io.*;
import java.util.Properties;

/**
 * This class is to hold the data for the user to be utilized throughout the program without having to make changes.
 *
 */
public class User {

    private String username;
    private String password;
    private int userAge;
    private int heightInInches;
    private int weight;
    private String gender;
    private double userBMI;
    private Goals goalsPlan;

    public User (String username){
        this.username = username;

        existingUserProfile(username);
    }

    public User (String username, String password, int userAge, int heightInInches,
                int weight, String gender) {
        this.username = username;
        this.password = password;
        this.userAge = userAge;
        this.heightInInches = heightInInches;
        this.weight = weight;
        this.gender = gender;

        this.userBMI = calculateBMI(this.heightInInches, this.weight);
    }

    private double calculateBMI(int heightInInches, int weight){
        return (double) weight / (heightInInches * heightInInches);
    }

    public static void writeUserToFile(User user) {
        File file = new File("users.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(user.getUsername() + " " +
                        user.getPassword() + " " +
                        user.getUserAge() + " " +
                        user.getHeightInInches() + " " +
                        user.getWeight() + " " +
                        user.getGender());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isUsernameDuplicate(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length > 0 && parts[0].equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void existingUserProfile(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 6 && parts[0].equals(username)) {
                    this.password = parts[1];
                    this.userAge = Integer.parseInt(parts[2]);
                    this.heightInInches = Integer.parseInt(parts[3]);
                    this.weight = Integer.parseInt(parts[4]);
                    this.gender = parts[5];
                    this.userBMI = calculateBMI(this.heightInInches, this.weight);
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addGoalsToPlan(){

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public int getHeightInInches() {
        return heightInInches;
    }

    public void setHeightInInches(int heightInInches) {
        this.heightInInches = heightInInches;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getUserBMI() {
        return userBMI;
    }

    public void setUserBMI(double userBMI) {
        this.userBMI = userBMI;
    }

    public Goals getGoalsPlan() {
        return goalsPlan;
    }

    public void setGoalsPlan(Goals goalsPlane) {
        this.goalsPlan = goalsPlane;
    }
}
