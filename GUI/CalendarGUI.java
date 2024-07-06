package com.fitness.tracker.GUI;

import com.fitness.tracker.Functions.AuthService;
import com.fitness.tracker.Functions.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Calendar;

public class CalendarGUI extends JPanel {

	private JTable workoutCalendar;
	private DefaultTableModel wTable;
<<<<<<< Updated upstream
	private final User currentUser = AuthService.getCurrentUser();
=======
	private JComboBox<String> monthWorkoutBox;
	private final String[] months = {"January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December"};
>>>>>>> Stashed changes
	
	public CalendarGUI() {
		
		setLayout(new BorderLayout());

		//Initialize combobox
		monthWorkoutBox = new JComboBox<>(months);
		monthWorkoutBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateTableMonth(monthWorkoutBox.getSelectedIndex());
			}
		});

		//Initialize workout calendar 
		wTable = new DefaultTableModel(new Object[]{"Day", "Workout Information"}, 0);


		workoutCalendar = new JTable(wTable);
		// Set margins using an empty border
		workoutCalendar.setBorder(new EmptyBorder(10, 10, 10, 10));

		//sets day column to a smaller size
		workoutCalendar.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		TableColumn dayReadjust = workoutCalendar.getColumnModel().getColumn(0);
		dayReadjust.setPreferredWidth(50);
		dayReadjust.setResizable(false);

		TableColumn woReadjust = workoutCalendar.getColumnModel().getColumn(1);
		woReadjust.setResizable(true);
		woReadjust.setPreferredWidth(900); // Initial width (adjust as needed)
		woReadjust.setMinWidth(100);

		JScrollPane scrollPane = new JScrollPane(workoutCalendar);
		scrollPane.setBorder(new EmptyBorder(10,10,10,10));
		
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

		JButton userInfoButton = new JButton("User Info");
		userInfoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentUser != null) {
					UserInfoDialog userInfoDialog = new UserInfoDialog(CalendarGUI.this, currentUser);
					userInfoDialog.setVisible(true);
					userInfoDialog.setAutoRequestFocus(true);
				} else {
					JOptionPane.showMessageDialog(null, "No user logged in.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JButton goalsGUIButton = new JButton("Goals");
		goalsGUIButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GoalsGUI goalsGUI = new GoalsGUI(currentUser);
				goalsGUI.setVisible(true);
			}
		});
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(addButton);
		buttonPanel.add(editButton);
		buttonPanel.add(clearButton);
		buttonPanel.add(saveButton);
<<<<<<< Updated upstream
		buttonPanel.add(userInfoButton);
		buttonPanel.add(goalsGUIButton);
		
=======

		add(monthWorkoutBox, BorderLayout.NORTH);
>>>>>>> Stashed changes
		add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

		//Open with first month
		updateTableMonth(Calendar.getInstance().get(Calendar.MONTH));
	}

	private void updateTableMonth(int month) {
		wTable.setRowCount(0);
		int daysInMonth = getDaysInMonth(month);

		for(int i = 1; i <= getDaysInMonth(month); i++) {
			wTable.addRow(new Object[]{i, ""});
		}

	}

	private int getDaysInMonth(int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, month);

		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	public DefaultTableModel getWorkoutCalendar() {
		return wTable;
		
	}
	
	public void setWorkoutCalendar(DefaultTableModel wTable) {
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
