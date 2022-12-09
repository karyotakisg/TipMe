
package kourpa;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener {

	//Log in graphics
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton registerButton = new JButton("Register");
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("username:");
	JLabel userPasswordLabel = new JLabel("password:");
	JLabel messageLabel = new JLabel();
	JLabel tryAgainLabel = new JLabel();

	HashMap<String, String> logininfo = new HashMap<String, String>();

	
	LoginPage() {
		
		userIDLabel.setBounds(50,100,75,25);
		userPasswordLabel.setBounds(50,150,75,25);
		
		messageLabel.setBounds(30,250,1200,35);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		
		tryAgainLabel.setBounds(40,300,1200,35);
		
		userIDField.setBounds(125,100,200,25);
		userPasswordField.setBounds(125,150,200,25);
		
		loginButton.setBounds(70,200, 100, 25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		resetButton.setBounds(205,200, 100, 25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		registerButton.setBounds(145,350,100,25);
		registerButton.setFocusable(false);
		registerButton.addActionListener(this);
		
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(tryAgainLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.add(registerButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
			messageLabel.setText("");
		}
		
		String jdbcUrl = "jdbc:sqlite:socialmedia.db";
		
		if (e.getSource() == loginButton) {
			
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			
			try {
				  Connection conn = DriverManager.getConnection(jdbcUrl);
				  Statement st = conn.createStatement();
			 
				  String query = "SELECT username, password FROM User;";
				  
				  ResultSet rs = st.executeQuery(query);
				  
				  boolean loggedIn = false;
				  
				  while (rs.next()) {
					  
					  if (rs.getString("username").equals(userID) && rs.getString("password").equals(password)) {
						  
						  messageLabel.setForeground(Color.green);
						  messageLabel.setText("Login successful!");
						  frame.dispose();
						  WelcomePage welcomePage = new WelcomePage();
						  
						  loggedIn = true;
						  break;
						  
					  } 
					  
					  
					if (!loggedIn) {
						
						userIDField.setText("");
						userPasswordField.setText("");
						messageLabel.setText("Wrong username or password!");
						tryAgainLabel.setText("Try Again!");
					
					}  
					  
				 }
				
				  
			  } catch (SQLException s) {
				  // TODO Auto-generated catch block
				  System.out.println("Failed to connect");
				  s.printStackTrace();
			  }
			
		
		if (e.getSource() == registerButton) {
			userIDField.setText("");
			userPasswordField.setText("");
			messageLabel.setText("");
			frame.dispose();
			Register.register();
		}

	}
  }
}
