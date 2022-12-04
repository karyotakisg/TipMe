package kourpa;
import java.util.HashMap;

public class Post {
	public HashMap<String, HashMap<String, String>> storeMessage(String tip, String categ) {
		HashMap<String, HashMap<String, String>> outer = new HashMap<>();
		HashMap<String, String> inner = new HashMap<>();
		User user = new User("dim","","","","","");
		inner.put(categ, tip);
		outer.put(user.getUsername(), inner);
		System.out.println(outer);
		return outer;
	}
}
