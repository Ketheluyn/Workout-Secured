package com.fitness.tracker;

public class Goals {

    private User user;
    private int calories;
    private int proteins;
    private int carbohydrates;
    private int fats;
    private int sugar;
    private int caffeine;
    private double defaultCalorieMaintenance;

    public Goals (User user){
        this.user = user;
        this.defaultCalorieMaintenance = calculateDefaultCalorieMaintenance(user.getWeight(),
                user.getHeightInInches(), user.getUserAge(), user.getGender());
    }

    private double calculateDefaultCalorieMaintenance(int userWeightInPounds, int userHeightInInches,
                                                      int userAge, String userGender){

        double userWeightInKGS = (userWeightInPounds / 2.204623);
        double userHeightInCMS = (userHeightInInches * 2.54);

        int genderConstant;

        if (userGender.equals("male")){
            genderConstant = 5;
        } else {
            genderConstant = -161;
        }

        return (10 * userWeightInKGS) + (6.25 * userHeightInCMS) - (5 * userAge) + genderConstant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getCaffeine() {
        return caffeine;
    }

    public void setCaffeine(int caffeine) {
        this.caffeine = caffeine;
    }

    public double getDefaultCalorieMaintenance() {
        return defaultCalorieMaintenance;
    }

    public void setDefaultCalorieMaintenance(double defaultCalorieMaintenance) {
        this.defaultCalorieMaintenance = defaultCalorieMaintenance;
    }
}
