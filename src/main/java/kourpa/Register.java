package kourpa;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Register {

	//Creating register graphics
	public static void register() {
		
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setSize(500, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		panel.setBackground(Color.orange);
		
		//Creating JLabels and JTextFields in Sign Up page
		
		JLabel welcomeLabel = new JLabel("Welcome to TipMe");
		welcomeLabel.setBounds(50, 7, 250, 25);
		welcomeLabel.setFont(new Font("TimesRoman", 40, 25));
		welcomeLabel.setForeground(Color.BLUE.brighter());
		panel.add(welcomeLabel);
		
		JLabel accountLabel = new JLabel("Create new account");
		accountLabel.setBounds(50, 40, 200, 25);
		accountLabel.setFont(new Font("Bold", 35, 20));
		accountLabel.setForeground(Color.BLACK);
		panel.add(accountLabel);
		
		JLabel firstNameLabel = new JLabel("First Name"); 
		firstNameLabel.setBounds(20, 70, 80, 50);
		firstNameLabel.setForeground(Color.BLACK);
		panel.add(firstNameLabel);
		
		JTextField firstNameText = new JTextField(20);
		firstNameText.setBounds(100, 85, 150, 25);
		panel.add(firstNameText);
		
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setBounds(20, 110, 80, 50);
		lastNameLabel.setForeground(Color.black);
		panel.add(lastNameLabel);
		
		JTextField lastNameText = new JTextField(20);
		lastNameText.setBounds(100, 125, 150, 25);
		panel.add(lastNameText);
		
		JLabel phoneNumberLabel = new JLabel("Phone Number");
		phoneNumberLabel.setBounds(8, 140, 85, 50);
		phoneNumberLabel.setForeground(Color.black);
		panel.add(phoneNumberLabel);
		
		JTextField phoneNumberText = new JTextField(20);
		phoneNumberText.setBounds(100, 155, 150, 25);
		phoneNumberText.setForeground(Color.black);
		panel.add(phoneNumberText);
		
		JLabel emailLabel = new JLabel("E-mail");
		emailLabel.setBounds(25, 170, 80, 50);
		emailLabel.setForeground(Color.black);
		panel.add(emailLabel);		
		
		JTextField emailText = new JTextField(20);
		emailText.setBounds(100, 185, 150, 25);
		emailText.setForeground(Color.black);
		panel.add(emailText);
		
		JLabel userNameLabel = new JLabel("Username");
		userNameLabel.setBounds(20, 210, 80, 50);
		userNameLabel.setForeground(Color.black);
		panel.add(userNameLabel);
		
		JTextField userNameText = new JTextField(20);
		userNameText.setBounds(100, 225, 150, 25);
		userNameText.setForeground(Color.black);
		panel.add(userNameText);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(20, 240, 80, 50);
		passwordLabel.setForeground(Color.black);
		panel.add(passwordLabel);
		
		JPasswordField passwordText = new JPasswordField();
		passwordText.setBounds(100, 255, 150, 25);
		passwordText.setForeground(Color.black);
		panel.add(passwordText);
		
		JButton loginButton = new JButton(
				"Already have an Account? Login!");
		loginButton.setBounds(30, 500, 250, 30);
		panel.add(loginButton);
		
		JLabel sexLabel = new JLabel("Sex");
		sexLabel.setBounds(30, 270, 80, 50);
		sexLabel.setForeground(Color.black);
		panel.add(sexLabel);
		
		String[] sexTypes = {"Male", "Female"};
		JComboBox<Object> cb = new JComboBox<Object>(sexTypes);
		cb.setBounds(100, 285, 100, 25);
		panel.add(cb);
		
		//Interest options
		String[] categories = 
			{"COOKING", "SPORTS", "PROGRAMMING", "DRIVING", "HEALTH", "DANCING", "NATURE", "HISTORY", "GEOGRAPHY", "PHYSICS", "MATHS", "CHEMISTRY"};
		
		//First Interest options menu
		JComboBox<Object> cat1 = new JComboBox<Object>(categories);
		cat1.setBounds(100, 320, 100, 25);
		panel.add(cat1);
		
		JLabel interest1Label = new JLabel("Interest 1");
		interest1Label.setBounds(30, 305, 80, 50);
		interest1Label.setForeground(Color.black);
		panel.add(interest1Label);
		
		//Second Interest options menu
		JComboBox<Object> cat2 = new JComboBox<Object>(categories);
		cat2.setBounds(100, 350, 100, 25);;
		panel.add(cat2);
		
		JLabel interest2Label = new JLabel("Interest 2");
		interest2Label.setBounds(30, 335, 80, 50);
		interest2Label.setForeground(Color.black);
		panel.add(interest2Label);
		
		//Third Interest options menu
		JComboBox<Object> cat3 = new JComboBox<Object>(categories);
		cat3.setBounds(100, 380, 100, 25);;
		panel.add(cat3);
		
		JLabel interest3Label = new JLabel("Interest 3");
		interest3Label.setBounds(30, 365, 80, 50);
		interest3Label.setForeground(Color.black);
		panel.add(interest3Label);
		
		JButton submitButton = new JButton("Submit");
		submitButton.setBounds(100, 440, 100, 25);
		panel.add(submitButton);
		
		frame.setVisible(true);
		
		//Creating a new user object in order to save User's preferences
		User user = new User();
		
		//What happens when user presses the "Submit" button
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Saving User's preferences
				user.setUsername(userNameText.getText());
				user.setPassword(String.valueOf(passwordText.getPassword()));
				user.setFirstName(firstNameText.getText());
				user.setLastName(lastNameText.getText());
				user.setEmail(emailText.getText());
				user.setPhoneNumber(phoneNumberText.getText());
				
				
				if (cb.getSelectedItem().equals("Male")) {
					user.setSex("Male");		
				    
				} else {
					user.setSex("Female");
				}
			
				for (int i = 0; i < categories.length; i++) { 
					if (cat1.getSelectedItem().equals(categories[i])) {
						
						user.setInterest1(categories[i]);
						break;
					  }
			     }
			
				for (int i = 0; i < categories.length; i++) { 
					if (cat2.getSelectedItem().equals(categories[i])) {
						
						user.setInterest2(categories[i]);
						break;
					  }
			     }
			
				
				for (int i = 0; i < categories.length; i++) { 
					if (cat3.getSelectedItem().equals(categories[i])) {
						
						user.setInterest3(categories[i]);
						break;
					  
					}
			     }
		
				//SQLite connection URL
				String jdbcUrl = "jdbc:sqlite:socialmedia.db";
				
				  try {
					  //Creating a new Connection
					  Connection conn = DriverManager.getConnection(jdbcUrl);
					  Statement statement = conn.createStatement();
					  
					  System.out.println("Connected");
					  
					  //Save preferences in the database
					  String query = "INSERT INTO User(username, "
					  		+ "password, "
					  		+ "email, "
					  		+ "PhoneNumber, "
					  		+ "Sex, "
					  		//+ "BirthDate, "
					  		+ "Interest1, "
					  		+ "Interest2, "
					  		+ "Interest3)"
					  		+ " VALUES(" 
					  		+ "'" + user.getUsername() + "'" + "," 
					  		+ "'" + user.getPassword() +  "'" + "," 
					  		+ "'" + user.getEmail() + "'" + "," 
					  		+ "'" + user.getPhoneNumber() + "'" + "," 
					  		+ "'" + user.getSex() + "'" + "," 
					  		//+ user.getBirthDate() + ","
					  		+ "'" + user.getInterest1() + "'" + ","
					  		+ "'" + user.getInterest2() + "'" + "," 
					  		+ "'" + user.getInterest3() + "'" + ");" ;
					  
					  statement.executeUpdate(query);
				 
				  } catch (SQLException s) {
					  // TODO Auto-generated catch block
					  System.out.println("Error");
					  s.printStackTrace();
				  }
			
				  //After signing up, opening the "Log in" page
				  frame.dispose();
				  LoginPage loginPage = new LoginPage();
			}
		
		});
	
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { 
				
				frame.dispose();
				LoginPage loginPage = new LoginPage();
				
			}
			
		});
		
	}
	
}

//What happens when you press the register button	
   /* @Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == registerButton) {
			
			String jdbcUrl = "jdbc:sqlite:socialmedia.db";
			
			  try {
				  Connection conn = DriverManager.getConnection(jdbcUrl);
				  Statement statement = conn.createStatement();
			 
			  } catch (SQLException s) {
				  // TODO Auto-generated catch block
				  System.out.println("Failed to connect");
				  s.printStackTrace();
			  }
			
			frame.dispose();
			IDandPasswords idpas = new IDandPasswords();
			LoginPage loginPage = new LoginPage(idpas.getLogininfo());
		} */
	
		
			
	
	




