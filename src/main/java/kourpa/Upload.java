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

	public Upload() {
		
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setLayout(new BorderLayout(1,1));
		jf.setBounds(500, 200, 500, 300);
		
		jp.setBackground(new Color(255, 102, 0));
		jp.setLayout(new BorderLayout(1, 1));
		
		jpnorth.setLayout(new GridLayout(3, 2));
		jpnorth.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
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

		String[] categories = { "General", "Sport", "Science", "Cook", "Video Games", "Nature" };
		JComboBox<Object> cb = new JComboBox<Object>(categories);
		jpgridright.add(cb);
		
		JLabel empty = new JLabel();
		JLabel jl5 = new JLabel("Text your tip");
		jpgridleft.add(jl5);
		
		jpnorth.add(empty);
		jpnorth.add(empty);
		jpnorth.add(empty);
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
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jp.add(scrollPane, BorderLayout.CENTER);
		jf.setVisible(true);
		
		jbinfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int number = textarea.getText().length();
				JOptionPane.showMessageDialog(null,
						"The number of character: " + number);	
			}
		});
		
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int number = textarea.getText().length();
				if (number < 1) {
					JOptionPane.showMessageDialog(null, "There is no tip to upload " + "("
				+ number + " / 200 character)");
				} else if (number > 200) {
					JOptionPane.showMessageDialog(null, "Your it is too large "
				+ "("+ number + " / 200 character)");
				} else {
					jf.dispose();
					setTip(textarea.getText());
					Post post = new Post();
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