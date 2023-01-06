package kourpa;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;


public class Main {  

	public static void main( String[] args ) {
     
		/*HashMap<Integer,ArrayList<User>> people = new HashMap<>();
        ArrayList<User> ar = new ArrayList<>();
      	User user1 = new User("user1","George2021","george","siu","Male","george@gmail.com","6993862603","23/3/2000","sports","science","movies");
        ar.add(user1);
        people.put(0,ar);*/

        
  

		User user = new User();
		user.setUsername("v.talos");
		user.setInterest1("Programming");
		user.setInterest2("Sports");
		user.setInterest3("Cooking");
		Color col = new Color(255, 102, 0);
		MyProfile obj = new MyProfile(user, col); 
		HomePage h = new HomePage(user);
		ExploreKourpaTest k = new ExploreKourpaTest();
		
		//Register.register();
	
	}

}
