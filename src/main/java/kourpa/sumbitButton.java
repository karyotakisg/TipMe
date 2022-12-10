package kourpa;

import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class sumbitButton extends JButton implements MouseListener {

	//
	//User user = new User();
	
	Font defaultFont = new Font("Gill Sans MT",Font.BOLD,14);
    Color textColor = Color.decode("#ffffff");
    Color backgroundColor = Color.decode("#000000");
    Color hoverColor = Color.decode("#00aced");
    String s= "sumbit";
    public sumbitButton(){
        s = s.toUpperCase();
        this.setFocusPainted(false);
        this.setText(s);
        this.setBorder(null);
        this.setBackground(backgroundColor);
        this.setFont(defaultFont);
        this.setOpaque(true);
        this.setBounds(700, 260, 150, 50);
        addMouseListener(this); 
 
        
    }
   
    @Override
    public void mouseClicked(MouseEvent e) { //when the button is clicked, sumbit the changes to the server
       if(e.getSource()==this) {
           /*
    	   user.setPassword(String.valueOf(passwordText.getPassword()));
    	   user.setEmail(emailText.getText());
    	   user.setInterest1(p1Text.getText());
    	   user.setInterest2(p2Text.getText());
    	   user.setInterest3(p3Text.getText());
    	   
    	    String jdbcUrl = "jdbc:sqlite:socialmedia.db";

			try {
				// Creating a new Connection
				Connection conn = DriverManager.getConnection(jdbcUrl);
				Statement statement = conn.createStatement(); 
			
			
				String query = "UPDATE User"
						+ "SET password = " + user.getPassword() + ", "
						+ "Email = " + user.getEmail() + ", "
						+ "Interest1 = " + user.getInterest1() + ", "
						+ "Interest2 = " + user.getInterest2() + ", "
						+ "Interest3 = " + user.getInterest3() + ", "
						+ "WHERE username = " + user.getUsername() + ";";
						
						statement.executeUpdate(query);
				
			} catch (SQLException e) {} */

       }  
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource()==this) {  
            this.setBackground(this.hoverColor); 
        }    
    }
    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource()==this) { 
            this.setBackground(this.backgroundColor); 
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
}
