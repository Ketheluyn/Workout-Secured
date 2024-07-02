package com.fitness.tracker;

import com.fitness.tracker.GUI.WorkoutLogin;

import javax.swing.SwingUtilities;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			WorkoutLogin loginW = new WorkoutLogin();
			loginW.setVisible(true);
		});
		
	}
	
}