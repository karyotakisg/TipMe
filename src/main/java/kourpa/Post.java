package kourpa;
import java.util.HashMap;

public class Post {
	public HashMap<String, HashMap<String, String>> storeMessage(String tip, String categ) {
		HashMap<String, HashMap<String, String>> outer = new HashMap<>();
		HashMap<String, String> inner = new HashMap<>();
		inner.put(categ, tip);
		outer.put("dim", inner);
		System.out.println(outer);
		return outer;
	}
}
