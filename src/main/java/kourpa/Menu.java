package kourpa;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu implements ActionListener, KeyListener, MouseListener  { //creates the menu at the top of the screen for each section of the app
    public Menu(){
        JPanel panel2 = new JPanel();
        Icon upload = new ImageIcon("src/main/resources/Upload.png");
        Icon myProfile = new ImageIcon("src/main/resources/MyProfile.png");
        Icon homepage = new ImageIcon("src/main/resources/Homepage.png");
        Icon explore = new ImageIcon("src/main/resources/Explore.png");
        JButton b1Icon = new JButton(upload);
        JButton b2Icon = new JButton(myProfile);
        JButton b3Icon = new JButton(homepage);
        JButton b4Icon = new JButton(explore);
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
        javax.swing.border.Border br = BorderFactory.createLineBorder(Color.black);
        panel2.setBorder(br);
        panel2.setBackground(new Color(18,18,18));
        panel2.setBounds(0,0,1000,50);
        panel2.setLayout(null);
        panel.add(panel2);
        b1Icon.setBackground(new Color(240,240,240));
        b2Icon.setBackground(new Color(240,240,240));
        b3Icon.setBackground(new Color(240,240,240));
        b4Icon.setBackground(new Color(240,240,240));
    }
    @Override
    public void actionPerformed(ActionEvent e) {}
}
