package kourpa;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Menu  extends JPanel implements ActionListener, KeyListener, MouseListener { //creates the menu at the top of the screen for each section of the app
    JPanel panel = new JPanel();
    Icon upload = new ImageIcon("src/main/resources/Upload.png");
    Icon myProfile = new ImageIcon("src/main/resources/MyProfile.png");
    Icon homepage = new ImageIcon("src/main/resources/Homepage.png");
    Icon explore = new ImageIcon("src/main/resources/Explore.png");
    JButton b1Icon = new JButton(upload);
    JButton b2Icon = new JButton(myProfile);
    JButton b3Icon = new JButton(homepage);
    JButton b4Icon = new JButton(explore);
    public Menu(){
        panel.add(b1Icon);
        panel.add(b2Icon);
        panel.add(b3Icon);
        panel.add(b4Icon);
        b1Icon.setBounds(300,0,100,50);
        b2Icon.setBounds(400,0,100,50);
        b3Icon.setBounds(500,0,100,50);
        b4Icon.setBounds(600,0,100,50);
        b1Icon.addActionListener(this);
        b2Icon.addActionListener(this);
        b3Icon.addActionListener(this);
        b4Icon.addActionListener(this);
        b1Icon.addMouseListener(this);
        b2Icon.addMouseListener(this);
        b3Icon.addMouseListener(this);
        b4Icon.addMouseListener(this);
        javax.swing.border.Border br = BorderFactory.createLineBorder(Color.BLACK);
        panel.setBorder(br);
        panel.setBackground(new Color (18,18,18));
        panel.setBounds(0,0,1000,50);
        panel.setLayout(null);
        b1Icon.setBackground(new Color(240,240,240));
        b2Icon.setBackground(new Color(240,240,240));
        b3Icon.setBackground(new Color(240,240,240));
        b4Icon.setBackground(new Color(240,240,240));
    }
    @Override
    public void actionPerformed(ActionEvent e) {  //go to another section of the app when user press a button.
        if(e.getSource() == b1Icon ){
        
        }
        if(e.getSource() == b3Icon ){
           
        }
        if(e.getSource() == b4Icon ){
            
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) { //The menu button (top button) change color to cyan when the user presses them.
        if(e.getSource() == b1Icon ){
            b1Icon.setBackground(Color.CYAN);
        }
         if(e.getSource() == b2Icon ){
            b2Icon.setBackground(Color.CYAN);
        }
        if(e.getSource() == b3Icon ){
            b3Icon.setBackground(Color.CYAN);
        }
        if(e.getSource() == b4Icon ){
           b4Icon.setBackground(Color.CYAN);
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) { //hovering a menu button changes its color.
        if(e.getSource() == b1Icon ) {
            b1Icon.setBackground(Color.YELLOW);
        }
        if(e.getSource() == b2Icon ) {
            b2Icon.setBackground(Color.YELLOW);
        }
        if(e.getSource() == b3Icon ) {
        b3Icon.setBackground(Color.YELLOW);
        }
        if(e.getSource() == b4Icon ) {
            b4Icon.setBackground(Color.YELLOW);
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == b1Icon ) {
            b1Icon.setBackground(new Color(240,240,240));
            }
            if(e.getSource() == b2Icon ) {
                b2Icon.setBackground(new Color(240,240,240));
            }
            if(e.getSource() == b3Icon ) {
            b3Icon.setBackground(new Color(240,240,240));
            }
            if(e.getSource() == b4Icon ) {
                b4Icon.setBackground(new Color(240,240,240));;
            }
    }
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
}
