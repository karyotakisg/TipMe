package kourpa;

import static org.junit.Assert.assertEquals;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPanel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExplorePanelTest {
	private static JPanel center;
	private JPanel east;
	private JPanel west;
	private JPanel south;
	JPanel panel = new JPanel();

	public ExplorePanelTest(User u, Color col) {
		center = new JPanel();
		center.setBackground(Color.black);
		center.setLayout(new GridLayout(2, 5, 10, 10));
		east = new JPanel();
		west = new JPanel();
		south = new JPanel();
		panel = new JPanel();
		panel.setLayout(new BorderLayout(2, 2));
		Menu menu = new Menu();
		south.setPreferredSize(new Dimension(200, 50));
		east.setPreferredSize(new Dimension(100, 680));
		west.setPreferredSize(new Dimension(100, 680));
		south.setBackground(col);
		east.setBackground(col);
		west.setBackground(col);
		center.setBackground(Color.BLACK);
		panel.setBackground(Color.BLACK);
		panel.add(center, BorderLayout.CENTER);
		panel.add(east, BorderLayout.EAST);
		panel.add(west, BorderLayout.WEST);
		panel.add(south, BorderLayout.SOUTH);
		panel.add(menu.menuBar(u, col), BorderLayout.NORTH);
	}

	private ExplorePanel exp;
	private Connection conn;

	@Before
	public void setUp() throws SQLException {
		exp = new ExplorePanel(3, panel, south, east, west);
		conn = DriverManager.getConnection("jdbc:sqlite:socialmedia.db");
	}

	@After
	public void tearDown() throws SQLException {
		conn.close();
	}

	@Test
	void getMessageCountTest() throws SQLException {
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT User.username, Post.text, Post.uploaddate, Post.likes, Post.Category "
				+ "FROM Post, User " + "WHERE Post.userId = User.userId AND Post.Category = Food");
		int x = 0;
		while (rs.next()) {
			x++;
		}
		assertEquals(x, exp.getMessageCount("Food"));
	}

}
