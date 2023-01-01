package kourpa;
import static org.junit.Assert.assertTrue;
import java.awt.Component;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
public class MyProfileTest {
    User user1 = new User("v.talos","8210146","Evangelos","Talos","Male","v.talos23@gmail.com","6906502673","2003-02-07","Programming","Sports","Sports");
    MyProfile obj = new MyProfile(user1);
    @Test
    public void panelSetupTest(){ //checks if some of the neccessary components are in the panel
        List<Component> componentList = Arrays.asList(obj.getPanel().getComponents());
        assertTrue("The panel does not contain the change button", componentList.contains(obj.getChangeButton()));
        assertTrue("The panel does not contain the sexLabel", componentList.contains(obj.getSexLabel()));
    }
}
