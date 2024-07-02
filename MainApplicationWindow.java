package com.fitness.tracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApplicationWindow extends JFrame {
	private CalendarGUI proCalendar = new CalendarGUI();
	
	public MainApplicationWindow() {
		//set up main application window
		setTitle("Workout Secured");
		setSize(1000, 800);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create Button to return to main
		JButton exitBtn = new JButton("Exit");
		exitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					exitWindow();
					
				}
				
			});
		
		add(proCalendar, BorderLayout.CENTER);
		add(exitBtn, BorderLayout.SOUTH);
		
	}
	
	public void exitWindow() {
		// Display a confirmation dialog
        int option = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to exit?",
                "Confirm Exit", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            // Dispose of the main window
            dispose();

            // Open the login window
            SwingUtilities.invokeLater(() -> {
                WorkoutLogin loginW = new WorkoutLogin();
                loginW.setVisible(true);
            });
		
        }
	
	
	}
}
