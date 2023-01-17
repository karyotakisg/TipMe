package kourpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.awt.Color;
import java.awt.Component;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class MyProfileTest {
	// tests the number of posts from a new account(should be 0)
	User user1 = new User("v.Talos", "8210146", "Evangelos", "Talos", "Male", "v.talos23@gmail.com", "6906502673",
			"2003-02-07", "Programming", "Sports", "Sports", 10);
	MyProfile obj = new MyProfile();

	@Test
	public void panelSetupTest() {
		obj.getMessageCount(user1);
		assertEquals(obj.getMessageCount(user1) == 0, true);
	}
}
