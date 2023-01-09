package kourpa;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {

		/*
		 * HashMap<Integer,ArrayList<User>> people = new HashMap<>();
		 * ArrayList<User> ar = new ArrayList<>();
		 * User user1 = new
		 * User("v.talos","8210146","Evangelos","Talos","Male","v.talos23@gmail.com",
		 * "6906502673","2003-02-07","Programming","Sports","Sports");
		 * ar.add(user1);
		 * people.put(0,ar);
		 */

		User user = new User();
		user.setUsername("v.talos");
		user.setInterest1("Education");
		user.setInterest2("Sports");
		user.setInterest3("Food");
		Color col = new Color(255, 102, 0);
		// MyProfile obj = new MyProfile(user, col);
		HomePage h = new HomePage(user, col);
		// ExploreKourpaTest k = new ExploreKourpaTest();

		// Register.register();

	}

}
