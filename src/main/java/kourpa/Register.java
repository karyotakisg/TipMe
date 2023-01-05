package kourpa;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Register {

	// Creating register graphics
	public static void register() {
		
		JPanel panel = new JPanel();
		JFrame frame = new JFrame("Welcome to GetTip()");
		frame.setSize(500, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(51, 153, 255));

		// Creating JLabels and JTextFields in Sign Up page

		ImageIcon icon = new ImageIcon("src\\main\\resources\\GetTip.png");
		Image image = icon.getImage();
		Image scaledImage = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH); //The image appears when the user opens a full screen
		
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		
		JLabel tips = new JLabel(scaledIcon);
		tips.setBounds(600, 100, 300, 300);
		panel.add(tips);
		
		JLabel welcomeLabel = new JLabel("Welcome to GetTip()");
		welcomeLabel.setBounds(40, 7, 300, 25);
		panel.add(welcomeLabel);
		welcomeLabel.setFont(new Font("Verdana", Font.BOLD, 25));
		welcomeLabel.setForeground(new Color(255, 255, 255));
		//panel.add(welcomeLabel);

		JLabel accountLabel = new JLabel("Create new account");
		accountLabel.setBounds(70, 40, 200, 25);
		accountLabel.setFont(new Font("Yu Gothic UI Semilight", 35, 20));
		accountLabel.setForeground(Color.BLACK);
		panel.add(accountLabel);

		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setBounds(20, 70, 80, 50);
		firstNameLabel.setForeground(Color.BLACK);
		//firstNameLabel.setFont(new Font("Calibri", 23, 15));
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

		JButton loginButton = new JButton("Already have an Account? Login!"); //If the user already owns an account, he/she is able to directly log in
		loginButton.setBounds(30, 500, 250, 30);
		panel.add(loginButton);

		JLabel sexLabel = new JLabel("Sex");
		sexLabel.setBounds(30, 270, 80, 50);
		sexLabel.setForeground(Color.black);
		panel.add(sexLabel);

		String[] sexTypes = { "Male", "Female" };
		JComboBox<Object> cb = new JComboBox<Object>(sexTypes);
		cb.setBounds(100, 285, 100, 25);
		panel.add(cb);

		// Interest options
		String[] categories = { "SCIENCE", "SPORTS", "MUSIC", "FASHION", "TRAVEL", "FITNESS", "ART", "EDUCATION",
				"ENVIROMENT", "FOOD" }; //10 categories of different topics from which the user can choose his favorites based on his interests

		// First Interest options menu
		JComboBox<Object> cat1 = new JComboBox<Object>(categories);
		cat1.setBounds(100, 320, 100, 25);
		panel.add(cat1);

		JLabel interest1Label = new JLabel("Interest 1");
		interest1Label.setBounds(30, 305, 80, 50);
		interest1Label.setForeground(Color.black);
		panel.add(interest1Label);

		// Second Interest options menu
		JComboBox<Object> cat2 = new JComboBox<Object>(categories);
		cat2.setBounds(100, 350, 100, 25);
		panel.add(cat2);

		JLabel interest2Label = new JLabel("Interest 2");
		interest2Label.setBounds(30, 335, 80, 50);
		interest2Label.setForeground(Color.black);
		panel.add(interest2Label);

		// Third Interest options menu
		JComboBox<Object> cat3 = new JComboBox<Object>(categories);
		cat3.setBounds(100, 380, 100, 25);
		panel.add(cat3);

		JLabel interest3Label = new JLabel("Interest 3");
		interest3Label.setBounds(30, 365, 80, 50);
		interest3Label.setForeground(Color.black);
		panel.add(interest3Label);

		JButton submitButton = new JButton("Submit"); //The user presses the "Submit" button to create his account
		submitButton.setBounds(100, 440, 100, 25);
		panel.add(submitButton);

		JLabel sameUserNameLabel = new JLabel(); //This message appears when the user declares a username that already belongs to another user
		sameUserNameLabel.setBounds(28, 540, 1000, 25);
		sameUserNameLabel.setText("");
		panel.add(sameUserNameLabel);

		JLabel emptyOrLongUserNameText = new JLabel(); //This message appears when the user doesn't declare a username or when the username he declared is longer than 30 characters
		emptyOrLongUserNameText.setBounds(260, 225, 250, 25);
		emptyOrLongUserNameText.setText("");
		panel.add(emptyOrLongUserNameText);

		JLabel emptyOrLongPasswordText = new JLabel(); //This message appears when the user doesn't declare a password or when the password he declared is longer than 30 characters
		emptyOrLongPasswordText.setBounds(260, 255, 250, 25);
		emptyOrLongPasswordText.setText("");
		panel.add(emptyOrLongPasswordText);

		JLabel emptyOrLongEmailText = new JLabel(); //This message appears when the user doesn't declare an email or when the email he declared is longer than 30 characters
		emptyOrLongEmailText.setBounds(260, 185, 250, 25);
		emptyOrLongEmailText.setText("");
		panel.add(emptyOrLongEmailText);

		JLabel incorrectPhoneNumber = new JLabel(); //This message appears when the user adds adds an invalid phone number (not 10 digits)
		incorrectPhoneNumber.setBounds(260, 155, 250, 25);
		incorrectPhoneNumber.setText("");
		panel.add(incorrectPhoneNumber);

		JLabel longFirstName = new JLabel(); //This message appears when the First Name is longer than 30 characters
		longFirstName.setBounds(260, 85, 250, 25);
		longFirstName.setText("");
		panel.add(longFirstName);

		JLabel longLastName = new JLabel(); //This message appears when the First Name is longer than 30 characters
		longLastName.setBounds(260, 125, 250, 25);
		longLastName.setText("");
		panel.add(longLastName);

		frame.setVisible(true);

		// Creating a new user object in order to save User's preferences
		User user = new User();

		// What happens when user presses the "Submit" button
		submitButton.addActionListener(new ActionListener() {
			/**
			 *
			 */
			@Override
			public void actionPerformed(ActionEvent e) {

				emptyOrLongUserNameText.setText(" ");
				emptyOrLongPasswordText.setText(" ");
				emptyOrLongEmailText.setText(" ");
				incorrectPhoneNumber.setText(" ");
				longFirstName.setText("");
				longLastName.setText("");

				boolean emptyFields = false; //Checks if there is an empty field that souldn't be empty

				if (userNameText.getText().isEmpty() || String.valueOf(passwordText.getPassword()).isEmpty()
						|| emailText.getText().isEmpty())
					emptyFields = true;

				boolean longFields = false; //Checks for too long fields or invalid phone number

				if ((userNameText.getText().length() > 30) || (String.valueOf(passwordText.getPassword()).length() > 30)
						|| (emailText.getText().length() > 30)
						|| ((phoneNumberText.getText().length() != 10) && !(phoneNumberText.getText().isEmpty()))
						|| (firstNameText.getText().length() > 30) || (lastNameText.getText().length() > 30))
					longFields = true;

				// Saving User's preferences
				user.setUsername(userNameText.getText());
				user.setPassword(String.valueOf(passwordText.getPassword()));
				user.setFirstName(firstNameText.getText());
				user.setLastName(lastNameText.getText());
				user.setEmail(emailText.getText());
				user.setPhoneNumber(phoneNumberText.getText());

				//set user's sex
				if (cb.getSelectedItem().equals("Male")) {
					user.setSex("Male");

				} else {
					user.setSex("Female");
				}

				
				//set user's interests
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

				boolean sameUserName = false; //Checks if the selectable username already exists
				
				// SQLite connection URL
				String jdbcUrl = "jdbc:sqlite:socialmedia.db";

				try {
					
					// Creating a new Connection
					Connection conn = DriverManager.getConnection(jdbcUrl);
					Statement statement = conn.createStatement();

					String checkValidQuery = "SELECT Username FROM User";

					ResultSet rs = statement.executeQuery(checkValidQuery);

					while (rs.next()) {

						if (user.getUsername().equals(rs.getString("Username"))) {

							sameUserName = true;
							break;
						}

					}

					if (emptyFields || sameUserName || longFields) {

						if (userNameText.getText().isEmpty())
							emptyOrLongUserNameText.setText("Empty Username Field");
						else if (sameUserName)
							sameUserNameLabel.setText("This Username already exists. Try another one!");

						if (String.valueOf(passwordText.getPassword()).isEmpty())
							emptyOrLongPasswordText.setText("Empty Password Field");

						if (emailText.getText().isEmpty())
							emptyOrLongEmailText.setText("Empty E-mail Field");

						if (userNameText.getText().length() > 30)
							emptyOrLongUserNameText.setText("Username too long. Try another one!");

						if (String.valueOf(passwordText.getPassword()).length() > 30)
							emptyOrLongPasswordText.setText("Password too long. Try another one!");

						if ((phoneNumberText.getText().length() != 10) && !(phoneNumberText.getText().isEmpty()))
							incorrectPhoneNumber.setText("Not a Phone Number");

						if (firstNameText.getText().length() > 30)
							longFirstName.setText("First Name too long. Try again!");

						if (lastNameText.getText().length() > 30)
							longLastName.setText("Last Name too long. Try again!");

					} else {

						// Save preferences in the database
						String query = "INSERT INTO User"
								+ "(username, password, email, PhoneNumber, Sex, Interest1, Interest2, Interest3, FirstName, LastName)"
								+ " VALUES(" + "'" + user.getUsername() + "'" + "," + "'" + user.getPassword() + "'"
								+ "," + "'" + user.getEmail() + "'" + "," + "'" + user.getPhoneNumber() + "'" + ","
								+ "'" + user.getSex() + "'" + "," + "'" + user.getInterest1() + "'" + "," + "'"
								+ user.getInterest2() + "'" + "," + "'" + user.getInterest3() + "'" + "," + "'"
								+ user.getFirstName() + "'" + "," + "'" + user.getLastName() + "'" + ");";

						statement.executeUpdate(query);

						conn.close();
						
						// After signing up, opening the "Log in" page
						frame.dispose();
						new LoginPage();

					}

				} catch (SQLException s) {
					// TODO Auto-generated catch block
					System.out.println("Error");
					s.printStackTrace();
				}

				// }

			}

		});

		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				new LoginPage();

			}

		});

	}

}

