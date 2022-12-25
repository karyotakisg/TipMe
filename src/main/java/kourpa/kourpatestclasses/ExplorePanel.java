package kourpa.kourpatestclasses;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class ExplorePanel {

    String category;

	public ExplorePanel(int x, JPanel jf, String u) {
        //jf.setLayout(new BorderLayout(5, 5));


		if(x == 0) {
			JPanel p0 = new JPanel();
			p0.setPreferredSize(new Dimension(600,600));
			//p0.setLayout(new GridLayout(3, 1, 10, 10));
		    jf.add(p0, BorderLayout.CENTER);
			category = "Science";
			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p0);
			p0.setBackground(Color.orange);
			//p0.add(m);



			p0.setBackground(new Color(25, 100, 200));
			//p0.setBorder(BorderFactory.createLineBorder(Color.RED));




		} else if(x == 1) {
			JPanel p1 = new JPanel();
			p1.setPreferredSize(new Dimension(600,600));
			p1.setLayout(new GridLayout(3, 1, 10, 10));
			category = "Sports";
			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p1);
			//p1.add(m);



			            jf.add(p1, BorderLayout.CENTER);
						p1.setBackground(new Color(25, 100, 200));

		} else if(x == 2) {
			JPanel p2 = new JPanel();
			p2.setPreferredSize(new Dimension(600,600));
            p2.setLayout(new GridLayout(3, 1, 10, 10));
            category = "Music";
            CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p2);
			//p2.add(m);

			            jf.add(p2, BorderLayout.CENTER);
						p2.setBackground(new Color(25, 100, 200));

		} else if(x == 3) {
			JPanel p3 = new JPanel();
			p3.setPreferredSize(new Dimension(600,600));
			p3.setLayout(new GridLayout(3, 1, 10, 10));
			category = "Fashion";
			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p3);
						//p3.add(m);

			            jf.add(p3, BorderLayout.CENTER);
						p3.setBackground(new Color(25, 100, 200));



		} else if(x == 4) {
			JPanel p4 = new JPanel();
			p4.setPreferredSize(new Dimension(600,600));
			p4.setLayout(new GridLayout(3, 1, 10, 10));
			category = "Travel";
			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p4);
						//p4.add(m);


			            jf.add(p4, BorderLayout.CENTER);
						p4.setBackground(new Color(25, 100, 200));

		} else {
			JPanel p5 = new JPanel();
			p5.setPreferredSize(new Dimension(600,600));
			p5.setLayout(new GridLayout(3, 1, 10, 10));
			category = "Fitness & Lifestyle";
			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p5);
						//p5.add(m);


			            jf.add(p5, BorderLayout.CENTER);
						p5.setBackground(new Color(25, 100, 200));

		}

	}

}



