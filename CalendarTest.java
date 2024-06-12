package com.fitness.tracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CalendarTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final InputStream originalIn = System.in;
    private Calendar calendar;

    @BeforeEach
    public void setUp() {
        // Injecting custom input stream for testing
        String userInput = "12\\12\\2020\npushup 20\nsitup 30\nexit\n";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        calendar = new Calendar(inputStream);
    }
    
    @Test
    public void testNotNull() {
        Calendar proCalendar = new Calendar();
        Map<String, Map<String, Integer>> fitnessCal = proCalendar.getFitnessCal();
        assertNotNull(fitnessCal);
        
    }

    @Test
    public void testAddWorkout() {
        // Invoke addWorkout method
        calendar.addWorkout();

        // Check if workout was added to the calendar
        Map<String, Map<String, Integer>> fitnessCal = calendar.getFitnessCal();
        assertTrue(fitnessCal.containsKey("12\\12\\2020"));
        assertEquals(2, fitnessCal.get("12\\12\\2020").size());
        assertTrue(fitnessCal.get("12\\12\\2020").containsKey("pushup"));
        assertTrue(fitnessCal.get("12\\12\\2020").containsKey("situp"));
        assertEquals(20, fitnessCal.get("12\\12\\2020").get("pushup"));
        assertEquals(30, fitnessCal.get("12\\12\\2020").get("situp"));
    }
    
    
  /*  @Test
    public void testRemoveWorkout() {
    	// Prepare input for the test
        String dateInput = "12\\12\\2020\n";
        String workoutToRemove = "pushup\n";

        // Combine the inputs
        String userInput = dateInput + workoutToRemove;

        // Redirect system input and output streams for testing
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        // Prepare test data
        Calendar proCalendar = new Calendar();
        Map<String, Map<String, Integer>> fitnessCal = new HashMap<>();
        Map<String, Integer> workouts = new HashMap<>();
        workouts.put("pushup", 20); // Add a workout for testing
        fitnessCal.put("12\\12\\2020", workouts); // Add a workout date for testing
        proCalendar.setFitnessCal(fitnessCal);

        // Call the method to be tested
        proCalendar.removeWorkout();

        // Restore original system input stream
        System.setIn(originalIn);

        // Perform assertions
        String actualOutput = outContent.toString().trim();

        // Assertions based on actual output
        System.out.println("Actual output " + actualOutput);
        assertTrue(actualOutput.contains("Enter date (DD\\MM\\YYYY) for workout: "));
        assertTrue(actualOutput.contains("Enter workout to remove: "));
        assertTrue(actualOutput.contains("Workout removed")); 
        assertFalse(proCalendar.getFitnessCal().get("12\\12\\2020").containsKey("pushup")); // Check if the workout is removed from fitnessCal

        // Clean up the fitnessCal for other tests
        proCalendar.getFitnessCal().clear();
    }
    */
    
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        calendar = new Calendar();
    }
    
    @Test
    public void testEditWorkout() {
        // Prepare input for the test
        String dateInput = "12\\12\\2020\n";
        String changeThis = "pushup\n";
        String workReplace = "situp 30\n";

        // Combine the inputs
        String userInput = dateInput + changeThis + workReplace;

        // Redirect system input stream for testing
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        // Prepare test data
        calendar.editWorkout();

        // Restore original system input stream
        System.setIn(originalIn);

        // Perform assertions
        String actualOutput = outContent.toString().trim();
        System.out.println("Actual Output:\n" + actualOutput); // Debugging: Print actual output to check its content

        // Assertions based on actual output
        assertTrue(actualOutput.contains("Enter date (DD\\MM\\YYYY) for workout:"));
        assertTrue(actualOutput.contains("Select Workout to edit!"));
        assertTrue(actualOutput.contains("Enter replacement workout!"));
        assertTrue(actualOutput.contains("Work outs have been changed and updated."));

        // Verify that the workout has been updated
        assertNotNull(calendar.getFitnessCal().get("12\\12\\2020").get("situp"));
        assertEquals(30, calendar.getFitnessCal().get("12\\12\\2020").get("situp"));
        assertNull(calendar.getFitnessCal().get("12\\12\\2020").get("pushup"));
    }

    @Test
    public void testEditWorkout_InvalidDate() {
        // Prepare input for the test with an invalid date
        String dateInput = "31\\02\\2020\n";

        // Redirect system input stream for testing
        System.setIn(new ByteArrayInputStream(dateInput.getBytes()));

        // Call the method to be tested
        calendar.editWorkout();

        // Restore original system input stream
        System.setIn(originalIn);

        // Perform assertions
        String actualOutput = outContent.toString().trim();
        System.out.println("Actual Output:\n" + actualOutput); // Debugging: Print actual output to check its content

        // Assertions based on actual output
        assertTrue(actualOutput.contains("Invalid date. Please enter as follows DD\\MM\\YYYY."));
        assertFalse(actualOutput.contains("Select Workout to edit!"));
        assertFalse(actualOutput.contains("Enter replacement workout!"));
        assertFalse(actualOutput.contains("Work outs have been changed and updated."));
    }

    // Add more test methods to cover other scenarios if needed

    @Test
    public void tearDownStreams() {
        // Restore original System.out
        System.setOut(originalOut);
    }
    
    
}