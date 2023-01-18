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
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Register class creates a new user registration in our social media
 * application GetTip(). When the "Submit" button is pressed, the form's fields
 * are checked for any errors, and the user's preferences are saved to the
 * database.
 * 
 * @author Vaggelis Talos, Eqerem Hena
 *
 */

public class Register {
	// Creating a new user object in order to set User's preferences
	static User user = new User(); // A new User signs up
	static JFrame frame; // class frame

	/**
	 * The register() method calls the necessary methods to create Register's
	 * graphics.
	 *
	 */
	public static void register() { // Create classe's frame and panel
		JPanel panel = createPanel();
		frame = createFrame(panel);
		createLabelsAndFields(frame, panel);
	}

	/**
	 * The createPanel() method creates a new JPanel and sets its layout and
	 * background color.
	 * 
	 * @return the created JPanel
	 */
	public static JPanel createPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(153, 208, 233));
		return panel;
	}

	/**
	 * The createFrame() method creates a new JFrame, sets its size and adds the
	 * created panel on it.
	 * 
	 * @param panel the panel that to be added to the frame
	 * @return the created JFrame
	 */
	public static JFrame createFrame(JPanel panel) {
		JFrame frame = new JFrame("Welcome to GetTip()");
		Image ic = Toolkit.getDefaultToolkit().getImage("src\\main\\resources\\logo.png");
		frame.setIconImage(ic);
		frame.setSize(500, 650);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		return frame;
	}

	/**
	 * The createLabelsAndFields(JFrame frame, JPanel panel) method creates and adds
	 * the necessary JLabels and JTextFields to the panel so the User can declare
	 * his preferences (first name, last name, phone number, email and interests).
	 * The method also sets the font, color, and position of the labels and fields
	 * on the panel. An image is also added to the panel using an ImageIcon class.
	 * 
	 * This method also checks if User's preferences are valid.
	 * 
	 * @param frame The JFrame where the panel is added.
	 * @param panel The JPanel where the labels and fields are added.
	 */

	private static void createLabelsAndFields(JFrame frame, JPanel panel) {
		// code for creating JLabels and JTextFields
		ImageIcon icon = new ImageIcon("src\\main\\resources\\GetTip.png");
		Image image = icon.getImage();
		Image scaledImage = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH); // image appears when full screen is								                                               
		                                                                           // opened
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		JLabel tips = new JLabel(scaledIcon);
		tips.setBounds(600, 100, 300, 300);
		panel.add(tips);

		JLabel welcomeLabel = new JLabel("Welcome to GetTip()");
		welcomeLabel.setBounds(40, 7, 300, 25);
		panel.add(welcomeLabel);
		welcomeLabel.setFont(new Font("Verdana", Font.BOLD, 25));
		welcomeLabel.setForeground(new Color(255, 255, 255));

		JLabel accountLabel = new JLabel("Create new account");
		accountLabel.setBounds(70, 40, 200, 25);
		accountLabel.setFont(new Font("Yu Gothic UI Semilight", 35, 20));
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

		// If the user already owns an account, he/she is able to directly log in
		JButton loginButton = new JButton("Already have an Account? Login!");
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

		// Interest options 10 categories of different topics from which the user can
		// choose his favorites based on his interests First Interest options menu
		String[] categories = { "SCIENCE", "SPORTS", "MUSIC", "FASHION", "TRAVEL", "FITNESS", "ART", "EDUCATION",
				"NATURE", "FOOD" };

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

		JButton submitButton = new JButton("Submit"); // The user presses the "Submit" button to create his account
		submitButton.setBounds(100, 440, 100, 25);
		panel.add(submitButton);

		JLabel sameUserNameLabel = new JLabel(); // This message appears when the user declares a username that already
													// belongs to another user
		sameUserNameLabel.setBounds(28, 540, 1000, 25);
		sameUserNameLabel.setText("");
		panel.add(sameUserNameLabel);
		JLabel emptyOrLongUserNameText = new JLabel(); // This message appears when the user doesn't declare a username
														// or when the username he declared is longer than 30 characters
		emptyOrLongUserNameText.setBounds(260, 225, 250, 25);
		emptyOrLongUserNameText.setText("");
		panel.add(emptyOrLongUserNameText);
		JLabel emptyOrLongPasswordText = new JLabel(); // This message appears when the user doesn't declare a password
														// or when the password he declared is longer than 30 characters
		emptyOrLongPasswordText.setBounds(260, 255, 250, 25);
		emptyOrLongPasswordText.setText("");
		panel.add(emptyOrLongPasswordText);
		JLabel emptyOrLongEmailText = new JLabel(); // This message appears when the user doesn't declare an email or
													// when the email he declared is longer than 30 characters
		emptyOrLongEmailText.setBounds(260, 185, 250, 25);
		emptyOrLongEmailText.setText("");
		panel.add(emptyOrLongEmailText);
		JLabel incorrectPhoneNumber = new JLabel(); // This message appears when the user adds adds an invalid phone
													// number (not 10 digits)
		incorrectPhoneNumber.setBounds(260, 155, 250, 25);
		incorrectPhoneNumber.setText("");
		panel.add(incorrectPhoneNumber);

		JLabel longFirstName = new JLabel(); // This message appears when the First Name is longer than 30 characters
		longFirstName.setBounds(260, 85, 250, 25);
		longFirstName.setText("");
		panel.add(longFirstName);

		JLabel longLastName = new JLabel(); // This message appears when the First Name is longer than 30 characters
		longLastName.setBounds(260, 125, 250, 25);
		longLastName.setText("");
		panel.add(longLastName);
		frame.setVisible(true);

		// What happens when user presses the "Submit" button
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				emptyOrLongUserNameText.setText(" ");
				emptyOrLongPasswordText.setText(" ");
				emptyOrLongEmailText.setText(" ");
				incorrectPhoneNumber.setText(" ");
				longFirstName.setText("");
				longLastName.setText("");
				boolean emptyFields = false; // Checks if there is an empty field that souldn't be empty
				if (userNameText.getText().isEmpty() || String.valueOf(passwordText.getPassword()).isEmpty()
						|| emailText.getText().isEmpty())
					emptyFields = true;
				boolean longFields = false; // Checks for too long fields or invalid phone number
				if (userNameText.getText().length() > 30 || String.valueOf(passwordText.getPassword()).length() > 30
						|| (emailText.getText().length() > 30)
						|| (phoneNumberText.getText().length() != 10 && !phoneNumberText.getText().isEmpty())
						|| firstNameText.getText().length() > 30 || lastNameText.getText().length() > 30)
					longFields = true;

				// Saving User's preferences
				user.setUsername(userNameText.getText());
				user.setPassword(String.valueOf(passwordText.getPassword()));
				user.setFirstName(firstNameText.getText());
				user.setLastName(lastNameText.getText());
				user.setEmail(emailText.getText());
				user.setPhoneNumber(phoneNumberText.getText());

				// Set user's gender
				if (cb.getSelectedItem().equals("Male")) {
					user.setSex("Male");
				} else {
					user.setSex("Female");
				}

				// Set user's interests
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

				boolean sameUserName = checkSameUserName(); // Calls the checkSameUserName() method in order to define
															// if the chosen username already belongs to another User

				if (emptyFields || sameUserName || longFields) { // When something is invalid or empty
					if (userNameText.getText().isEmpty()) // Username field can't be empty
						emptyOrLongUserNameText.setText("Empty Username Field");
					else if (sameUserName)
						sameUserNameLabel.setText("This Username already exists. Try another one!");
					if (String.valueOf(passwordText.getPassword()).isEmpty()) // Password field can't be empty
						emptyOrLongPasswordText.setText("Empty Password Field");
					if (emailText.getText().isEmpty()) // Email field can't be empty
						emptyOrLongEmailText.setText("Empty E-mail Field");
					if (userNameText.getText().length() > 30) // Username should be shorter than 30 characters
						emptyOrLongUserNameText.setText("Username too long. Try another one!");
					if (String.valueOf(passwordText.getPassword()).length() > 30) // password should be shorter than 30
																				  // characters
						emptyOrLongPasswordText.setText("Password too long. Try another one!");
					if (phoneNumberText.getText().length() != 10 && !phoneNumberText.getText().isEmpty()) // Phone
																										  // Number
																												// should
																												// contain
																												// 10
																												// digits
																												// only
						incorrectPhoneNumber.setText("Not a Phone Number");
					if (firstNameText.getText().length() > 30) // First Name should be shorter than 30 characters
						longFirstName.setText("First Name too long. Try again!");
					if (lastNameText.getText().length() > 30) // Last Name should be shorter than 30 characters
						longLastName.setText("Last Name too long. Try again!");
				} else {
					insertUser(user); // If everything is valid, insert the new User into the database
					LoginPage lg = new LoginPage();
					lg.loginPage(); // Open new Log In page
				}
			}
		});

		// What happens when User presses the "login" button
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginPage lg = new LoginPage();
				lg.loginPage();
			}
		});
	}

	/**
	 * The checkSameUserName() method checks if the chosen username already belongs
	 * to another user. It compares the current user's username with all the
	 * existing usernames in the system.
	 * 
	 * @return true if the chosen username already belongs to another user, false
	 *         otherwise.
	 */
	public static boolean checkSameUserName() { // Checks if the chosen username already exists
		boolean sameUserName = false;
		// SQLite connection URL
		String jdbcUrl = "jdbc:sqlite:socialmedia.db";
		try {
			// Creating a new Connection
			Connection conn = DriverManager.getConnection(jdbcUrl);
			Statement statement = conn.createStatement();
			String checkValidQuery = "SELECT Username FROM User"; // We get all the usernames from the database in order
																	// to define if the one that the User chosen belongs
																	// to someone else
			ResultSet rs = statement.executeQuery(checkValidQuery);
			while (rs.next()) { // For every username in the database
				if (user.getUsername().equals(rs.getString("Username"))) {
					sameUserName = true;
					break;
				}
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sameUserName;
	}

	/**
	 * The insertUser(User u) method inserts the new user that registered in the
	 * database.
	 *
	 * @param u The User object that is going to be inserted in the database
	 */
	public static void insertUser(User u) { // Insert new User's elements in the database
		// SQLite connection URL
		String jdbcUrl = "jdbc:sqlite:socialmedia.db";

		try {
			Connection conn = DriverManager.getConnection(jdbcUrl);
			Statement statement = conn.createStatement();

			// Save preferences in the database
			String query = "INSERT INTO User"
					+ "(username, password, email, PhoneNumber, Sex, Interest1, Interest2, Interest3, FirstName, LastName)"
					+ " VALUES(" + "'" + u.getUsername() + "'" + "," + "'" + u.getPassword() + "'" + "," + "'"
					+ u.getEmail() + "'" + "," + "'" + u.getPhoneNumber() + "'" + "," + "'" + u.getSex() + "'" + ","
					+ "'" + u.getInterest1() + "'" + "," + "'" + u.getInterest2() + "'" + "," + "'" + u.getInterest3()
					+ "'" + "," + "'" + u.getFirstName() + "'" + "," + "'" + u.getLastName() + "'" + ");";
			statement.executeUpdate(query);
			conn.close();

			// After signing up, opening the "Log in" page
			frame.dispose();
			new LoginPage();

		} catch (SQLException s) {
			System.out.println("Error");
			s.printStackTrace();
		}
	}
}
