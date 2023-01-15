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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener {
	// Log in graphics
	JFrame frame = new JFrame("Log In");
	JButton loginButton = new JButton("Login");
	JButton registerButton = new JButton("Register");
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("Username:");
	JLabel userPasswordLabel = new JLabel("Password:");
	JLabel messageLabel = new JLabel();
	JLabel tryAgainLabel = new JLabel();
	static JFrame expl;
	static JFrame myPr;
	static JFrame home;
	static ExplorePage ex;
	static HomePage hp;
	final Color col = new Color(255, 102, 0);

	// HashMap<String, String> logininfo = new HashMap<String, String>();
	Color c;

	public JFrame loginPage() {
		c = new Color(51, 153, 255);
		frame.getContentPane().setBackground(c);
		userIDLabel.setBounds(50, 100, 75, 25);
		userPasswordLabel.setBounds(50, 150, 75, 25);
		messageLabel.setBounds(20, 250, 1200, 35);
		messageLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		messageLabel.setForeground(new Color(130, 12, 10));
		tryAgainLabel.setBounds(150, 280, 1200, 50);
		tryAgainLabel.setForeground(Color.black);
		userIDField.setBounds(125, 100, 200, 25);
		userPasswordField.setBounds(125, 150, 200, 25);
		loginButton.setBounds(70, 200, 100, 25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		resetButton.setBounds(205, 200, 100, 25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		registerButton.setBounds(138, 350, 100, 25);
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
		frame.setSize(420, 420);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setVisible(true);
		return frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
			messageLabel.setText("");
			tryAgainLabel.setText("");
		}
		String jdbcUrl = "jdbc:sqlite:socialmedia.db";
		if (e.getSource() == loginButton) {
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			try {
				Connection conn = DriverManager.getConnection(jdbcUrl);
				Statement st = conn.createStatement();
				String query = "SELECT userid, username, password, email, PhoneNumber, Sex,"
						+ " Interest1, Interest2, Interest3, FirstName, LastName FROM User;";
				// String query2 = " SELECT username, password FROM User;";
				ResultSet rs = st.executeQuery(query);
				boolean loggedIn = false;
				while (rs.next()) {
					if ((rs.getString("username").equals(userID) && rs.getString("password").equals(password))
							&& !(userID.isEmpty() && password.isEmpty())) {
						messageLabel.setForeground(Color.green);
						messageLabel.setText("Login successful!");
						frame.dispose();
						User u = new User();
						u.setUsername(rs.getString("username"));
						u.setPassword(rs.getString("password"));
						u.setEmail(rs.getString("email"));
						u.setPhoneNumber(rs.getString("PhoneNumber"));
						u.setSex(rs.getString("Sex"));
						u.setInterest1(rs.getString("Interest1"));
						u.setInterest2(rs.getString("Interest2"));
						u.setInterest3(rs.getString("Interest3"));
						u.setFirstName(rs.getString("FirstName"));
						u.setLastName(rs.getString("LastName"));
						u.setUserId(rs.getInt("userid"));
						//System.out.println(rs.getInt("Userid") );
						hp = new HomePage(u);
						System.out.println(u.getUserId() + "userid");
						MyProfile mp = new MyProfile();
						ex = new ExplorePage();
						expl = ex.explorePage(u, col);
						expl.setVisible(false);
						setExplore(expl);
						myPr = mp.myProfile(u, col);
						myPr.setVisible(false);
						setMyProf(myPr);
						home = hp.homePage(u, col);
						setHome(home);
						home.setVisible(true);
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
				conn.close();
			} catch (SQLException s) {
				System.out.println("Failed to connect");
				s.printStackTrace();
			}
		}
		if (e.getSource() == registerButton) {
			userIDField.setText("");
			userPasswordField.setText("");
			messageLabel.setText("");
			frame.dispose();
			Register.register();
		}
	}

	public void setExplore(JFrame frame) {
		expl = frame;
	}

	public JFrame getExplore() {
		return expl;
	}

	public void setHome(JFrame frame) {
		home = frame;
	}

	public JFrame getHome() {
		return home;
	}

	public void setMyProf(JFrame frame) {
		myPr = frame;
	}

	public JFrame getMyProf() {
		return myPr;
	}
}
