package kourpa;
//package kourpa.kourpatestclasses;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class ExplorePanel implements ActionListener {

    String category;
    private Timer timer;
    private static JPanel p0;
    private static JPanel p1;
    private static JPanel p2;
    private static JPanel p3;
    private static JPanel p4;
    private static JPanel p5;
    private static JPanel p6;
    private static JPanel p7;
    private static JScrollPane scr;
    private static JPanel p8;
    private static JPanel p9;
    CardLayout cl = new CardLayout();
    JPanel jp;
    Icon back = new ImageIcon("src\\main\\resources\\goback.png");
    private JButton [] goback;

	public ExplorePanel(int x, JPanel jf, JPanel south, JPanel east, JPanel west, User u, boolean[] flag) {
        //jf.setLayout(new BorderLayout(5, 5));
          //jf.setLayout(new GridLayout(3, 2, 10, 10));
		goback = new JButton[10];
        for (int d = 0 ; d < goback.length ; d++) {
			    goback [d] = new JButton();
		  		goback[d].setIcon(back);
		  		goback[d].setBackground(Color.black);
	     }
        HomePage hp = new HomePage();
        south.setPreferredSize(new Dimension(200, 50));
        east.setPreferredSize(new Dimension(100, 200));
		west.setPreferredSize(new Dimension(100, 200));
		if(x == 0) {
			if (flag [0] == false) {
				for (int w = 0 ; w < 10 ; w++) {
					if ( w == x) {
						west.add(goback[w]);	
						goback[w].addActionListener(this);
					} else {
						west.remove(goback[w]);
					}
				}
				p0 = new JPanel();
				category = "Science";
				p0.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p0.setBackground(Color.BLACK);
				CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p0);
				jf.add(p0, BorderLayout.CENTER);
				scr = hp.getScroll(p1);
				jf.add(scr, BorderLayout.CENTER);
			} else {
				p0 = new JPanel();
				category = "Science";
				p0.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p0.setBackground(Color.BLACK);
				CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p0);
				jf.add(p0, BorderLayout.CENTER);
				scr = hp.getScroll(p0);
				jf.add(scr, BorderLayout.CENTER);
				for (int w = 0 ; w < 10 ; w++) {
					if ( w == x) {
						west.add(goback[w]);
						goback[w].addActionListener(this);
					} else {
						west.remove(goback[w]);
					}
				}
			}
		} else if(x == 1) {
			if (flag [1] == false) {
				for (int w = 0 ; w < 10 ; w++) {
					if ( w == x) {
						west.add(goback[w]);	
						goback[w].addActionListener(this);
					} else {
						west.remove(goback[w]);
					}
				}
				p1 = new JPanel();
				category = "Sports";
				p1.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p1.setBackground(Color.BLACK);
				CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p1);
				jf.add(p1, BorderLayout.CENTER);
				scr = hp.getScroll(p1);
				jf.add(scr, BorderLayout.CENTER);
			} else {
				p1 = new JPanel();
				category = "Sports";
				p1.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p1.setBackground(Color.BLACK);
				CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p1);
				jf.add(p1, BorderLayout.CENTER);
				scr = hp.getScroll(p1);
				jf.add(scr, BorderLayout.CENTER);
				for (int w = 0 ; w < 10 ; w++) {
					if ( w == x) {
						west.add(goback[w]);
						goback[w].addActionListener(this);
					} else {
						west.remove(goback[w]);
					}
				}
			}	            

		} else if(x == 2) {
			if (flag [2] == false) {
				for (int w = 0 ; w < 10 ; w++) {
					if ( w == x) {
						west.add(goback[w]);	
						goback[w].addActionListener(this);
					} else {
						west.remove(goback[w]);
					}
				}
			
				p2 = new JPanel();
				category = "Music";
				p2.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p2.setBackground(Color.BLACK);
				CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p2);
				jf.add(p2, BorderLayout.CENTER);
				scr = hp.getScroll(p2);
				jf.add(scr, BorderLayout.CENTER);
			} else {
				p2 = new JPanel();
				category = "Music";
				p2.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p2.setBackground(Color.BLACK);
				CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p2);
				jf.add(p2, BorderLayout.CENTER);
				scr = hp.getScroll(p2);
				jf.add(scr, BorderLayout.CENTER);
				for (int w = 0 ; w < 10 ; w++) {
					if ( w == x) {
						west.add(goback[w]);
						goback[w].addActionListener(this);
					} else {
						west.remove(goback[w]);
					}
				}
			}
		} else if(x == 3) {
			if (flag [3] == false) {
				for (int w = 0 ; w < 10 ; w++) {
					if ( w == x) {
						west.add(goback[w]);	
						goback[w].addActionListener(this);
					} else {
						west.remove(goback[w]);
					}
				}
				p3 = new JPanel();
				category = "Fashion";
				p3.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p3.setBackground(Color.BLACK);
				CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p3);
				jf.add(p3, BorderLayout.CENTER);
				scr = hp.getScroll(p3);
				jf.add(scr, BorderLayout.CENTER);
			} else {
				p3 = new JPanel();
				category = "Fashion";
				p3.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p3.setBackground(Color.BLACK);
				CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p3);
				jf.add(p3, BorderLayout.CENTER);
				scr = hp.getScroll(p3);
				jf.add(scr, BorderLayout.CENTER);
				for (int w = 0 ; w < 10 ; w++) {
					if ( w == x) {
						west.add(goback[w]);
						goback[w].addActionListener(this);
					} else {
						west.remove(goback[w]);
					}
				}
			}
		} else if(x == 4) {
			if (flag [4] == false) {
				for (int w = 0 ; w < 10 ; w++) {
					if ( w == x) {
						west.add(goback[w]);	
						goback[w].addActionListener(this);
					} else {
						west.remove(goback[w]);
					}
				}
				p4 = new JPanel();
				category = "Travel";
				p4.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p4.setBackground(Color.BLACK);
				CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p4);
				scr = hp.getScroll(p4);
				jf.add(scr, BorderLayout.CENTER);
			} else {
				p4 = new JPanel();
				category = "Travel";
				p4.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p4.setBackground(Color.BLACK);
				CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p4);
				scr = hp.getScroll(p4);
				jf.add(scr, BorderLayout.CENTER);
				for (int w = 0 ; w < 10 ; w++) {
					if ( w == x) {
						west.add(goback[w]);
						goback[w].addActionListener(this);
					} else {
						west.remove(goback[w]);
					}
				}
			}
		} else if(x == 5) {
			if (flag [5] == false) {
				for (int w = 0 ; w < 10 ; w++) {
					if ( w == x) {
						west.add(goback[w]);	
						goback[w].addActionListener(this);
					} else {
						west.remove(goback[w]);
					}
				}
				p5 = new JPanel();
				category = "Fitness";
				p5.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p5.setBackground(Color.BLACK);
				CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p5);
				scr = hp.getScroll(p5);
				jf.add(scr, BorderLayout.CENTER);
			} else {
				p5 = new JPanel();
				category = "Fitness";
				p5.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p5.setBackground(Color.BLACK);
				CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p5);
				scr = hp.getScroll(p5);
				jf.add(scr, BorderLayout.CENTER);
				for (int w = 0 ; w < 10 ; w++) {
					if ( w == x) {
						west.add(goback[w]);
						goback[w].addActionListener(this);
					} else {
						west.remove(goback[w]);
					}
				}
			}
		} else if (x == 6) {
			if (flag [6] == false) {
				for (int w = 0 ; w < 10 ; w++) {
					if ( w == x) {
						west.add(goback[w]);	
						goback[w].addActionListener(this);
					} else {
						west.remove(goback[w]);
					}
				}
				p6 = new JPanel();
				category = "Art";
				p6.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p6.setBackground(Color.BLACK);
				CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p6);
				jf.add(p6, BorderLayout.CENTER);
				scr = hp.getScroll(p6);
				jf.add(scr, BorderLayout.CENTER);
			} else {
				p6 = new JPanel();
				category = "Art";
				p6.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p6.setBackground(Color.BLACK);
				CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p6);
				jf.add(p6, BorderLayout.CENTER);
				scr = hp.getScroll(p6);
				jf.add(scr, BorderLayout.CENTER);
				for (int w = 0 ; w < 10 ; w++) {
					if ( w == x) {
						west.add(goback[w]);
						goback[w].addActionListener(this);
					} else {
						west.remove(goback[w]);
					}
				}
			}
	   } else if (x == 7) {
		   if (flag [7] == false) {
				for (int w = 0 ; w < 10 ; w++) {
					if ( w == x) {
						west.add(goback[w]);	
						goback[w].addActionListener(this);
					} else {
						west.remove(goback[w]);
					}
				}
			   	p7 = new JPanel();
			   	category = "Education";
				p7.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p7.setBackground(Color.BLACK);			
				CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p7);
				jf.add(p7, BorderLayout.CENTER);
				scr = hp.getScroll(p7);
				jf.add(scr, BorderLayout.CENTER);
		   } else {
			   p7 = new JPanel();
			   	category = "Education";
				p7.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p7.setBackground(Color.BLACK);			
				CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p7);
				jf.add(p7, BorderLayout.CENTER);
				scr = hp.getScroll(p7);
				jf.add(scr, BorderLayout.CENTER);
				for (int w = 0 ; w < 10 ; w++) {
					if ( w == x) {
						west.add(goback[w]);
						goback[w].addActionListener(this);
					} else {
						west.remove(goback[w]);
					}
				}
			}
		} else if ( x == 8) {
			if (flag [8] == false) {
				for (int w = 0 ; w < 10 ; w++) {
					if ( w == x) {
						west.add(goback[w]);	
						goback[w].addActionListener(this);
					} else {
						west.remove(goback[w]);
					}
			}
				p8 = new JPanel();
				category = "Environment";
				p8.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p8.setLayout(new GridLayout(hp.getMessageCount(), 1, 7, 3));
				p8.setBackground(Color.BLACK);
				CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p8);
				jf.add(p8, BorderLayout.CENTER);
				scr = hp.getScroll(p8);
				jf.add(scr, BorderLayout.CENTER);
			} else {
				p8 = new JPanel();
				category = "Environment";
				p8.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p8.setLayout(new GridLayout(hp.getMessageCount(), 1, 7, 3));
				p8.setBackground(Color.BLACK);
				CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p8);
				jf.add(p8, BorderLayout.CENTER);
				scr = hp.getScroll(p8);
				jf.add(scr, BorderLayout.CENTER);
				for (int w = 0 ; w < 10 ; w++) {
					if ( w == x) {
						west.add(goback[w]);
						goback[w].addActionListener(this);
					} else {
						west.remove(goback[w]);
					}
				}
			}
		} else {
			if (flag [9] == false) {
				for (int w = 0 ; w < 10 ; w++) {
					if ( w == x) {
						west.add(goback[w]);	
						goback[w].addActionListener(this);
					} else {
						west.remove(goback[w]);
					}
				}
				p9 = new JPanel();
				category = "Food";
				p9.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p9.setLayout(new GridLayout(hp.getMessageCount(), 1, 7, 3));
				p9.setBackground(Color.BLACK);
				CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p9);
				jf.add(p9, BorderLayout.CENTER);
				scr = hp.getScroll(p9);
				jf.add(scr, BorderLayout.CENTER);
			} else {
				p9 = new JPanel();
				category = "Food";
				p9.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p9.setLayout(new GridLayout(hp.getMessageCount(), 1, 7, 3));
				p9.setBackground(Color.BLACK);
				CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p9);
				jf.add(p9, BorderLayout.CENTER);
				scr = hp.getScroll(p9);
				jf.add(scr, BorderLayout.CENTER);
				for (int w = 0 ; w < 10 ; w++) {
					if ( w == x) {
						west.add(goback[w]);
						goback[w].addActionListener(this);
					} else {
						west.remove(goback[w]);
					}
				}
			}
		}
	}
	
	public int getMessageCount(String category) {
		int count = 0;
		String url = "jdbc:sqlite:socialmedia.db";
		try {
			// New Connection
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();

			// Get posts from the database

			String query = "SELECT User.username, Post.text, Post.uploaddate, Post.likes, Post.Category FROM Post, User WHERE Post.userId = User.userId AND Post.Category = '" + category + "'";

			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				count++; // count the number of posts
			}

			conn.close();

		} catch (SQLException s) {
			System.out.println("Error");
			s.printStackTrace();
		}

		return count;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int q = 0 ; q < goback.length ; q++) {
			if (e.getSource() == goback[q]) {
	            if (p0 != null) {
	            	p0.setVisible(false);
	            }
	            if (p1 != null) {
	            	p1.setVisible(false);            	
	            	

	            }
	            if (p2 != null) {
		            p2.setVisible(false);
				}
				if (p3 != null) {
		            p3.setVisible(false);
				}
				if (p4 != null) {
		            p4.setVisible(false);
				}
				if (p5 != null) {
		            p5.setVisible(false);
				}
				if (p6 != null) {
		            p6.setVisible(false);
				}
				if (p7 != null) {
		            p7.setVisible(false);
				}
				if (p8 != null) {
		            p8.setVisible(false);
				}
				if (p9 != null) {
		            p9.setVisible(false);
				}
				goback[q].setVisible(false);
				ExploreKourpaTest.visibility(q);
				scr.setVisible(false);	        	    
			}
		}

	}
}




