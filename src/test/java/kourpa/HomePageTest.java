package kourpa;

import static org.junit.Assert.*;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import org.junit.Test;

import junit.framework.Assert;

public class HomePageTest {

	@Test
	public void testFrame() {
		HomePage hp = new HomePage();
		User user = new User("v.talos","8210146","Evangelos",
				"Talos","Male","v.talos23@gmail.com",
				"6906502673","2003-02-07","Programming",
				"Sports","Sports",10);
		Color color = new Color(255, 102, 0);
		JFrame frame =  hp.homePage(user, color);
		assertNotNull(frame);
	}
	
	@Test
	public void testTextArea() {
		HomePage hp = new HomePage();
		JTextArea textArea = hp.getMessageText("Test");
		assertEquals(" " + "Test" + '\n', textArea.getText());
	}
	
	@Test
	public void testIcon() {
		HomePage hp = new HomePage();
		Icon result =  hp.getIcon("Sports");
		String icon2 = result.toString();
		String icon = "src\\main\\resources\\sports3.png";
		assertEquals(icon, icon2);
	}
	
	
	
	
	

}
