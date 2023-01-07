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
	private Color col1 = Color.white;
	private Color col2 = Color.white;
	private boolean flag = false;
	private int likes;
	private int dislikes;	// SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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

	// παίρνει από την βάση το ποστ με στοιχεία (λογικά) όνομα, κατηγορία, κείμενο
	public void receivePost() {
		String query = "SELECT Category, UploadDate, Text, Likes FROM Post;";
		// username
		String jdbcUrl = "jdbc:sqlite:socialmedia.db";
		try {
			Connection conn = DriverManager.getConnection(jdbcUrl);
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				// String username = rs.getString("username");
				String category = rs.getString("Category");
				String uploadDate = rs.getString("UploadDate");
				String text = rs.getString("Text");
				int likes = rs.getInt("Likes");

				System.out.println(category + " | " + uploadDate + " | " + text + "|" + likes);
				// +username,,,,,, +likes

			}
			conn.close();
		} catch (SQLException s) {
			// TODO Auto-generated catch block
			System.out.println("Failed to connect and get the post");
			s.printStackTrace();
		}
	}

	/*
	 * //μέτρηση λαικ - αύξηση κατά 1 των αριθμό των λαικ public void countLike() {
	 * Upload up = new Upload(); //String query = "UPDATE Post " + //
	 * "SET Likes = Likes + 1" + // "WHERE Text = + ? AND username = ? ";
	 * 
	 * String query = "UPDATE Post " + "SET Likes = Likes + 1" + "WHERE Text =" +
	 * up.getTip() + " AND username = " + user.getUsername() + " ;" ;
	 * 
	 * String jdbcUrl = "jdbc:sqlite:socialmedia.db"; try { Connection conn =
	 * DriverManager.getConnection(jdbcUrl); Statement statement =
	 * conn.createStatement();
	 * 
	 * ResultSet rs = statement.executeQuery(query);
	 * 
	 * // PreparedStatement pst = conn.prepareStatement(query);
	 * 
	 * // pst.setString(1, user.getUsername()); // pst.setString(2, up.getTip()); //
	 * ResultSet rs = pst.executeQuery();
	 * 
	 * if (rs.next()) {
	 * System.out.println("The number of likes was increased successfully");
	 * JOptionPane.showMessageDialog(null, "Successfull like"); } conn.close();
	 * 
	 * } catch (SQLException s) { // TODO Auto-generated catch block
	 * System.out.println("Failed to connect and increase the number of likes");
	 * s.printStackTrace();
	 * 
	 * }
	 * 
	 * }
	 */

	/*
	 * //επιστρέφει το νούμερο των λαικ που έχει public void receiveLike() { Upload
	 * up = new Upload(); //String query =
	 * "SELECT Likes FROM Post, User WHERE Text = ? AND username = ? "; String query
	 * = "SELECT Likes FROM Post, User WHERE Text =" + up.getTip() +
	 * "AND username =" + user.getUsername() +";";
	 * 
	 * String jdbcUrl = "jdbc:sqlite:socialmedia.db"; try { Connection conn =
	 * DriverManager.getConnection(jdbcUrl); Statement statement =
	 * conn.createStatement();
	 * 
	 * ResultSet rs = statement.executeQuery(query);
	 * 
	 * //PreparedStatement pst = conn.prepareStatement(query);
	 * 
	 * 
	 * //pst.setString(1, user.getUsername()); //pst.setString(2, up.getTip());
	 * //ResultSet rs = pst.executeQuery();
	 * 
	 * if (rs.next()) { int likes = rs.getInt("Likes"); setLikes(likes);
	 * conn.close(); }
	 * 
	 * } catch (SQLException s) { // TODO Auto-generated catch block
	 * System.out.println("Failed to connect and get the number of likes");
	 * s.printStackTrace(); } }
	 */

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
		like.setBackground(Color.white);
		
		like.addActionListener(new ActionListener() {
			String query;
			String jdbcUrl;
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == like && like.getBackground() == Color.white && flag == false) {// TODO Auto-generated method stub
						query = "UPDATE Post SET Likes = Likes+1 WHERE PostId =" + postid;
						jdbcUrl = "jdbc:sqlite:socialmedia.db";						
						col1 = Color.green;
						like.setBackground(Color.green);
						likes++;
						like.setText(String.valueOf(likes));
						getDislikeButton(postid).setBackground(Color.white);
						flag = true;
				} else if (e.getSource() == like && like.getBackground() == Color.green) {
						query = "UPDATE Post SET Likes = Likes-1 WHERE PostId =" + postid;
						jdbcUrl = "jdbc:sqlite:socialmedia.db";							
						col1 = Color.white;
						like.setBackground(col1);
						likes--;
						like.setText(String.valueOf(likes));
						flag = false;
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
		dislike.setBackground(Color.white);
		
		dislike.addActionListener(new ActionListener() {
			String query;
			String jdbcUrl;
			@Override
			public void actionPerformed(ActionEvent e) {

				if(e.getSource() == dislike && dislike.getBackground() == Color.white && flag == false) {// TODO Auto-generated method stub
						query = "UPDATE Post SET dislikes = dislikes+1 WHERE PostId =" + postid;
						jdbcUrl = "jdbc:sqlite:socialmedia.db";						
						dislike.setBackground(Color.red);
						dislikes++;
						dislike.setText(String.valueOf(dislikes));
						flag = true;
				} else if (e.getSource() == dislike && dislike.getBackground() == Color.red) {
						query = "UPDATE Post SET Likes = Likes-1 WHERE PostId =" + postid;
						jdbcUrl = "jdbc:sqlite:socialmedia.db";							
						col1 = Color.white;
						dislike.setBackground(col1);
						dislikes--;
						dislike.setText(String.valueOf(likes));	
						flag = false;
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
}	
	



/*
 * JButton button = new JButton("Like"); button.setBounds(250, 20, 60, 30);
 * panel.add(button);
 * 
 * button.addActionListener(new ActionListener() {
 * 
 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
 * method stub if(postlike.containsKey(code.getText()) == false) {
 * JOptionPane.showMessageDialog(null,
 * "This code does not exist. Try one other code"); } else if
 * (postlike.containsKey(code.getText()) == true) { if
 * (postlike.get(code.getText()) == 0) { postlike.put(code.getText(), 1);
 * inner_frame.dispose(); JOptionPane.showMessageDialog(null,
 * "Successfull like"); } else { JOptionPane.showMessageDialog(null,
 * "You already like this post. Try one other code");
 * System.out.println(postlike); } }
 * 
 * } });
 */

// διαμόρφωση στοιχείων (δεν αποτελεί κoμμάτι της βάσης) η οποία καλεί την
// receivePost
// public void customizePost() {

// }
// μέτρηση λαικ - αύξηση κατά 1 των αριθμό των λαικ
// public void countLike(){

// }