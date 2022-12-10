package kourpa;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;
public class sumbitButton extends JButton implements MouseListener {
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
