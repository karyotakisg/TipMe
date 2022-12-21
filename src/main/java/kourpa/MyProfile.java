package kourpa;
import java.awt.*;
import java.awt.event.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;
public class MyProfile extends JFrame implements ActionListener, MouseListener {
    User user1 = new User();
	JFrame frame = new JFrame(); //creation of the necesery components for  MyProfile GUI//
    JPanel panel = new JPanel();
    JLabel userLabel = new JLabel("User");
    public JTextField userText = new JTextField(25);
    JLabel passwordLabel = new JLabel("Password");
    public JPasswordField passwordText = new JPasswordField(25);
    JLabel emailLabel = new JLabel("Email");
    public JTextField emailText = new JTextField(25);
    JLabel p1Label = new JLabel("Preference 1");
    public JTextField p1Text = new JTextField(25);
    JLabel p2Label = new JLabel("Preference 2");
    public JTextField p2Text = new JTextField(25);
    JLabel p3Label = new JLabel("Preference 3");
    public JTextField p3Text = new JTextField(25);
    public JTextField firstNameText = new JTextField(25);
    JLabel firstNameLabel = new JLabel("First Name");
    public JTextField lastNameText = new JTextField(25);
    JLabel lastNameLabel = new JLabel("Last Name");
    public JTextField sexText = new JTextField(25);
    JLabel sexLabel = new JLabel("Sex");
    public JTextField phoneNumberText = new JTextField(25);
    JLabel phoneNumberLabel = new JLabel("Phone Number");
    public JTextField birthdayText = new JTextField(25);
    JLabel birthdayLabel = new JLabel("Birthday");
    JLabel labelForPosts = new JLabel("<html><font size = '22' color = 'black'><strong>My Posts</strong><text-align: center></font><</html> ");
    Icon diary = new ImageIcon("src/main/resources/diaryIcon.png");
    JTextArea diaryArea = new JTextArea("Here the user can see his posts!");
    Menu menu = new Menu();
    JButton changeButton = new JButton();
    JButton sumbitButton = new JButton();
    Font defaultFont = new Font("Gill Sans MT",Font.BOLD,16);
    Color textColor = Color.decode("#ffffff");
    Color backgroundColor = Color.decode("#000000");
    Color hoverColor = Color.decode("#00aced");
    String s= "sumbit";
    JDialog dial = new JDialog(this,"Dialog Box");
    JButton dialBut = new JButton("OK");
    MyProfile(User user){ //constructor of the MyProfile GUI
        super("MyProfile");
        user1 = user;
        setSize(1000,1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.getContentPane().setBackground(Color.CYAN);
        panel.setBackground(Color.ORANGE);
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(null); 
        userLabel.setBounds(310,100,165,25);
        panel.add(userLabel);
        userText.setBounds(400,100,165,25);
        panel.add(userText);
        
        passwordLabel.setBounds(310,130,165,25);
        panel.add(passwordLabel);
        passwordText.setBounds(400,130,165,25);
        panel.add(passwordText);
        
        emailLabel.setBounds(310,160, 165, 25);
        panel.add(emailLabel);
        emailText.setBounds(400, 160, 165, 25);
        panel.add(emailText); 
        
        p1Label.setBounds(310, 190, 165, 25);
        panel.add(p1Label);
        p1Text.setBounds(400, 190, 165, 25);
        panel.add(p1Text);
        p2Label.setBounds(310, 220, 165, 25);
        panel.add(p2Label);
        p2Text.setBounds(400, 220, 165, 25);
        panel.add(p2Text);
        p3Label.setBounds(310, 250, 165, 25);
        panel.add(p3Label);
        p3Text.setBounds(400, 250, 165, 25);
        panel.add(p3Text);
        firstNameText.setBounds(400,280,165,25);
        firstNameLabel.setBounds(310,280,165,25);
        lastNameText.setBounds(400,310,165,25);
        lastNameLabel.setBounds(310,310,165,25);
        sexText.setBounds(400,340,165,25);
        sexLabel.setBounds(310,340,165,25);
        birthdayText.setBounds(400,370,165,25);
        birthdayLabel.setBounds(310,370,165,25);
        phoneNumberText.setBounds(400,400,165,25);
        phoneNumberLabel.setBounds(310,400,165,25);
        setValuesInTextAreas();
        panel.add(firstNameLabel);
        panel.add(lastNameLabel);
        panel.add(sexLabel);
        panel.add(phoneNumberLabel);
        panel.add(birthdayLabel);
        panel.add(birthdayText);
        panel.add(firstNameText);
        panel.add(lastNameText);
        panel.add(phoneNumberText);
        panel.add(sexText);

       
        changeButton.setBounds(600, 260, 150, 50);
        changeButton.setText("Change");
        changeButton.addActionListener(this);
        Font defaultFont = new Font("Gill Sans MT",Font.BOLD,16);
        Color textColor = Color.decode("#ffffff");
        Color backgroundColor = Color.decode("#000000");
        changeButton.setFont(defaultFont);
        changeButton.setBackground(backgroundColor);
        changeButton.setForeground(textColor);
        panel.add(changeButton);
        labelForPosts.setBounds(400,420,200,150);
        labelForPosts.setIcon(diary);
        panel.add(labelForPosts);
        setFieldsUneditable();
        diaryArea.setBounds(50,600,800,300);
        diaryArea.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.add(diaryArea);
        panel.add(menu,BorderLayout.NORTH);
        this.add(panel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);    
    }
    public void sumbit(User user){
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
            String query = "UPDATE User SET password = " + "'"+ user.getPassword() +"'" + ", " + "Email = " + "'" + user.getEmail() + "'" + ", " + "Interest1 = " + "'" + user.getInterest1() + "'" + ", " + "Interest2 = " + "'" + user.getInterest2() + "'" + ", " + "Interest3 = " + "'" + user.getInterest3() + "'" + ", " + "PhoneNumber = " + user.getPhoneNumber() + " " + "WHERE username = " + "'" + user.getUsername() + "'" + ";";
            statement.executeUpdate(query);
        } catch (SQLException e) { e.printStackTrace(); }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //make TextArea editable and create sumbit button
        if(e.getSource() == changeButton) {
            changeButton.setVisible(false);
            s = s.toUpperCase();
            sumbitButton.setFocusPainted(false);
            sumbitButton.setText(s);
            sumbitButton.setBorder(null);
            sumbitButton.setBackground(backgroundColor);
            sumbitButton.setForeground(textColor);
            sumbitButton.setFont(defaultFont);
            sumbitButton.setOpaque(true);
            sumbitButton.setBounds(600, 260, 150, 50);
            sumbitButton.addMouseListener(this); 
            panel.add(sumbitButton);
            this.add(panel); 
            changeButton.setVisible(false);
            //setFieldsEditable();
           
            //The only fields a User can modify:
            passwordText.setEditable(true); //
            emailText.setEditable(true); //
            p1Text.setEditable(true); //
            p2Text.setEditable(true); // 
            p3Text.setEditable(true); //
            phoneNumberText.setEditable(true); //
        }   
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == sumbitButton) {
        this.sumbit(user1);
        setValuesInTextAreas();
        dial.setSize(500,500);
        dial.setLocationRelativeTo(null);
        JLabel dialLabel = new JLabel("You have sumbitted your changes with success",SwingConstants.CENTER);
        dialLabel.setSize(100,50);
        dial.add(dialLabel,BorderLayout.CENTER);
        dialBut.setSize(100,50);
        dial.add(dialBut,BorderLayout.SOUTH);
        Icon icon = new ImageIcon("src\\main\\resources\\gif.gif");
        JLabel gifLabel = new JLabel(icon);
        dial.add(gifLabel,BorderLayout.NORTH); 
        dialBut.setVisible(true);
        dial.setVisible(true);
        dialBut.addMouseListener(this);
        }
        if(e.getSource() == dialBut) {
            dial.dispose();
            this.dispose();
        MyProfile obj = new MyProfile(user1);
        } 
    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource()==sumbitButton) {  
            sumbitButton.setBackground(hoverColor); 
        }   
    }
    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource()==sumbitButton) { 
            sumbitButton.setBackground(backgroundColor); 
        }
    }
    public void setFieldsEditable(){
        userText.setEditable(true);
        passwordText.setEditable(true);
        emailText.setEditable(true);
        p1Text.setEditable(true);
        p2Text.setEditable(true);
        p3Text.setEditable(true);
        birthdayText.setEditable(true);
        sexText.setEditable(true);
        firstNameText.setEditable(true);
        lastNameText.setEditable(true);
        phoneNumberText.setEditable(true);
    }
    public void setFieldsUneditable(){
        userText.setEditable(false);
        passwordText.setEditable(false);
        emailText.setEditable(false);
        p1Text.setEditable(false);
        p2Text.setEditable(false);
        p3Text.setEditable(false);
        birthdayText.setEditable(false);
        sexText.setEditable(false);
        firstNameText.setEditable(false);
        lastNameText.setEditable(false);
        phoneNumberText.setEditable(false);
    }
    public void setValuesInTextAreas(){
        userText.setText(user1.getUsername());
        passwordText.setText(user1.getPassword());
        emailText.setText(user1.getEmail());
        p1Text.setText(user1.getInterest1());
        p2Text.setText(user1.getInterest2());
        p3Text.setText(user1.getInterest3());
        firstNameText.setText(user1.getFirstName());
        lastNameText.setText(user1.getLastName());
        sexText.setText(user1.getSex());
        birthdayText.setText(user1.getBirthDate());
        phoneNumberText.setText(user1.getPhoneNumber());
    }
}
