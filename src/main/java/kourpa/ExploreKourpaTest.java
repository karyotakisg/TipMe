package kourpa;
//package kourpa.kourpatestclasses;

import javax.swing.*;
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
    private JFrame frame;
    //User user = new User();
    String user = "Kourpadakios";
    private JButton goback;

    private final JRadioButton colorPick;
	private final JRadioButton darkMode;
    private final JRadioButton lightMode;
    private final ButtonGroup radioGroup;
    private final JRadioButton plainMode;
    JLabel slogan = new JLabel("Give me just the tip!");

    public 	ExploreKourpaTest() {
		  super("TipMe");

		  center = new JPanel();
		 	        center.setBackground(new Color(179, 230, 184));
		 	        center.setLayout(new GridLayout(2, 5, 10, 10));
		 	        //west.setLayout(new GridLayout(10, 1, 1, 1));
		 	        east = new JPanel();
		 		    west = new JPanel();
		 	        south = new JPanel();
		 	        north = new JPanel();
		 		    panel = new JPanel();
		 		    bl = new BorderLayout(5, 5);

		 		    // panel.setLayout(bl);
		 		    panel.setLayout(bl);
		 		    //center.setPreferredSize(new Dimension(600,600));
		 		    east.setPreferredSize(new Dimension(100, 600));
		 		    west.setPreferredSize(new Dimension(100, 600));
		 		    south.setPreferredSize(new Dimension(800, 100));
		 		    north.setPreferredSize(new Dimension(800, 100));


		 		    south.setBackground(new Color(255, 102, 0));
					east.setBackground(new Color(255, 102, 0));
					west.setBackground(new Color(255, 102, 0));
                    center.setBackground(Color.BLACK);

		 		    // panel.add(...);
		 		    panel.add(center, BorderLayout.CENTER);
		 		    panel.add(east, BorderLayout.EAST);
		 		    panel.add(west, BorderLayout.WEST);
		 		    panel.add(south, BorderLayout.SOUTH);
		 	        panel.add(north, BorderLayout.NORTH);
		 	       // tabs.addTab( "<html><h1 style='padding:5px 100px;font-size:10px;display:inline-block;text-align:center;margin:4px 0px;border:none'>Explore</h1></html>", null, panel, "Explore page");
		 	       add(panel);
		 	       buttons = new JButton[10];



		             Color c = new Color(255, 102, 102);
		             Color c1 = new Color(255, 255, 255);

		 	        for (int count = 0; count < buttons.length; count++ ) {
		 				buttons[count] = new JButton(ExploreButtons.titles(count), ExploreButtons.getIcon(count));
		 				buttons[count].setBackground(ExploreButtons.colors(count));
		 				buttons[count].setForeground(c1);
		 				center.add(buttons[count]);
		 				buttons[count].addActionListener(this);
		 				buttons[count].setHorizontalAlignment(SwingConstants.LEFT);
		 				buttons[count].setFont(new Font("Calibri", Font.PLAIN, 30));
		 			}


		    			//scroller = new JScrollPane(center, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		    			//scroller  = new JScrollPane(panel);
		    			//scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		    			//scroller.setPreferredSize(new Dimension(600,600));
		    			//scroller.getViewport().setPreferredSize(new Dimension(160, 200));
	                    //panel.add(scroller);



	                    ImageIcon iconColorChooser = new ImageIcon("C:\\Javaproject new\\colors.png");
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


                                south.setLayout(new FlowLayout(FlowLayout.CENTER));
						        Font fontSlogan = new Font("Serif", Font.BOLD, 25);
						        slogan.setForeground(Color.WHITE);
						        slogan.setFont(fontSlogan);
                                south.add(slogan);


                                Menu MenuBar = new Menu();
                                MenuBar.setPreferredSize(new Dimension(200, 50));
                                panel.add(MenuBar, BorderLayout.NORTH);

								//JScrollPane scr = new JScrollPane(center, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
								//panel.add(scr, BorderLayout.CENTER);
								//scr.getVerticalScrollBar().setUnitIncrement(12);


				}




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


		   for(int counter = 0; counter < buttons.length; counter++) {
			   if(e.getSource() == buttons[counter]) {
				   center.setVisible(false);                 //panel
				    e3 = new ExplorePanel(counter, panel, user);

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


 }
