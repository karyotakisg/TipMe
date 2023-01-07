package kourpa;
//package kourpa.kourpatestclasses;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;
import java.awt.*;
import javax.xml.stream.Location;

import java.sql.*;

public class ExploreKourpaTest extends JFrame implements ActionListener {

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
    // private JPanel panel2;
    private final JFrame frame = new JFrame();
    //User user = new User();
    String user = "Kourpadakios";
    private JButton goback;

    public 	ExploreKourpaTest() {

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setBounds(180, 50, 1050, 750);
			frame.setResizable(false);
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
                  	Menu MenuBar = new Menu();
		 		    MenuBar.setPreferredSize(new Dimension(200, 50));
		 		   south.setPreferredSize(new Dimension(200, 50));
					east.setPreferredSize(new Dimension(100, 200));
					west.setPreferredSize(new Dimension(100, 200));
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
		 	        panel.add(north, BorderLayout.NORTH);
		 	       // tabs.addTab( "<html><h1 style='padding:5px 100px;font-size:10px;display:inline-block;text-align:center;margin:4px 0px;border:none'>Explore</h1></html>", null, panel, "Explore page");
		 	       
		 	       buttons = new JButton[10];



		             Color c = new Color(255, 102, 102);
		             Color c1 = new Color(255, 255, 255);

		 	        for (int count = 0; count < buttons.length; count++ ) {
		 				buttons[count] = new JButton(ExploreButtons.titles(count), ExploreButtons.getIcon(count));
		 				buttons[count].setBackground(ExploreButtons.colors(count));
		 				buttons[count].setForeground(c1);
		 				center.add(buttons[count]);
		 				buttons[count].addActionListener(this);
		 				buttons[count].setVerticalTextPosition(SwingConstants.BOTTOM);
		 			    buttons[count].setHorizontalTextPosition(SwingConstants.CENTER);
		 				buttons[count].setHorizontalAlignment(SwingConstants.LEFT);
		 				buttons[count].setFont(new Font("Calibri", Font.BOLD, 22));
		 			}
		 	       
                    panel.add(MenuBar, BorderLayout.NORTH);
                    
                    frame.add(panel);
                    frame.setVisible(true);
	}




      public void actionPerformed(ActionEvent e) {


		   for(int counter = 0; counter < buttons.length; counter++) {
			   if(e.getSource() == buttons[counter]) {
				   center.setVisible(false);                 //panel
				    e3 = new ExplorePanel(counter, panel, south, east, west, user);

				   Icon back = new ImageIcon("C:\\Javaproject new\\goback.png");
				   goback = new JButton(back);
                   west.add(goback);
				   goback.setVisible(true);
				   goback.addActionListener(this);



			   }
		   }

		   if (e.getSource() == goback) {
		   					   ExplorePanel.hidepanel();


					}







		   //if(e.getSource() == goback) {
			   //ExplorePanel.hidepanel();
			   //Explore
			  // center.setVisible(true);





     }
      
      private static class RoundedBorder implements Border {
  		private int radius;

  		RoundedBorder(int radius) {
  			this.radius = radius;
  		}

  		@Override
  		public Insets getBorderInsets(Component c) {
  			return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
  		}

  		@Override
  		public boolean isBorderOpaque() {
  			return true;
  		}

  		@Override
  		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {}
  	}


 }
