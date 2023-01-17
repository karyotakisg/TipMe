package kourpa;

import static org.junit.Assert.assertEquals;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.After;
import org.junit.Before;
import java.awt.Color;

import javax.swing.JFrame;
import org.junit.Test;

public class RegisterTest {

	@Test
	public void testCreatePanel() {
		Register reg = new Register();
		JFrame frame = reg.createFrame(reg.createPanel());
		assertEquals(new Color(51, 153, 255), reg.createPanel().getBackground());
	}

	@Test
	public void testCreateFrame() {
		Register reg = new Register();
		JFrame frame = reg.createFrame(reg.createPanel());
		assertEquals("Welcome to GetTip()", frame.getTitle());
		assertEquals(500, frame.getWidth());
		assertEquals(650, frame.getHeight());
	}

	private Register reg;
	private Connection conn;

	@Before
	public void setUp() throws SQLException {
		reg = new Register();
		conn = DriverManager.getConnection("jdbc:sqlite:socialmedia.db");
	}

	@After
	public void tearDown() throws SQLException {
		conn.close();
	}

	@Test
	public void testSubmit() throws SQLException {

		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM User WHERE Username='testuser'");
		rs.next();
		assertEquals("testuser", rs.getString("Username"));
		assertEquals("password", rs.getString("password"));
		assertEquals("test@gmail.com", rs.getString("Email"));
		assertEquals("1234567890", rs.getString("PhoneNumber"));
		assertEquals("Test", rs.getString("FirstName"));
		assertEquals("User", rs.getString("LastName"));
	}
}
