package com.fitness.tracker.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel; 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalendarGUI extends JPanel {

	private JTable workoutCalendar;
	private DefaultTableModel wTable;
	
	public CalendarGUI() {
		
		setLayout(new BorderLayout());		
		//Initialize workout calendar 
		wTable = new DefaultTableModel(new Object[]{"Day", "Data"}, 0);
		
		for(int i = 1; i <= 31; i++) {
			wTable.addRow(new Object[]{i, ""});
		}
		
		workoutCalendar = new JTable(wTable);
		JScrollPane scrollPane = new JScrollPane(workoutCalendar);
		
		//Configure save button
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent s) {
				saveWorkout();
				
			}
			
		});
		
		
		//Configure edit button
		JButton editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					editWorkout();
					
				}
				
			});
		
		//Configure add button
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				addWorkout();
				
			}
			
		});
		
		//Configure clear button
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent s) {
				clearWorkout();
				
			}
			
		});
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(addButton);
		buttonPanel.add(editButton);
		buttonPanel.add(clearButton);
		buttonPanel.add(saveButton);
		
		add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
		
	}
	
	public DefaultTableModel getWorkoutCalendar() {
		return wTable;
		
	}
	
	public void setWrokoutCalendar(DefaultTableModel wTable) {
		this.wTable = wTable;
		
	}

	public void clearWorkout() {
		// TODO Add clearing
		int weekrow = workoutCalendar.getSelectedRow();
		
		//select row
		if(weekrow != -1) {
			wTable.setValueAt("", weekrow, 1);
					
		}
	}

	public void addWorkout() {
		int weekrow = workoutCalendar.getSelectedRow();
		
		//select row
		if(weekrow != -1) {
			String workoutData = JOptionPane.showInputDialog(this, "Enter workout " + (weekrow + 1));
			if(workoutData != null) {
				wTable.setValueAt(workoutData, weekrow, 1);
			}
		}
	}

	public void editWorkout() {
		// TODO set up edit workout
		int weekrow = workoutCalendar.getSelectedRow();
		
		if(weekrow != -1) {
			String savedWorkout = (String) wTable.getValueAt(weekrow, 1);
			String editMade = JOptionPane.showInputDialog(this, "Edit workout " + (weekrow + 1), savedWorkout);
			
			if(editMade != null) {
				wTable.setValueAt(editMade, weekrow, 1);
	
			}
			
		}
				
	}

	public void saveWorkout() {
		StringBuilder toastM = new StringBuilder();
		
		for(int i = 0; i < wTable.getRowCount(); i++) {
			int day = (int) wTable.getValueAt(i,0);
			String workoutInput = (String) wTable.getValueAt(i,1); 
			// TODO set up save to database when available
			toastM.append("Day ").append(day).append(": ").append(workoutInput).append("\n");
		}
		//Toast Message to show completion
		JOptionPane.showMessageDialog(this,
				toastM.toString(), "Workout Saved",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	 // Method to start the application
    public void startApp() {
        setVisible(true);
    }
	
	
}
