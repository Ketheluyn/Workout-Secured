package com.fitness.tracker.GUI;

import com.fitness.tracker.Functions.AuthService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkoutLogin extends JFrame {
	private JTextField userNaF;
	private JPasswordField passWoF;
	
	
	public WorkoutLogin() {
		//setting up window
		setTitle("User Login");
		setSize(300, 150);
		setLayout(new GridLayout(3, 2));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new JLabel("Username:"));
		userNaF = new JTextField();
		add(userNaF);
		
		add(new JLabel("Password:"));
		passWoF = new JPasswordField();
		add(passWoF);
		
		JButton loginBtn = new JButton("Login");
		add(loginBtn);
		
		loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendLogin();
            }
        });

		JButton registerButton = new JButton("Register");
		add(registerButton);

		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RegisterGUI registerGUI = new RegisterGUI();
				registerGUI.setVisible(true);
			}
		});
		
		
	}
	
	private void sendLogin() {
		String username = userNaF.getText().trim();
		String password = new String(passWoF.getPassword()).trim();
		
		AuthService authService = new AuthService();
		if(authService.login(username, password)) {
			dispose();
						
			SwingUtilities.invokeLater(() -> {
	            MainApplicationWindow main = new MainApplicationWindow();
	            main.setVisible(true);
			});
						
		} else {
			JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
