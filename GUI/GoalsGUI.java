package com.fitness.tracker.GUI;

import com.fitness.tracker.Functions.Goals;
import com.fitness.tracker.Functions.User;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Properties;

public class GoalsGUI extends JFrame {

    private User user;
    private Goals goals;
    private String username;
    private JTextField usernameField;
    private JTextField calorieField;
    private JTextField proteinField;
    private JTextField carbohydrateField;
    private JTextField fatsField;
    private JTextField sugarField;
    private JTextField caffeineField;
    private JTextField defaultCalorieMaintenanceField;
    private boolean isEditable = false;

    public GoalsGUI(User user) {

        this.user = user;
        this.goals = new Goals(user);
        this.username = user.getUsername();

        setTitle("Set Goals");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        Font labelFont = new Font("Arial", Font.PLAIN, 18);
        Font fieldFont = new Font("Arial", Font.PLAIN, 18);
        Dimension fieldSize = new Dimension(200, 40);

        JLabel goalsHeaderLabel = new JLabel("Set Your Goals");
        goalsHeaderLabel.setForeground(Color.BLUE);
        goalsHeaderLabel.setFont(labelFont);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(goalsHeaderLabel, gbc);

        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(labelFont);
        add(usernameLabel, gbc);
        gbc.gridx = 1;
        usernameField = new JTextField(username);
        usernameField.setPreferredSize(fieldSize);
        usernameField.setFont(fieldFont);
        usernameField.setEditable(false);
        add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel calorieLabel = new JLabel("Calories:");
        calorieLabel.setFont(labelFont);
        add(calorieLabel, gbc);
        gbc.gridx = 1;
        calorieField = new JTextField();
        calorieField.setPreferredSize(fieldSize);
        calorieField.setFont(fieldFont);
        calorieField.setEditable(false);
        add(calorieField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel proteinLabel = new JLabel("Protein:");
        proteinLabel.setFont(labelFont);
        add(proteinLabel, gbc);
        gbc.gridx = 1;
        proteinField = new JTextField();
        proteinField.setPreferredSize(fieldSize);
        proteinField.setFont(fieldFont);
        proteinField.setEditable(false);
        add(proteinField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel carbohydrateLabel = new JLabel("Carbohydrates:");
        carbohydrateLabel.setFont(labelFont);
        add(carbohydrateLabel, gbc);
        gbc.gridx = 1;
        carbohydrateField = new JTextField();
        carbohydrateField.setPreferredSize(fieldSize);
        carbohydrateField.setFont(fieldFont);
        carbohydrateField.setEditable(false);
        add(carbohydrateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel fatsLabel = new JLabel("Fats:");
        fatsLabel.setFont(labelFont);
        add(fatsLabel, gbc);
        gbc.gridx = 1;
        fatsField = new JTextField();
        fatsField.setPreferredSize(fieldSize);
        fatsField.setFont(fieldFont);
        fatsField.setEditable(false);
        add(fatsField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        JLabel sugarLabel = new JLabel("Sugar:");
        sugarLabel.setFont(labelFont);
        add(sugarLabel, gbc);
        gbc.gridx = 1;
        sugarField = new JTextField();
        sugarField.setPreferredSize(fieldSize);
        sugarField.setFont(fieldFont);
        sugarField.setEditable(false);
        add(sugarField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        JLabel caffeineLabel = new JLabel("Caffeine:");
        caffeineLabel.setFont(labelFont);
        add(caffeineLabel, gbc);
        gbc.gridx = 1;
        caffeineField = new JTextField();
        caffeineField.setPreferredSize(fieldSize);
        caffeineField.setFont(fieldFont);
        caffeineField.setEditable(false);
        add(caffeineField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        JLabel defaultCalorieMaintenanceLabel = new JLabel("Calorie Maintenance:");
        defaultCalorieMaintenanceLabel.setFont(labelFont);
        add(defaultCalorieMaintenanceLabel, gbc);
        gbc.gridx = 1;
        defaultCalorieMaintenanceField = new JTextField(String.valueOf(goals.getDefaultCalorieMaintenance()));
        defaultCalorieMaintenanceField.setPreferredSize(fieldSize);
        defaultCalorieMaintenanceField.setFont(fieldFont);
        defaultCalorieMaintenanceField.setEditable(false);
        add(defaultCalorieMaintenanceField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        JButton toggleEditButton = new JButton("Edit");
        toggleEditButton.setFont(new Font("Arial", Font.BOLD, 18));
        toggleEditButton.setPreferredSize(new Dimension(200, 40));
        add(toggleEditButton, gbc);

        toggleEditButton.addActionListener(e -> toggleEditMode(toggleEditButton));

        loadGoals();
        pack();
    }

    private void toggleEditMode(JButton toggleEditButton) {
        isEditable = !isEditable;
        calorieField.setEditable(isEditable);
        proteinField.setEditable(isEditable);
        carbohydrateField.setEditable(isEditable);
        fatsField.setEditable(isEditable);
        sugarField.setEditable(isEditable);
        caffeineField.setEditable(isEditable);

        if (isEditable) {
            toggleEditButton.setText("Save");
        } else {
            toggleEditButton.setText("Edit");
            saveGoals();
        }
    }

    private void saveGoals() {

        Properties properties = new Properties();
        properties.setProperty("username", usernameField.getText());
        properties.setProperty("calories", calorieField.getText());
        properties.setProperty("protein", proteinField.getText());
        properties.setProperty("carbohydrates", carbohydrateField.getText());
        properties.setProperty("fats", fatsField.getText());
        properties.setProperty("sugar", sugarField.getText());
        properties.setProperty("caffeine", caffeineField.getText());
        properties.setProperty("defaultCalorieMaintenance", defaultCalorieMaintenanceField.getText());

        try (OutputStream output = new FileOutputStream(username + "_goals.properties")) {
            properties.store(output, null);
            JOptionPane.showMessageDialog(this, "Goals saved successfully for " + username);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    private void loadGoals() {

        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error loading username, please restart program.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Properties properties = new Properties();
        try (InputStream input = new FileInputStream(username + "_goals.properties")) {
            properties.load(input);
            calorieField.setText(properties.getProperty("calories", ""));
            proteinField.setText(properties.getProperty("protein", ""));
            carbohydrateField.setText(properties.getProperty("carbohydrates", ""));
            fatsField.setText(properties.getProperty("fats", ""));
            sugarField.setText(properties.getProperty("sugar", ""));
            caffeineField.setText(properties.getProperty("caffeine", ""));
            JOptionPane.showMessageDialog(this, "Goals loaded for " + username);
        } catch (IOException io) {
            JOptionPane.showMessageDialog(this, "No goals found for " + username, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
