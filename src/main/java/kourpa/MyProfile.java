package kourpa;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MyProfile extends JFrame implements ActionListener, KeyListener, MouseListener {
   JFrame frame = new JFrame(); //creation of the necesery components for  MyProfile GUI//
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
   
   
   JPanel panel2 = new JPanel();
   Icon upload = new ImageIcon("src/main/resources/Upload.png");
   Icon myProfile = new ImageIcon("src/main/resources/MyProfile.png");
   Icon homepage = new ImageIcon("src/main/resources/Homepage.png");
   Icon explore = new ImageIcon("src/main/resources/Explore.png");
   JButton b1Icon = new JButton(upload);
   JButton b2Icon = new JButton(myProfile);
   JButton b3Icon = new JButton(homepage);
   JButton b4Icon = new JButton(explore);
   

     MyProfile(User user){ //constructor of the MyProfile GUI
        frame.setTitle("MyProfile");
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.getContentPane().setBackground(Color.CYAN);
        
        panel.setBackground(Color.ORANGE);
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(null);
        frame.add(panel);
        
        userLabel.setBounds(310,200,165,25);
        panel.add(userLabel);
        
        userText.setBounds(400,200,165,25);
        panel.add(userText);
        userText.setText(user.getUsername());
        
        passwordLabel.setBounds(310,230,165,25);
        panel.add(passwordLabel);
        
        passwordText.setBounds(400,230,165,25);
        panel.add(passwordText);
        passwordText.setText(user.getPassword());
        
        emailLabel.setBounds(310,260, 165, 25);
        panel.add(emailLabel);
        
        emailText.setBounds(400, 260, 165, 25);
        panel.add(emailText); 
        emailText.setText(user.getMail());

        p1Label.setBounds(310, 290, 165, 25);
        panel.add(p1Label);
       
        p1Text.setBounds(400, 290, 165, 25);
        panel.add(p1Text);
        p1Text.setText(user.getp1());

        p2Label.setBounds(310, 320, 165, 25);
        panel.add(p2Label);
       
        p2Text.setBounds(400, 320, 165, 25);
        panel.add(p2Text);
        p2Text.setText(user.getp2());

        p3Label.setBounds(310, 350, 165, 25);
        panel.add(p3Label);
        
        p3Text.setBounds(400, 350, 165, 25);
        panel.add(p3Text);
        p3Text.setText(user.getp3());

       b1.addActionListener(this);
       b2.addActionListener(this);
       b3.addActionListener(this);
       b4.addActionListener(this);
       b5.addActionListener(this);
       b6.addActionListener(this);
       userText.addKeyListener(this);
       passwordText.addKeyListener(this);
       emailText.addKeyListener(this);
       p1Text.addKeyListener(this);
       p2Text.addKeyListener(this);
       p3Text.addKeyListener(this);

      
       
        
       b1.setBounds(600,200,80,25);//placing of buttons//
       b1.setText("Change");
       panel.add(b1);
       b2.setBounds(600,230,80,25);
       b2.setText("Change");
       panel.add(b2);
       b3.setBounds(600,260,80,25);
       b3.setText("Change");
       panel.add(b3);
       b4.setBounds(600,290,80,25);
       b4.setText("Change");
       panel.add(b4);
       b5.setBounds(600,320,80,25);
       b5.setText("Change");
       panel.add(b5);
       b6.setBounds(600,350,80,25);
       b6.setText("Change");
       panel.add(b6);

       

       JLabel labelForPosts = new JLabel("<html><font size = '22' color = 'black'><strong>My Posts</strong><text-align: center></font><</html> ");
       labelForPosts.setBounds(400,420,200,150);
       Icon diary = new ImageIcon("src/main/resources/diaryIcon.png");
       labelForPosts.setIcon(diary);
       panel.add(labelForPosts);
       
       JTextArea diaryArea = new JTextArea("Here the user can see his posts!"); // will be changed later. string setted for the purposes of the presentation
       diaryArea.setBounds(50,600,800,300);
       diaryArea.setBorder(BorderFactory.createLineBorder(Color.black));
       panel.add(diaryArea);
       
       frame.setVisible(true);
    }
    public void menu(){  //Creates the menu of the app 
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
    public void actionPerformed(ActionEvent e) {
        //delete the existing text when the user presses the button "change"//
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
        //go to another section of the app when user press a button. For example, when the user press the homepage button, open the homepage interface//
        if(e.getSource() == b1Icon ){
          Upload upload = new Upload();
        }
        if(e.getSource() == b2Icon ){
            
        }
        if(e.getSource() == b3Icon ){
           
        }
        if(e.getSource() == b4Icon ){
            
        }
        
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        //for submitting changes in the user setting after pressing enter//
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ENTER & e.getSource() == userText){
            
        }
        if (key == KeyEvent.VK_ENTER & e.getSource() == passwordText){
            
        }
        if (key == KeyEvent.VK_ENTER & e.getSource() == emailText){
            
        }
        if (key == KeyEvent.VK_ENTER & e.getSource() == p1Text){
            
        }
        if (key == KeyEvent.VK_ENTER & e.getSource() == p2Text){
            
        }
        if (key == KeyEvent.VK_ENTER & e.getSource() == p3Text){
            
        }
    }
   
    @Override
    public void keyReleased(KeyEvent e) {}
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
        if(e.getSource() == b1Icon ){
        b1Icon.setBackground(Color.YELLOW);
        }
        if(e.getSource() == b2Icon ){
            b2Icon.setBackground(Color.YELLOW);
            }
        if(e.getSource() == b3Icon ){
        b3Icon.setBackground(Color.YELLOW);
        }
        if(e.getSource() == b4Icon ){
            b4Icon.setBackground(Color.YELLOW);
            }

    }
    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == b1Icon ){
            b1Icon.setBackground(new Color(240,240,240));
            }
            if(e.getSource() == b2Icon ){
                b2Icon.setBackground(new Color(240,240,240));
                }
            if(e.getSource() == b3Icon ){
            b3Icon.setBackground(new Color(240,240,240));
            }
            if(e.getSource() == b4Icon ){
                b4Icon.setBackground(new Color(240,240,240));
                }
         }
    @Override
    public void keyTyped(KeyEvent e) {}
   }
