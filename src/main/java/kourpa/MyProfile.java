package kourpa;
import java.awt.*;
import java.awt.event.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.Border;
public class MyProfile extends JFrame implements ActionListener, MouseListener { // creation of the necesery components for MyProfile GUI//
	User user1 = new User();
	HomePage hp = new HomePage();
	private JPanel panel;
	private JPanel center;
	private JPanel south;
	private JPanel west;
	JPanel center2;
	JPanel south2;
	JPanel east2;
	JPanel west2;
	JPanel southEast;
	JPanel southWest;
	JPanel southCenter;
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
	JLabel labelForPosts = new JLabel("My Posts");
	Icon diary = new ImageIcon("src/main/resources/diaryIcon.png");
	Icon diary2 = new ImageIcon("src/main/resources/diary2.png");
	private JPanel p = new JPanel( new GridLayout(getMessageCount(), 1, 0, 10));//
	Menu menu = new Menu();
	JButton changeButton = new JButton();
	JButton sumbitButton = new JButton();
	Font defaultFont = new Font("Gill Sans MT", Font.BOLD, 16);
	Color textColor = Color.decode("#ffffff");
	Color backgroundColor = Color.decode("#000000");
	Color hoverColor = Color.decode("#00aced");
	private final Color col = new Color(255, 102, 0);
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
    
    MyProfile() {}
    
