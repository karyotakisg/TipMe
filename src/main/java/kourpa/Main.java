package kourpa;
import java.util.ArrayList;
import java.util.HashMap;
public class Main {
    public static void main( String[] args ) {
        HashMap<Integer,ArrayList<User>> people = new HashMap<>();
        ArrayList<User> ar = new ArrayList<>();
        User user1 = new User("user1","George2021","george@gmail.com","sports","science","movies");
        ar.add(user1);
        people.put(0,ar);
        MyProfile obj = new MyProfile(user1);
         
    }
}
