package kourpa;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.Component;

/**
 * Creates the menu of the application, so the user can navigate through
 * different sections
 * 
 * @author Giannis Karyotakis, Panagiotis Theocharis
 */
public class Menu implements MouseListener { // creates the menu at the top of the screen
	User user = new User();
	JPanel menu = new JPanel();
	Color col = new Color(255, 102, 0);
	Icon upload = new ImageIcon("src/main/resources/Upload.png");
	Icon myProfile = new ImageIcon("src/main/resources/MyProfile.png");
	Icon homepage = new ImageIcon("src/main/resources/Homepage.png");
	Icon explore = new ImageIcon("src/main/resources/Explore.png");
	Icon refresh = new ImageIcon("src/main/resources/refresh.png");
	JButton b1Icon = new JButton(homepage);
	JButton b2Icon = new JButton(explore);
	JButton b3Icon = new JButton(myProfile);
	JButton b4Icon = new JButton(upload);
	JButton b5Icon = new JButton(refresh);
	LoginPage lp = new LoginPage();
	static HomePage hp;
	static ExplorePage ex;
	MyProfile mp;
	
	/* These variables are needed to change 
	 * the frame's visibility properly from the menu.
	 */
	static JFrame myProf;
	static JFrame expl;
	static JFrame home;
	/* These variables work like flags, if the user has not clicked
	 * the counterpart  menu button then the value is 1. 
	 * When the actual counterpart button is clicked the count turns to 0. 
	 * This way we can find all the appropriate cases. (countH = home button, 
	 * countEx = explore button, countPr = myProfile button) 
	 */
	static int countPr = 1;
	static int countEx = 1;
	static int countH = 1;
	//current frame displayed
	static int current = 0;
	//used to transfer the correct color everywhere (plain modes-dark modes etc.)
	static boolean flagColor;
	boolean flag = false;
	JFrame home2;

