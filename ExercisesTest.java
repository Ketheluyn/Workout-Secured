package com.fitness.tracker;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ExercisesTest {

    private Exercises exercises;

    @BeforeEach
    void setUp() {
        exercises = new Exercises("Running");
        exercises.setExerciseRepetitions(10);
        exercises.setDistanceTraveledInMiles(5.0);
        exercises.setExerciseStart(LocalDateTime.of(2023, 6, 11, 6, 0));
        exercises.setExerciseEnd(LocalDateTime.of(2023, 6, 11, 7, 0));
    }

    @AfterEach
    void tearDown() {
        exercises = null;
    }

    @Test
    void getExerciseName() {
        assertEquals("Running", exercises.getExerciseName());
    }

    @Test
    void setExerciseName() {
        exercises.setExerciseName("Swimming");
        assertEquals("Swimming", exercises.getExerciseName());
    }

    @Test
    void getExerciseRepetitions() {
        assertEquals(10, exercises.getExerciseRepetitions());
    }

    @Test
    void setExerciseRepetitions() {
        exercises.setExerciseRepetitions(15);
        assertEquals(15, exercises.getExerciseRepetitions());
    }

    @Test
    void getDistanceTraveledInMiles() {
        assertEquals(5.0, exercises.getDistanceTraveledInMiles());
    }

    @Test
    void setDistanceTraveledInMiles() {
        exercises.setDistanceTraveledInMiles(7.5);
        assertEquals(7.5, exercises.getDistanceTraveledInMiles());
    }

    @Test
    void getExerciseStart() {
        assertEquals(LocalDateTime.of(2023, 6, 11, 6, 0), exercises.getExerciseStart());
    }

    @Test
    void setExerciseStart() {
        LocalDateTime newStart = LocalDateTime.of(2023, 6, 11, 5, 0);
        exercises.setExerciseStart(newStart);
        assertEquals(newStart, exercises.getExerciseStart());
    }

    @Test
    void getExerciseEnd() {
        assertEquals(LocalDateTime.of(2023, 6, 11, 7, 0), exercises.getExerciseEnd());
    }

    @Test
    void setExerciseEnd() {
        LocalDateTime newEnd = LocalDateTime.of(2023, 6, 11, 8, 0);
        exercises.setExerciseEnd(newEnd);
        assertEquals(newEnd, exercises.getExerciseEnd());
    }
}