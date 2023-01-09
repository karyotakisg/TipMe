//package kourpa;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.xml.stream.Location;
import java.sql.*;

public class ExploreKourpaTest extends JFrame implements ActionListener {

	private JButton [] buttons;
	private JButton postFeed;
	private JPanel explore1;
	private BorderLayout bl;
	private BorderLayout bl2;
	private JScrollPane scroller;
    private JPanel panel;
    private JFrame frame;
    //User user = new User();
    String user = "Kourpadakios";

    public 	ExploreKourpaTest() {
		  super("TipMe");

		  explore1 = new JPanel();
		 	        explore1.setBackground(new Color(25, 100, 200));
		 	        explore1.setLayout(new GridLayout(3, 2, 10, 10));
		 	        JPanel explore2 = new JPanel();
		 		    JPanel explore3 = new JPanel();
		 	        JPanel explore4 = new JPanel();
		 	        JPanel explore5 = new JPanel();
		 		    panel = new JPanel();
		 		    bl = new BorderLayout(5, 5);
		 		    // panel.setLayout(bl);
		 		    panel.setLayout(bl);
		 		    explore1.setPreferredSize(new Dimension(600,600));
		 		    explore2.setPreferredSize(new Dimension(100, 600));
		 		    explore3.setPreferredSize(new Dimension(100, 600));
		 		    explore4.setPreferredSize(new Dimension(800, 100));
		 		    explore5.setPreferredSize(new Dimension(800, 100));
		 		    // panel.add(...);
		 		    panel.add(explore1, BorderLayout.CENTER);
		 		    panel.add(explore2, BorderLayout.EAST);
		 		    panel.add(explore3, BorderLayout.WEST);
		 		    panel.add(explore4, BorderLayout.SOUTH);
		 	        panel.add(explore5, BorderLayout.NORTH);
		 	       // tabs.addTab( "<html><h1 style='padding:5px 100px;font-size:10px;display:inline-block;text-align:center;margin:4px 0px;border:none'>Explore</h1></html>", null, panel, "Explore page");
		 	       add(panel);
		 	       buttons = new JButton[6];



		             Color c = new Color(255, 102, 102);
		             Color c1 = new Color(255, 255, 255);

		 	        for (int count = 0; count < buttons.length; count++ ) {
		 				buttons[count] = new JButton(ExploreButtons.numbers(count));
		 				buttons[count].setBackground(c);
		 				buttons[count].setForeground(c1);
		 				explore1.add(buttons[count]);
		 				buttons[count].addActionListener(this);
		 			}

				}




      public void actionPerformed(ActionEvent e) {

		   for(int counter = 0; counter < buttons.length; counter++) {
			   if(e.getSource() == buttons[counter]) {
				   explore1.setVisible(false);                 //panel
				   ExplorePanel e3 = new ExplorePanel(counter, panel, user);

			   }
		   }



     }


 }
