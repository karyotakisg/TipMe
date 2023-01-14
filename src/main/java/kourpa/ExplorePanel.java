package kourpa;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
public class ExplorePanel implements ActionListener {
    String category;
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
    Icon back = new ImageIcon("src\\main\\resources\\goback.png");
    private JButton [] goback;
    private HomePage hp = new HomePage();
	public ExplorePanel(int x, JPanel jf, JPanel south, JPanel east, JPanel west, User u, boolean[] flag) {
        //jf.setLayout(new BorderLayout(5, 5));
          //jf.setLayout(new GridLayout(3, 2, 10, 10));
		goback = new JButton[10];
        for (int d = 0 ; d < goback.length ; d++) {
			goback [d] = new JButton();
		  	goback[d].setIcon(back);
		  	goback[d].setBackground(Color.black);
	    }
        
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
				category = "SCIENCE";
				p0.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p0.setBackground(Color.BLACK);
				customizeMessage(u, category, p0);
				jf.add(p0, BorderLayout.CENTER);
				scr = hp.getScroll(p1);
				jf.add(scr, BorderLayout.CENTER);
			} else {
				p0 = new JPanel();
				category = "SCIENCE";
				p0.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p0.setBackground(Color.BLACK);
				customizeMessage(u, category, p0);
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
				customizeMessage(u, category, p1);
				jf.add(p1, BorderLayout.CENTER);
				scr = hp.getScroll(p1);
				jf.add(scr, BorderLayout.CENTER);
			} else {
				p1 = new JPanel();
				category = "Sports";
				p1.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p1.setBackground(Color.BLACK);
				customizeMessage(u, category, p1);
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
				category = "MUSIC";
				p2.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p2.setBackground(Color.BLACK);
				customizeMessage(u, category, p2);
				jf.add(p2, BorderLayout.CENTER);
				scr = hp.getScroll(p2);
				jf.add(scr, BorderLayout.CENTER);
			} else {
				p2 = new JPanel();
				category = "MUSIC";
				p2.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p2.setBackground(Color.BLACK);
				customizeMessage(u, category, p2);
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
				category = "FASHION";
				p3.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p3.setBackground(Color.BLACK);
				customizeMessage(u, category, p3);
				jf.add(p3, BorderLayout.CENTER);
				scr = hp.getScroll(p3);
				jf.add(scr, BorderLayout.CENTER);
			} else {
				p3 = new JPanel();
				category = "FASHION";
				p3.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p3.setBackground(Color.BLACK);
				customizeMessage(u, category, p3);
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
				category = "TRAVEL";
				p4.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p4.setBackground(Color.BLACK);
				customizeMessage(u, category, p4);
				scr = hp.getScroll(p4);
				jf.add(scr, BorderLayout.CENTER);
			} else {
				p4 = new JPanel();
				category = "TRAVEL";
				p4.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p4.setBackground(Color.BLACK);
				customizeMessage(u, category, p4);
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
				category = "FITNESS";
				p5.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p5.setBackground(Color.BLACK);
				customizeMessage(u, category, p5);
				scr = hp.getScroll(p5);
				jf.add(scr, BorderLayout.CENTER);
			} else {
				p5 = new JPanel();
				category = "FITNESS";
				p5.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p5.setBackground(Color.BLACK);
				customizeMessage(u, category, p5);
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
				category = "ART";
				p6.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p6.setBackground(Color.BLACK);
				customizeMessage(u, category, p6);
				jf.add(p6, BorderLayout.CENTER);
				scr = hp.getScroll(p6);
				jf.add(scr, BorderLayout.CENTER);
			} else {
				p6 = new JPanel();
				category = "ART";
				p6.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p6.setBackground(Color.BLACK);
				customizeMessage(u, category, p6);
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
				customizeMessage(u, category, p7);
				jf.add(p7, BorderLayout.CENTER);
				scr = hp.getScroll(p7);
				jf.add(scr, BorderLayout.CENTER);
		   } else {
			   p7 = new JPanel();
			   	category = "Education";
				p7.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p7.setBackground(Color.BLACK);
				customizeMessage(u, category, p7);
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
				category = "NATURE";
				p8.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p8.setLayout(new GridLayout(hp.getMessageCount(), 1, 7, 3));
				p8.setBackground(Color.BLACK);
				customizeMessage(u, category, p8);
				jf.add(p8, BorderLayout.CENTER);
				scr = hp.getScroll(p8);
				jf.add(scr, BorderLayout.CENTER);
			} else {
				p8 = new JPanel();
				category = "NATURE";
				p8.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p8.setLayout(new GridLayout(hp.getMessageCount(), 1, 7, 3));
				p8.setBackground(Color.BLACK);
				customizeMessage(u, category, p8);
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
				category = "FOOD";
				p9.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p9.setLayout(new GridLayout(hp.getMessageCount(), 1, 7, 3));
				p9.setBackground(Color.BLACK);
				customizeMessage(u, category, p9);
				jf.add(p9, BorderLayout.CENTER);
				scr = hp.getScroll(p9);
				jf.add(scr, BorderLayout.CENTER);
			} else {
				p9 = new JPanel();
				category = "FOOD";
				p9.setLayout(new GridLayout(getMessageCount(category), 1, 7, 3));
				p9.setLayout(new GridLayout(hp.getMessageCount(), 1, 7, 3));
				p9.setBackground(Color.BLACK);
				customizeMessage(u, category, p9);
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
				ExplorePage.visibility(q);
				scr.setVisible(false);
			}
		}
	}	
	public void customizeMessage(User u, String category, JPanel explore) {	
		String jdbcUrl = "jdbc:sqlite:socialmedia.db";
		try {
			// Creating a new Connection
			Connection conn = DriverManager.getConnection(jdbcUrl);
			Statement statement = conn.createStatement();
			// System.out.println("Connected");
			// Get the right posts from the database
			String query = "SELECT User.username, Post.text, Post.uploaddate, Post.likes, Post.PostId, "
					+ "Post.Category FROM Post, User WHERE Post.userId = User.userId AND Post.Category = '" + category + "'";
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				HomePage hp = new HomePage();
				JPanel post = new JPanel(new BorderLayout(1, 1));
				JPanel eastern = new JPanel();
				eastern.setBackground(new Color(245, 245, 245));
				post.setBackground(Color.black);
				post.add(hp.getNorthLabel(rs.getString("username"), rs.getString("uploaddate"), rs.getString("Category")),
					BorderLayout.NORTH);
				post.add(eastern, BorderLayout.EAST);
				post.add(hp.getMessageText(rs.getString("text")), BorderLayout.CENTER);
				post.add(hp.getSouthLike2(rs.getString("text"), explore, post, rs.getInt("PostId")), BorderLayout.SOUTH);
				Post p = new Post();
				p.getLikeCount(rs.getInt("PostId"));
				p.getDislikeCount(rs.getInt("PostId"));
				//postid = rs.getInt("PostId");
				explore.add(post);
			}
		} catch (SQLException s) {
			System.out.println("Error");
			s.printStackTrace();
		}
	}
	
}
