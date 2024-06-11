package com.fitness.tracker;

public class User {
    private String username;
    private String password;
    private int userAge;
    private int heightInInches;
    private int weight;
    private String gender;
    private double userBMI;

    public User(String username, String password, int userAge, int heightInInches,
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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getUserAge() { return userAge; }

    public int getHeightInInches() { return heightInInches; }

    public int getWeight () { return weight; }

    public String getGender() { return gender; }

    public double getUserBMI() { return userBMI; }


}
