package kourpa;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class Post {

	private Color col1 = new Color(246, 246, 246);
	private Color col2 = new Color(246, 246, 246);
	private int likes;
	private boolean liked = false;
	private boolean disliked = false;
	private int dislikes;
	// SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
	Date now = new Date();
	String strDate = sdfDate.format(now);
	User userPosted = new User();
	User userConnected = new User();

	//αποθήκευση ποστ στην βαση με στοιχεια όνομα, κατηγορία, κείμενο -- void
	public Post() {
	}

	public Post(User user) {
		this.userPosted = user;
	}

	public void storePost(String tip, String categ) {
		String jdbcUrl = "jdbc:sqlite:socialmedia.db";
		try {
			Connection conn = DriverManager.getConnection(jdbcUrl);
			Statement statement = conn.createStatement();
			//System.out.println("Connected");
			/*
			 * String query = "INSERT INTO Post(Text, " + "Category, " + "UploadDate)" +
			 * " VALUES(" + "'" + up.getTip() + "'" + "," + "'" + up.getCateg() + "'" + ","
			 * + "'" + strDate + "'" + ");";
			 * 
			 */
			String query = "INSERT INTO Post(Text, Category, UploadDate, Likes, UserId, Dislikes)"
					+ " VALUES( '" + tip + "', '" + categ + "', '" + strDate + "', " + 0
					+ ", '" +  userPosted.getUserId()+ "', ' " + 0  + "');";
			statement.executeUpdate(query);
			conn.close();
		} catch (SQLException s) {
			System.out.println("Failed to connect and save post");
			s.printStackTrace();
		} catch (NullPointerException s) {
			System.out.println("NullPointerException");
		}
	}

	public JButton getLikeButton(int postid, int userid) {
		Font fontLike = new Font("Serif", Font.BOLD, 15);
		ImageIcon icon = new ImageIcon("src\\main\\resources\\like.png");
		JButton like = new JButton("" + getLikeCount(postid) + "", icon);
		String jdbcUrl = "jdbc:sqlite:socialmedia.db";
		try {
			String qLikes = "SELECT userid FROM Likes WHERE PostId = " + postid;
			Connection conn = DriverManager.getConnection(jdbcUrl);
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(qLikes);
			// System.out.println(user.getUserId());
			while (rs.next()) {
				//System.out.println(userid + "param");
				//System.out.println(rs.getInt("userid") + "db");
				if (rs.getInt("userid") == userid){
					liked = true;
					//System.out.print("AAAAAAAAAAAAA");
					col1 = Color.green;
					break;
				}
			}
			like.setBackground(col1);
			conn.close();
		} catch (SQLException s) {
			System.out.println("Failed to connect and get the number of likes");
			s.printStackTrace();
		}

		like.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String query = "SELECT Likes FROM Post";
				String qLikes = "SELECT userid FROM Dislikes WHERE PostId = " + postid;
				if (e.getSource() == like && !liked && !disliked) {
					query = "UPDATE Post SET Likes = Likes + 1 WHERE PostId = " + postid;
					qLikes = "INSERT INTO Likes(userid, postid) VALUES(" + userid + ", " + postid + ")";
					col1 = Color.green;
					like.setBackground(col1);
					likes = getLikeCount(postid);
					liked = true;
					likes++;
					like.setText(String.valueOf(likes));
					getLikeButton(postid, userid).setBackground(Color.green);
				} else if (e.getSource() == like && liked && !disliked) {
					query = "UPDATE Post SET Likes = Likes-1 WHERE PostId =" + postid;
					qLikes = "DELETE FROM Likes WHERE postid = " + postid + "  " + "AND userid = " + userid;
					col1 = new Color(246, 246, 246);
					like.setBackground(col1);
					likes = getLikeCount(postid);
					liked = false;
					if (likes < 0) {
						likes = 0;
					} else {
						--likes;
					}
					like.setText(String.valueOf(likes));
				} else if (e.getSource() == like && disliked) {
					@SuppressWarnings("unused")
					int input = JOptionPane.showOptionDialog(null,
							"Remove your dislike first (click again on the dislike button)", "Help message",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
					// query = "SELECT Likes FROM Post";
				}
				try {
					Connection conn = DriverManager.getConnection(jdbcUrl);
					Statement statement = conn.createStatement();
					statement.executeUpdate(query);
					statement.executeUpdate(qLikes);
					conn.close();

				} catch (SQLException s) {
					s.printStackTrace();
				}

			}
		});

		like.setFont(fontLike);
		like.setPreferredSize(new Dimension(100, 30));
		like.setFocusable(false);
		return like;
	}

	public JButton getDislikeButton(int postid, int userid) {
		Font fontdisLike = new Font("Serif", Font.BOLD, 15);
		ImageIcon icon = new ImageIcon("src\\main\\resources\\dislike.png");
		JButton dislike = new JButton("" + getDislikeCount(postid) + "", icon);

		String jdbcUrl = "jdbc:sqlite:socialmedia.db";

		try {
			String qDislikes = "SELECT userid FROM Dislikes WHERE PostId = " + postid;
			Connection conn = DriverManager.getConnection(jdbcUrl);
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(qDislikes);
			// System.out.println(user.getUserId());
			while (rs.next()) {
				if (rs.getInt("userid") == userid) {
					disliked = true;
					col2 = Color.red;
					break;
				}
			}
			dislike.setBackground(col2);
			conn.close();
		} catch (SQLException s) {
			System.out.println("Failed to connect and get the number of likes");
			s.printStackTrace();
		}

		dislike.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String query = "SELECT Dislikes FROM Post";
				String qDislikes = "SELECT userid FROM Dislikes WHERE PostId = " + postid;
				if (e.getSource() == dislike && !disliked && !liked) {
					query = "UPDATE Post SET Dislikes = Dislikes + 1 WHERE PostId = " + postid;
					qDislikes = "INSERT INTO Dislikes(userid, postid) VALUES(" + userid + ", " + postid + ")";
					col2 = Color.red;
					dislike.setBackground(col2);
					dislikes = getDislikeCount(postid);
					disliked = true;
					dislikes++;
					dislike.setText(String.valueOf(dislikes));
					getDislikeButton(postid, userid).setBackground(Color.red);
				} else if (e.getSource() == dislike && disliked && !liked) {
					query = "UPDATE Post SET Dislikes = Dislikes - 1 WHERE PostId =" + postid;
					// qDislikes = "DELETE FROM Dislikes WHERE postid = " + postid + "AND userid = "
					// + user.getUserId();
					qDislikes = "DELETE FROM Dislikes WHERE UserId = " + userid + "  " + "AND PostId = "
							+ postid + ";";
					col2 = new Color(246, 246, 246);
					dislike.setBackground(col2);
					dislikes = getDislikeCount(postid);
					disliked = false;
					if (dislikes < 0) {
						dislikes = 0;
					} else {
						--dislikes;
					}
					dislike.setText(String.valueOf(dislikes));
				} else if (e.getSource() == dislike && liked) {
					@SuppressWarnings("unused")
					int input = JOptionPane.showOptionDialog(null,
							"Remove your like first (click again on the like button)", "Help message",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
					// query = "SELECT Likes FROM Post";
				}
				try {
					Connection conn = DriverManager.getConnection(jdbcUrl);
					Statement statement = conn.createStatement();
					statement.executeUpdate(query);
					statement.executeUpdate(qDislikes);
					conn.close();

				} catch (SQLException s) {
					System.out.println("Failed to connect and get the number of dislikes");
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
