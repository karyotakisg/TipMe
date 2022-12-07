package kourpa;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Register implements ActionListener {
	

	JFrame frame = new JFrame();
	JButton registerButton = new JButton("Register");
	JTextField usernameField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	JPasswordField confirmPasswordField = new JPasswordField();
	JTextField emailField = new JTextField();
	JTextField phoneField = new JTextField();
	JTextField categoryField = new JTextField();
	JTextField birthField = new JTextField();
	JLabel usernameLabel = new JLabel("username:");
	JLabel passwordLabel = new JLabel("password:");
	JLabel confirmPasswordLabel = new JLabel("Confirm password:");
	JLabel emailLabel = new JLabel("email:");
	JLabel phoneLabel = new JLabel("Phone Number:");
	JLabel categoryLabel = new JLabel("Category:");
	JLabel birthLabel = new JLabel("Birthdate:");
	JLabel sexLabel = new JLabel("Sex:");
	JLabel messageLabel = new JLabel();
	JLabel registerLabel = new JLabel("Making our family bigger");
	
	String[] sexTypes = {"Male", "Female"};
	JComboBox<Object> cb = new JComboBox<Object>(sexTypes);
	
	String[] categories = 
		{"Sports", "Cooking", "Programming", "Driving", "Health", "Dancing", "Nature", "History", "Geography", "Physics", "Maths", "Chemistry"};
	JComboBox<Object> cat1 = new JComboBox<Object>(categories);
	JComboBox<Object> cat2 = new JComboBox<Object>(categories);
	
	JLabel interest1Label = new JLabel("Interest 1");
	JLabel interest2Label = new JLabel("Interest 2");
	
Register() {
		
		registerLabel.setBounds(0,0,2000,35);
		registerLabel.setFont(new Font(null, Font.PLAIN,25));
		
		frame.add(registerLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
	
		usernameLabel.setBounds(50,100,75,25);
		passwordLabel.setBounds(50,150,75,25);
		confirmPasswordLabel.setBounds(50,200,150,25);
		emailLabel.setBounds(50,250,75,25);
		phoneLabel.setBounds(50,300,150,25);
		categoryLabel.setBounds(50,350,75,25);
		birthLabel.setBounds(50,400,150,25);
		sexLabel.setBounds(50,450,75,25);
		sexLabel.setForeground(Color.black);
		cb.setBounds(200, 450, 75, 25);
		frame.add(cb);
		cat1.setBounds(200, 500, 75, 25);
		interest1Label.setBounds(50, 500, 74, 25);
		interest1Label.setForeground(Color.black);
		cat2.setBounds(200, 550, 75, 25);
		interest2Label.setBounds(50, 550, 74, 25);
		interest2Label.setForeground(Color.black);
		
		
		
		messageLabel.setBounds(100,250,2000,35);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		
		usernameField.setBounds(200,100,200,25);
		passwordField.setBounds(200,150,200,25);
		confirmPasswordField.setBounds(200,200,200,25);
		emailField.setBounds(200,250,200,25);
		phoneField.setBounds(200,300,200,25);
		categoryField.setBounds(200,350,200,25);
		birthField.setBounds(200,400,200,25);
		
		registerButton.setBounds(70,600, 100, 25);
		registerButton.setFocusable(false);
		registerButton.addActionListener(this);
		
		
	
		frame.add(usernameLabel);
		frame.add(passwordLabel);
		frame.add(confirmPasswordLabel);
		frame.add(emailLabel);
		frame.add(phoneLabel);
		frame.add(categoryLabel);
		frame.add(birthLabel);
		frame.add(messageLabel);
		frame.add(usernameField);
		frame.add(passwordField);
		frame.add(confirmPasswordField);
		frame.add(emailField);
		frame.add(phoneField);
		frame.add(categoryField);
		frame.add(birthField);
		frame.add(sexLabel);
		frame.add(cat1);
		frame.add(cat2);
		frame.add(interest1Label);
		frame.add(interest2Label);
		frame.add(registerButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,1000);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == registerButton) {
			frame.dispose();
			IDandPasswords idpas = new IDandPasswords();
			LoginPage loginPage = new LoginPage(idpas.getLogininfo());
		}
		
	}
	
	

}
