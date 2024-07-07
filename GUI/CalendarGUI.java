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
import java.io.*;
import java.util.Calendar;

public class CalendarGUI extends JPanel {

	private JTable workoutCalendar;
	private DefaultTableModel wTable;

	private final User currentUser = AuthService.getCurrentUser();

	private JComboBox<String> monthWorkoutBox;
	private final String[] months = {"January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December"};

	
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
				saveWorkout(currentUser.getUsername());
				
			}
			
		});

		//Configure save button
		JButton loadButton = new JButton("Load");
		loadButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent s) {
				loadWorkout(currentUser.getUsername());
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
		buttonPanel.add(loadButton);
		buttonPanel.add(saveButton);

		buttonPanel.add(userInfoButton);
		buttonPanel.add(goalsGUIButton);
		


		add(monthWorkoutBox, BorderLayout.NORTH);

		add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

		//Open with first month
		updateTableMonth(Calendar.getInstance().get(Calendar.MONTH));
	}

	private void updateTableMonth(int month) {
		int daysInMonth = getDaysInMonth(month);

		// Update existing rows or add new rows as needed
		DefaultTableModel model = (DefaultTableModel) workoutCalendar.getModel();

		model.setRowCount(daysInMonth);

		for (int i = 0; i < daysInMonth; i++) {
			model.setValueAt(i + 1, i, 0); // Day number
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

	public void loadWorkout(String userName) {
		String selectMonth = (String) JOptionPane.showInputDialog(this, "Select Month to Load: ",
				"Load Workout", JOptionPane.QUESTION_MESSAGE, null, months, months[0]);

		if(selectMonth == null) {
			return;
		}

		File inputWorkout = new File("user_workoutdata", "workout_data_" + userName + "_month_" +
				selectMonth + ".csv");

		if (!inputWorkout.exists()) {
			JOptionPane.showMessageDialog(this, "No data found for " + selectMonth, "Load Error",
					JOptionPane.ERROR_MESSAGE);
		}

		try(BufferedReader reader = new BufferedReader(new FileReader(inputWorkout))) {
			DefaultTableModel model = (DefaultTableModel) workoutCalendar.getModel();
			model.setRowCount(0);

			String line;
			while((line = reader.readLine()) != null) {
				String[] parts = line.split(",", -1);
				if (parts.length == 3) {
					int day = Integer.parseInt(parts[1].trim());
					String workoutInput = parts[2].trim();

					wTable.addRow(new Object[]{day, workoutInput});


					System.out.println("Line: " + day + " printed");
				}
			}

			model.fireTableDataChanged();
			monthWorkoutBox.setSelectedItem(selectMonth);

			JOptionPane.showMessageDialog(this, "Workout data loaded for " + selectMonth,
					"Workout Loaded", JOptionPane.INFORMATION_MESSAGE);

		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Workout data failed to load" +
					e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Error parsing workout data: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
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

	public void saveWorkout(String userName) {
		int selectedMonth = monthWorkoutBox.getSelectedIndex();
		String selectedMonthName = months[selectedMonth];

		File userSave = new File("user_workoutdata");
		if(!userSave.exists()) {
			userSave.mkdirs();

		}

		//set file name based on user and month
		File outputWorkouts = new File(userSave, "workout_data_" + userName + "_month_" +
				selectedMonthName + ".csv");


		//Write to file
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputWorkouts))) {
			for(int i = 0; i < wTable.getRowCount(); i++) {
				int day = (int) wTable.getValueAt(i, 0);
				String workoutInput = (String) wTable.getValueAt(i, 1);

				writer.write(selectedMonthName + "," + day + "," + workoutInput);
				writer.newLine();

			}
			JOptionPane.showMessageDialog(this, "Workout data saved to: " + outputWorkouts.getAbsolutePath(),
					"Workout Saved", JOptionPane.INFORMATION_MESSAGE);

		} catch(IOException e) {
			JOptionPane.showMessageDialog(this, "Error saving data: " + e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);

		}


	}
	
	 // Method to start the application
    public void startApp() {
        setVisible(true);
    }
	
	
}
