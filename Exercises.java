package com.fitness.tracker;

import java.time.LocalDateTime;

/** {@code @Author} Carey Sunderland
 *
 * This class will be used by the user to create their own custom workouts. The constructor of the
 * class gives it flexibility of being used for distance exercises (like running or walking), repetitious
 * ones (like push-ups or pull-ups), and time based ones (like planks).
 *
 * This will be integrated into the GUI, allowing the user to select what type of exercise they are making
 * for them to log their workouts.
 */
public class Exercises {

    private String exerciseName;
    private int exerciseRepetitions;
    private double distanceTraveledInMiles;
    private LocalDateTime exerciseStart;
    private LocalDateTime exerciseEnd;

    public Exercises(String exerciseName){
        this.exerciseName = exerciseName;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public int getExerciseRepetitions() {
        return exerciseRepetitions;
    }

    public void setExerciseRepetitions(int exerciseRepetitions) {
        this.exerciseRepetitions = exerciseRepetitions;
    }

    public double getDistanceTraveledInMiles() {
        return distanceTraveledInMiles;
    }

    public void setDistanceTraveledInMiles(double distanceTraveledInMiles) {
        this.distanceTraveledInMiles = distanceTraveledInMiles;
    }

    public LocalDateTime getExerciseStart() {
        return exerciseStart;
    }

    public void setExerciseStart(LocalDateTime exerciseStart) {
        this.exerciseStart = exerciseStart;
    }

    public LocalDateTime getExerciseEnd() {
        return exerciseEnd;
    }

    public void setExerciseEnd(LocalDateTime exerciseEnd) {
        this.exerciseEnd = exerciseEnd;
    }





}
