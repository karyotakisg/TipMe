package kourpa;
import java.util.ArrayList;
import java.util.HashMap;
public class Main {  
	public static void main(String[] args) {
      HashMap<Integer,ArrayList<User>> people = new HashMap<>();
        ArrayList<User> ar = new ArrayList<>();
      	User user1 = new User("v.talos","8210146","Evangelos","Talos","Male","v.talos23@gmail.com","6906502673","2003-02-07","Programming","Sports","Sports");
        ar.add(user1);
        people.put(0,ar);
        MyProfile obj = new MyProfile(user1); 
	}
}
