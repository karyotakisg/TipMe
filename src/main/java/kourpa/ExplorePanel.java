package kourpa;
//package kourpa.kourpatestclasses;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class ExplorePanel {

    String category;
    private static JPanel p0;
    private static JPanel p1;
    private static JPanel p2;
    private static JPanel p3;
    private static JPanel p4;
    private static JPanel p5;
    private static JPanel p6;
    private static JPanel p7;
    private static JPanel p8;
    private static JPanel p9;
	private static JPanel  panelBack;

	public ExplorePanel(int x, JPanel jf, JPanel south, JPanel east, JPanel west, String u) {
        //jf.setLayout(new BorderLayout(5, 5));
          //jf.setLayout(new GridLayout(3, 2, 10, 10));

        panelBack = jf;
        HomePage hp = new HomePage();
        south.setPreferredSize(new Dimension(200, 5));
        east.setPreferredSize(new Dimension(135, 200));
		west.setPreferredSize(new Dimension(135, 200));
		if(x == 0) {
			p0 = new JPanel();
			category = "Science";
			p0.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
			p0.setBackground(Color.BLACK);
			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p0);
			jf.add(p0, BorderLayout.CENTER);
			jf.add(hp.getScroll(p0), BorderLayout.CENTER);
		} else if(x == 1) {
			p1 = new JPanel();
			category = "Sports";
			p1.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
			p1.setBackground(Color.BLACK);
			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p1);
			jf.add(p1, BorderLayout.CENTER);
			jf.add(hp.getScroll(p1), BorderLayout.CENTER);
			//p1.add(m);	            

		} else if(x == 2) {
			p2 = new JPanel();
			category = "Music";
			p2.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
			p2.setBackground(Color.BLACK);
			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p2);
			jf.add(p2, BorderLayout.CENTER);
			jf.add(hp.getScroll(p2), BorderLayout.CENTER);

		} else if(x == 3) {
			p3 = new JPanel();
			category = "Fashion";
			p3.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
			p3.setBackground(Color.BLACK);
			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p3);
			jf.add(p3, BorderLayout.CENTER);
			jf.add(hp.getScroll(p3), BorderLayout.CENTER);
		} else if(x == 4) {
			p4 = new JPanel();
			category = "Travel";
			p4.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
			p4.setBackground(Color.BLACK);
			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p4);
			jf.add(p1, BorderLayout.CENTER);
		} else if(x == 5) {
			p5 = new JPanel();
			category = "Fitness";
			p5.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
			p5.setBackground(Color.BLACK);
			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p5);
			jf.add(p5, BorderLayout.CENTER);
		} else if (x == 6) {
			p6 = new JPanel();
			category = "Art";
			p6.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
			p6.setBackground(Color.BLACK);
			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p6);
			jf.add(p6, BorderLayout.CENTER);
			jf.add(hp.getScroll(p6), BorderLayout.CENTER);
	   } else if (x == 7) {
		   	p7 = new JPanel();
		   	category = "Education";
			p7.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
			p7.setBackground(Color.BLACK);			
			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p7);
			jf.add(p7, BorderLayout.CENTER);
			jf.add(hp.getScroll(p7), BorderLayout.CENTER);
		} else if ( x == 8) {
			p8 = new JPanel();
			category = "Environment";
			p8.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
			p8.setLayout(new GridLayout(hp.getMessageCount(), 1, 7, 3));
			p8.setBackground(Color.BLACK);
			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p8);
			jf.add(p8, BorderLayout.CENTER);
			jf.add(hp.getScroll(p8), BorderLayout.CENTER);
		} else {
			p9 = new JPanel();
			category = "Food";
			p9.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
			p9.setLayout(new GridLayout(hp.getMessageCount(), 1, 7, 3));
			p9.setBackground(Color.BLACK);
			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p9);
			jf.add(p1, BorderLayout.CENTER);
			jf.add(hp.getScroll(p9), BorderLayout.CENTER);
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

			String query = "SELECT User.username, Post.text, Post.uploaddate, Post.likes, Post.Category FROM Post, User WHERE Post.userId AND Post.Category = '" + category + "'";

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

	public static void hidepanel() {

		p0.setVisible(false);
		p1.setVisible(false);
		p2.setVisible(false);
		p3.setVisible(false);
		p4.setVisible(false);
		p5.setVisible(false);
		p6.setVisible(false);
		p7.setVisible(false);
		p8.setVisible(false);
		panelBack.setVisible(true);



}

}



