package kourpa;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;


//import java.util.HashMap;

public class Post {
	//String jdbcUrl = "jdbc:sqlite:socialmedia.db" ;
	
	
	
	Upload up = new Upload();
	//SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
	Date now = new Date();
	String strDate = sdfDate.format(now);
	User user = new User();
	
	
	
	

	//αποθήκευση ποστ στην βαση με στοιχεια όνομα, κατηγορία, κείμενο -- void
		
		public void storePost(String tip, String categ) {
			String jdbcUrl = "jdbc:sqlite:socialmedia.db";
			try {
				Connection conn = DriverManager.getConnection(jdbcUrl);
				Statement statement = conn.createStatement();

				System.out.println("Connected");
				
				/*
				String query = "INSERT INTO Post(Text, " + "Category, " + "UploadDate)" + " VALUES(" + "'" + up.getTip() + "'"
								+ "," + "'" + up.getCateg() + "'" + "," + "'" + strDate + "'" + ");";
				
				 */
				String query = "INSERT INTO Post(Text, " + "Category, " + "UploadDate, " + "Likes, "
								+ "UserId)" + " VALUES(" + "'" + tip + "'"
								+ "," + "'" + categ + "'" + "," + "'" + strDate + "'" + "," + "'"
								+ 0 + "'" + "," + "'" + 5 + "'" + ");";
						
				
				statement.executeUpdate(query);
				
				
				
			} catch (SQLException s) {
				  System.out.println("Failed to connect and save post");
				  s.printStackTrace();
			} catch (NullPointerException s) {
				System.out.println("NullPointerException");
			}
		}
			
		
	
	
	//παίρνει από την βάση το ποστ με στοιχεία (λογικά) όνομα, κατηγορία, κείμενο
	public void receivePost() {
		String query = "SELECT Category, UploadDate, Text, Likes FROM Post;";
		//username
		String jdbcUrl = "jdbc:sqlite:socialmedia.db";
		try {
			Connection conn = DriverManager.getConnection(jdbcUrl);
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while (rs.next()) {
		       //String username = rs.getString("username");
				String category = rs.getString("Category");
		        String uploadDate = rs.getString("UploadDate");
		        String text = rs.getString("Text");
		        int likes = rs.getInt("Likes");		        
		        
		      System.out.println(category + " | " +uploadDate  + " | " + text + "|" + likes);
		       // +username,,,,,, +likes
		                          
			}
		} catch (SQLException s) {
			  // TODO Auto-generated catch block
			  System.out.println("Failed to connect and get the post");
			  s.printStackTrace();
		}
	}
	
	//μέτρηση λαικ - αύξηση κατά 1 των αριθμό των λαικ
		public void countLike() {
			//String query = "UPDATE Post " +
			//		"SET Likes = Likes + 1" +
			//		"WHERE Text = + ? AND username = ? ";
			
			String query = "UPDATE Post " +
					"SET Likes = Likes + 1" +
					"WHERE Text =" + up.getTip() + " AND username = " + user.getUsername() + " ;" ;				
							
			String jdbcUrl = "jdbc:sqlite:socialmedia.db";
			try {
				Connection conn = DriverManager.getConnection(jdbcUrl);
				Statement statement = conn.createStatement();
				
				ResultSet rs = statement.executeQuery(query);
				
				//	PreparedStatement pst = conn.prepareStatement(query);
				
			//	pst.setString(1, user.getUsername());
			//	pst.setString(2, up.getTip());
			//	ResultSet rs = pst.executeQuery();
				
				if (rs.next()) {
			       System.out.println("The number of likes was increased successfully");
			                          
				}
				
			} catch (SQLException s) {
				  // TODO Auto-generated catch block
				  System.out.println("Failed to connect and increase the number of likes");
				  s.printStackTrace();
				  
			}
			
		}
	
		//επιστρέφει το νούμερο των λαικ που έχει
		public void receiveLike() {
			//String query = "SELECT Likes FROM Post, User WHERE Text = ? AND username = ? ";
			String query = "SELECT Likes FROM Post, User WHERE Text =" + up.getTip() + "AND username =" + user.getUsername() +";";
			
			String jdbcUrl = "jdbc:sqlite:socialmedia.db";
			try {
				Connection conn = DriverManager.getConnection(jdbcUrl);
				Statement statement = conn.createStatement();
				
				ResultSet rs = statement.executeQuery(query);
				
				//PreparedStatement pst = conn.prepareStatement(query);
				
				
				//pst.setString(1, user.getUsername());
				//pst.setString(2, up.getTip());
				//ResultSet rs = pst.executeQuery();
				
				if (rs.next()) {
			        int likes = rs.getInt("Likes");
			        up.setLikes(likes);
			                          
				}
				
			} catch (SQLException s) {
				  // TODO Auto-generated catch block
				  System.out.println("Failed to connect and get the number of likes");
				  s.printStackTrace();
				  
			}
			
			
		}


}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	//διαμόρφωση στοιχείων (δεν αποτελεί κoμμάτι της βάσης) η οποία καλεί την receivePost
	//public void customizePost() {

	//}
	//μέτρηση λαικ - αύξηση κατά 1 των αριθμό των λαικ
	//public void countLike(){


	

	//}

