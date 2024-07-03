package com.fitness.tracker.GUI;

import com.fitness.tracker.Functions.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class RegisterGUI extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField userAgeField;
    private JTextField heightInInchesField;
    private JTextField weightField;
    private JTextField genderField;

    public RegisterGUI() {
        setTitle("Create a new account");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        Font labelFont = new Font("Arial", Font.PLAIN, 18);
        Font fieldFont = new Font("Arial", Font.PLAIN, 18);
        Dimension fieldSize = new Dimension(200, 40);

        JLabel demoLabel = new JLabel("Demonstration purposes only");
        demoLabel.setForeground(Color.RED);
        demoLabel.setFont(labelFont);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(demoLabel, gbc);

        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(labelFont);
        add(usernameLabel, gbc);
        gbc.gridx = 1;
        usernameField = new JTextField();
        usernameField.setPreferredSize(fieldSize);
        usernameField.setFont(fieldFont);
        add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(labelFont);
        add(passwordLabel, gbc);
        gbc.gridx = 1;
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(fieldSize);
        passwordField.setFont(fieldFont);
        add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel ageLabel = new JLabel("Age");
        ageLabel.setFont(labelFont);
        add(ageLabel, gbc);
        gbc.gridx = 1;
        userAgeField = new JTextField();
        userAgeField.setPreferredSize(fieldSize);
        userAgeField.setFont(fieldFont);
        add(userAgeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel heightLabel = new JLabel("Height in inches");
        heightLabel.setFont(labelFont);
        add(heightLabel, gbc);
        gbc.gridx = 1;
        heightInInchesField = new JTextField();
        heightInInchesField.setPreferredSize(fieldSize);
        heightInInchesField.setFont(fieldFont);
        add(heightInInchesField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel weightLabel = new JLabel("Weight");
        weightLabel.setFont(labelFont);
        add(weightLabel, gbc);
        gbc.gridx = 1;
        weightField = new JTextField();
        weightField.setPreferredSize(fieldSize);
        weightField.setFont(fieldFont);
        add(weightField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setFont(labelFont);
        add(genderLabel, gbc);
        gbc.gridx = 1;
        genderField = new JTextField();
        genderField.setPreferredSize(fieldSize);
        genderField.setFont(fieldFont);
        add(genderField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Arial", Font.BOLD, 18));
        registerButton.setPreferredSize(new Dimension(200, 40));
        add(registerButton, gbc);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createUserProfile();
            }
        });

        pack();
    }

    private void createUserProfile(){

        String usernameEntered = usernameField.getText();

        if(User.isUsernameDuplicate(usernameEntered)){
            JOptionPane.showMessageDialog(this, "User with username already created, " +
                    "try a different username or login.", "Username taken", JOptionPane.ERROR_MESSAGE);
            return;
        }

        User newRegisteredUser;

        String stringPasswordField = new String(passwordField.getPassword());
        try {
            int intUserAgeField = Integer.parseInt(userAgeField.getText());
            int intHeightInInchesField = Integer.parseInt(heightInInchesField.getText());
            int intWeightField = Integer.parseInt(weightField.getText());

            newRegisteredUser = new User(usernameEntered, stringPasswordField, intUserAgeField,
                    intHeightInInchesField, intWeightField, genderField.getText());

            JOptionPane.showMessageDialog(this, "You successfully created your account " +
                    newRegisteredUser.getUsername() + ", please login now.");

            dispose();

            User.writeUserToFile(newRegisteredUser);

        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "There was an error creating your profile. Please" +
                    "check your fields", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
