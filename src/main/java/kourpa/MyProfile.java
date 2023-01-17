package kourpa;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
*Creates the settings, post review and personal info change section of the app
* @author Giannis Karyotakis, Panagiotis Theocharis
*/
public class MyProfile implements ActionListener, MouseListener { // creation of the necessary components
	private static User user1 = new User();
	private JFrame frame = new JFrame();
	private User u = new User();
	HomePage hp = new HomePage();
	private JPanel panel;
	private JPanel center;
	private JPanel south;
	private JPanel west;
	private JPanel center2;
	private JPanel south2;
	private JPanel east2;
	private JPanel west2;
	private JPanel southEast;
	private JPanel southWest;
	private JPanel southCenter;
	private JLabel userLabel = new JLabel("User");
	private JTextField userText = new JTextField(25);
	private JLabel passwordLabel = new JLabel("Password");
	private JPasswordField passwordText = new JPasswordField(25);
	private JLabel emailLabel = new JLabel("Email");
	private JTextField emailText = new JTextField(25);
	private JLabel p1Label = new JLabel("Preference 1");
	private JLabel p2Label = new JLabel("Preference 2");
	private JLabel p3Label = new JLabel("Preference 3");
	private JTextField firstNameText = new JTextField(25);
	private JLabel firstNameLabel = new JLabel("First Name");
	private JTextField lastNameText = new JTextField(25);
	private JLabel lastNameLabel = new JLabel("Last Name");
	private JLabel sexLabel = new JLabel("Sex");
	private JTextField phoneNumberText = new JTextField(25);
	private JLabel phoneNumberLabel = new JLabel("Phone Number");
	private JLabel labelForPosts = new JLabel("My Posts");
	private String[] categories = { "SCIENCE", "SPORTS", "MUSIC", "FASHION", "TRAVEL", "FITNESS", "ART", "EDUCATION",
	"NATURE", "FOOD" };
	private JComboBox<Object> pCombo1 = new JComboBox<Object>(categories);
	private JComboBox<Object> pCombo2 = new JComboBox<Object>(categories);
	private JComboBox<Object> pCombo3 = new JComboBox<Object>(categories);
	private String[] sexTypes = { "Male", "Female" };
	private JComboBox<Object> sexType = new JComboBox<Object>(sexTypes);
	private Icon diary = new ImageIcon("src/main/resources/diaryIcon.png");
	private Icon diary2 = new ImageIcon("src/main/resources/diary2.png");
	private JPanel p;
	private JButton changeButton = new JButton();
	private JButton sumbitButton = new JButton();
	private Font defaultFont = new Font("Gill Sans MT", Font.BOLD, 16);
	private final Color textColor = Color.decode("#ffffff");
	private final Color backgroundColor = Color.decode("#000000");
	private final Color hoverColor = Color.decode("#00aced");
	static final Color col = new Color(255, 102, 0);
	String s = "submit";
	private JDialog dial = new JDialog(frame, "Dialog Box");
	private JButton dialBut = new JButton("OK");
	private JPanel east = new JPanel();
	private JRadioButton colorPick;
	private JRadioButton darkMode;
	private JRadioButton lightMode;
	private ButtonGroup radioGroup;
	private JRadioButton plainMode;
	private Menu menu;
	private ImageIcon iconColorChooser = new ImageIcon("src\\main\\resources\\colors.png");
	private JButton logoutButton = new JButton();
	static Color col2;
	static Color currentColor = new Color(255, 102, 0);
	/** 
	*Method that give values to the components 
	*  and calls other methods to form tha frame
	* @param user the data of the users
	* @param col the color used as background
	* @return the frame for myProfile feauture  of the app
	*/
	public JFrame myProfile(User user, Color col) {
		user1 = user;
		pCombo1.setSelectedItem(user.getInterest1());
		pCombo2.setSelectedItem(user.getInterest2());
		pCombo3.setSelectedItem(user.getInterest3());
		sexType.setSelectedItem(user.getSex());
		frame.setTitle("GetTip-MyProfile");
		Image ic = Toolkit.getDefaultToolkit().getImage("src\\main\\resources\\logo.png");
		frame.setIconImage(ic);
		frame.setBounds(180, 50, 1050, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p = new JPanel(new GridLayout(getMessageCount(user), 1, 0, 10));
		setValuesInTextAreas();
		Font defaultFont = new Font("Gill Sans MT", Font.BOLD, 16);
		Color textColor = Color.decode("#ffffff");
		Color backgroundColor = Color.decode("#000000");
		changeButton.setSize(150, 50);
		changeButton.setText("Change");
		changeButton.addActionListener(this);
		changeButton.setFont(defaultFont);
		changeButton.setBackground(backgroundColor);
		changeButton.setForeground(textColor);
		Font font = new Font("Calibri", Font.BOLD, 22);
		labelForPosts.setFont(font);
		labelForPosts.setIcon(diary);
		panelSetup(col);
		setFieldsUneditable();
		southSetup(col);
		setTextinPostArea(user);
		scrollbarSetup();
		logoutButtonSetup();
		eastPanelSetup(col);
		menu = new Menu();
		panel.add(menu.menuBar(user, col), BorderLayout.NORTH);
		frame.add(panel);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		u = user;
		return frame;
	}
	/** 
	* SetTextinPostArea method connects with SQLite to retrieve the data for the posts of the User and appears
	* them with a GUI
	* @param user1 the data of the user
	*/
	public void setTextinPostArea(User user1) {
		String jdbcUrl = "jdbc:sqlite:socialmedia.db"; // Database URL
		try {
			// New Connection
			Connection conn = DriverManager.getConnection(jdbcUrl);
			Statement statement = conn.createStatement();
			// Get user's posts from the database
			String query = "SELECT User.username, Post.text, Post.uploaddate, Post.PostId, Post.likes, Post.Category FROM Post, User WHERE User.username = '"
				+ user1.getUsername() + "' AND Post.UserId = User.UserId";
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				JPanel post = new JPanel();
				post.setLayout(new BorderLayout(2, 2));
				post.setBackground(Color.black);
				post.add(hp.getNorthLabel(rs.getString("username"), rs.getString("uploaddate"),
				rs.getString("Category")), BorderLayout.NORTH);
				post.add(hp.getMessageText(rs.getString("text")), BorderLayout.CENTER);
				post.add(hp.getSouthLike2(rs.getString("text"), p, post, rs.getInt("PostId")), BorderLayout.SOUTH);
				p.add(post);
			}
		} catch (SQLException s) {
			System.out.println("Error");
			s.printStackTrace();
		}
	}
	/** 
	* logoutButtonSetup edits the button, puts
	* it in the proper panel and adds actionsListener  
	*/
	public void logoutButtonSetup() {
		logoutButton.setBounds(900, 25, 100, 25);
		logoutButton.setText("Log out");
		logoutButton.addActionListener(this);
		logoutButton.setFocusable(false);
		logoutButton.setHorizontalTextPosition(JButton.CENTER);
		logoutButton.setBackground(backgroundColor);
		logoutButton.setForeground(textColor);
		logoutButton.setOpaque(true);
		west.add(logoutButton, BorderLayout.NORTH);
	}
	/** 
	* inserts the data for the JTextAreas and JComboBoxes of the personal info section 
	*/
	public void setValuesInTextAreas() {
		userText.setText(user1.getUsername());
		passwordText.setText(user1.getPassword());
		emailText.setText(user1.getEmail());
		for (int i = 0; i < categories.length; i++) {
			if (pCombo1.getSelectedItem().equals(categories[i])) {
				user1.setInterest1(categories[i]);
				break;
			}
		}
		for (int i = 0; i < categories.length; i++) {
			if (pCombo2.getSelectedItem().equals(categories[i])) {
				user1.setInterest2(categories[i]);
				break;
			}
		}
		for (int i = 0; i < categories.length; i++) {
			if (pCombo3.getSelectedItem().equals(categories[i])) {
				user1.setInterest3(categories[i]);
				break;
			}
		}
		firstNameText.setText(user1.getFirstName());
		lastNameText.setText(user1.getLastName());
		for (int i = 0; i < sexTypes.length; i++) {
			if (sexType.getSelectedItem().equals(categories[i])) {
				user1.setSex(categories[i]);
				break;
			}
		}
	phoneNumberText.setText(user1.getPhoneNumber());
	}
	/** 
	* makes the fields of personal infos editable after user presses "change " button 
	* */
	public void setFieldsEditable() {
		passwordText.setEditable(true);
		emailText.setEditable(true);
		pCombo1.setEnabled(true);
		pCombo2.setEnabled(true);
		pCombo3.setEnabled(true);
		sexType.setEnabled(true);
		firstNameText.setEditable(true);
		lastNameText.setEditable(true);
		phoneNumberText.setEditable(true);
	}
	/** 
	* makes the fields of personal infos uneditable when the user first time 
	* opens myProfile
	*/
	public void setFieldsUneditable() {
		userText.setEditable(false);
		passwordText.setEditable(false);
		emailText.setEditable(false);
		pCombo1.setEnabled(false);
		pCombo2.setEnabled(false);
		pCombo3.setEnabled(false);
		sexType.setEnabled(false);
		firstNameText.setEditable(false);
		lastNameText.setEditable(false);
		phoneNumberText.setEditable(false);
	}
	/** 
	* sumbit inputs all the changes the user made at his personal infos 
	* in the database
	* @param user the data of the user
	*/
	public void sumbit(User user) {
		user.setPassword(String.valueOf(passwordText.getPassword()));
		user.setEmail(emailText.getText());
		System.out.println(categories[pCombo1.getSelectedIndex()]);
		System.out.println(categories[pCombo2.getSelectedIndex()]);
		System.out.println(categories[pCombo3.getSelectedIndex()]);
		user.setInterest1(categories[pCombo1.getSelectedIndex()]);
		user.setInterest2(categories[pCombo2.getSelectedIndex()]);
		user.setInterest3(categories[pCombo3.getSelectedIndex()]);
		user.setPhoneNumber(phoneNumberText.getText());
		user.setFirstName(firstNameText.getText());
		user.setLastName(lastNameText.getText());
		u = user;
		String jdbcUrl = "jdbc:sqlite:socialmedia.db";
		try {
		// Creating a new Connection
		Connection conn = DriverManager.getConnection(jdbcUrl);
		Statement statement = conn.createStatement();
		String query = "UPDATE User SET password = '" + user.getPassword() + "', Sex= '" + user.getSex()
		+ "', Interest1= '" + user.getInterest1() + "', Interest2= '" + user.getInterest2()
		+ "', Interest3= '" + user.getInterest3() + "', Email= '" + user.getEmail() + "', PhoneNumber= '"
		+ user.getPhoneNumber() + "', FirstName= '" + user.getFirstName() + "', LastName= '"
		+ user.getLastName() + "' WHERE Username = '" + user.getUsername() + "'";
		statement.executeUpdate(query);
		conn.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}
	/** 
	* edits 6 panels, add them Layout Managers and adds JLabels and JTextAreas
	* in the center2 panel (personal infos that exist in the middle of GUI).
	* Then, adds the center2,west2 etc. panel at the center panel and also
	* adds center and west panel to the main Panel 
	* @param col color for the background of west2 etc. panels
	*/
	public void panelSetup(Color col) {
		panel = new JPanel(new BorderLayout(0, 3));
		panel.setBackground(Color.black);
		center = new JPanel(new BorderLayout());
		center2 = new JPanel(new GridLayout(11, 2, 2, 2));
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
		center2.setBackground(col);
		center2.add(userLabel);
		center2.add(userText);
		center2.add(passwordLabel);
		center2.add(passwordText);
		center2.add(emailLabel);
		center2.add(emailText);
		center2.add(p1Label);
		center2.add(pCombo1);
		center2.add(p2Label);
		center2.add(pCombo2);
		center2.add(p3Label);
		center2.add(pCombo3);
		center2.add(firstNameLabel);
		center2.add(firstNameText);
		center2.add(lastNameLabel);
		center2.add(lastNameText);
		center2.add(sexLabel);
		center2.add(sexType);
		center2.add(phoneNumberLabel);
		center2.add(phoneNumberText);
		east2.add(Box.createVerticalStrut(380));
		east2.add(changeButton);
		south2.add(labelForPosts);
		center.add(center2, BorderLayout.CENTER); //adds at the center and main panel with BorderLayout 
		center.add(south2, BorderLayout.SOUTH);
		center.add(east2, BorderLayout.EAST);
		center.add(west2, BorderLayout.WEST);
		panel.add(west, BorderLayout.WEST);
		panel.add(center, BorderLayout.CENTER);
	}
	/** 
	* Creates south panel and other sub-south panels, black line borders,
	* gives size to them, adds sub-panel to south and ,finally, 
	* adds south to the main panel
	* @param col a colour that will be user to set the background color for 
	* southwest and southeast panel
	*/
	public void southSetup(Color col) {
		p.setBorder(BorderFactory.createLineBorder(Color.black));
		south = new JPanel(new BorderLayout(0, 5));
		south.setPreferredSize(new Dimension(780, 250));
		southCenter = new JPanel(); // creation of subpanels
		southEast = new JPanel();
		southWest = new JPanel();
		southEast.setPreferredSize(new Dimension(135, 680));
		southWest.setPreferredSize(new Dimension(135, 680));
		southWest.setBackground(col);
		southEast.setBackground(col);
		southCenter.add(p);
		southEast.setBorder(BorderFactory.createLineBorder(Color.black)); //black line border
		southWest.setBorder(BorderFactory.createLineBorder(Color.black));
		south.add(southCenter, BorderLayout.CENTER);
		south.add(southEast, BorderLayout.EAST);
		south.add(southWest, BorderLayout.WEST);
		south.setBackground(Color.black);
		panel.add(south, BorderLayout.SOUTH);
	}
	/** 
	* Creates the scrollbar, so user can scroll through his posts in myProfile.
	* Also, sets the color of the scrollabar black and add it to the south panel
	*/
	public void scrollbarSetup() {
		JScrollPane scrollbar = new JScrollPane(p, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollbar.getVerticalScrollBar().setUnitIncrement(12);
		scrollbar.getVerticalScrollBar().setBackground(Color.BLACK);
		scrollbar.getVerticalScrollBar().setPreferredSize(new Dimension(8, 695));
		south.add(scrollbar);
	}
	/** 
	* 
	* Creates the dark theme, light theme and custom theme feature of the app.
	* Uses JRadiobuttonw so that only one optin can be picked at any time
	* @param col is the background color for the starting theme 
	*/
	public void eastPanelSetup(Color col) {
		east.setLayout(new GridLayout(10, 1));
		east.setBackground(col);
		east.setPreferredSize(new Dimension(160, 680));
		darkMode = new JRadioButton("Dark Mode", false);
		lightMode = new JRadioButton("Light Mode", false);
		plainMode = new JRadioButton("Plain Mode", true);
		colorPick = new JRadioButton("Other", iconColorChooser, false);
		darkMode.setBackground(Color.DARK_GRAY);
		lightMode.setBackground(Color.WHITE);
		plainMode.setBackground(new Color(255,102,0));
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
	/** 
	* Uses a counter and a query to calculate how many are the total posts
	* the user has made while using the app
	* @param user1 data of the user
	* @return the number of posts the user has done
	*/
	public int getMessageCount(User user1) {
		int count = 0;
		String url = "jdbc:sqlite:socialmedia.db";
		try {
			// New Connection
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();
			// Get posts from the database
			String query = "SELECT User.username, Post.text, Post.uploaddate, Post.likes, Post.Category FROM Post, User WHERE User.username = '"
			+ user1.getUsername() + "' AND Post.UserId = User.UserId";
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
	/**
	* changes the color of the background to the one that user gave
	* @param c color to be used
	*/
	public void setColor(Color c) {
		currentColor = c;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == changeButton) { // make TextArea editable and create submit button
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
			sumbitButton.setVisible(true);
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
			firstNameLabel.setForeground(Color.white);
			lastNameLabel.setForeground(Color.white);
			phoneNumberLabel.setForeground(Color.white);
			labelForPosts.setForeground(Color.white);
			labelForPosts.setIcon(diary2);
			setColor(Color.DARK_GRAY);
			if (Menu.flagColor == false) {
				LoginPage.ex.applyColors(0);
				LoginPage.hp.applyColors(0);
			} else {
				menu.applyColors(0);
			}
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
			firstNameLabel.setForeground(Color.black);
			lastNameLabel.setForeground(Color.black);				
			phoneNumberLabel.setForeground(Color.black);
			labelForPosts.setForeground(Color.black);
			labelForPosts.setIcon(diary);
			setColor(Color.white);
			if (Menu.flagColor == false) {
				LoginPage.ex.applyColors(1);
				LoginPage.hp.applyColors(1);
			} else {
				menu.applyColors(1);
			}
		} else if (e.getSource() == plainMode) {
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
			firstNameLabel.setForeground(Color.black);
			lastNameLabel.setForeground(Color.black);
			phoneNumberLabel.setForeground(Color.black);
			labelForPosts.setForeground(Color.black);
			labelForPosts.setIcon(diary);
			setColor(col);
			if (Menu.flagColor == false) {
				LoginPage.ex.applyColors(2);
				LoginPage.hp.applyColors(2);
			} else {
				menu.applyColors(2);
			}
		} else if (e.getSource() == colorPick) {
			col2 = JColorChooser.showDialog(frame, "Pick a color!", col2);
			panel.setBackground(col2);
			east.setBackground(col2);
			west.setBackground(col2);
			south.setBackground(col2);
			center2.setBackground(col2);
			south2.setBackground(col2);
			east2.setBackground(col2);
			west2.setBackground(col2);
			southCenter.setBackground(col2);
			southWest.setBackground(col2);
			southEast.setBackground(col2);
			labelForPosts.setIcon(diary);
			setColor(col2);
			if (Menu.flagColor == false) {
				LoginPage.ex.applyColors(3);
				LoginPage.hp.applyColors(3);
			} else {
				menu.applyColors(3);
			}
		}
		if (e.getSource() == logoutButton) {
			int input = JOptionPane.showOptionDialog(null, "Are you sure you want to logout?", null,
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
			if (input == JOptionPane.OK_OPTION) {
				LoginPage lp = new LoginPage();
				Menu.myProf.dispose();
				if (Menu.countH == 0) {
					Menu.home.dispose();
				} else {
					lp.getHome().dispose();
				}				
				if (Menu.countEx == 0) {
					Menu.expl.dispose();
				} else {
					lp.getExplore().dispose();
				}
				Menu.countH = 1;
				Menu.countEx = 1;
				Menu.countPr = 1;
				Menu.current = 0;
				lp.loginPage();
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == sumbitButton) {
			this.sumbit(user1);
			setValuesInTextAreas();
			dial.setSize(480, 370);
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
			sumbitButton.setVisible(false);
		}
		if (e.getSource() == dialBut) {
			dial.dispose();
			changeButton.setVisible(true);
			setFieldsUneditable();
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
}
