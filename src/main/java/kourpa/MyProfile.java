package kourpa;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class MyProfile extends JFrame implements ActionListener {
   JFrame frame = new JFrame();
   JPanel panel = new JPanel();
   JLabel userLabel = new JLabel("User");
   JTextField userText = new JTextField(25);
   JLabel passwordLabel = new JLabel("Password");
   JPasswordField passwordText = new JPasswordField(25);
   JLabel emailLabel = new JLabel("Email");
   JTextField emailText = new JTextField(25);
   JLabel p1Label = new JLabel("Preference 1");
   JTextField p1Text = new JTextField(25);
   JLabel p2Label = new JLabel("Preference 2");
   JTextField p2Text = new JTextField(25);
   JLabel p3Label = new JLabel("Preference 3");
   JTextField p3Text = new JTextField(25);
   JButton b1 = new JButton();
   JButton b2 = new JButton();
   JButton b3 = new JButton();
   JButton b4 = new JButton();
   JButton b5 = new JButton();
   JButton b6 = new JButton();

     MyProfile(User user){
        frame.setTitle("MyProfile");
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.getContentPane().setBackground(Color.CYAN);
        
        panel.setBackground(Color.ORANGE);
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(null);
        frame.add(panel);
        
        userLabel.setBounds(10,20,165,25);
        panel.add(userLabel);
        
        userText.setBounds(100,20,165,25);
        panel.add(userText);
        userText.setText(user.getUsername());
        
        passwordLabel.setBounds(10,50,165,25);
        panel.add(passwordLabel);
        
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);
        passwordText.setText(user.getPassword());
        
        emailLabel.setBounds(10,80, 165, 25);
        panel.add(emailLabel);
        
        emailText.setBounds(100, 80, 165, 25);
        panel.add(emailText); 
        emailText.setText(user.getMail());

        p1Label.setBounds(10, 110, 165, 25);
        panel.add(p1Label);
       
        p1Text.setBounds(100, 110, 165, 25);
        panel.add(p1Text);
        p1Text.setText(user.getp1());

        p2Label.setBounds(10, 140, 165, 25);
        panel.add(p2Label);
       
        p2Text.setBounds(100, 140, 165, 25);
        panel.add(p2Text);
        p2Text.setText(user.getp2());

        p3Label.setBounds(10, 170, 165, 25);
        panel.add(p3Label);
        
        p3Text.setBounds(100, 170, 165, 25);
        panel.add(p3Text);
        p3Text.setText(user.getp3());

       b1.addActionListener(this);
       b2.addActionListener(this);
       b3.addActionListener(this);
       b4.addActionListener(this);
       b5.addActionListener(this);
       b6.addActionListener(this);
      
       b1.setBounds(300,20,80,25);
       b1.setText("Change");
       panel.add(b1);
       b2.setBounds(300,50,80,25);
       b2.setText("Change");
       panel.add(b2);
       b3.setBounds(300,80,80,25);
       b3.setText("Change");
       panel.add(b3);
       b4.setBounds(300,110,80,25);
       b4.setText("Change");
       panel.add(b4);
       b5.setBounds(300,140,80,25);
       b5.setText("Change");
       panel.add(b5);
       b6.setBounds(300,170,80,25);
       b6.setText("Change");
       panel.add(b6);
       frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1 ){
            userText.setText("");
        }
        if(e.getSource() == b2 ){
            passwordText.setText("");
        }
        if(e.getSource() == b3 ){
            emailText.setText("");
        }
        if(e.getSource() == b4 ){
            p1Text.setText("");
        }
        if(e.getSource() == b5 ){
            p2Text.setText("");
        }
        if(e.getSource() == b6 ){
            p3Text.setText("");
        }
    }
}
