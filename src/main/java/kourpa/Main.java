package kourpa;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
    public class Main {  public static void main( String[] args ) {
        String jdbcUrl = "jdbc:sqlite:/socialmedia.db";
        try {
			Connection conn = DriverManager.getConnection(jdbcUrl);
        } catch (SQLException e1) {
			e1.printStackTrace();
		}
        HashMap<Integer,ArrayList<User>> people = new HashMap<>();
        ArrayList<User> ar = new ArrayList<>();
        User user1 = new User("user1","George2021","george@gmail.com","sports","science","movies");
        ar.add(user1);
        people.put(0,ar);
    }
}
