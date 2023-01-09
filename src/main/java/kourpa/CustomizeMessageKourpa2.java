package kourpa;
//package kourpa.kourpatestclasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CustomizeMessageKourpa2 {
	
	
	
	CustomizeMessageKourpa2(User u, String category, JPanel explore) {	
		String jdbcUrl = "jdbc:sqlite:socialmedia.db";
		try {
			// Creating a new Connection
			Connection conn = DriverManager.getConnection(jdbcUrl);
			Statement statement = conn.createStatement();

			// System.out.println("Connected");

			// Get the right posts from the database

			String query = "SELECT User.username, Post.text, Post.uploaddate, Post.likes, Post.PostId, Post.Category FROM Post, User WHERE Post.userId AND Post.Category = '" + category + "'";

			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				HomePage hp = new HomePage();
				ExploreKourpaTest ex = new ExploreKourpaTest();
				JPanel post = new JPanel(new BorderLayout(1, 1));
			
				JPanel eastern = new JPanel();
				eastern.setBackground(new Color(245, 245, 245));
				post.setBackground(Color.black);
				post.add(hp.getNorthLabel(rs.getString("username"), rs.getString("uploaddate"), rs.getString("Category")),
					BorderLayout.NORTH);
				post.add(eastern, BorderLayout.EAST);
				post.add(hp.getMessageText(rs.getString("text")), BorderLayout.CENTER);
				post.add(hp.getSouthLike2(rs.getString("text"), explore, post, rs.getInt("PostId")), BorderLayout.SOUTH);
			
				Post p = new Post();
				p.getLikeCount(rs.getInt("PostId"));
				p.getDislikeCount(rs.getInt("PostId"));

				//postid = rs.getInt("PostId");

				explore.add(post);
			}
		} catch (SQLException s) {
			System.out.println("Error");
			s.printStackTrace();
		}
	}
	
	

}
