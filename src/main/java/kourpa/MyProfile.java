package kourpa;
import java.awt.*;

import java.awt.event.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
public class MyProfile extends JFrame implements ActionListener, MouseListener { // creation of the necesery components for MyProfile GUI//
	User user1 = new User();
	HomePage hp = new HomePage();
	JPanel panel = new JPanel();
	JLabel userLabel = new JLabel("User");
	public JTextField userText = new JTextField(25);
	JLabel passwordLabel = new JLabel("Password");
	public JPasswordField passwordText = new JPasswordField(25);
	JLabel emailLabel = new JLabel("Email");
	public JTextField emailText = new JTextField(25);
	JLabel p1Label = new JLabel("Preference 1");
	public JTextField p1Text = new JTextField(25);
	JLabel p2Label = new JLabel("Preference 2");
	public JTextField p2Text = new JTextField(25);
	JLabel p3Label = new JLabel("Preference 3");
	public JTextField p3Text = new JTextField(25);
	public JTextField firstNameText = new JTextField(25);
	JLabel firstNameLabel = new JLabel("First Name");
	public JTextField lastNameText = new JTextField(25);
	JLabel lastNameLabel = new JLabel("Last Name");
	public JTextField sexText = new JTextField(25);
	JLabel sexLabel = new JLabel("Sex");
	public JTextField phoneNumberText = new JTextField(25);
	JLabel phoneNumberLabel = new JLabel("Phone Number");
	public JTextField birthdayText = new JTextField(25);
	JLabel birthdayLabel = new JLabel("Birthday");
	JLabel labelForPosts = new JLabel(
			"<html><font size = '22' color = 'black'><strong>My Posts</strong><text-align: center></font><</html> ");
	Icon diary = new ImageIcon("src/main/resources/diaryIcon.png");
	JPanel p = new JPanel( new GridLayout(getMessageCount(), 1, 0, 10));//
	Menu menu = new Menu();
	JButton changeButton = new JButton();
	JButton sumbitButton = new JButton();
	Font defaultFont = new Font("Gill Sans MT", Font.BOLD, 16);
	Color textColor = Color.decode("#ffffff");
	Color backgroundColor = Color.decode("#000000");
	Color hoverColor = Color.decode("#00aced");
	String s = "submit";
	JDialog dial = new JDialog(this, "Dialog Box");
	JButton dialBut = new JButton("OK");
	JPanel east = new JPanel();
	private JRadioButton colorPick;
    private JRadioButton darkMode;
    private JRadioButton lightMode;
    private ButtonGroup radioGroup;
    private JRadioButton plainMode;
	ImageIcon iconColorChooser = new ImageIcon("src\\main\\resources\\colors.png");
    JButton logoutButton = new JButton();
	MyProfile(User user, Color col) { // constructor of the MyProfile GUI
		super("GetTip()-MyProfile");
		Image ic = Toolkit.getDefaultToolkit().getImage("src\\main\\resources\\logo.png");
		this.setIconImage(ic);
		user1 = user;
		setBounds(180, 50, 1000, 750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		userLabel.setBounds(310, 100, 165, 25);
		userText.setBounds(400, 100, 165, 25);
		passwordLabel.setBounds(310, 130, 165, 25);
		passwordText.setBounds(400, 130, 165, 25);
		emailLabel.setBounds(310, 160, 165, 25);
		emailText.setBounds(400, 160, 165, 25);
		p1Label.setBounds(310, 190, 165, 25);
		p1Text.setBounds(400, 190, 165, 25);
		p2Label.setBounds(310, 220, 165, 25);
		p2Text.setBounds(400, 220, 165, 25);
		p3Label.setBounds(310, 250, 165, 25);
		p3Text.setBounds(400, 250, 165, 25);	
		firstNameText.setBounds(400, 280, 165, 25);
		firstNameLabel.setBounds(310, 280, 165, 25);
		lastNameText.setBounds(400, 310, 165, 25);
		lastNameLabel.setBounds(310, 310, 165, 25);
		sexText.setBounds(400, 340, 165, 25);
		sexLabel.setBounds(310, 340, 165, 25);
		birthdayText.setBounds(400, 370, 165, 25);
		birthdayLabel.setBounds(310, 370, 165, 25);
		phoneNumberText.setBounds(400, 400, 165, 25);
		phoneNumberLabel.setBounds(310, 400, 165, 25);
		setValuesInTextAreas();
		changeButton.setBounds(600, 260, 150, 50);
		changeButton.setText("Change");
		changeButton.addActionListener(this);
		Font defaultFont = new Font("Gill Sans MT", Font.BOLD, 16);
		Color textColor = Color.decode("#ffffff");
		Color backgroundColor = Color.decode("#000000");
		changeButton.setFont(defaultFont);
		changeButton.setBackground(backgroundColor);
		changeButton.setForeground(textColor);
		labelForPosts.setBounds(400, 420, 200, 150);
		labelForPosts.setIcon(diary);
		panelSetup();
		setFieldsUneditable();
		textAreaSetup();
		setTextinPostArea();
		scrollbarSetup();
        logoutButtonSetup();
		this.add(panel);
		panel.add(menu, BorderLayout.NORTH);
		eastPanelSetup();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	public void sumbit(User user) {
		user.setPassword(String.valueOf(passwordText.getPassword()));
		user.setEmail(emailText.getText());
		user.setInterest1(p1Text.getText());
		user.setInterest2(p2Text.getText());
		user.setInterest3(p3Text.getText());
		user.setPhoneNumber(phoneNumberText.getText());
		user.setFirstName(firstNameText.getText());
		user.setLastName(lastNameText.getText());
		String jdbcUrl = "jdbc:sqlite:socialmedia.db";
		try {
			// Creating a new Connection
			Connection conn = DriverManager.getConnection(jdbcUrl);
			Statement statement = conn.createStatement();
			String query = "UPDATE User SET password = " + "'" + user.getPassword() + "'" + ", " + "Email = " + "'"
					+ user.getEmail() + "'" + ", " + "Sex =" + "'" + user.getSex() + "'" + ", " + "Interest1 = " + "'"
					+ user.getInterest1() + "'" + ", " + "Interest2 = " + "'" + user.getInterest2() + "'" + ", "
					+ "Interest3 = " + "'" + user.getInterest3() + "'" + ", " + "PhoneNumber = " + user.getPhoneNumber()
			        + ", FirstName = " + "'" + user.getFirstName() + "'" + ", "
			        + "LastName = " + "'" + user.getLastName() + "'"
			        + " WHERE username = " + "'" + user.getUsername() + "'"; 
			statement.executeUpdate(query);
		    conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// make TextArea editable and create submit button
		if (e.getSource() == changeButton) {
			changeButton.setVisible(false);
			s = s.toUpperCase();
			sumbitButton.setFocusPainted(false);
			sumbitButton.setText(s);
			sumbitButton.setBorder(null);
			sumbitButton.setBackground(backgroundColor);
			sumbitButton.setForeground(textColor);
			sumbitButton.setFont(defaultFont);
			sumbitButton.setOpaque(true);
			sumbitButton.setBounds(600, 260, 150, 50);
			sumbitButton.addMouseListener(this);
			panel.add(sumbitButton);
			this.add(panel);
			changeButton.setVisible(false);
			setFieldsEditable();
		}
		if (e.getSource() == darkMode) {
			p.setVisible(false);
			p.setVisible(true);
            east.setBackground(Color.DARK_GRAY);
            panel.setBackground(Color.DARK_GRAY);
        } else if (e.getSource() == lightMode) {
			p.setVisible(false);
			p.setVisible(true);
            east.setBackground(Color.white);
            panel.setBackground(Color.WHITE);
        } else if (e.getSource() == plainMode){
			p.setVisible(false);
			p.setVisible(true);
            panel.setBackground(new Color(255, 102, 0));
            east.setBackground(new Color(255, 102, 0));
        } else if (e.getSource() == colorPick) {
            JColorChooser colorChoose = new JColorChooser();
            Color col = JColorChooser.showDialog(null, "Pick a color!", Color.LIGHT_GRAY);
            panel.setBackground(col);
            east.setBackground(col);
			p.setVisible(false);
			p.setVisible(true);
        }
        if(e.getSource()==logoutButton) {
        	int input = JOptionPane.showOptionDialog(null, "Are you sure you want to logout?", null,
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
			if (input == JOptionPane.OK_OPTION) {
				new LoginPage();
				dispose();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == sumbitButton) {
			this.sumbit(user1);
			setValuesInTextAreas();
			dial.setSize(500, 500);
			dial.setLocationRelativeTo(null);
			JLabel dialLabel = new JLabel("You have submitted your changes with success", SwingConstants.CENTER);
			dialLabel.setSize(100, 50);
			dial.add(dialLabel, BorderLayout.CENTER);
			dialBut.setSize(100, 50);
			dial.add(dialBut, BorderLayout.SOUTH);
			Icon icon = new ImageIcon("src\\main\\resources\\gif.gif");
			JLabel gifLabel = new JLabel(icon);
			dial.add(gifLabel, BorderLayout.NORTH);
			dialBut.setVisible(true);
			dial.setVisible(true);
			dialBut.addMouseListener(this);
		}
		if (e.getSource() == dialBut) {
			dial.dispose();
			this.dispose();
			MyProfile obj = new MyProfile(user1,this.getColor());
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == sumbitButton) {
			sumbitButton.setBackground(hoverColor);
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == sumbitButton) {
			sumbitButton.setBackground(backgroundColor);
		}
	}
	public void setFieldsEditable() {
		passwordText.setEditable(true);
		emailText.setEditable(true);
		p1Text.setEditable(true);
		p2Text.setEditable(true);
		p3Text.setEditable(true);
		birthdayText.setEditable(true);
		sexText.setEditable(true);
		firstNameText.setEditable(true);
		lastNameText.setEditable(true);
		phoneNumberText.setEditable(true);
	}
	public void setFieldsUneditable() {
		userText.setEditable(false);
		passwordText.setEditable(false);
		emailText.setEditable(false);
		p1Text.setEditable(false);
		p2Text.setEditable(false);
		p3Text.setEditable(false);
		birthdayText.setEditable(false);
		sexText.setEditable(false);
		firstNameText.setEditable(false);
		lastNameText.setEditable(false);
		phoneNumberText.setEditable(false);
	}
	public void setValuesInTextAreas() {
		userText.setText(user1.getUsername());
		passwordText.setText(user1.getPassword());
		emailText.setText(user1.getEmail());
		p1Text.setText(user1.getInterest1());
		p2Text.setText(user1.getInterest2());
		p3Text.setText(user1.getInterest3());
		firstNameText.setText(user1.getFirstName());
		lastNameText.setText(user1.getLastName());
		sexText.setText(user1.getSex());
		birthdayText.setText(user1.getBirthDate());
		phoneNumberText.setText(user1.getPhoneNumber());
	}
	public void setTextinPostArea() {
		String jdbcUrl = "jdbc:sqlite:socialmedia.db"; // Database URL
		try {
			// New Connection
			Connection conn = DriverManager.getConnection(jdbcUrl);
			Statement statement = conn.createStatement();
			// Get user's posts from the database
			String query = "SELECT User.username, Post.text, Post.uploaddate, Post.likes, Post.Category FROM Post, User WHERE User.username = '" + user1.getUsername() + "' AND Post.UserId = User.UserId"; //Post.userId = User.userId AND (Post.Category = "
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				JPanel post = new JPanel();
				post.setLayout(new BorderLayout(2, 2));
				post.setBackground(Color.black);
				post.add(hp.getNorthLabel(rs.getString("username"), rs.getString("uploaddate"), rs.getString("Category")),
					BorderLayout.NORTH);
				post.add(hp.getMessageText(rs.getString("text")), BorderLayout.CENTER);
				post.add(hp.getSouthLike(rs.getString("text"), p, post), BorderLayout.SOUTH);			
				p.add(post);
			}			
		} catch (SQLException s) {
			System.out.println("Error");
			s.printStackTrace();
		}
	}
	public void textAreaSetup() {
		p.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.add(p,BorderLayout.SOUTH);
	}
	public void scrollbarSetup() {
		JScrollPane scrollbar = new JScrollPane(p, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollbar.setBounds(100, 600, 800, 300);
		scrollbar.getVerticalScrollBar().setUnitIncrement(12);
		scrollbar.getVerticalScrollBar().setBackground(Color.BLACK);
		scrollbar.getVerticalScrollBar().setPreferredSize(new Dimension(8, 695));
		this.add(scrollbar);
	}
	public void panelSetup(){
	panel.setLayout(new BorderLayout());
	Color col = new Color(255, 102, 0);
	panel.setBackground(col);
	panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
	panel.setLayout(null);
	panel.add(userLabel);
	panel.add(userText);
	panel.add(passwordLabel);
	panel.add(passwordText);
	panel.add(emailLabel);
	panel.add(emailText);
	panel.add(p1Label);
	panel.add(p1Text);
	panel.add(p2Label);
	panel.add(p2Text);
	panel.add(p3Label);
	panel.add(p3Text);
	panel.add(firstNameText);
	panel.add(firstNameLabel);
	panel.add(lastNameText);
	panel.add(lastNameLabel);
	panel.add(sexText);
	panel.add(sexLabel);
	panel.add(birthdayText);
	panel.add(birthdayLabel);
	panel.add(phoneNumberText);
	panel.add(phoneNumberLabel);
	panel.add(changeButton);
	panel.add(labelForPosts);
	}
	public void eastPanelSetup(){
		east.setLayout(new GridLayout(4,1));
		east.setBackground(new Color(255, 102, 0));
		east.setBounds(850,100,150,200);
		darkMode = new JRadioButton("Dark Mode", false);
        lightMode = new JRadioButton("Light Mode", false);
        plainMode = new JRadioButton("Plain Mode", true);		
        colorPick = new JRadioButton("Other", iconColorChooser, false);
		darkMode.setBackground(Color.DARK_GRAY);
        lightMode.setBackground(Color.WHITE);
        plainMode.setBackground(new Color(255, 102, 0));
        colorPick.setBackground(Color.LIGHT_GRAY);
        darkMode.setForeground(Color.WHITE);
        plainMode.setForeground(Color.WHITE);
        east.add(plainMode);
        east.add(darkMode);
        east.add(lightMode);
        east.add(colorPick);
		radioGroup = new ButtonGroup();
        radioGroup.add(darkMode);
        radioGroup.add(lightMode);
        radioGroup.add(plainMode);
        radioGroup.add(colorPick);
        darkMode.addActionListener(this);
        lightMode.addActionListener(this);
        plainMode.addActionListener(this);
        colorPick.addActionListener(this);
		panel.add(east);
	}
    public void logoutButtonSetup(){
		logoutButton.setBounds(850, 15, 100, 25);
		logoutButton.setText("Log out");
		logoutButton.addActionListener(this);
		logoutButton.setFocusable(false);
		logoutButton.setHorizontalTextPosition(JButton.CENTER);
        logoutButton.setBackground(backgroundColor);
		logoutButton.setForeground(textColor);
        logoutButton.setOpaque(true);
        panel.add(logoutButton);
       
		
    }
    
    public int getMessageCount() {
		int count = 0;
		String url = "jdbc:sqlite:socialmedia.db";
		try {
			// New Connection
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();

			// Get posts from the database

			String query = "SELECT User.username, Post.text, Post.uploaddate, Post.likes, Post.Category FROM Post, User WHERE User.username = '" + user1.getUsername() + "' AND Post.UserId = User.UserId"; 

			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				count++; // count the number of posts
			}

			conn.close();

		} catch (SQLException s) {
			System.out.println("Error");
			s.printStackTrace();
		}

		return count;
	}
	public Color getColor(){ // returns the color of the panel so other sections of the app can use it
		return panel.getBackground();
	}
	public  JPanel getPanel(){ // The following methods are created for testing purposes
		return panel;
	}
	public JButton getChangeButton() {
		return changeButton;
	}
	public JLabel getSexLabel() {
		return sexLabel;
	}
}