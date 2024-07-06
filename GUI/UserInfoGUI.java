package com.fitness.tracker.GUI;

import com.fitness.tracker.Functions.User;

import javax.swing.*;
import java.awt.*;

public class UserInfoGUI extends JFrame {

    private User user;
    private JTextField usernameField;
    private JTextField userAgeField;
    private JTextField heightInInchesField;
    private JTextField weightField;
    private JTextField genderField;

    public UserInfoGUI(User userEntered){

        this.user = userEntered;

        setTitle("User Information");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        Font labelFont = new Font("Arial", Font.PLAIN, 18);
        Font fieldFont = new Font("Arial", Font.PLAIN, 18);
        Dimension fieldSize = new Dimension(200, 40);

        JLabel userInfoHeaderLabel = new JLabel("User Information");
        userInfoHeaderLabel.setForeground(Color.GREEN);
        userInfoHeaderLabel.setFont(labelFont);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(userInfoHeaderLabel, gbc);

        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(labelFont);
        add(usernameLabel, gbc);
        gbc.gridx = 1;
        usernameField = new JTextField(user.getUsername());
        usernameField.setPreferredSize(fieldSize);
        usernameField.setFont(fieldFont);
        usernameField.setEditable(false);
        add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel userAgeLabel = new JLabel("Age:");
        userAgeLabel.setFont(labelFont);
        add(userAgeLabel, gbc);
        gbc.gridx = 1;
        userAgeField = new JTextField(String.valueOf(user.getUserAge()));
        userAgeField.setPreferredSize(fieldSize);
        userAgeField.setFont(fieldFont);
        userAgeField.setEditable(false);
        add(userAgeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel heightLabel = new JLabel("Height in inches:");
        heightLabel.setFont(labelFont);
        add(heightLabel, gbc);
        gbc.gridx = 1;
        heightInInchesField = new JTextField(String.valueOf(user.getHeightInInches()));
        heightInInchesField.setPreferredSize(fieldSize);
        heightInInchesField.setFont(fieldFont);
        heightInInchesField.setEditable(false);
        add(heightInInchesField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel weightLabel = new JLabel("Weight:");
        weightLabel.setFont(labelFont);
        add(weightLabel, gbc);
        gbc.gridx = 1;
        weightField = new JTextField(String.valueOf(user.getWeight()));
        weightField.setPreferredSize(fieldSize);
        weightField.setFont(fieldFont);
        weightField.setEditable(false);
        add(weightField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(labelFont);
        add(genderLabel, gbc);
        gbc.gridx = 1;
        genderField = new JTextField(user.getGender());
        genderField.setPreferredSize(fieldSize);
        genderField.setFont(fieldFont);
        genderField.setEditable(false);
        add(genderField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 18));
        backButton.setPreferredSize(new Dimension( 200, 40));
        add(backButton, gbc);

        backButton.addActionListener(e -> dispose());
        pack();

    }

}

