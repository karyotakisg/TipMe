package kourpa;
//package kourpa.kourpatestclasses;

import javax.swing.*;

import javax.swing.border.Border;

import java.awt.event.*;
import java.awt.*;
import javax.xml.stream.Location;

import java.sql.*;

public class ExplorePage implements ActionListener {

	private JButton [] buttons;
	private JButton postFeed;
	private JPanel center;
	private JPanel east;
	private JPanel west;
	private JPanel south;
	private JPanel north;
	private BorderLayout bl;
	private BorderLayout bl2;
	private JScrollPane scroller;
	private ExplorePanel e3;
    private JPanel panel;
    static JPanel center2;
    static boolean [] flag = new boolean[10];
    private final JFrame frame = new JFrame();
    User u = new User();
    private JButton goback;
    
    public ExplorePage() {}

    public JFrame explorePage(User u, Color col) {

    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(180, 50, 1050, 750);
		frame.setBackground(Color.BLACK);
		   
		center = new JPanel();	  			
		center.setBackground(Color.black);
	 	center.setLayout(new GridLayout(2, 5, 10, 10));
	 	//west.setLayout(new GridLayout(10, 1, 1, 1));
	 	east = new JPanel();
	 	west = new JPanel();
	 	south = new JPanel();
	 	north = new JPanel();
	 	panel = new JPanel();
	 	//panel.setBorder(new RoundedBorder(10)); 		    
		// panel.setLayout(bl);
	 	panel.setLayout(new BorderLayout(2, 2));
	 	//center.setPreferredSize(new Dimension(600,600));
	 	Menu menu = new Menu();
		south.setPreferredSize(new Dimension(200, 50));
		east.setPreferredSize(new Dimension(100, 680));
		west.setPreferredSize(new Dimension(100, 680));
		north.setPreferredSize(new Dimension(800, 100));

		south.setBackground(new Color(255, 102, 0));
		east.setBackground(new Color(255, 102, 0));
		west.setBackground(new Color(255, 102, 0));
		center.setBackground(Color.BLACK);
		panel.setBackground(Color.BLACK);

		// panel.add(...);
		panel.add(center, BorderLayout.CENTER);
		panel.add(east, BorderLayout.EAST);
		panel.add(west, BorderLayout.WEST);
		panel.add(south, BorderLayout.SOUTH);
		// tabs.addTab( "<html><h1 style='padding:5px 100px;font-size:10px;display:inline-block;text-align:center;margin:4px 0px;border:none'>Explore</h1></html>", null, panel, "Explore page");
		 	       
		buttons = new JButton[10];
		Color c = new Color(255, 102, 102);
		Color c1 = new Color(255, 255, 255);
		JButtonCreator(buttons, center);		 	        

		center2 = center;
		
		panel.add(menu.menuBar(u), BorderLayout.NORTH);
		
		frame.add(panel);
		return frame;
    }
    
    public  JPanel getPanel(){ // The following methods are created for testing purposes
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

    public void actionPerformed(ActionEvent e) {	
    	for(int counter = 0; counter < buttons.length; counter++) {
			   if(e.getSource() == buttons[counter]) {
				   center.setVisible(false);                 //panel
				   center2.setVisible(false);
				   e3 = new ExplorePanel(counter,  panel, south, east, west, u, flag);				 
			   }
		}
     }
	

	public static void visibility(int q) {
		center2.setVisible(true);
		flag[q] = true;
	}
	
	
	public void JButtonCreator(JButton[] buttons, JPanel center) {
		for (int count = 0; count < buttons.length; count++ ) {
		 	buttons[count] = new JButton(ExploreButtons.titles(count), ExploreButtons.getIcon(count));
		 	buttons[count].setBackground(ExploreButtons.colors(count));
		 	buttons[count].setForeground(Color.white);
		 	center.add(buttons[count]);
		 	buttons[count].addActionListener(this);
		 	buttons[count].setVerticalTextPosition(SwingConstants.BOTTOM);
		 	buttons[count].setHorizontalTextPosition(SwingConstants.CENTER);
		 	buttons[count].setHorizontalAlignment(SwingConstants.LEFT);
		 	buttons[count].setFont(new Font("Calibri", Font.BOLD, 22));
		}
	}
	
	
	
	

 }
