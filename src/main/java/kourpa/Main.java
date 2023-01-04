package kourpa;


import kourpa.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		/*
		 *HashMap<Integer,ArrayList<User>> people = new HashMap<>(); ArrayList<User> ar
		 * = new ArrayList<>(); User user1 = new
		 * User("user1","George2021","george@gmail.com","sports","science","movies");
		 * Menu menu = new Menu(); ar.add(user1); people.put(0,ar);
		 */
		Upload upload = new Upload();
		
		Post p = new Post();
		JButton lb = p.getLikeButton(1);
		
		JFrame frame = new JFrame();
		lb.setBounds(30, 40, 50, 50);
		frame.add(lb);
		frame.setVisible(true);
		frame.setSize(500, 500);
		


	}
}
