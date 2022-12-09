package kourpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:sqlite:/socialmedia.db";
		
		try {
			Connection conn = DriverManager.getConnection(jdbcUrl);
		
		    String userTable = "CREATE TABLE User "
				+ "(UserId INT NOT NULL PRIMARY KEY"
				+ "username VARCHAR(30) NOT NULL"
				+ "password VARCHAR(30) NOT NULL"
				+ "email VARCHAR(30) NOT NULL"
				+ "PhoneNumber CHAR(10)"
				+ "Sex VARCHAR(6)"
				+ "BirthDate DATE NOT NULL"
				+ "Interest1 VARCHAR(30)"
				+ "Interest2 VARCHAR(30)"
				+ "Interest3 VARCHAR(30))";
		
		    String postTable = "CREATE TABLE Post "
				+ "(PostId INT NOT NULL PRIMARY KEY"
				+ "Text VARCHAR(200) NOT NULL"
				+ "Category VARRCHAR(30) NOT NULL"
				+ "UploadDate DATE NOT NULL"
				+ "Likes INT NOT NULL"
				+ "UserId VARCHAR(30) NOT NULL"
				+ "FOREIGN KEY (UserId) REFERENCES User";
		
		    Statement st = conn.createStatement();
		    st.executeUpdate(userTable);
		    st.executeUpdate(postTable);
		
		System.out.println("User and Post tables created");
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//IDandPasswords idpas = new IDandPasswords();
		//LoginPage loginPage = new LoginPage(idpas.getLogininfo());
	
		/*HashMap<Integer,ArrayList<User>> people = new HashMap<>();
        ArrayList<User> ar = new ArrayList<>();
        User user1 = new User("user1","George2021","george@gmail.com","sports","science","movies");
        ar.add(user1);
        people.put(0,ar);
        MyProfile obj = new MyProfile(user1);*/
	
	}

}
