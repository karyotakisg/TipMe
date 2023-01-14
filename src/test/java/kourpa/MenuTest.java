package kourpa;
import static org.junit.Assert.assertTrue;
import java.awt.Color;
import javax.swing.JFrame;
import org.junit.Before;
import org.junit.Test;
public class MenuTest implements Runnable{
    JFrame frame = new JFrame();
    Thread t = new Thread();
    Menu menu = new Menu();
    @Before
    public void setUp() {
    frame.setSize(1000,1000);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBackground(new Color(50,50,50));
    }
    @Before
    public void run() {
    frame.setVisible(true);
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    }
    @Test
    public void testMenuGraphics(){
    run();
   // assertTrue("error", menu.isVisible());
    }
}
