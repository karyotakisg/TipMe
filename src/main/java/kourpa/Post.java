package kourpa;
import java.util.HashMap;

public class Post {
	//αποθήκευση ποστ στην βαση με στοιχεια όνομα, κατηγορία, κείμενο -- void
	public HashMap<String, HashMap<String, String>> storePost(String username, String tip, String categ) {
		HashMap<String, HashMap<String, String>> outer = new HashMap<>();
		HashMap<String, String> inner = new HashMap<>();
		inner.put(categ, tip);
		outer.put(username, inner);
		System.out.println(outer);
		return outer;
	}
	//παίρνει από την βάση το ποστ με στοιχεία (λογικά) όνομα, κατηγορία, κείμενο
	public HashMap<String, HashMap<String, String>> receivePost(String username, String categ) {

	}
	//διαμόρφωση στοιχείων (δεν αποτελεί κωμμάτι της βάσης) η οποία καλεί την receivePost
	public void customizePost() {

	}
	//μέτρηση λαικ - αύξηση κατά 1 των αριθμό των λαικ
	public void countLike(){

	}
	//επιστρέφει το νούμερο των λαικ που έχει
	public receiveLike(){

	}
}
