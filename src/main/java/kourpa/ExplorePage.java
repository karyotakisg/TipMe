package kourpa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
public class ExplorePage implements ActionListener {
	private JButton [] buttons;
	private JPanel center;
	private static JPanel east;
	private static JPanel west;
	private static JPanel south;
	private static JPanel panel = new JPanel();
	private static JPanel center2;
    static boolean [] flag = new boolean[10];
    private final JFrame frame = new JFrame();
    User u = new User();
    public ExplorePage() {}
    public JFrame explorePage(User u, Color col) {
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(180, 50, 1050, 750);
		frame.setBackground(Color.BLACK);
		frame.setLocationRelativeTo(null);
		Image i = Toolkit.getDefaultToolkit().getImage("src\\main\\resources\\logo.png");
		frame.setIconImage(i);
		center = new JPanel();
		center.setBackground(Color.black);
	 	center.setLayout(new GridLayout(2, 5, 10, 10));
	 	east = new JPanel();
	 	west = new JPanel();
	 	south = new JPanel();
	 	panel = new JPanel();
	 	panel.setLayout(new BorderLayout(2, 2));
	 	Menu menu = new Menu();
		south.setPreferredSize(new Dimension(200, 50));
		east.setPreferredSize(new Dimension(100, 680));
		west.setPreferredSize(new Dimension(100, 680));
		south.setBackground(col);
		east.setBackground(col);
		west.setBackground(col);
		center.setBackground(Color.BLACK);
		panel.setBackground(Color.BLACK);
		panel.add(center, BorderLayout.CENTER);
		panel.add(east, BorderLayout.EAST);
		panel.add(west, BorderLayout.WEST);
		panel.add(south, BorderLayout.SOUTH);
		buttons = new JButton[10];
		JButtonCreator(buttons, center);
		center2 = center;
		panel.add(menu.menuBar(u, col), BorderLayout.NORTH);
		frame.add(panel);
		return frame;
    }    
    public void actionPerformed(ActionEvent e) {
    	for(int counter = 0; counter < buttons.length; counter++) {
		   if(e.getSource() == buttons[counter]) {
			   center.setVisible(false);
			   center2.setVisible(false);
			   @SuppressWarnings("unused")
			ExplorePanel e3 = new ExplorePanel(counter,  panel, south, east, west, u, flag);
		   }
		}
    }
	public static void visibility(int q) {
		center2.setVisible(true);
		flag[q] = true;
	}
	public void applyColors(int c) {
		if (c == 0) {
			east.setBackground(Color.DARK_GRAY);
			west.setBackground(Color.DARK_GRAY);
			south.setBackground(Color.DARK_GRAY);
		} else if (c == 1) {
			east.setBackground(Color.white);
			west.setBackground(Color.white);
			south.setBackground(Color.white);
		} else if (c == 2) {
			east.setBackground(MyProfile.col);
			west.setBackground(MyProfile.col);
			south.setBackground(MyProfile.col);
		} else {
			east.setBackground(MyProfile.col2);
			west.setBackground(MyProfile.col2);
			south.setBackground(MyProfile.col2);
		}
	}
	public void JButtonCreator(JButton[] buttons, JPanel center) {
		for (int count = 0; count < buttons.length; count++ ) {
		 	buttons[count] = new JButton(titles(count), getIcon(count));
		 	buttons[count].setBackground(colors(count));
		 	buttons[count].setForeground(Color.white);
		 	center.add(buttons[count]);
		 	buttons[count].addActionListener(this);
		 	buttons[count].setVerticalTextPosition(SwingConstants.BOTTOM);
		 	buttons[count].setHorizontalTextPosition(SwingConstants.CENTER);
		 	buttons[count].setHorizontalAlignment(SwingConstants.LEFT);
		 	buttons[count].setFont(new Font("Calibri", Font.BOLD, 22));
		}
	}
	public static String titles(int n) {
		if (n == 0) {
			String s1 = "Science";
			return s1;
		} else if (n == 1) {
			String s2 = "Sports";
			return s2;
		} else if (n == 2) {
			String s3 = "Music";
			return s3;
		} else if (n == 3) {
			String s4 =  "Fashion";
			return s4;
		} else if (n == 4) {
			String s5 = "Travel";
			return s5;
		} else if (n == 5)  {
			String s6 = "Fitness";
			return s6;
		} else if (n == 6) {
			String s7 = "Art";
			return s7;
		} else if (n == 7) {
		    String s8 = "Education";
		    return s8;
		} else if (n == 8) {
			String s9 = "Nature";
			return s9;
		} else {
			String s10 = "Food";
			return s10;
		}
	}
	public static Color colors(int n) {
		if (n == 0) {
			Color c1 = new Color(30, 25, 98);
			return c1;
		} else if (n == 1) {
			Color c2 = new Color(0, 102, 204);
			return c2;
		} else if (n == 2) {
			Color c3 = new Color(240, 131, 189);
			return c3;
		} else if (n == 3) {
			Color c4 = new Color(198, 78, 126);
			return c4;
		} else if (n == 4) {
			Color c5 = new Color(155, 236, 236);
			return c5;
		} else if (n == 5)  {
			Color c6 = new Color(147, 236, 156);
			return c6;
		} else if (n == 6) {
			Color c7 = new Color(204, 0, 51);
			return c7;
		} else if (n == 7) {
			Color c8 = new Color(255, 204, 0);
		    return c8;
		} else if (n == 8) {
			Color c9 = new Color(0, 153, 51);
			return c9;
		} else {
			Color c10 = new Color(153, 51, 0);
			return c10;
		}
	}
	public static ImageIcon getIcon(int n) {
	   if (n == 0) {
		   return new ImageIcon("src\\main\\resources\\atom.png");
	   } else if (n == 1) {
		   return new ImageIcon("src\\main\\resources\\sports.png");
	   } else if (n == 2) {
		   return new ImageIcon("src\\main\\resources\\notes.png");
	   } else if (n == 3) {
		   return new ImageIcon("src\\main\\resources\\fashion3.png");
	   } else if (n == 4) {
			return new ImageIcon("src\\main\\resources\\luggage.png");
	   } else if (n == 5) {
			return new ImageIcon("src\\main\\resources\\dumbbell.png");
	   } else if (n == 6) {
			return new ImageIcon("src\\main\\resources\\creativity.png");
	   } else if (n == 7) {
		   return new ImageIcon("src\\main\\resources\\educations.png");
	   } else if (n == 8) {
		   return new ImageIcon("src\\main\\resources\\planet.png");
	   } else if (n == 9) {
		   return new ImageIcon("src\\main\\resources\\fast-food.png");
	   } else {
		   return null;
	   }
	}
 }
