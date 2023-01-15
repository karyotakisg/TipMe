package kourpa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
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

/**
 * An interface of upload, which contains a text area to write, a checkbox to
 * select a category of the context. The context and the category are able to be
 * stored in a database and it informs of the length of the contex
 **/
public class Upload {
	/*
	 * @tip The context of upload from text area
	 */
	private String tip;
	/* categ The category of the context */
	private String categ;

	User user = new User();

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

	public Upload(User u) {

		user = u;
		Image i = Toolkit.getDefaultToolkit().getImage("src\\main\\resources\\logo.png");
		jf.setIconImage(i);
		jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		jf.setLayout(new BorderLayout(1, 1));
		jf.setBounds(500, 200, 500, 300);
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jp.setBackground(new Color(255, 102, 0));
		jp.setLayout(new BorderLayout(1, 1));

		jpnorth.setLayout(new GridLayout(2, 1));
		jpnorth.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		jpgridleft.setLayout(new FlowLayout(FlowLayout.LEFT));
		jpgridright.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jpsouth.setLayout(new FlowLayout(FlowLayout.CENTER));
		jpgridleft.setBackground(MyProfile.currentColor);
		jpgridright.setBackground(MyProfile.currentColor);
		jpsouth.setBackground(MyProfile.currentColor);
		jpnorth.setBackground(MyProfile.currentColor);
		jpeast.setBackground(MyProfile.currentColor);
		jpwest.setBackground(MyProfile.currentColor);

		JTextArea textarea = new JTextArea();
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		LineBorder line = new LineBorder(Color.BLACK);
		textarea.setBorder(line);
		Font f = new Font("Calibri", Font.PLAIN, 15);
		textarea.setFont(f);

		jpsouth.add(jb);
		jpsouth.add(jbinfo);

		JLabel jlc = new JLabel("Choose Category");
		jpgridright.add(jlc);

		String[] categories = { "", "SCIENCE", "SPORTS", "MUSIC",
				"FASHION", "TRAVEL", "FITNESS", "ART", "EDUCATION",
				"NATURE", "FOOD" };
		JComboBox<Object> cb = new JComboBox<Object>(categories);
		jpgridright.add(cb);

		JLabel jl5 = new JLabel("Text your tip");
		jpgridleft.add(jl5);

		jpnorth.add(jpgridright);
		jpnorth.add(jpgridleft);

		cb.addItemListener(new ItemListener() {
			/* saves selected category */
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

		JScrollPane scrollPane = new JScrollPane(textarea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jp.add(scrollPane, BorderLayout.CENTER);
		jf.setVisible(true);
		jbinfo.addActionListener(new ActionListener() {
			/* informs for the length of context */
			@Override
			public void actionPerformed(ActionEvent e) {
				int number = textarea.getText().length();
				JOptionPane.showMessageDialog(null, "The number of character: " + number);
			}
		});

		jb.addActionListener(new ActionListener() {
			/*
			 * saves the context when it covers the prerequisites of the number of
			 * characters and displays a message for any condition
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				int number = textarea.getText().length();
				String tempcateg = cb.getSelectedItem().toString();
				if (number < 1) {
					JOptionPane.showMessageDialog(null,
							"There is no tip to upload " + "(" + number + " / 300 character)");
				} else if (number > 300) {
					JOptionPane.showMessageDialog(null,
							"Your it is" + "too large " + "(" + number + " / 300 character)");
				} else {
					if (tempcateg != "") {
						jf.dispose();
						setTip(textarea.getText());
						Post post = new Post(u);
						post.storePost(tip, categ);
						JOptionPane.showMessageDialog(null,
								"Your tip is uploaded " + "(" + number + " / 300 character)");
					} else {
						JOptionPane.showMessageDialog(null, "Select one category");
					}
				}
			}
		});

	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		if (tip.length() <= 300) {
			this.tip = tip;
		}
	}

	public String getCateg() {
		return categ;
	}

	public void setCateg(String categ) {
		this.categ = categ;
	}
}