	MyProfile(User user, Color col) { 
		super("Get tip-My profile");// constructor of the MyProfile GUI
		Image ic = Toolkit.getDefaultToolkit().getImage("src\\main\\resources\\logo.png");
		
		this.setIconImage(ic);
		user1 = user;
		
		this.setBounds(180, 50, 1050, 750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setValuesInTextAreas();
		changeButton.setSize(150, 50);
		changeButton.setText("Change");
		changeButton.addActionListener(this);
		Font defaultFont = new Font("Gill Sans MT", Font.BOLD, 16);
		Color textColor = Color.decode("#ffffff");
		Color backgroundColor = Color.decode("#000000");
		changeButton.setFont(defaultFont);
		changeButton.setBackground(backgroundColor);
		changeButton.setForeground(textColor);
		Font font = new Font("Calibri", Font.BOLD, 22);
		labelForPosts.setFont(font);
		labelForPosts.setIcon(diary);
		panelSetup();
		setFieldsUneditable();
		southSetup();
		setTextinPostArea();
		scrollbarSetup();
        logoutButtonSetup();
		this.add(panel);
		panel.add(menu, BorderLayout.NORTH);
		eastPanelSetup();
		this.setResizable(true);
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
			sumbitButton.setFocusPainted(true);
			sumbitButton.setText(s);
			sumbitButton.setBackground(backgroundColor);
			sumbitButton.setForeground(textColor);
			sumbitButton.setFont(defaultFont);
			sumbitButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			sumbitButton.setOpaque(true);
			sumbitButton.setSize(160, 60);
			sumbitButton.addMouseListener(this);
			east2.add(sumbitButton);
			
			setFieldsEditable();
		}
		if (e.getSource() == darkMode) {
            east.setBackground(Color.DARK_GRAY);
            panel.setBackground(Color.DARK_GRAY);
            west.setBackground(Color.DARK_GRAY);
            south.setBackground(Color.DARK_GRAY);
            center2.setBackground(Color.DARK_GRAY);
            south2.setBackground(Color.DARK_GRAY);
            east2.setBackground(Color.DARK_GRAY);
            west2.setBackground(Color.DARK_GRAY);
            southCenter.setBackground(Color.DARK_GRAY);
            southWest.setBackground(Color.DARK_GRAY);
            southEast.setBackground(Color.DARK_GRAY);
            
            userLabel.setForeground(Color.white);
            passwordLabel.setForeground(Color.white);
            emailLabel.setForeground(Color.white);
            p1Label.setForeground(Color.white);
            p2Label.setForeground(Color.white);
            p3Label.setForeground(Color.white);
            sexLabel.setForeground(Color.white);
            birthdayLabel.setForeground(Color.white);
            firstNameLabel.setForeground(Color.white);
            lastNameLabel.setForeground(Color.white);
            phoneNumberLabel.setForeground(Color.white);
            labelForPosts.setForeground(Color.white);
            
            labelForPosts.setIcon(diary2);
            
        } else if (e.getSource() == lightMode) {
            east.setBackground(Color.white);
            panel.setBackground(Color.WHITE);
            west.setBackground(Color.white);
            south.setBackground(Color.white);
            center2.setBackground(Color.white);
            south2.setBackground(Color.white);
            east2.setBackground(Color.white);
            west2.setBackground(Color.white);
            southCenter.setBackground(Color.white);
            southWest.setBackground(Color.white);
            southEast.setBackground(Color.white);
            
            userLabel.setForeground(Color.black);
            passwordLabel.setForeground(Color.black);
            emailLabel.setForeground(Color.black);
            p1Label.setForeground(Color.black);
            p2Label.setForeground(Color.black);
            p3Label.setForeground(Color.black);
            sexLabel.setForeground(Color.black);
            birthdayLabel.setForeground(Color.black);
            firstNameLabel.setForeground(Color.black);
            lastNameLabel.setForeground(Color.black);
            phoneNumberLabel.setForeground(Color.black);
            labelForPosts.setForeground(Color.black);
            
            labelForPosts.setIcon(diary);
            
        } else if (e.getSource() == plainMode){
            panel.setBackground(col);
            east.setBackground(col);
            west.setBackground(col);
            south.setBackground(col);
            center2.setBackground(col);
            south2.setBackground(col);
            east2.setBackground(col);
            west2.setBackground(col);
            southCenter.setBackground(col);
            southWest.setBackground(col);
            southEast.setBackground(col);
            
            userLabel.setForeground(Color.black);
            passwordLabel.setForeground(Color.black);
            emailLabel.setForeground(Color.black);
            p1Label.setForeground(Color.black);
            p2Label.setForeground(Color.black);
            p3Label.setForeground(Color.black);
            sexLabel.setForeground(Color.black);
            birthdayLabel.setForeground(Color.black);
            firstNameLabel.setForeground(Color.black);
            lastNameLabel.setForeground(Color.black);
            phoneNumberLabel.setForeground(Color.black);
            labelForPosts.setForeground(Color.black);
            
            labelForPosts.setIcon(diary);
        } else if (e.getSource() == colorPick) {
            Color col = JColorChooser.showDialog(null, "Pick a color!", Color.LIGHT_GRAY);
            panel.setBackground(col);
            east.setBackground(col);
            west.setBackground(col);
            south.setBackground(col);
            center2.setBackground(col);
            south2.setBackground(col);
            east2.setBackground(col);
            west2.setBackground(col);
            southCenter.setBackground(col);
            southWest.setBackground(col);
            southEast.setBackground(col);
            
            labelForPosts.setIcon(diary);
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
			dial.setSize(300, 300);
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
			new MyProfile(user1,this.getColor());
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
			String query = "SELECT User.username, Post.text, Post.uploaddate, Post.PostId, Post.likes, Post.Category FROM Post, User WHERE User.username = '" + user1.getUsername() + "' AND Post.UserId = User.UserId"; //Post.userId = User.userId AND (Post.Category = "
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				JPanel post = new JPanel();
				post.setLayout(new BorderLayout(2, 2));
				post.setBackground(Color.black);
				post.add(hp.getNorthLabel(rs.getString("username"), rs.getString("uploaddate"), rs.getString("Category")),
					BorderLayout.NORTH);
				post.add(hp.getMessageText(rs.getString("text")), BorderLayout.CENTER);
				post.add(hp.getSouthLike2(rs.getString("text"), p, post, rs.getInt("PostId")), BorderLayout.SOUTH);			
				p.add(post);
			}			
		} catch (SQLException s) {
			System.out.println("Error");
			s.printStackTrace();
		}
	}
	public void southSetup() {
		p.setBorder(BorderFactory.createLineBorder(Color.black));
		south = new JPanel(new BorderLayout(0, 3));
		south.setPreferredSize(new Dimension(780, 250));
		southCenter = new JPanel();
		southEast = new JPanel();
		southWest = new JPanel();
		//JPanel southSouth = new JPanel();
		//southSouth.setPreferredSize(new Dimension(1050, 5));
		southEast.setPreferredSize(new Dimension(135, 680));
		southWest.setPreferredSize(new Dimension(135, 680));
		southWest.setBackground(col);
		southEast.setBackground(col);
		//southSouth.setBackground(col);
		southCenter.add(p);
		southEast.setBorder(BorderFactory.createLineBorder(Color.black));
		southWest.setBorder(BorderFactory.createLineBorder(Color.black));
		south.add(southCenter, BorderLayout.CENTER);
		south.add(southEast, BorderLayout.EAST);
		south.add(southWest, BorderLayout.WEST);
		//south.add(southSouth, BorderLayout.SOUTH);\
		south.setBackground(Color.black);
		panel.add(south, BorderLayout.SOUTH);
	}
	public void scrollbarSetup() {
		JScrollPane scrollbar = new JScrollPane(p, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollbar.getVerticalScrollBar().setUnitIncrement(12);
		scrollbar.getVerticalScrollBar().setBackground(Color.BLACK);
		scrollbar.getVerticalScrollBar().setPreferredSize(new Dimension(8, 695));
		south.add(scrollbar);
	}
	
	
	public void panelSetup(){
	
	panel = new JPanel(new BorderLayout());
	panel.setBackground(Color.black);
	panel.setPreferredSize(hp);
	center = new JPanel(new BorderLayout());
	center.setBackground(Color.black);
	center2 = new JPanel(new GridLayout(11 , 2, 2, 2));
	center2.setPreferredSize(new Dimension(380, 380));
	south2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
	east2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
	west2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
	west2.setPreferredSize(new Dimension(230, 470));
	west2.setBackground(col);
	south2.setPreferredSize(new Dimension(840, 100));
	south2.setBackground(col);
	east2.setBackground(col);
	east2.setPreferredSize(new Dimension(250, 470));
	west = new JPanel();
	west.setPreferredSize(new Dimension(160, 680));
	west.setBackground(col);
	
	center2.setBackground(new Color(255, 102, 0));
	center2.add(userLabel);
	center2.add(userText);
	center2.add(passwordLabel);
	center2.add(passwordText);
	center2.add(emailLabel);
	center2.add(emailText);
	center2.add(p1Label);
	center2.add(p1Text);
	center2.add(p2Label);
	center2.add(p2Text);
	center2.add(p3Label);
	center2.add(p3Text);
	center2.add(firstNameLabel);
	center2.add(firstNameText);
	center2.add(lastNameLabel);
	center2.add(lastNameText);
	center2.add(sexLabel);
	center2.add(sexText);
	center2.add(birthdayLabel);
	center2.add(birthdayText);
	center2.add(phoneNumberLabel);
	center2.add(phoneNumberText);
	east2.add(Box.createVerticalStrut(380));
	east2.add(changeButton);
	south2.add(labelForPosts);
	center.add(center2, BorderLayout.CENTER);
	center.add(south2, BorderLayout.SOUTH);
	center.add(east2, BorderLayout.EAST);
	center.add(west2, BorderLayout.WEST);
	panel.add(west, BorderLayout.WEST);
	panel.add(center, BorderLayout.CENTER);
	
	}
	public void eastPanelSetup(){
		east.setLayout(new GridLayout(10,1));
		east.setBackground(new Color(255, 102, 0));
		east.setPreferredSize(new Dimension(160, 680));
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
		panel.add(east, BorderLayout.EAST);
	}
    public void logoutButtonSetup(){
		logoutButton.setBounds(900, 25, 100, 25);
		logoutButton.setText("Log out");
		logoutButton.addActionListener(this);
		logoutButton.setFocusable(false);
		logoutButton.setHorizontalTextPosition(JButton.CENTER);
        logoutButton.setBackground(backgroundColor);
		logoutButton.setForeground(textColor);
        logoutButton.setOpaque(true);
        //west.add(Box.createVerticalStrut(380));
        west.add(logoutButton, BorderLayout.NORTH);
       
		
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
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public JButton getChangeButton() {
		return changeButton;
	}
	public JLabel getSexLabel() {
		return sexLabel;
	}
}