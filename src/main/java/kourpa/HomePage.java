package kourpa;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class HomePage {
    JFrame frame = new JFrame();
    JPanel feed = new JPanel();
    
    User user = new User();

    HomePage(User u) {
       
    	feed.setBackground(new Color(153, 0, 0));
        feed.setLayout(null);
        Menu north = new Menu();
        JPanel south = new JPanel();
        JPanel east = new JPanel();
        JPanel west = new JPanel();
        JPanel center = new JPanel( new GridLayout(5, 1, 0, 10));

        JTextArea tip = new JTextArea();
        tip.setEditable(false);

        frame.setSize(1000, 1000);
        center.setBounds(100, 100, 800, 600 );
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.add(feed);

        feed.add(north, BorderLayout.NORTH);
        feed.add(south, BorderLayout.SOUTH);
        feed.add(center, BorderLayout.CENTER);
        feed.add(west, BorderLayout.WEST);
        feed.add(east, BorderLayout.EAST);

        
     // SQLite connection URL
		String jdbcUrl = "jdbc:sqlite:socialmedia.db";

		try {
			// Creating a new Connection
			Connection conn = DriverManager.getConnection(jdbcUrl);
			Statement statement = conn.createStatement();

			//System.out.println("Connected");

			// Get the right posts from the database
			
			String query = "SELECT User.username, Post.text, Post.uploaddate, Post.likes"
					       + "FROM Post, User"
					       + "WHERE Post.userId = User.userId AND Post.category IN (" 
					       + "'" + user.getInterest1() + "'" + ", " 
					       + "'" + user.getInterest2() + "'" + ", " 
					       + "'" + user.getInterest3() + "'" + ")" 
					       + "COLLATE NOCASE"
					       + "ORDER BY uploaddate;";

		ResultSet rs = statement.executeQuery(query);

		while (rs.next()) {
			
			JTextArea post = new JTextArea();
			post.setText(rs.getString("username") + "         "  + rs.getString("category") + "\n" + "\n" + rs.getString("text"));
			post.setEditable(false);
            center.add(post);
			
		}    
			  
		
		} catch (SQLException s) {
			System.out.println("Error");
			s.printStackTrace();
		   }	

    }

}
