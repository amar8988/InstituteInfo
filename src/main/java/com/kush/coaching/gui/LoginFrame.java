package com.kush.coaching.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import com.kush.coaching.service.LoginData;

import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LoginFrame {
	private JFrame frmPleaseSignin;
	private JTextField textField;
	private JPasswordField passwordField;

	public static void login() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame window = new LoginFrame();
					window.frmPleaseSignin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginFrame() {
		initialize();
	}

	private void initialize() {
		frmPleaseSignin = new JFrame();
		frmPleaseSignin.getContentPane().setBackground(Color.PINK);
		frmPleaseSignin.setTitle("Please sign-in");
		frmPleaseSignin.setBounds(100, 100, 353, 207);
		frmPleaseSignin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPleaseSignin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("user_name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(27, 40, 83, 21);
		frmPleaseSignin.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(113, 41, 168, 20);
		frmPleaseSignin.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(27, 81, 72, 21);
		frmPleaseSignin.getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		
		passwordField.setBounds(113, 82, 168, 20);
		frmPleaseSignin.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName, password, passwordDB;
				userName = textField.getText();
				password = passwordField.getText();
				
				passwordDB = new LoginData().meth(userName);
				
				if(passwordDB != null) {
					if(!(password.equals(passwordDB))) 
						LoginDialog.passwordDialog(frmPleaseSignin);
					else
						System.out.println("Login userId- "+userName+", password- "+ password);
				}
				
				System.out.println("passwordDB-"+passwordDB+"..... userName-"+userName+", password-"+password);
		}});
		
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(69, 129, 89, 23);
		frmPleaseSignin.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(168, 129, 89, 23);
		frmPleaseSignin.getContentPane().add(btnNewButton_1);
	}
}
