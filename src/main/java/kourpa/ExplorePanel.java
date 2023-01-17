package kourpa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * ExplorePanel class is used to create a new panel with posts if one specific
 * category has been chosen The new panels include all the posts for each
 * category, appropriately customized This class also handles the "Go Back
 * Button"
 * 
 * @author Apostolos Kourpadakis, Panagiotis Theocharis
 *
 */

public class ExplorePanel implements ActionListener {
	String category;
	private static JPanel p0;
	private static JPanel p1;
	private static JPanel p2;
	private static JPanel p3;
	private static JPanel p4;
	private static JPanel p5;
	private static JPanel p6;
	private static JPanel p7;
	private static JScrollPane scr;
	private static JPanel p8;
	private static JPanel p9;
	Icon back = new ImageIcon("src\\main\\resources\\goback.png");
	private JButton goback;
	private HomePage hp = new HomePage();

	public ExplorePanel(int x, JPanel jf, JPanel south, JPanel east, JPanel west) {

		// The back button is created
		goback = new JButton();
		goback.setIcon(back);
		goback.setBackground(Color.black);
		goback.addActionListener(this);

		south.setPreferredSize(new Dimension(200, 50));
		east.setPreferredSize(new Dimension(100, 200));
		west.setPreferredSize(new Dimension(100, 200));

		// Depending on the button pressed
		// The suitable panel will be created
		// The new panels include the messages for each category
		if (x == 0) {
			west.add(goback);
			p0 = new JPanel();
			category = "SCIENCE";
			p0.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
			p0.setBackground(Color.BLACK);
			customizeMessage(category, p0); // Method will customize the message appearance
			jf.add(p0, BorderLayout.CENTER);
			scr = hp.getScroll(p0);
			jf.add(scr, BorderLayout.CENTER);
		} else if (x == 1) {
			west.add(goback);
			p1 = new JPanel();
			category = "Sports";
			p1.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
			p1.setBackground(Color.BLACK);
			customizeMessage(category, p1);
			jf.add(p1, BorderLayout.CENTER);
			scr = hp.getScroll(p1);
			jf.add(scr, BorderLayout.CENTER);
		} else if (x == 2) {
			west.add(goback);
			p2 = new JPanel();
			category = "MUSIC";
			p2.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
			p2.setBackground(Color.BLACK);
			customizeMessage(category, p2);
			jf.add(p2, BorderLayout.CENTER);
			scr = hp.getScroll(p2);
			jf.add(scr, BorderLayout.CENTER);
		} else if (x == 3) {
			west.add(goback);
			p3 = new JPanel();
			category = "FASHION";
			p3.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
			p3.setBackground(Color.BLACK);
			customizeMessage(category, p3);
			jf.add(p3, BorderLayout.CENTER);
			scr = hp.getScroll(p3);
			jf.add(scr, BorderLayout.CENTER);
		} else if (x == 4) {
			west.add(goback);
			p4 = new JPanel();
			category = "TRAVEL";
			p4.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
			p4.setBackground(Color.BLACK);
			customizeMessage(category, p4);
			scr = hp.getScroll(p4);
			jf.add(scr, BorderLayout.CENTER);
		} else if (x == 5) {
			west.add(goback);
			p5 = new JPanel();
			category = "FITNESS";
			p5.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
			p5.setBackground(Color.BLACK);
			customizeMessage(category, p5);
			scr = hp.getScroll(p5);
			jf.add(scr, BorderLayout.CENTER);
		} else if (x == 6) {
			west.add(goback);
			p6 = new JPanel();
			category = "ART";
			p6.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
			p6.setBackground(Color.BLACK);
			customizeMessage(category, p6);
			jf.add(p6, BorderLayout.CENTER);
			scr = hp.getScroll(p6);
			jf.add(scr, BorderLayout.CENTER);
		} else if (x == 7) {
			west.add(goback);
			p7 = new JPanel();
			category = "Education";
			p7.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
			p7.setBackground(Color.BLACK);
			customizeMessage(category, p7);
			jf.add(p7, BorderLayout.CENTER);
			scr = hp.getScroll(p7);
			jf.add(scr, BorderLayout.CENTER);
		} else if (x == 8) {
			west.add(goback);
			p8 = new JPanel();
			category = "NATURE";
			p8.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
			p8.setBackground(Color.BLACK);
			customizeMessage(category, p8);
			jf.add(p8, BorderLayout.CENTER);
			scr = hp.getScroll(p8);
			jf.add(scr, BorderLayout.CENTER);
		} else {
			west.add(goback);
			p9 = new JPanel();
			category = "FOOD";
			p9.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
			p9.setBackground(Color.BLACK);
			customizeMessage(category, p9);
			jf.add(p9, BorderLayout.CENTER);
			scr = hp.getScroll(p9);
			jf.add(scr, BorderLayout.CENTER);
		}
	}

