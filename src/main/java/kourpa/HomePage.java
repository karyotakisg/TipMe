package kourpa;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class HomePage {
	private final User user = new User();
	private int postid;
	private final JFrame frame = new JFrame();
	private final JPanel feed = new JPanel();
	private final JPanel east = new JPanel();
	private final JPanel west = new JPanel();
	private final JPanel south = new JPanel();
	private final JPanel center = new JPanel();
	
	HomePage() {}

	HomePage(User u) {
		frame.setResizable(false);
		frame.setTitle("GetTip");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setBounds(180, 50, 1100, 750);

		frame.setBackground(Color.BLACK);

		feed.setLayout(new BorderLayout(2, 2));
		feed.setBackground(Color.BLACK);
		feed.setBorder(new RoundedBorder(10));

		Menu MenuBar = new Menu();
		east.setLayout(new GridLayout(5, 1, 0, 0));
		west.setLayout(new GridLayout(5, 1, 10, 10));
		center.setLayout(new GridLayout(getMessageCount(), 1, 7, 3));


		south.setBackground(new Color(255, 102, 0));
		east.setBackground(new Color(255, 102, 0));
		west.setBackground(new Color(255, 102, 0));
		center.setBackground(Color.BLACK);

		MenuBar.setPreferredSize(new Dimension(200, 50));
		south.setPreferredSize(new Dimension(200, 5));
		east.setPreferredSize(new Dimension(135, 200));
		west.setPreferredSize(new Dimension(135, 200));


		getDecorations();
		getDataBasePosts(u);
		frame.add(feed);
		feed.add(MenuBar, BorderLayout.NORTH);
		feed.add(south, BorderLayout.SOUTH);
		feed.add(center, BorderLayout.CENTER);
		feed.add(west, BorderLayout.WEST);
		feed.add(east, BorderLayout.EAST);
		feed.add(getScroll(center), BorderLayout.CENTER);
		
		frame.setVisible(true);
	}

	// necessary method in order to dispose the correct frame when clicking on the menu buttons
	public final JFrame getMainFrame() {
		return frame;
	}
	
	//ScrollPane generator
	public JScrollPane getScroll(JPanel central) {
		JScrollPane scr = new JScrollPane(central, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scr.getVerticalScrollBar().setUnitIncrement(12);
		scr.getVerticalScrollBar().setBackground(Color.BLACK);
		scr.getVerticalScrollBar().setPreferredSize(new Dimension(8, 695));
		return scr;
	}
	
	//gets the posts from SQL and places them in the central panel
	public void  getDataBasePosts(User u) {
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
				JPanel eastern = new JPanel();
				post.setBackground(Color.black);
				post.add(getNorthLabel(rs.getString("username"), rs.getString("uploaddate"), rs.getString("Category")),
					BorderLayout.NORTH);
				post.add(eastern, BorderLayout.EAST);
				post.add(getMessageText(rs.getString("text")), BorderLayout.CENTER);
				post.add(getSouthLike(rs.getString("text"), center, post), BorderLayout.SOUTH);
				postid = rs.getInt("PostId");
				center.add(post);
			}
		} catch (SQLException s) {
			System.out.println("Error");
			s.printStackTrace();
		}
	
	}
	
	//places the decorating images in the eastern and the western panel
	public void getDecorations() {
		ImageIcon iconSports = new ImageIcon("src\\main\\resources\\sports3.png");
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
	
	//The message is divided into 3 components: 
	//The label (user name, date, category), the text of the message and the panel for the buttons (like, dislike, copy, delete)
	
	//This is the code for the label panel which uses the data from SQL through arguments
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
	
	//This is the main part of the post, the general text (also uses SQL similarly)
	public JTextArea getMessageText(String text) {
		Font fontMessage = new Font("KodchiangUPC", Font.BOLD, 18);

		JTextArea postMessage = new JTextArea();
		postMessage.setText(" " + text );
		postMessage.setLineWrap(true);
		postMessage.setWrapStyleWord(true);
		postMessage.setBackground(new Color(246, 246, 246));
		postMessage.setBorder(BorderFactory.createRaisedBevelBorder());
		postMessage.setEditable(false);
		postMessage.setFont(fontMessage);
		postMessage.setForeground(Color.BLACK);
		return postMessage;
	}
	
	//this is where we get the southern panel of the post which contains the buttons
	public JPanel getSouthLike(String text, JPanel center, JPanel post) {
		Font fontLike = new Font("Calibri", Font.PLAIN, 5);
		JPanel southLike = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		// showcase the like button

		//Post p = new Post();
		//p.getLikeButton(postid);
		//p.getDislikeButton(postid);
		
		
		ImageIcon likeB = new ImageIcon("src\\main\\resources\\like.png");
		JButton like = new JButton(likeB);
		like.setFont(fontLike);
		like.setBorder(BorderFactory.createLineBorder(Color.black));
		like.setPreferredSize(new Dimension(80, 30));
		like.setBackground(new Color(246, 246, 246));
		like.setForeground(Color.WHITE);
		like.setFocusable(false);

		ImageIcon dislikeB = new ImageIcon("src\\main\\resources\\dislike.png");
		JButton dislike = new JButton(dislikeB);
		dislike.setFont(fontLike);
		dislike.setBorder(BorderFactory.createLineBorder(Color.black));
		dislike.setPreferredSize(new Dimension(80, 30));
		dislike.setBackground(new Color(246, 246, 246));
		dislike.setForeground(Color.WHITE);
		dislike.setFocusable(false);
		
		ImageIcon copyIcon = new ImageIcon("src\\main\\resources\\copy.png");
		JButton dots = new JButton(copyIcon);
		dots.setPreferredSize(new Dimension(30, 30));
		dots.setBackground(new Color(246, 246, 246));
		dots.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == dots) {
					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
					StringSelection copyPost = new StringSelection(getMessageText(text).getText());
					clipboard.setContents(copyPost, copyPost);
					JOptionPane.showMessageDialog(null, "TEXTS ARE COPIED!");
				}
			}
		});
		
		ImageIcon deleteB = new ImageIcon("src\\main\\resources\\delete.png");
		JButton delete = new JButton(deleteB);
		delete.setPreferredSize(new Dimension(30, 30));
		delete.setBackground(new Color(246, 246, 246));
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == delete) {
					delete.setBackground(Color.RED);
					int input = JOptionPane.showOptionDialog(null, "Are you sure you want to delete?", null,
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
					if (input == JOptionPane.OK_OPTION) {
						delete.setBackground(new Color(246, 246, 246));
						center.remove(post);
					}
				}
			}
		});
		southLike.setBackground(new Color(243, 243, 243));
		southLike.setPreferredSize(new Dimension(700, 40));
		southLike.setBorder(BorderFactory.createRaisedBevelBorder());

		//southLike.add( p.getLikeButton(postid));
		southLike.add(like);
		southLike.add(Box.createHorizontalStrut(20));
		//southLike.add( p.getDislikeButton(postid));
		southLike.add(dislike);
		southLike.add(Box.createHorizontalStrut(405));
		southLike.add(dots);
		southLike.add(delete);

		return southLike;
	}


	public int getMessageCount() {
		int count = 0;
		String url = "jdbc:sqlite:socialmedia.db";
		try {
			// New Connection
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();

			// Get posts from the database

			String query = "SELECT Text FROM Post, User WHERE Post.userId = User.userId AND (Post.Category = " + "'"
					+ user.getInterest1() + "'" + "COLLATE NOCASE  OR Post.Category = " + "'" + user.getInterest2()
					+ "'" + "COLLATE NOCASE OR Post.Category = " + "'" + user.getInterest3() + "'"
					+ " COLLATE NOCASE);";

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
	
	public Icon getIcon(String categ) {
		if (categ.equals("Sports")) {
			ImageIcon iconSports = new ImageIcon("src\\main\\resources\\sports2.png");
			return iconSports;
		} else if (categ.equals("Education")) {
			ImageIcon iconEdu = new ImageIcon("src\\main\\resources\\academic2.png");
			return iconEdu;
		} else if (categ.equals("Environment")) {
			ImageIcon iconEnvironment = new ImageIcon("src\\main\\resources\\environment2.png");
			return iconEnvironment;
		} else if (categ.equals("Fashion")) {
			ImageIcon iconFashion = new ImageIcon("src\\main\\resources\\fashion2.png");
			return iconFashion;
		} else if (categ.equals("Science")) {
			ImageIcon iconScience = new ImageIcon("src\\main\\resources\\science2.png");
			return iconScience;
		} else if (categ.equals("Art")) {
			ImageIcon iconArt = new ImageIcon("src\\main\\resources\\art2.png");
			return iconArt;
		} else if (categ.equals("Food")) {
			ImageIcon iconFood = new ImageIcon("src\\main\\resources\\food2.png");
			return iconFood;
		} else if (categ.equals("Travel")) {
			ImageIcon iconTravel = new ImageIcon("src\\main\\resources\\travel2.png");
			return iconTravel;
		} else if (categ.equals("Fitness")) {
			ImageIcon iconFit = new ImageIcon("src\\main\\resources\\fitness2.png");
			return iconFit;
		} else if (categ.equals("Music")) {
			ImageIcon iconMusic = new ImageIcon("src\\main\\resources\\music2.png");
			return iconMusic;
		} else {
			return null;
		}
	}

	public Color getCategoryColor(String categ) {
		if (categ.equals("Sports")) {
			return new Color(0, 102, 204);
		} else if (categ.equals("Education")) {
			return new Color(255, 204, 0);
		} else if (categ.equals("Environment")) {
			return new Color(0, 153, 51);
		} else if (categ.equals("Fashion")) {
			return new Color(198, 78, 126);
		} else if (categ.equals("Science")) {
			return new Color(30, 25, 98);
		} else if (categ.equals("Art")) {
			return new Color(204, 0, 51);
		} else if (categ.equals("Food")) {
			return new Color(153, 51, 0);
		} else if (categ.equals("Travel")) {
			return new Color(235, 250, 255);
		} else if (categ.equals("Fitness")) {
			return new Color(101, 253, 208);
		} else if (categ.equals("Music")) {
			return new Color(240, 131, 189);
		} else {
			return null;
		}
	}

    private static class RoundedBorder implements Border {
		private int radius;
		RoundedBorder(int radius) {
			this.radius = radius;
		}

		@Override
		public Insets getBorderInsets(Component c) {
			return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
		}

		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {}

		@Override
		public boolean isBorderOpaque() {
			return true;
		}
	}
}
