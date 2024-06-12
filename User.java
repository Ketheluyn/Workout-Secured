package com.fitness.tracker;

public class User {
    private String username;
    private String password;
    private int userAge;
    private int heightInInches;
    private int weight;
    private String gender;
    private double userBMI;

    public User (String username, String password){
        this.username = username;
        this.password = password;
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

    /**
     * This method is used in the case the user does not enter all their information in a complete setup and
     * creates just a basic account with a username and password.
     */
    public void setupUserprofile(int userAge, int heightInInches, int weight, String gender){
        this.userAge = userAge;
        this.heightInInches = heightInInches;
        this.weight = weight;
        this.gender = gender;

        this.userBMI = calculateBMI(this.heightInInches, this.weight);
    }

    private double calculateBMI(int heightInInches, int weight){
        return (double) weight / (heightInInches * heightInInches);
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
}
