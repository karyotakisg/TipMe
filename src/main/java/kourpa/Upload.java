package kourpa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

public class Upload {
	private int number = 0;
	private String tip;
	private String categ;
	/* Set graphics of upload */
	JFrame jf = new JFrame();
	JPanel jp = new JPanel();
	JPanel jpsouth = new JPanel();
	JPanel jpnorth = new JPanel();
	JPanel jpwest = new JPanel();
	JPanel jpeast = new JPanel();
	JPanel jpgridleft = new JPanel();
	JPanel jpgridright = new JPanel();
	
	JButton jb = new JButton("Upload");
	JButton jbinfo = new JButton("Info");
	
	User user = new User();

	public Upload(User u) {
		
		user = u;
		
		jf.setTitle("Upload");
		jf.setResizable(false);
		jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		jf.setLayout(new BorderLayout(1,1));
		jf.setBounds(455, 225, 500, 300);
		
		jp.setBackground(new Color(255, 102, 0));
		jp.setLayout(new BorderLayout(1, 1));
		
		jpnorth.setLayout(new GridLayout(2, 1));
		jpnorth.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		jpgridleft.setLayout(new FlowLayout(FlowLayout.LEFT));
		jpgridright.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jpsouth.setLayout(new FlowLayout(FlowLayout.CENTER));
		jpgridleft.setBackground(new Color(255, 102, 0));
		jpgridright.setBackground(new Color(255, 102, 0));
		jpsouth.setBackground(new Color(255, 102, 0));
		jpnorth.setBackground(new Color(255, 102, 0));
		jpeast.setBackground(new Color(255, 102, 0));
		jpwest.setBackground(new Color(255, 102, 0));
		
		JTextArea textarea = new JTextArea();
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		LineBorder line = new LineBorder(Color.BLACK);
		textarea.setBorder(line);
		Font f = new Font("Calibri",Font.PLAIN,15);
		textarea.setFont(f);
		
		
		jpsouth.add(jb);
		jpsouth.add(jbinfo);
		
		JLabel jlc = new JLabel("Choose Category");
		jpgridright.add(jlc);

		String[] categories = { "SCIENCE", "SPORTS", "MUSIC", "FASHION", "TRAVEL", "FITNESS", "ART", "EDUCATION",
				"NATURE", "FOOD" };
		JComboBox<Object> cb = new JComboBox<Object>(categories);
		jpgridright.add(cb);
		
		JLabel jl5 = new JLabel("Text your tip");
		jpgridleft.add(jl5);
		
		
		jpnorth.add(jpgridright);
		jpnorth.add(jpgridleft);
		

		cb.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					setCateg(cb.getSelectedItem().toString());
				}
			}
		});

		jf.add(jp);
		jp.add(jpsouth, BorderLayout.SOUTH);
		jp.add(jpnorth, BorderLayout.NORTH);
		jp.add(textarea, BorderLayout.CENTER);
		jp.add(jpeast, BorderLayout.EAST);
		jp.add(jpwest, BorderLayout.WEST);
		
		JScrollPane scrollPane = new JScrollPane(textarea,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jp.add(scrollPane, BorderLayout.CENTER);
		jf.setVisible(true);
		
		jbinfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
			//	int number = textarea.getText().length() - (int)textarea.getText().lines().count();
				JOptionPane.showMessageDialog(null,
						"The number of character: " + number);	
			}
		});
		
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
	        //int number = textarea.getText().length() - (int)textarea.getText().count();
				if (number < 1) {
					JOptionPane.showMessageDialog(null, "There is no tip to upload " + "("
				+ number + " / 200 character)");
				} else if (number > 200) {
					JOptionPane.showMessageDialog(null, "Your it is too large "
				+ "("+ number + " / 200 character)");
				} else {
					jf.dispose();
					setTip(textarea.getText());
					Post post = new Post(user); 
					post.storePost(tip, categ);
					JOptionPane.showMessageDialog(null,
							"Your tip is uploaded " +
					"("+ number +" / 200 character)");
				}
			}
		});

	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getCateg() {
		return categ;
	}

	public void setCateg(String categ) {

		this.categ = categ;
	}
}
