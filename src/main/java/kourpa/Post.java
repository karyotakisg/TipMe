package kourpa;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import javax.swing.Timer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

//import java.util.HashMap;

public class Post {
	// String jdbcUrl = "jdbc:sqlite:socialmedia.db" ;
	private Color col1 = new Color(246, 246, 246);
	private Color col2 = new Color(246, 246, 246);
	private boolean flag = false;
	private int likes;
	private int dislikes; // SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
	Date now = new Date();
	String strDate = sdfDate.format(now);
	User user = new User();

	// αποθήκευση ποστ στην βαση με στοιχεια όνομα, κατηγορία, κείμενο -- void

	public void storePost(String tip, String categ) {
		String jdbcUrl = "jdbc:sqlite:socialmedia.db";
		try {
			Connection conn = DriverManager.getConnection(jdbcUrl);
			Statement statement = conn.createStatement();

			System.out.println("Connected");

			/*
			 * String query = "INSERT INTO Post(Text, " + "Category, " + "UploadDate)" +
			 * " VALUES(" + "'" + up.getTip() + "'" + "," + "'" + up.getCateg() + "'" + ","
			 * + "'" + strDate + "'" + ");";
			 * 
			 */
			String query = "INSERT INTO Post(Text, " + "Category, " + "UploadDate, " + "Likes, " + "UserId)"
					+ " VALUES(" + "'" + tip + "'" + "," + "'" + categ + "'" + "," + "'" + strDate + "'" + "," + "'" + 0
					+ "'" + "," + "'" + 5 + "'" + ");";

			statement.executeUpdate(query);

			conn.close();
		} catch (SQLException s) {
			System.out.println("Failed to connect and save post");
			s.printStackTrace();
		} catch (NullPointerException s) {
			System.out.println("NullPointerException");
		}
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getLikes() {
		return likes;
	}

	public JButton getLikeButton(int postid) {

		Font fontLike = new Font("Serif", Font.BOLD, 15);
		ImageIcon icon = new ImageIcon("src\\main\\resources\\like.png");

		// likeButton.setBounds(250, 20, 60, 30);

		JButton like = new JButton("0", icon);
		like.setBackground(col1);

		like.addActionListener(new ActionListener() {
			String query;
			String jdbcUrl = "jdbc:sqlite:socialmedia.db";

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == like && like.getBackground() == col1 && getDislikeButton(postid).getBackground() == col2 && flag == false) {
					// TODO Auto-generated method stub
					query = "UPDATE Post SET Likes = Likes+1 WHERE PostId =" + postid;
					col1 = Color.green;
					like.setBackground(col1);
					likes = getLikeCount(postid);
					likes++;
					like.setText(String.valueOf(likes));
					getLikeButton(postid).setBackground(Color.white);
					flag = true;
				} else if (e.getSource() == like && like.getBackground() == Color.green) {
					query = "UPDATE Post SET Likes = Likes-1 WHERE PostId =" + postid;
					col1 = new Color(246, 246, 246);
					like.setBackground(col1);
					likes = getLikeCount(postid);
					if (likes > 0) {
						likes--;
					} else {
						likes = 0;
					}
					like.setText(String.valueOf(likes));
					flag = false;
				} else {
					int input = JOptionPane.showOptionDialog(null,
							"Remove your dislike first (click again on the dislike button)", "Help message",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
					query = "SELECT Likes FROM Post";
				}

				try {
					Connection conn = DriverManager.getConnection(jdbcUrl);
					Statement statement = conn.createStatement();
					statement.executeUpdate(query);

					conn.close();
				} catch (SQLException s) {
					// TODO Auto-generated catch block
					System.out.println("Failed to connect and get the number of likes");
					s.printStackTrace();
				}

			}
		});

		like.setFont(fontLike);
		like.setPreferredSize(new Dimension(100, 30));
		like.setFocusable(false);

		return like;
	}

	public JButton getDislikeButton(int postid) {
		Font fontdisLike = new Font("Serif", Font.BOLD, 15);
		ImageIcon icon = new ImageIcon("src\\main\\resources\\dislike.png");

		// likeButton.setBounds(250, 20, 60, 30);

		JButton dislike = new JButton("0", icon);
		dislike.setBackground(col2);
	
		dislike.addActionListener(new ActionListener() {
			String query;
			String jdbcUrl = "jdbc:sqlite:socialmedia.db";

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == dislike && dislike.getBackground() == col2 && getLikeButton(postid).getBackground() == col1 && flag == false) {
					// TODO Auto-generated method stub
					query = "UPDATE Post SET dislikes = dislikes + 1 WHERE PostId =" + postid;
					col2 = Color.red;
					dislike.setBackground(col2);
					dislikes = getDislikeCount(postid);
					dislikes++;
					dislike.setText(String.valueOf(dislikes));
					flag = true;
				} else if (e.getSource() == dislike && dislike.getBackground() == Color.red) {
					query = "UPDATE Post SET dislikes = dislikes - 1 WHERE PostId =" + postid;
					col2 = new Color(246, 246, 246);
					dislike.setBackground(col2);
					dislikes = getDislikeCount(postid);
					if (dislikes > 0) {
						dislikes--;
					} else {
						dislikes = 0;
					}
					dislike.setText(String.valueOf(dislikes));
					flag = false;
				} else {
					int input = JOptionPane.showOptionDialog(null,
							"Remove your like first (click again on the like button)", "Help message",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
					query = "SELECT Dislikes FROM Post";
				}

				try {
					Connection conn = DriverManager.getConnection(jdbcUrl);
					Statement statement = conn.createStatement();
					statement.executeUpdate(query);

					conn.close();
				} catch (SQLException s) {
					// TODO Auto-generated catch block
					System.out.println("Failed to connect and get the number of likes");
					s.printStackTrace();

				}
			}

		});
		dislike.setFont(fontdisLike);
		dislike.setPreferredSize(new Dimension(100, 30));
		dislike.setFocusable(false);

		return dislike;

	}

	public int getLikeCount(int postid) {
		int count = 0;
		String url = "jdbc:sqlite:socialmedia.db";
		try {
			// New Connection
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();

			// Get posts from the database
			String query = "SELECT Likes FROM Post WHERE PostId =" + postid;

			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				count = rs.getInt("Likes");
			}
			conn.close();
		} catch (SQLException s) {
			System.out.println("Error");
			s.printStackTrace();
		}
		return count;
	}

	public int getDislikeCount(int postid) {
		int count = 0;
		String url = "jdbc:sqlite:socialmedia.db";
		try {
			// New Connection
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();

			// Get posts from the database
			String query = "SELECT Dislikes FROM Post WHERE PostId =" + postid;

			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				count = rs.getInt("Dislikes");
			}
			conn.close();
		} catch (SQLException s) {
			System.out.println("Error");
			s.printStackTrace();
		}
		return count;
	}
}