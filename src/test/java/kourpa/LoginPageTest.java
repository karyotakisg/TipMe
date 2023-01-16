package kourpa;

import static org.junit.Assert.assertEquals;


import java.awt.Color;
import javax.swing.JFrame;


import org.junit.Test;

public class LoginPageTest {
	@Test
	public void testCreatePanel() {
		LoginPage lg = new LoginPage();
		JFrame frame = lg.loginPage();
		//assertEquals(null, frame.getLayout());
		assertEquals(new Color(51, 153, 255), frame.getBackground());
	}
	
}
