package kourpa;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class Menu extends JPanel implements  KeyListener, MouseListener { // creates the menu at the top
                                                                                         // of the screen for each
                      
    User user = new User();
    Color col = new Color(255, 102, 0);
    Icon upload = new ImageIcon("src/main/resources/Upload.png");
    Icon myProfile = new ImageIcon("src/main/resources/MyProfile.png");
    Icon homepage = new ImageIcon("src/main/resources/Homepage.png");
    Icon explore = new ImageIcon("src/main/resources/Explore.png");
    JButton b1Icon = new JButton(homepage);
    JButton b2Icon = new JButton(explore);
    JButton b3Icon = new JButton(myProfile);
    JButton b4Icon = new JButton(upload);
    ButtonGroup radioGroup = new ButtonGroup();
    MyProfile mp;
    HomePage hp;
    ExplorePage ex;
    static JFrame  myProf;
    static JFrame  expl;
    static JFrame  home;
    static int countPr = 1;
    static int countEx = 1;
    static int countH = 1;

    public JPanel menuBar(User u)  {
        this.add(b1Icon);
        this.add(b2Icon);
        this.add(b3Icon);
        this.add(b4Icon);
        
        
        
        hp = new HomePage();
        mp = new MyProfile();
        ex = new ExplorePage();
        
        
        //this.frame = frame;
        b1Icon.setPreferredSize(new Dimension(100, 50));
        b2Icon.setPreferredSize(new Dimension(100, 50));
        b3Icon.setPreferredSize(new Dimension(100, 50));
        b4Icon.setPreferredSize(new Dimension(100, 50));

        b1Icon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(countH == 1) {
					countH = 0;
					home = hp.homePage(u);
					home.setVisible(true);
				} else if (countEx != 0 && countPr != 0 && countH == 0) {
					home.setVisible(true);
				} else if (countH == 0 && countPr != 0 && countEx == 0) {
					home.setVisible(true);
					expl.setVisible(false);
					
				} else if (countEx == 0 && countPr == 0 && countEx != 0) {
					home.setVisible(true);
					myProf.setVisible(false);
					
				} else {
					home.setVisible(true);
					myProf.setVisible(false);				
					expl.setVisible(false);
					
				}
			}
        	
        });
        b2Icon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (countEx == 1) {
					countEx = 0;
					expl = ex.explorePage(u, col);
					expl.setVisible(true);
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
        b3Icon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {	
				if (countPr == 1) {
					countPr = 0;
					myProf = mp.myProfile(u);
					myProf.setVisible(true);
				} else if (countEx != 0 && countPr == 0 && countH != 0) {
					myProf.setVisible(true);
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
        b4Icon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Upload();
			}
        	
        });
        b1Icon.addMouseListener(this);
        b2Icon.addMouseListener(this);
        b3Icon.addMouseListener(this);
        b4Icon.addMouseListener(this);

        javax.swing.border.Border br = BorderFactory.createLineBorder(Color.BLACK);
        this.setBorder(br);
        this.setBackground(Color.BLACK);
        this.setBounds(0, 0, 1050, 70);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        b1Icon.setBackground(new Color(240, 240, 240));
        b2Icon.setBackground(new Color(240, 240, 240));
        b3Icon.setBackground(new Color(240, 240, 240));
        b4Icon.setBackground(new Color(240, 240, 240));
        
        return this;
        
    }

    

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) { // The menu button (top button) change color to cyan when the user presses
                                             // them.
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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
