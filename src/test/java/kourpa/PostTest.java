package kourpa;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PostTest {
	Post p = new Post();
	private Connection conn;
	@Before
	public void setUp() throws SQLException {
		conn = DriverManager.getConnection("jdbc:sqlite:socialmedia.db");
	}
	
	@After
	public void tearDown() throws SQLException {
		conn.close();
	}
	
	@Test
	public void getLikeCountTest() throws SQLException {
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT Likes FROM Post WHERE PostId = 1" );
		int likes = 0;
		while (rs.next()) {
			likes = rs.getInt("Likes");
		}
		assertEquals(likes, p.getLikeCount(1));
	}
	
	@Test
	public void getDislikeCountTest() throws SQLException {
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT Dislikes FROM Post WHERE PostId = 1" );
		int dislikes = 0;
		while (rs.next()) {
			dislikes = rs.getInt("Dislikes");
		}
		assertEquals(dislikes, p.getLikeCount(1));
	}


}
