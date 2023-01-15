package kourpa;

import javax.swing.JFrame;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class HomePage {

	private User user = new User();
	private int deletedMessagesCount = 0;
	ImageIcon logo = new ImageIcon("src\\main\\resources\\logo.png");
	private int count = 0;
	// private static final JFrame frame = new JFrame();
	private JFrame frame = new JFrame();
	private static JPanel feed = new JPanel();
	private JPanel east;
	private JPanel west;
	private JPanel south;
	private JPanel center;

	public HomePage(User u) {
		this.user = u;
		//System.out.println(u.getUserId());
	}
	
	public JFrame homePage(User u, Color col) {
		frame.setTitle("GetTip");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setBounds(180, 50, 1050, 750);
		Image i = Toolkit.getDefaultToolkit().getImage("src\\main\\resources\\logo.png");
		frame.setIconImage(i);
		frame.setBackground(Color.BLACK);
		feed.setLayout(new BorderLayout(2, 2));
		feed.setBackground(Color.BLACK);
		// feed.setBorder(new RoundedBorder(10));
		center = new JPanel();
		east = new JPanel();
		west = new JPanel();
		south = new JPanel();
		east.setLayout(new GridLayout(5, 1, 0, 0));
		west.setLayout(new GridLayout(5, 1, 10, 10));
		center.setLayout(new GridLayout(getMessageCount(), 1, 7, 3));
		south.setBackground(col);
		east.setBackground(col);
		west.setBackground(col);
		center.setBackground(Color.BLACK);
		south.setPreferredSize(new Dimension(1050, 20));
		east.setPreferredSize(new Dimension(135, 680));
		west.setPreferredSize(new Dimension(135, 680));
		getDecorations();
		getDataBasePosts(u, center, frame);
		// logoutButtonSetup();
		feed.add(south, BorderLayout.SOUTH);
		feed.add(center, BorderLayout.CENTER);
		feed.add(west, BorderLayout.WEST);
		feed.add(east, BorderLayout.EAST);
		feed.add(getScroll(center), BorderLayout.CENTER);
		Menu menu = new Menu();
		feed.add(menu.menuBar(u, col), BorderLayout.NORTH);
		frame.add(feed);
		return frame;
	}

	// necessary method in order to dispose the correct panel when clicking on the
	// menu buttons
	// ScrollPane generator
	public JScrollPane getScroll(JPanel central) {
		JScrollPane scr = new JScrollPane(central, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scr.getVerticalScrollBar().setUnitIncrement(11);
		scr.getVerticalScrollBar().setBackground(Color.BLACK);
		scr.getVerticalScrollBar().setPreferredSize(new Dimension(8, 695));
		return scr;
	}

	// gets the posts from SQL and places them in the central panel
	public void getDataBasePosts(User u, JPanel center, JFrame frame) {
		// SQLite connection URL
		String jdbcUrl = "jdbc:sqlite:socialmedia.db";
		try {
			// Creating a new Connection
			Connection conn = DriverManager.getConnection(jdbcUrl);
			Statement statement = conn.createStatement();
			// System.out.println("Connected");
			// Get the right posts from the database
			String query = "SELECT Post.PostId, User.username, Post.text, Post.uploaddate, Post.likes, Post.Category FROM Post, User WHERE Post.userId = User.userId AND (Post.Category = "
					+ "'" + u.getInterest1() + "'" + "COLLATE NOCASE  OR Post.Category = " + "'" + u.getInterest2()
					+ "'" + "COLLATE NOCASE OR Post.Category = " + "'" + u.getInterest3() + "'"
					+ "COLLATE NOCASE) ORDER BY uploadDate DESC;";
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				JPanel post = new JPanel(new BorderLayout(1, 1));
				count++;
				JPanel eastern = new JPanel();
				post.setBackground(Color.black);
				post.add(getNorthLabel(rs.getString("username"), rs.getString("uploaddate"), rs.getString("Category")),
						BorderLayout.NORTH);
				post.add(eastern, BorderLayout.EAST);
				post.add(getMessageText(rs.getString("text")), BorderLayout.CENTER);
				post.add(getSouthLike(rs.getString("text"), center, post, frame, rs.getInt("PostId")),
						BorderLayout.SOUTH);
				Post p = new Post(u);
				p.getLikeCount(rs.getInt("PostId"));
				p.getDislikeCount(rs.getInt("PostId"));
				center.add(post);
			}
			System.out.print(count);
		} catch (SQLException s) {
			System.out.println("Error");
			s.printStackTrace();
		}
	}

	// The message is divided into 3 components:
	// The label (user name, date, category), the text of the message and the panel
	// for the buttons (like, dislike, copy, delete)
	// This is the code for the label panel which uses the data from SQL through
	// arguments
	public JPanel getNorthLabel(String usernm, String upldate, String category) {
		Font fontUsername = new Font("KodchiangUPC", Font.BOLD, 18);
		Font fontDate = new Font("KodchiangUPC", Font.BOLD, 15);
		Font fontCateg = new Font("KodchiangUPC", Font.BOLD, 18);
		JPanel northLabel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel username = new JLabel(usernm);
		username.setFont(fontUsername);
		username.setForeground(Color.white);
		JLabel uploaddate = new JLabel(upldate);
		uploaddate.setFont(fontDate);
		uploaddate.setForeground(Color.white);
		JLabel categ = new JLabel(category);
		categ.setFont(fontCateg);
		categ.setForeground(Color.white);
		JLabel iconic = new JLabel(getIcon(category));
		northLabel.setPreferredSize(new Dimension(700, 35));
		northLabel.setBackground(getCategoryColor(category));
		northLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		northLabel.add(username);
		northLabel.add(Box.createHorizontalStrut(30));
		northLabel.add(uploaddate);
		northLabel.add(Box.createHorizontalStrut(30));
		northLabel.add(categ);
		northLabel.add(Box.createHorizontalStrut(30));
		northLabel.add(iconic);
		return northLabel;
	}

	// This is the main part of the post, the general text (also uses SQL similarly)
	public JTextArea getMessageText(String text) {
		Font fontMessage = new Font("KodchiangUPC", Font.BOLD, 18);
		JTextArea postMessage = new JTextArea();
		postMessage.setText(" " + text + '\n');
		postMessage.setLineWrap(true);
		postMessage.setWrapStyleWord(true);
		postMessage.setBackground(new Color(246, 246, 246));
		postMessage.setBorder(BorderFactory.createRaisedBevelBorder());
		postMessage.setEditable(false);
		postMessage.setFont(fontMessage);
		postMessage.setForeground(Color.BLACK);
		return postMessage;
	}

	// this is where we get the southern panel of the post which contains the
	// buttons
	public JPanel getSouthLike(String text, JPanel center, JPanel post, JFrame frame, int postid) {
		JPanel southLike = new JPanel(new FlowLayout(FlowLayout.LEFT));
		User u = new User();
		Post p = new Post(u);
		southLike.setBackground(new Color(243, 243, 243));
		southLike.setPreferredSize(new Dimension(700, 40));
		southLike.setBorder(BorderFactory.createRaisedBevelBorder());
		southLike.add(p.getLikeButton(postid, user.getUserId()));
		southLike.add(Box.createHorizontalStrut(20));
		southLike.add(p.getDislikeButton(postid));
		southLike.add(Box.createHorizontalStrut(395));
		southLike.add(getCopyButton(text, post));
		southLike.add(getTemporaryDeleteButton(post, center, frame, postid));
		return southLike;
	}

	public JPanel getSouthLike2(String text, JPanel center, JPanel post, int postid) {
		JPanel southLike = new JPanel(new FlowLayout(FlowLayout.LEFT));
		User u = new User();
		Post p = new Post(u);
		southLike.setBackground(new Color(243, 243, 243));
		southLike.setPreferredSize(new Dimension(700, 40));
		southLike.setBorder(BorderFactory.createRaisedBevelBorder());
		southLike.add(p.getLikeButton(postid, user.getUserId()));
		southLike.add(Box.createHorizontalStrut(20));
		southLike.add(p.getDislikeButton(postid));
		southLike.add(Box.createHorizontalStrut(425));
		southLike.add(getCopyButton(text, post));
		return southLike;
	}

	public JButton getCopyButton(String text, JPanel post) {
		ImageIcon copyIcon = new ImageIcon("src\\main\\resources\\copy.png");
		JButton copy = new JButton(copyIcon);
		copy.setBounds(495, 345, 30, 30);
		copy.setBackground(new Color(246, 246, 246));
		copy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == copy) {
					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
					StringSelection copyPost = new StringSelection(getMessageText(text).getText());
					clipboard.setContents(copyPost, copyPost);
					JOptionPane.showMessageDialog(null, "TEXTS ARE COPIED!");
				}
			}
		});
		return copy;
	}

	public JButton getTemporaryDeleteButton(JPanel post, JPanel center, JFrame frame, int postid) {
		ImageIcon deleteB = new ImageIcon("src\\main\\resources\\visible.png");
		JButton delete = new JButton(deleteB);
		JPanel backup = new JPanel();
		backup.setBackground(Color.black);
		backup.setPreferredSize(post.getSize());
		JPanel nothing = new JPanel(new FlowLayout(FlowLayout.CENTER));
		nothing.setBackground(Color.black);
		nothing.setPreferredSize(post.getSize());
		ImageIcon sadness = new ImageIcon("src\\main\\resources\\empty.png");
		JLabel nothingLeft = new JLabel(sadness);
		nothing.add(nothingLeft);
		delete.setPreferredSize(new Dimension(30, 30));
		delete.setBackground(new Color(246, 246, 246));
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == delete) {
					delete.setBackground(Color.yellow);
					int input = JOptionPane.showOptionDialog(null, "Are you sure you want to hide it?", null,
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
					if (input == JOptionPane.OK_OPTION) {
						delete.setBackground(new Color(246, 246, 246));
						deletedMessagesCount++;
						if (count - deletedMessagesCount == 0) {
							center.remove(post);
							center.add(nothing);
						} else if (center.getSize().height <= 680) {
							center.remove(post);
							center.add(backup);
						} else {
							center.remove(post);
						}
						frame.revalidate();
					} else {
						delete.setBackground(new Color(246, 246, 246));
					}
				}
			}
		});
		return delete;
	}

	public int getMessageCount() {
		int count = 0;
		String url = "jdbc:sqlite:socialmedia.db";
		try {
			// New Connection
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();
			// Get posts from the database
			String query = "SELECT Post.PostId FROM Post, User WHERE Post.userId = User.userId AND (Post.Category = "
					+ "'" + user.getInterest1() + "'" + "COLLATE NOCASE  OR Post.Category = " + "'"
					+ user.getInterest2() + "'" + "COLLATE NOCASE OR Post.Category = " + "'" + user.getInterest3() + "'"
					+ " COLLATE NOCASE);";
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				count++;// count the number of posts
			}
			conn.close();
		} catch (SQLException s) {
			System.out.println("Error");
			s.printStackTrace();
		}
		return count;
	}

	// places the decorating images in the eastern and the western panel
	public final void getDecorations() {
		ImageIcon iconSports = new ImageIcon("src\\main\\resources\\balls-sports.png");
		JLabel sports = new JLabel(iconSports);
		west.add(sports);
		ImageIcon iconFashion = new ImageIcon("src\\main\\resources\\dress.png");
		JLabel fashion = new JLabel(iconFashion);
		west.add(fashion);
		ImageIcon iconScience = new ImageIcon("src\\main\\resources\\molecule.png");
		JLabel science = new JLabel(iconScience);
		west.add(science);
		ImageIcon iconMusic = new ImageIcon("src\\main\\resources\\music.png");
		JLabel music = new JLabel(iconMusic);
		east.add(music);
		ImageIcon iconArt = new ImageIcon("src\\main\\resources\\paint.png");
		JLabel art = new JLabel(iconArt);
		east.add(art);
		ImageIcon iconTravel = new ImageIcon("src\\main\\resources\\airplane.png");
		JLabel travel = new JLabel(iconTravel);
		east.add(travel);
		ImageIcon iconEdu = new ImageIcon("src\\main\\resources\\education.png");
		JLabel academic = new JLabel(iconEdu);
		west.add(academic);
		ImageIcon iconFit = new ImageIcon("src\\main\\resources\\armmuscle.png");
		JLabel fitness = new JLabel(iconFit);
		east.add(fitness);
		ImageIcon iconEnvironment = new ImageIcon("src\\main\\resources\\envir.png");
		JLabel environment = new JLabel(iconEnvironment);
		west.add(environment);
		ImageIcon iconFood = new ImageIcon("src\\main\\resources\\restaurant.png");
		JLabel food = new JLabel(iconFood);
		east.add(food);
	}

	public static Icon getIcon(String categ) {
		if (categ.equalsIgnoreCase("Sports")) {
			ImageIcon iconSports = new ImageIcon("src\\main\\resources\\sports3.png");
			return iconSports;
		} else if (categ.equalsIgnoreCase("Education")) {
			ImageIcon iconEdu = new ImageIcon("src\\main\\resources\\scholarship.png");
			return iconEdu;
		} else if (categ.equalsIgnoreCase("Nature")) {
			ImageIcon iconEnvironment = new ImageIcon("src\\main\\resources\\environment2.png");
			return iconEnvironment;
		} else if (categ.equalsIgnoreCase("Fashion")) {
			ImageIcon iconFashion = new ImageIcon("src\\main\\resources\\search.png");
			return iconFashion;
		} else if (categ.equalsIgnoreCase("Science")) {
			ImageIcon iconScience = new ImageIcon("src\\main\\resources\\science.png");
			return iconScience;
		} else if (categ.equalsIgnoreCase("ART")) {
			ImageIcon iconArt = new ImageIcon("src\\main\\resources\\art2.png");
			return iconArt;
		} else if (categ.equalsIgnoreCase("Food")) {
			ImageIcon iconFood = new ImageIcon("src\\main\\resources\\burger.png");
			return iconFood;
		} else if (categ.equalsIgnoreCase("Travel")) {
			ImageIcon iconTravel = new ImageIcon("src\\main\\resources\\passport.png");
			return iconTravel;
		} else if (categ.equalsIgnoreCase("Fitness")) {
			ImageIcon iconFit = new ImageIcon("src\\main\\resources\\barbell.png");
			return iconFit;
		} else if (categ.equalsIgnoreCase("Music")) {
			ImageIcon iconMusic = new ImageIcon("src\\main\\resources\\music2.png");
			return iconMusic;
		} else {
			return null;
		}
	}

	public static Color getCategoryColor(String categ) {
		if (categ.equalsIgnoreCase("Sports")) {
			final Color c1 = new Color(0, 102, 204);
			return c1;
		} else if (categ.equalsIgnoreCase("Education")) {
			final Color c2 = new Color(255, 204, 0);
			return c2;
		} else if (categ.equalsIgnoreCase("Nature")) {
			final Color c3 = new Color(0, 153, 51);
			return c3;
		} else if (categ.equalsIgnoreCase("Fashion")) {
			final Color c4 = new Color(198, 78, 126);
			return c4;
		} else if (categ.equalsIgnoreCase("Science")) {
			final Color c5 = new Color(30, 25, 98);
			return c5;
		} else if (categ.equalsIgnoreCase("Art")) {
			final Color c6 = new Color(204, 0, 51);
			return c6;
		} else if (categ.equalsIgnoreCase("Food")) {
			final Color c7 = new Color(153, 51, 0);
			return c7;
		} else if (categ.equalsIgnoreCase("Travel")) {
			final Color c8 = new Color(0, 204, 153);
			return c8;
		} else if (categ.equalsIgnoreCase("Fitness")) {
			final Color c9 = new Color(101, 253, 208);
			return c9;
		} else if (categ.equalsIgnoreCase("Music")) {
			final Color c10 = new Color(240, 131, 189);
			return c10;
		} else {
			return null;
		}
	}

	public final void applyColors(int c) {
		if (c == 0) {
			east.setBackground(Color.DARK_GRAY);
			west.setBackground(Color.DARK_GRAY);
			south.setBackground(Color.DARK_GRAY);
		} else if (c == 1) {
			east.setBackground(Color.white);
			west.setBackground(Color.white);
			south.setBackground(Color.white);
		} else if (c == 2) {
			east.setBackground(MyProfile.col);
			west.setBackground(MyProfile.col);
			south.setBackground(MyProfile.col);
		} else {
			east.setBackground(MyProfile.col2);
			west.setBackground(MyProfile.col2);
			south.setBackground(MyProfile.col2);
		}
	}
}
