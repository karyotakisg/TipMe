package kourpa;
//package kourpa.kourpatestclasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;




public class CustomizeMessageKourpa2 {

	JFrame frame = new JFrame();
	//JPanel explore = new JPanel();
    String [][] array = { {"Gkaryolakis", "Kritikos goat", "2022-12-19", "0", "Sports"}, {"Ptheoxarhs", "MONO TEXTPAD", "2022-12-19", "100", "Music"} };
	//User user = new User();
   //User u

   Color c;

	CustomizeMessageKourpa2(String u, String category, JPanel explore) {

		explore.setBackground(new Color(152, 0, 0));
		//explore.setLayout(null);
		//Menu north = new Menu();
		//JPanel south = new JPanel();
		//JPanel east = new JPanel();
		//JPanel west = new JPanel();
		//JPanel center = new JPanel( new GridLayout(5, 1, 0, 10));
        explore.setLayout(new GridLayout(5, 1, 0, 10));

		JTextArea tip = new JTextArea();
		tip.setEditable(false);

		//frame.setSize(1000, 1000);
		//center.setBounds(100, 100, 800, 600);

		//frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		//frame.add(explore);

		//explore.add(north, BorderLayout.NORTH);
		//explore.add(south, BorderLayout.SOUTH);
		//explore.add(center, BorderLayout.CENTER);
		//explore.add(west, BorderLayout.WEST);
		//explore.add(east, BorderLayout.EAST);

		/*String jdbcUrl = "jdbc:sqlite:socialmedia.db";

			try {
					// Creating a new Connection
					Connection conn = DriverManager.getConnection(jdbcUrl);
					Statement statement = conn.createStatement();

					//System.out.println("Connected");

				// Get the right posts from the database
                                                                                                                                                                                           //u.getInterest1()
				String query = "SELECT User.username, Post.text, Post.uploaddate, Post.likes, Post.Category FROM Post, User WHERE Post.userId = User.userId AND (Post.Category = " + "'" + category; // "'" + "COLLATE NOCASE  OR Post.Category = " + "'" + u.getInterest2() + "'" + "COLLATE NOCASE OR Post.Category = " + "'" + u.getInterest1() + "'" + "COLLATE NOCASE) ORDER BY uploadDate DESC;";

				ResultSet rs = statement.executeQuery(query);

				while (rs.next()) {
					JTextArea post = new JTextArea();
					post.setText(rs.getString("username") + "             Likes: " + rs.getString("likes")+ "            " + rs.getString("uploaddate") + "\n" + "\n" + "\n" + rs.getString("text") + "\n" + "\n" +"\n" + "Category:  " + rs.getString("Category"));
					post.setEditable(false);
		            explore.add(post);

				}

				explore.setVisible(true);

				} catch (SQLException s) {
					System.out.println("Error");
					s.printStackTrace();
				   } */


                   if(category == "Science") {
					   c = new Color(36, 94, 80);
				   } else if (category == "Sports") {
				        c = new Color(123, 119, 236);
				   } else if (category == "Music") {
					    c = new Color(240,131,189);
				   } else if (category == "Fashion") {
					  c = new Color(198, 78, 126);
				   } else if (category == "Travel") {
					    c = new Color(237, 242, 103);
				   } else if (category == "Fitness") {
					    c = new Color(121, 229, 88);
				   } else if (category == "Art") {
					   c = new Color(121, 229, 88);
				   } else if (category == "Education") {
					   c = new Color(147, 148, 147);
				   } else if (category == "Environment") {
					   c = new Color(178, 102, 16);
				   } else {
					   c = new Color(243, 220, 216);
				   }


				   for(int row = 0 ; row < array.length ; row++) {
					   //for (int col = 0; col < array[row].length ; col++) {

                           JPanel post = new JPanel(new BorderLayout(1, 1));
                           Font font = new Font("Calibri", Font.PLAIN, 20);
                           Font fontlike = new Font("Calibri", Font.BOLD, 15);
					      // JTextArea post = new JTextArea(5, 10);

					       JTextArea postUserInfo = new JTextArea();
					       postUserInfo.setText(array[row][0] + array[row][2] + array[row][4]);
					       //postUserInfo.setBackground(ExploreButtons.colorscat(array[row][4]));
					       postUserInfo.setBackground(c);
					       postUserInfo.setEditable(false);
			           	   postUserInfo.setFont(font);
			               postUserInfo.setForeground(Color.BLACK);

			               JTextArea postMessage = new JTextArea();
						   postMessage.setText(array[row][1]);
				     	   postMessage.setBackground(new Color(240,255,251));
						   postMessage.setEditable(false);
						   postMessage.setFont(font);
			               postMessage.setForeground(Color.BLACK);

			                ImageIcon icon = new ImageIcon("C:\\Javaproject new\\like.png");
						   	JButton like = new JButton("1233", icon);
						   	like.setFont(fontlike);
						   	like.setPreferredSize(new Dimension(100, 30 ));
						    like.setBackground(Color.white);
						    like.setForeground(Color.WHITE);
                            like.setFocusable(false);


                              JPanel southLike = new JPanel(new FlowLayout(FlowLayout.LEFT));
							  southLike.setSize(900, 30);
							  southLike.setBackground(Color.white);
							  southLike.add(like);

							   post.add(postUserInfo, BorderLayout.NORTH);
							   post.add(postMessage, BorderLayout.CENTER);
							   post.add(southLike, BorderLayout.SOUTH);
			                   explore.add(post);


					       //post.setText( array[row][0] + array [row][1] + array[row][2] + array[row][ 3] + category);
					       //array[row][0].setBounds(80, 100, 100, 100);
					       post.setBackground(c);
					      // post.setEditable(false);
					       post.setPreferredSize(new Dimension(1000, 1000));
					       //Font f = new Font("Serif", Font.SERIF, 15);
					       //post.setFont(f);
					       //explore.add(post);
					       //JScrollPane scrollPane = new JScrollPane(post, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );


						      // post.setLineWrap(true);


						       //explore.add(scrollPane);


					  // }
				   }


		    }

}


