//package kourpa;
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


				   for(int row = 0 ; row < array.length ; row++) {
					   //for (int col = 0; col < array[row].length ; col++) {


					       JTextArea post = new JTextArea(5, 10);
					       post.setText( array[row][0] + array [row][1] + array[row][2] + array[row][ 3] + array[row][4] );
					       post.setEditable(false);
					       post.setPreferredSize(new Dimension(1000, 1000));
					       //Font f = new Font("Serif", Font.SERIF, 15);
					       //post.setFont(f);
					       explore.add(post);
					       JScrollPane scrollPane = new JScrollPane(post, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );

						       post.setLineWrap(true);


						       explore.add(scrollPane);


					  // }
				   }


		    }

}


