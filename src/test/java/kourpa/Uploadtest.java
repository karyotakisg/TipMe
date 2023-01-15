package kourpa;

import static org.junit.Assert.*;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import org.junit.Test;

public class Uploadtest {

	@Test
	public void testUploadGraphics() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setBounds(500, 200, 500, 300);
		panel.setBackground(new Color(255, 102, 0));
		frame.add(panel);
		frame.setVisible(true);
		assertEquals(new Color(255, 102, 0), panel.getBackground());
	}
	
	@Test
	public void testMethods() {
		User user = new User("v.talos","8210146","Evangelos",
				"Talos","Male","v.talos23@gmail.com",
				"6906502673","2003-02-07","Programming",
				"Sports","Sports");
		Upload upload = new Upload(user);
		upload.setCateg("Sport");
		upload.setTip("If you are athlete, you should drink at least 3 Lt of water everyday");
		assertEquals("Sport", upload.getCateg());
		assertEquals("If you are athlete, you should drink at least 3 Lt of water everyday", upload.getTip());
	}
	
	@Test
	public void testSetTip() {
		User user = new User("v.talos","8210146","Evangelos",
				"Talos","Male","v.talos23@gmail.com",
				"6906502673","2003-02-07","Programming",
				"Sports","Sports");
		Upload upload = new Upload(user);
		StringBuilder sb = new StringBuilder();
		sb.setLength(310);
		String text = sb.toString();
		upload.setCateg(text);
		assertNull(upload.getTip());
	}

}
