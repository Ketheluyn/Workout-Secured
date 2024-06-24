package com.fitness.tracker;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel; 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalendarGUI extends JFrame {

	private JTable workoutCalendar;
	private DefaultTableModel wTable;
	
	public CalendarGUI() {
		setTitle("Personal Workout Tracker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
				int weekrow = workoutCalendar.getSelectedRow();
				
				//select row
				if(weekrow != -1) {
					String workoutData = (String) wTable.getValueAt(weekrow, 1);
					//TODO: NEED TO ADD DATABASE HERE IF USING
					saveWorkout(weekrow, workoutData);
					
				}
				
			}
			
		});
		
		
		//Configure edit button
		JButton editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent s) {
				int weekrow = workoutCalendar.getSelectedRow();
				
				//select row
				if(weekrow != -1) {
					String workoutData = (String) wTable.getValueAt(weekrow, 1);
					//TODO: NEED TO ADD DATABASE HERE IF USING
					editWorkout(weekrow, workoutData);
					
				}
				
			}
			
		});
		
		//Configure add button
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent s) {
				int weekrow = workoutCalendar.getSelectedRow();
				
				//select row
				if(weekrow != -1) {
					String workoutData = (String) wTable.getValueAt(weekrow, 1);
					//TODO: NEED TO ADD DATABASE HERE IF USING
					addWorkout(weekrow, workoutData);
					
				}
				
			}
			
		});
		
		//Configure clear button
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent s) {
				int weekrow = workoutCalendar.getSelectedRow();
				
				//select row
				if(weekrow != -1) {
					String workoutData = (String) wTable.getValueAt(weekrow, 1);
					//TODO: NEED TO ADD DATABASE HERE IF USING
					clearWorkout(weekrow, workoutData);
					
				}
				
			}
			
		});
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(addButton);
		buttonPanel.add(editButton);
		buttonPanel.add(clearButton);
		buttonPanel.add(saveButton);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		pack();
		
		setLocationRelativeTo(null);
		
		
	}
	
	public DefaultTableModel getWorkoutCalendar() {
		return wTable;
		
	}
	
	public void setWrokoutCalendar(DefaultTableModel wTable) {
		this.wTable = wTable;
		
	}

	public void clearWorkout(int weekrow, String workoutData) {
		// TODO Add clearing
		
	}

	public void addWorkout(int weekrow, String workoutData) {
		// TODO Set up add workout
		
	}

	public void editWorkout(int weekrow, String workoutData) {
		// TODO set up edit workout
		
	}

	public void saveWorkout(int weekrow, String workoutData) {
		// TODO set up save method here 
		wTable.setValueAt(workoutData, weekrow, 1);
		//Toast Message to show completion
		JOptionPane.showMessageDialog(this,
				"Workout saved for day " + (workoutData + 1) + ":" + workoutData, ". ",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	
	
}
