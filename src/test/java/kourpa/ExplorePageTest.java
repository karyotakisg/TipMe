package kourpa;

import static org.junit.Assert.*;

import java.awt.Color;

import javax.swing.JFrame;

import org.junit.Test;
public class ExplorePageTest {

	@Test
	public void testFrame() {
		ExplorePage ep = new ExplorePage();
		User user = new User("v.talos","8210146","Evangelos",
		"Talos","Male","v.talos23@gmail.com",
		"6906502673","2003-02-07","Programming",
		"Sports","Sports",10);
		Color color = new Color(255, 102, 0);
		JFrame frame =  ep.explorePage(user, color);
		assertNotNull(frame);
	}
	
	@Test
	public void testSize() {
		ExplorePage ep = new ExplorePage();
		//assertEquals(10,ep.buttons.length);
	}
}
