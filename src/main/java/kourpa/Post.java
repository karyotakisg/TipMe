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

/**
 * The class "Post" stores in the database the tip that the user writes, sets up
 * the Like and Dislike buttons and count the nu,,ber of Likes and Dislikes. *
 *
 * @author Eqerem Hena, Vaggelis Talos, Panagiotis Theocharis, Dimitris Doukas
 *
 */

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

	public Post() {
	}

	/**
	 * 
	 * @param user
	 */
	public Post(User user) {
		this.userPosted = user;
	}

	/**
	 * The method storePost() stores the tip(post) and the
	 * parameters(Category,UploadDate etc) of it in the database. If an exception
	 * happens then a message will be printed in the screen.
	 * 
	 * @param tip   is the text of the tip(post)
	 * @param categ the category that the post is for
	 */
	public void storePost(String tip, String categ) {
		String jdbcUrl = "jdbc:sqlite:socialmedia.db";
		try {
			// Creating a new connection
			Connection conn = DriverManager.getConnection(jdbcUrl);
			Statement statement = conn.createStatement();
			String query = "INSERT INTO Post(Text, Category, UploadDate, Likes, UserId, Dislikes)" + " VALUES( '" + tip
					+ "', '" + categ + "', '" + strDate + "', " + 0 + ", '" + userPosted.getUserId() + "', ' " + 0
					+ "');";
			// Store the post in the database
			statement.executeUpdate(query);
			conn.close();
		} catch (SQLException s) {
			System.out.println("Failed to connect and save post");
			s.printStackTrace();
		} catch (NullPointerException s) {
			System.out.println("NullPointerException");
		}
	}

	/**
	 * The method getLikeButton creates the Like button and checks if the user likes
	 * a post. If the user likes a post the like button will be green else it will
	 * be white. The user can like a post by clicking on the Like button an undo it
	 * by click it again.
	 * 
	 * 
	 * @param postid the id of the post
	 * @param userid the id of the user who will like the post or undo the like and
	 *               is being checked if he likes the post or not
	 * @return the like button
	 */
	public JButton getLikeButton(int postid, int userid) {
		// Create the Like button
		Font fontLike = new Font("Serif", Font.BOLD, 15);
		ImageIcon icon = new ImageIcon("src\\main\\resources\\like.png");
		JButton like = new JButton("" + getLikeCount(postid) + "", icon);
		String jdbcUrl = "jdbc:sqlite:socialmedia.db";
		try {
			String qLikes = "SELECT userid FROM Likes WHERE PostId = " + postid;
			Connection conn = DriverManager.getConnection(jdbcUrl);
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(qLikes);
			// Check if the user likes the post already
			while (rs.next()) {
				if (rs.getInt("userid") == userid) {
					liked = true;
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
				/*
				 * If the user doesn't like or doesn't dislike already the post he likes it by
				 * clicking on like button. The like button will be green when he like it
				 */
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
					/*
					 * If the user like and doesn't dislike the post he can undo the like by
					 * clicking on the like button again. The like button will be white when he undo
					 * the like
					 */
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
					/*
					 * When a user dislikes already the post and wants to like it then a message
					 * that will ask him to undo the dislike will appear
					 */
				} else if (e.getSource() == like && disliked) {
					@SuppressWarnings("unused")
					int input = JOptionPane.showOptionDialog(null,
							"Remove your dislike first (click again on the dislike button)", "Help message",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
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

	/**
	 * The method getDislikeButton creates the Dislike button and checks if the user
	 * dislikes a post. If the user dislikes a post the dislike button will be red
	 * else it will be white. The user can dislike a post by clicking on the Dislike
	 * button an undo it by click it again.
	 * 
	 * 
	 * @param postid the id of the post
	 * @param userid the id of the user who will dislike the post or undo the
	 *               dislike and is being checked if he dislikes the post or not
	 * @return the dislike button
	 */
	public JButton getDislikeButton(int postid, int userid) {
		// Create the dislike button
		Font fontdisLike = new Font("Serif", Font.BOLD, 15);
		ImageIcon icon = new ImageIcon("src\\main\\resources\\dislike.png");
		JButton dislike = new JButton("" + getDislikeCount(postid) + "", icon);

		String jdbcUrl = "jdbc:sqlite:socialmedia.db";

		try {
			String qDislikes = "SELECT userid FROM Dislikes WHERE PostId = " + postid;
			Connection conn = DriverManager.getConnection(jdbcUrl);
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(qDislikes);
			
			// Check if the user dislikes the post already
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
				/*
				 * If the user doesn't dislike or doesn't like already the post he dislikes it
				 * by clicking on dislike button. The dislike button will be red when he dislike
				 * it
				 */
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
					/*
					 * If the user dislike and doesn't like the post he can undo the dislike by
					 * clicking on the dislike button again. The dislike button will be white when
					 * he undo the dislike
					 */
				} else if (e.getSource() == dislike && disliked && !liked) {
					query = "UPDATE Post SET Dislikes = Dislikes - 1 WHERE PostId =" + postid;
					qDislikes = "DELETE FROM Dislikes WHERE UserId = " + userid + "  " + "AND PostId = "
							+ postid + ";";
					qDislikes = "DELETE FROM Dislikes WHERE UserId = " + userid + "  " + "AND PostId = " + postid + ";";

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
					/*
					 * When a user likes already the post and wants to dislike it then a message
					 * that will ask him to undo the like will appear
					 */
				} else if (e.getSource() == dislike && liked) {
					@SuppressWarnings("unused")
					int input = JOptionPane.showOptionDialog(null,
							"Remove your like first (click again on the like button)", "Help message",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
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

	/**
	 * The method getLikeCount gets the number of likes form the database
	 * 
	 * @param postid the id of the post that is needed in order to have the correct
	 *               number of likes displayed
	 * @return the number of likes
	 */
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

	/**
	 * The method getDislikeCount gets the number of dislikes form the database
	 * 
	 * @param postid the id of the post that is needed in order to have the correct
	 *               number of dislikes displayed
	 * @return the number of dislikes
	 */
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