	/**
	 * The method finds in which frame the user is and navigates him to the next
	 * feature/frame he clicks
	 * 
	 * @param u   the data of user
	 * @param col the current color of background
	 * @return menu Panel
	 */
	public JPanel menuBar(User u, Color col) {
		this.user = u;
		menu.add(b1Icon);
		menu.add(b2Icon);
		menu.add(b3Icon);
		menu.add(b4Icon);
		hp = new HomePage();
		mp = new MyProfile();
		ex = new ExplorePage();
		flagColor = false;

		b1Icon.setPreferredSize(new Dimension(100, 50));
		b2Icon.setPreferredSize(new Dimension(100, 50));
		b3Icon.setPreferredSize(new Dimension(100, 50));
		b4Icon.setPreferredSize(new Dimension(100, 50));
		b5Icon.setPreferredSize(new Dimension(35, 35));

		b1Icon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				current = 1;
				/* This if-else statement takes all the cases and variations 
				 * for the time the home page button is clicked. 
				 * This way it knows, when to set the home page visible and which ones
				 * to make invisible.(Ex: First case is when no buttons are clicked
				 * , Second case is when only the explore button is clicked 
				 * (because it's value is 0)) 
				 */
 /* 1st case*/	if (countH != 0 && countEx != 0 & countPr != 0) {
					home = lp.getHome();
					lp.setHome(home);
 /* 2nd case*/	} else if (countH != 0 && countEx == 0 & countPr != 0) {
					countH = 0;
					home = lp.getHome();
					lp.setHome(home);
					home.setVisible(true);
					expl.setVisible(false);
				} else if (countH != 0 && countEx != 0 & countPr == 0) {
					countH = 0;
					home = lp.getHome();
					lp.setHome(home);
					home.setVisible(true);
					myProf.setVisible(false);
				} else if (countH != 0 && countEx == 0 & countPr == 0) {
					countH = 0;
					home = lp.getHome();
					home.setVisible(true);
					expl.setVisible(false);
					myProf.setVisible(false);
				} else if (countH == 0 && countPr != 0 && countEx == 0) {
					home.setVisible(true);
					expl.setVisible(false);
				} else if (countH == 0 && countPr == 0 && countEx != 0) {
					home.setVisible(true);
					myProf.setVisible(false);
				} else {
					home.setVisible(true);
					myProf.setVisible(false);
					expl.setVisible(false);
				}
			}
		});
		/* This if-else statement is the same, but this time with the
		 * explore button (2nd button of the menu)
		 */
		b2Icon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				current = 2;
				if (countH != 0 && countEx != 0 & countPr != 0) {
					countEx = 0;
					expl = lp.getExplore();
					expl.setVisible(true);
					lp.getHome().setVisible(false);
				} else if (countH == 0 && countEx != 0 & countPr != 0) {
					countEx = 0;
					expl = lp.getExplore();
					expl.setVisible(true);
					home.setVisible(false);
				} else if (countH != 0 && countEx != 0 & countPr == 0) {
					countEx = 0;
					expl = lp.getExplore();
					expl.setVisible(true);
					myProf.setVisible(false);
				} else if (countH == 0 && countEx != 0 & countPr == 0) {
					countEx = 0;
					expl = lp.getExplore();
					expl.setVisible(true);
					home.setVisible(false);
					myProf.setVisible(false);
				} else if (countEx == 0 && countPr != 0 && countH != 0) {
					expl.setVisible(true);
				} else if (countEx == 0 && countPr != 0 && countH == 0) {
					expl.setVisible(true);
					home.setVisible(false);
				} else if (countEx == 0 && countPr == 0 && countH != 0) {
					expl.setVisible(true);
					myProf.setVisible(false);
				} else {
					expl.setVisible(true);
					myProf.setVisible(false);
					home.setVisible(false);
				}
			}
		});
		// Similar to the previous ones, but with profile button
		b3Icon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				current = 3;
				if (countH != 0 && countEx != 0 & countPr != 0) {
					countPr = 0;
					myProf = lp.getMyProf();
					myProf.setVisible(true);
					lp.getHome().setVisible(false);
				} else if (countH == 0 && countEx != 0 & countPr != 0) {
					countPr = 0;
					myProf = lp.getMyProf();
					myProf.setVisible(true);
					home.setVisible(false);
				} else if (countH != 0 && countEx == 0 & countPr != 0) {
					countPr = 0;
					myProf = lp.getMyProf();
					myProf.setVisible(true);
					expl.setVisible(false);
				} else if (countH == 0 && countEx == 0 & countPr != 0) {
					countPr = 0;
					myProf = lp.getMyProf();
					myProf.setVisible(true);
					expl.setVisible(false);
				} else if (countH != 0 && countEx != 0 & countPr == 0){
				} else if (countEx == 0 && countPr == 0 && countH != 0) {
					myProf.setVisible(true);
					expl.setVisible(false);
				} else if (countEx != 0 && countPr == 0 && countH == 0) {
					myProf.setVisible(true);
					home.setVisible(false);
				} else {
					myProf.setVisible(true);
					home.setVisible(false);
					expl.setVisible(false);
				}
			}
		});
		//Upload button
		b4Icon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flag = !flag;
				if (flag && (current == 0 || current == 1)) {
					Upload up = new Upload(); 
					up.upload(u);
				}
				if (current != 1 && current != 0) {
					Upload up = new Upload(); 
					up.upload(u);
				}
			}
		});

		menu.add(b5Icon);
		/* This is the refresh button, which disposes
		 * the current frame and re-makes it. This way the user can
		 * access new data in various ways.
		 */
		b5Icon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flagColor = true;
				//the first frame of home after login is the case: current = 0;
				if (current == 0) {
					lp.getHome().dispose();
					lp.setHome(home);
					home = hp.homePage(u, MyProfile.currentColor);
					home.setVisible(true);
					lp.setHome(home);
				} else if (current == 1) {
					home.dispose();
					home = hp.homePage(u, MyProfile.currentColor);
					home.setVisible(true);
				} else if (current == 3) {
					myProf.dispose();
					myProf = mp.myProfile(u, MyProfile.currentColor);
					myProf.setVisible(true);
				} else {
					menu.remove(b5Icon);
				}
			}
		});

		b1Icon.addMouseListener(this);
		b2Icon.addMouseListener(this);
		b3Icon.addMouseListener(this);
		b4Icon.addMouseListener(this);
		b5Icon.addMouseListener(this);
		Border br = BorderFactory.createLineBorder(Color.BLACK);
		menu.setBorder(br);
		menu.setBackground(Color.BLACK);
		menu.setBounds(0, 0, 1050, 70);
		menu.setLayout(new FlowLayout(FlowLayout.CENTER));
		b1Icon.setBackground(new Color(240, 240, 240));
		b2Icon.setBackground(new Color(240, 240, 240));
		b3Icon.setBackground(new Color(240, 240, 240));
		b4Icon.setBackground(new Color(240, 240, 240));
		b5Icon.setBackground(Color.BLACK);
		return menu;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) { // The menu button (top button) change color to cyan when the user presses
												// them
		if (e.getSource() == b1Icon) {
			b1Icon.setBackground(Color.CYAN);
		}
		if (e.getSource() == b2Icon) {
			b2Icon.setBackground(Color.CYAN);
		}
		if (e.getSource() == b3Icon) {
			b3Icon.setBackground(Color.CYAN);
		}
		if (e.getSource() == b4Icon) {
			b4Icon.setBackground(Color.CYAN);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) { // hovering a menu button changes its color.
		if (e.getSource() == b1Icon) {
			b1Icon.setBackground(Color.YELLOW);
		}
		if (e.getSource() == b2Icon) {
			b2Icon.setBackground(Color.YELLOW);
		}
		if (e.getSource() == b3Icon) {
			b3Icon.setBackground(Color.YELLOW);
		}
		if (e.getSource() == b4Icon) {
			b4Icon.setBackground(Color.YELLOW);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == b1Icon) {
			b1Icon.setBackground(new Color(240, 240, 240));
		}
		if (e.getSource() == b2Icon) {
			b2Icon.setBackground(new Color(240, 240, 240));
		}
		if (e.getSource() == b3Icon) {
			b3Icon.setBackground(new Color(240, 240, 240));
		}
		if (e.getSource() == b4Icon) {
			b4Icon.setBackground(new Color(240, 240, 240));
		}
	}

	/**
	 * If the uses decides to change color, then all components of the app use that
	 * color
	 * 
	 * @param c the current color of the app
	 */
	public void applyColors(int c) {
		/* It gets all the homePage's main components
		 * and paints them the correct colors with a for each statement.
		 * This is used, because it wouldn't transfer the correct colors 
		 * immediately after refresh.
		 */
		Component[] compsF = home.getComponents();
		if (c == 0) {
			for (Component comp : compsF) {
				if (comp instanceof JComponent) {
					((JComponent) comp).setBackground(Color.DARK_GRAY);
				}
			}
		} else if (c == 1) {
			for (Component comp : compsF) {
				if (comp instanceof JComponent) {
					((JComponent) comp).setBackground(Color.white);
				}
			}
			
		} else if (c == 2) {
			for (Component comp : compsF) {
				if (comp instanceof JComponent) {
					((JComponent) comp).setBackground(col);
				}
			}
			
		} else {
			for (Component comp : compsF) {
				if (comp instanceof JComponent) {
					((JComponent) comp).setBackground(MyProfile.col2);
				}
			}
		}
	}
}
