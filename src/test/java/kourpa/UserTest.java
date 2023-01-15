package kourpa;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class UserTest {
    @Test
    public void testConstructor() {
        User user = new User("v.talos","8210146","Evangelos","Talos","Male","v.talos23@gmail.com","6906502673","2003-02-07","Programming","Sports","Sports",10);
        assertEquals("v.talos",user.getUsername());
        assertEquals("8210146", user.getPassword());
        assertEquals("Evangelos", user.getFirstName());
        assertEquals("Talos", user.getLastName());
        assertEquals("Male", user.getSex());
        assertEquals("v.talos23@gmail.com", user.getEmail());
        assertEquals("6906502673", user.getPhoneNumber());
        assertEquals("2003-02-07", user.getBirthDate());
        assertEquals("Programming", user.getInterest1());
        assertEquals("Sports", user.getInterest2());
        assertEquals("Sports", user.getInterest3());
    }
}
