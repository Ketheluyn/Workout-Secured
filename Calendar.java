package com.fitness.tracker;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Calendar {
	private Map<String, Map<String, Integer>> fitnessCal; 
	private Scanner calInput;
	private static final Pattern DATE_INPUT = Pattern.compile("\\d{2}\\\\\\d{2}\\\\\\d{4}");
	
	//create hashmap for calendar storage for now
	public Calendar() {
		fitnessCal = new HashMap<>();
		calInput = new Scanner(System.in);
	}
	
	//Loop for allowing calendar input
	public void userSel() {
		boolean endInput = false;
		
		while(!endInput){
			System.out.println(" ");
			System.out.println("--------------------------");
			System.out.println("Please select from below:");
			System.out.println("Add");
			System.out.println("Remove");
			System.out.println("View");
			System.out.println("Edit");
			System.out.println("Return");
			System.out.println("--------------------------");
			System.out.println(" ");
			
			String userSelect = calInput.nextLine().toLowerCase();
			
			switch(userSelect) {
				case "add":
					addWorkout();
					break;
				case "remove":
					removeWorkout();
					break;
				case "view":
					viewWorkout();
					break;	
				case "edit":
					editWorkout();
					break;
				case "return":
					System.out.println("Returning to main menu!");
					endInput = true;
					break;
				default:
					System.out.print("Please make a valid selection!");
					break;
			
			}
		}
	}
	

	private void addWorkout() {
		// add the workout to the calendar
		System.out.println("Enter date (DD\\MM\\YYYY) for workout: ");
		String dateEntry = calInput.nextLine().trim();
		
		if(!isFormattedDate(dateEntry)) {
			System.out.println("Invalid date. Please enter as follows DD\\MM\\YYYY.");
            return;
		}
		
		Map<String, Integer> workouts = fitnessCal.getOrDefault(dateEntry, new HashMap<>());
		
		while(true) {
			System.out.println("Enter workout and rep or time in seconds, when done type exit! ");
			String workOut = calInput.nextLine().trim();
			
			if("exit".equalsIgnoreCase(workOut)) {
				break;
			}
			
			String[] dataInput = workOut.split(" ");
			if(dataInput.length >= 2) {
				StringBuilder workBuild = new StringBuilder();
				for(int i = 0; i < dataInput.length -1; i++) {
					workBuild.append(dataInput[i]).append(" ");
				}				
				
				String workInput = sanitizeWorkOut(workBuild.toString().trim());
				int amount;
				
				try {
					amount = Integer.parseUnsignedInt(dataInput[dataInput.length-1]);
				} catch (NumberFormatException e) {
					System.out.println("Invalid count format. Please enter the workout followed by the count.");
                    continue;
				}
				
				workouts.put(workInput, workouts.getOrDefault(workInput, 0) + amount);
				System.out.println("Workout and Reps/Time added!");				
				
			} else {
				System.out.println("Workout failed to be added");
				
			}
		
			
		}
		fitnessCal.put(dateEntry, workouts);
		
	}
	
	private boolean isFormattedDate(String dateEntry) {
		return DATE_INPUT.matcher(dateEntry).matches();
		
	}
	
	private String sanitizeWorkOut(String workoutString) {
        // Remove all unauthorized characters
        return workoutString.replaceAll("[^\\p{L}\\p{N}\\p{P}\\p{Z}]", "").replaceAll("\\s+", " ").trim();
    }

	private void removeWorkout() {
		// remove the workout
		System.out.println("Enter date (DD\\MM\\YYYY) for workout: ");
		String dateEntry = calInput.nextLine().trim();
		
		if(!isFormattedDate(dateEntry)) {
			System.out.println("Invalid date. Please enter as follows DD\\MM\\YYYY.");
            return;
		}
		
		Map<String, Integer> workouts = fitnessCal.get(dateEntry);
		
		if(workouts == null) {
			System.out.println("No workouts found.");
            return;
		}
		
		System.out.println("Enter workout to remove: ");
		String workInput = sanitizeWorkOut(calInput.toString().trim()); 
		
		if (workouts.containsKey(workInput)) {
            workouts.remove(workInput);
            if (workouts.isEmpty()) {
                fitnessCal.remove(dateEntry);
            }
            System.out.println("Workout removed: " + workouts);
        } else {
            System.out.println("Workout not found: " + workouts);
        }
		
	}
	
	private void viewWorkout() {
		// view the workout
		if(fitnessCal.isEmpty()) {
			System.out.println("Calendar Is Empty");
		} else {
			System.out.println("Workout Schedules");
			for (Map.Entry<String, Map<String, Integer>> workoutDate : fitnessCal.entrySet()) {
                System.out.println("Date: " + workoutDate.getKey());
                for (Map.Entry<String, Integer> workoutAction : workoutDate.getValue().entrySet()) {
                    System.out.println("Workout: " + workoutAction.getKey() + " - Amount: " + workoutAction.getValue());
			
                }
			}
		
		}
	}
	
	private void editWorkout() {
		// edit a workout
		System.out.println("Enter date (DD\\MM\\YYYY) for workout: ");
		String dateEntry = calInput.nextLine().trim();
		
		if(!isFormattedDate(dateEntry)) {
			System.out.println("Invalid date. Please enter as follows DD\\MM\\YYYY.");
            return;
		}
		
		Map<String, Integer> workouts = fitnessCal.get(dateEntry);
		
		if(workouts == null) {
			System.out.println("No workouts found.");
            return;
		}
		
		System.out.println("Select Workout to edit! ");
		String changeThis = sanitizeWorkOut(calInput.toString().trim());
		
		if(!workouts.containsKey(changeThis)) {
			System.out.println("Work out not listed!");
			return;
		}
		
		System.out.println("Enter replacement workout! ");
		String workReplace = calInput.nextLine().trim();
		String[] dataInput = workReplace.split(" ");
		if(dataInput.length >= 2) {
			StringBuilder workBuild = new StringBuilder();
			for(int i = 0; i < dataInput.length -1; i++) {
				workBuild.append(dataInput[i]).append(" ");
			}				
			
			String workInput = sanitizeWorkOut(workBuild.toString().trim());
			int amount;
			
			try {
				amount = Integer.parseUnsignedInt(dataInput[dataInput.length-1]);
			} catch (NumberFormatException e) {
				System.out.println("Invalid count format. Please enter the workout followed by the count.");
                return;
			}
			
			workouts.remove(changeThis);
			workouts.put(workInput, amount);
			
			System.out.println("Work outs have been changed and updated.");
			
		} else {
			System.out.println("Invalid Input Please Try Again! ");
			
		}
	}

	
}