	public int getMessageCount(String category) {
		int count = 0;
		String url = "jdbc:sqlite:socialmedia.db";
		try {
			// New Connection
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();
			// Get posts from the database
			String query = "SELECT User.username, Post.text, Post.uploaddate, Post.likes, Post.Category FROM Post, User WHERE Post.userId = User.userId AND Post.Category = '"
					+ category + "'";
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

	// Method for the go back function
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == goback) {
			if (p0 != null) {
				p0.setVisible(false);
			}
			if (p1 != null) {
				p1.setVisible(false);
			}
			if (p2 != null) {
				p2.setVisible(false);
			}
			if (p3 != null) {
				p3.setVisible(false);
			}
			if (p4 != null) {
				p4.setVisible(false);
			}
			if (p5 != null) {
				p5.setVisible(false);
			}
			if (p6 != null) {
				p6.setVisible(false);
			}
			if (p7 != null) {
				p7.setVisible(false);
			}
			if (p8 != null) {
				p8.setVisible(false);
			}
			if (p9 != null) {
				p9.setVisible(false);
			}
			goback.setVisible(false);
			ExplorePage.visibility();
			scr.setVisible(false);
		}

	}

	// Customize the posts appearance
	public void customizeMessage(String category, JPanel explore) {
		String jdbcUrl = "jdbc:sqlite:socialmedia.db";
		try {
			// Creating a new Connection
			Connection conn = DriverManager.getConnection(jdbcUrl);
			Statement statement = conn.createStatement();
			// System.out.println("Connected");
			// Get the right posts from the database
			String query = "SELECT User.username, Post.text, Post.uploaddate, Post.likes, Post.PostId, "
					+ "Post.Category FROM Post, User WHERE Post.userId = User.userId AND Post.Category = '" + category
					+ "' COLLATE NOCASE ORDER BY Post.UploadDate DESC";
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				HomePage hp = new HomePage();
				JPanel post = new JPanel(new BorderLayout(1, 1));
				JPanel eastern = new JPanel();
				eastern.setBackground(new Color(245, 245, 245));
				post.setBackground(Color.black);
				post.add(hp.getNorthLabel(rs.getString("username"), rs.getString("uploaddate"),
						rs.getString("Category")), BorderLayout.NORTH);
				post.add(eastern, BorderLayout.EAST);
				post.add(hp.getMessageText(rs.getString("text")), BorderLayout.CENTER);
				post.add(hp.getSouthLike2(rs.getString("text"), explore, post, rs.getInt("PostId")),
						BorderLayout.SOUTH);
				Post p = new Post();
				p.getLikeCount(rs.getInt("PostId"));
				p.getDislikeCount(rs.getInt("PostId"));
				// postid = rs.getInt("PostId");
				explore.add(post);
			}
		} catch (SQLException s) {
			System.out.println("Error");
			s.printStackTrace();
		}
	}

}
