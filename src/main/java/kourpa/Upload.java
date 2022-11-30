package kourpa;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Upload {
    private String tip;
	private String categ;

	/* Set graphics of upload */
	public Upload() {

		JFrame jf = new JFrame();
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.getContentPane().setBackground(Color.ORANGE);
		JButton jb = new JButton("Upload");

		jf.setBounds(500, 200, 600, 400);

		jf.setLayout(null);
		jb.setBounds(250, 300, 80, 50);

		JTextArea textarea = new JTextArea();
		textarea.setBounds(35, 100, 510, 180);
		jf.add(textarea);

		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setTip(textarea.getText());
                User username = new User();//problem with the name!!!!
                Message message = new Message();
				message.storeMessage(username.getUsername(), tip, categ);
				jf.setVisible(false);
				JOptionPane.showMessageDialog(null, "Your tip is uploaded!");
			}
		});
		jf.add(jb);

		String[] categories = { "General", "Sport", "Science", "Cook", "Video Games", "Nature" };
		JComboBox<Object> cb = new JComboBox<Object>(categories);
		cb.setBounds(465, 45, 80, 30);
		jf.add(cb);

		cb.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (!cb.getSelectedItem().toString().equals("General")) {
						setCateg(cb.getSelectedItem().toString());
					}
				}
			}
		});

		JLabel jlc = new JLabel("Choose Category");
		jlc.setBounds(360, 45, 100, 30);
		jf.add(jlc);

		JLabel jlt = new JLabel("Texts your thoughts");
		jlt.setBounds(35, 70, 130, 30);
		jf.add(jlt);

		jf.setVisible(true);

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
