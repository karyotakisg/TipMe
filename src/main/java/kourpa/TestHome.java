package kourpa;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.event.InternalFrameListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.apache.maven.settings.Settings;
import org.w3c.dom.events.MouseEvent;
import net.sf.saxon.trans.SymbolicName.F;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class TestHome implements ActionListener {
    User user = new User();
    private final JFrame frame = new JFrame();
    private final JPanel feed = new JPanel();
    private final JPanel east = new JPanel();
    private final JPanel west = new JPanel();
    private final JPanel center = new JPanel();
    private final JPanel south = new JPanel();
    private final JRadioButton colorPick;
    private final JRadioButton darkMode;
    private final JRadioButton lightMode;
    private final ButtonGroup radioGroup;
    private final JRadioButton plainMode;
    Icon logo = new ImageIcon("src\\main\\resources\\logo.png"); 
    JLabel logo2 =  new JLabel(logo);
    JLabel slogan = new JLabel("Give me just the tip!");


    TestHome(User u) {
		//Adjust the feed frame properly
        frame.setTitle("GetTip");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setSize(1000, 1000);	
        frame.setBackground(Color.BLACK);

		feed.setLayout(new BorderLayout(0, 1));
        feed.setBackground(Color.BLACK);

		//Get Message count
		int count = 0;
		String url = "jdbc:sqlite:socialmedia.db";
		try {
			// New Connection
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();

			// Get posts from the database

			String query = "SELECT Text FROM Post, User WHERE Post.userId = User.userId AND (Post.Category = "
					+ "'" + u.getInterest1() + "'" + "COLLATE NOCASE  OR Post.Category = " + "'" + u.getInterest2()
					+ "'" + "COLLATE NOCASE OR Post.Category = " + "'" + u.getInterest3() + "'"
					+ "COLLATE NOCASE);";

			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				count++; //count the number of posts
			}

			System.out.println(count);
			
			conn.close();
		
		} catch (SQLException s) {
			System.out.println("Error");
			s.printStackTrace();
		}
		
        //Layouts for each panel
        Menu MenuBar = new Menu();
        east.setLayout(new GridLayout(16, 1, 0, 0));
        west.setLayout(new GridLayout(5, 1, 10, 10));
        center.setLayout(new GridLayout(count, 1, 5, 10));
        

		//Colors for each panel
		south.setBackground(new Color(255, 102, 0));
		east.setBackground(new Color(255, 102, 0));
		west.setBackground(new Color(255, 102, 0));
        center.setBackground(Color.BLACK);

        //Sizes for each panel and logo placement
		MenuBar.setPreferredSize(new Dimension(200, 50));
		south.setPreferredSize(new Dimension(200, 60 ));
		east.setPreferredSize(new Dimension(150, 200));
		west.setPreferredSize(new Dimension(150, 200));
        logo2.setBounds(0, 0, 150, 50);
        
        //Image decorations in western panel of BorderLayout
        ImageIcon iconSports = new ImageIcon("src\\main\\resources\\sports.png");
        JLabel sports = new JLabel(iconSports);
        ImageIcon iconFashion = new ImageIcon("src\\main\\resources\\fashion.png");
        JLabel fashion = new JLabel(iconFashion);
        ImageIcon iconScience = new ImageIcon("src\\main\\resources\\science.png");
        JLabel science = new JLabel(iconScience);
        ImageIcon iconMusic = new ImageIcon("src\\main\\resources\\music.png");
        JLabel music = new JLabel(iconMusic);
        ImageIcon iconArt = new ImageIcon("src\\main\\resources\\art.png");
        JLabel art = new JLabel(iconArt);
        ImageIcon iconTravel = new ImageIcon("src\\main\\resources\\travel.png");
        JLabel travel = new JLabel(iconTravel);
        ImageIcon iconEdu = new ImageIcon("src\\main\\resources\\academic.png");
        JLabel academic = new JLabel(iconEdu);
        ImageIcon iconFit = new ImageIcon("src\\main\\resources\\fitness.png");
        JLabel fitness = new JLabel(iconFit);
        ImageIcon iconEnvironment = new ImageIcon("src\\main\\resources\\environment.png");
        JLabel environment = new JLabel(iconEnvironment);
        ImageIcon iconFood = new ImageIcon("src\\main\\resources\\food.png");
        JLabel food = new JLabel(iconFood);
        west.add(sports);
        west.add(environment);
        west.add(academic);
        west.add(science);
        west.add(fashion);
        west.add(art);
        west.add(music);
        west.add(travel);
        west.add(fitness);
        west.add(food);

        //RadioButton modifications
        ImageIcon iconColorChooser = new ImageIcon("src\\main\\resources\\colors.png");
        darkMode = new JRadioButton("Dark Mode", false);
        lightMode = new JRadioButton("Light Mode", false);
        plainMode = new JRadioButton("Plain Mode", true);
        colorPick = new JRadioButton("Other", iconColorChooser, false);
        

        darkMode.setBackground(Color.DARK_GRAY);
        lightMode.setBackground(Color.WHITE);
        plainMode.setBackground(new Color(255, 102, 0));
        colorPick.setBackground(Color.LIGHT_GRAY);
        darkMode.setForeground(Color.WHITE);
        plainMode.setForeground(Color.WHITE);

        east.add(plainMode);
        east.add(darkMode);
        east.add(lightMode);
        east.add(colorPick);

        radioGroup = new ButtonGroup();
        radioGroup.add(darkMode);
        radioGroup.add(lightMode);
        radioGroup.add(plainMode);
        radioGroup.add(colorPick);
        darkMode.addActionListener(this);
        lightMode.addActionListener(this);
        plainMode.addActionListener(this);
        colorPick.addActionListener(this);
       

        //Color chooser buttons modifications
        /*ImageIcon iconColorChooser = new ImageIcon("src\\main\\resources\\colors.png");
        colorPick = new JButton("Pick a color", iconColorChooser);
        colorPick.setCursor(new Cursor(Cursor.HAND_CURSOR));
        colorPick.setSize(80, 30);
        colorPick.addActionListener(this);
        east.add(colorPick);*/

        //Slogan in the southern panel of the feed
        south.setLayout(new FlowLayout(FlowLayout.CENTER));
        Font fontSlogan = new Font("Serif", Font.BOLD, 25);
        slogan.setForeground(Color.WHITE);
        slogan.setFont(fontSlogan);
        south.add(slogan);
        
        // SQLite connection URL
		String jdbcUrl = "jdbc:sqlite:socialmedia.db";

		try {
			// Creating a new Connection
			Connection conn = DriverManager.getConnection(jdbcUrl);
			Statement statement = conn.createStatement();

			//System.out.println("Connected");

		    // Get the right posts from the database
			
		    String query = "SELECT Post.PostId, User.username, Post.text, Post.uploaddate, Post.likes, Post.Category FROM Post, User WHERE Post.userId = User.userId AND (Post.Category = " + "'" + u.getInterest1() + "'" + "COLLATE NOCASE  OR Post.Category = " + "'" + u.getInterest2() + "'" + "COLLATE NOCASE OR Post.Category = " + "'" + u.getInterest1() + "'" + "COLLATE NOCASE) ORDER BY uploadDate DESC;";

		    ResultSet rs = statement.executeQuery(query);

		    while (rs.next()) {
		    	
                /*Panel creation in order to separate the User information (username, date, category), the actual message 
                 and the like button through BorderLayout */
			    JPanel post = new JPanel(new BorderLayout(1, 1));
			    Font font = new Font("Serif", Font.PLAIN, 20);
             //   Font fontLike = new Font("Serif", Font.BOLD, 15);
                Color labelBackground;

                //User's Information modifications and data passing to the 1st textarea
                JTextArea postUserInfo = new JTextArea();
			    postUserInfo.setText(rs.getString("username") + "            " + rs.getString("uploaddate") + "            "
			     + rs.getString("Category"));
			    postUserInfo.setBackground(Color.WHITE);
			    postUserInfo.setEditable(false);
			    postUserInfo.setFont(font);
			    postUserInfo.setForeground(Color.BLACK);

                //User's message modification and data passing to the 2nd textarea
			    JTextArea postMessage = new JTextArea();
			    postMessage.setText(rs.getString("text"));
			    postMessage.setBackground(Color.WHITE);
			    postMessage.setEditable(false);
			    postMessage.setFont(font);
			    postMessage.setForeground(Color.BLACK);
			
			
			    int postid = rs.getInt("PostId");	
			    //showcase the like button
			   // p.getLikeButton(postid);
			    
			    Font fontLike = new Font("Serif", Font.BOLD, 15);
				ImageIcon icon = new ImageIcon("src\\main\\resources\\like.png");
				JButton like = new JButton(icon);
				like.setFont(fontLike);
			    like.setPreferredSize(new Dimension(100, 30 ));
			    like.setBackground(Color.white);
			    like.setForeground(Color.WHITE);
	            like.setFocusable(false);

                //Place it in the southern panel of the BorderLayout 
                JPanel southLike = new JPanel(new FlowLayout(FlowLayout.LEFT));
                southLike.setSize(900, 30);
                southLike.setBackground(Color.white);
                southLike.add(like);

                //final adding
			    post.add(postUserInfo, BorderLayout.NORTH);
			    post.add(postMessage, BorderLayout.CENTER);
			    post.add(southLike, BorderLayout.SOUTH);
			    center.add(post);
			    
			    like.addActionListener(new ActionListener() {
					

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
					
						String query = "UPDATE Post SET Likes = Likes+1 WHERE PostId =" + postid;
						
						String jdbcUrl = "jdbc:sqlite:socialmedia.db";
						try {
							Connection conn = DriverManager.getConnection(jdbcUrl);
							Statement statement = conn.createStatement();
							
							statement.executeQuery(query);
							
							
						} catch (SQLException s) {
							  // TODO Auto-generated catch block
							  System.out.println("Failed to connect and get the number of likes");
							  s.printStackTrace();  
						}
						
					}});
		    }   
		
		    
		
		} catch (SQLException s) {
			System.out.println("Error");
			s.printStackTrace();
		}
		
        //add all the necessary components to the frame container
        frame.add(logo2);
		frame.add(feed);
		feed.add(MenuBar, BorderLayout.NORTH);
        feed.add(south, BorderLayout.SOUTH);
        feed.add(center, BorderLayout.CENTER);
        feed.add(west, BorderLayout.WEST);
        feed.add(east, BorderLayout.EAST);

        //create a scroll bar for the central panel which includes the messages
		JScrollPane scr = new JScrollPane(center, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		feed.add(scr, BorderLayout.CENTER);
		scr.getVerticalScrollBar().setUnitIncrement(12);
		
		frame.setVisible(true);

        
    }

    //Utilizing the RadioButtons and JColorChooser for changing the background color
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == darkMode) {
            east.setBackground(Color.DARK_GRAY);
            west.setBackground(Color.DARK_GRAY);
            south.setBackground(Color.DARK_GRAY);
            
            slogan.setForeground(Color.WHITE);

        } else if (e.getSource() == lightMode) {   
            east.setBackground(Color.white);
            west.setBackground(Color.WHITE);
            south.setBackground(Color.WHITE);
            
            slogan.setForeground(Color.BLACK);

        } else if (e.getSource() == plainMode){
            south.setBackground(new Color(255, 102, 0));
            east.setBackground(new Color(255, 102, 0));
            west.setBackground(new Color(255, 102, 0));
            
            slogan.setForeground(Color.WHITE);

        } else if (e.getSource() == colorPick) {
            JColorChooser colorChoose = new JColorChooser();
            Color col = JColorChooser.showDialog(null, "Pick a color!", Color.LIGHT_GRAY);
            south.setBackground(col);
            east.setBackground(col);
            west.setBackground(col);
        } 
    }

    //necessary method in order to dispose the correct frame when clicking on the menu buttons
    public final JFrame getMainFrame(){
        return frame;
    }
    
    /*Color bord = new Color(204, 0, 51);
    Color brown = new Color(102, 51, 0);
    public Color getCategoryColor(String categ) {
    	if (categ == "Sports") {
    		return Color.BLUE; 		
    	} else if (categ == "Education") {
    		return Color.DARK_GRAY;
    	} else if (categ == "Environment") {
    		return Color.GREEN;
    	} else if (categ == "Fashion") {
    		return Color.PINK;
		} else if (categ == "Science") {
    		return  Color.YELLOW;
		} else if (categ == "Art") {
    		return Color.ORANGE;
		} else if (categ == "Food") {
    		return brown;
		} else if (categ == "Travel") {
    		return Color.pink;
    	} else if (categ == "Fitness") {
    		return bord;
    	} else if (categ == "Music") {
    		return Color.BLACK;
    	} else {
    		return Color.CYAN;
    	}
	}*/

}