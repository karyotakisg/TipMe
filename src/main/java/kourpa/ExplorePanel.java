package kourpa;
//package kourpa.kourpatestclasses;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class ExplorePanel {

    String category;
    private static JPanel p0;
    private static JPanel p1;
    private static JPanel p2;
    private static JPanel p3;
    private static JPanel p4;
    private static JPanel p5;
    private static JPanel p6;
    private static JPanel p7;
    private static JPanel p8;
    private static JPanel p9;
	private static JPanel  panelBack;

	public ExplorePanel(int x, JPanel jf, String u) {
        //jf.setLayout(new BorderLayout(5, 5));
          //jf.setLayout(new GridLayout(3, 2, 10, 10));

        panelBack = jf;

		if(x == 0) {
		    p0 = new JPanel();
			p0.setPreferredSize(new Dimension(600,600));
			//p0.setLayout(new GridLayout(3, 1, 10, 10));
		    jf.add(p0, BorderLayout.CENTER);
			category = "Science";
			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p0);
			JScrollPane scr = new JScrollPane(p0, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			jf.add(scr, BorderLayout.CENTER);
			scr.getVerticalScrollBar().setUnitIncrement(12);
			//p0.add(m);




			p0.setBackground(new Color(179, 230, 184));
			//p0.setBorder(BorderFactory.createLineBorder(Color.RED));




		} else if(x == 1) {
			 p1 = new JPanel();
			p1.setPreferredSize(new Dimension(600,600));
			p1.setLayout(new GridLayout(3, 1, 10, 10));
			category = "Sports";
			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p1);
			//p1.add(m);



			            jf.add(p1, BorderLayout.CENTER);
						p1.setBackground(new Color(179, 230, 184));

		} else if(x == 2) {
			p2 = new JPanel();
			p2.setPreferredSize(new Dimension(600,600));
            p2.setLayout(new GridLayout(3, 1, 10, 10));
            category = "Music";
            CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p2);
			//p2.add(m);


			            jf.add(p2, BorderLayout.CENTER);
						p2.setBackground(new Color(179, 230, 184));

		} else if(x == 3) {
			p3 = new JPanel();
			p3.setPreferredSize(new Dimension(600,600));
			p3.setLayout(new GridLayout(3, 1, 10, 10));
			category = "Fashion";
			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p3);
						//p3.add(m);


			            jf.add(p3, BorderLayout.CENTER);
						p3.setBackground(new Color(179, 230, 184));



		} else if(x == 4) {
			p4 = new JPanel();
			p4.setPreferredSize(new Dimension(600,600));
			p4.setLayout(new GridLayout(3, 1, 10, 10));
			category = "Travel";
			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p4);

						//p4.add(m);



			            jf.add(p4, BorderLayout.CENTER);
						p4.setBackground(new Color(179, 230, 184));

		} else if (x == 5) {
			p5 = new JPanel();
			p5.setPreferredSize(new Dimension(600,600));
			p5.setLayout(new GridLayout(3, 1, 10, 10));
			category = "Fitness";
			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p5);

						//p5.add(m);


			            jf.add(p5, BorderLayout.CENTER);
						p5.setBackground(new Color(179, 230, 184));

		} else if (x == 6) {
			p6 = new JPanel();
						p6.setPreferredSize(new Dimension(600,600));
						p6.setLayout(new GridLayout(3, 1, 10, 10));
						category = "Art";
						CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p6);

									//p5.add(m);


						            jf.add(p6, BorderLayout.CENTER);
						p6.setBackground(new Color(179, 230, 184));
	   } else if (x == 7) {
		   p7 = new JPanel();
		   			p7.setPreferredSize(new Dimension(600,600));
		   			p7.setLayout(new GridLayout(3, 1, 10, 10));
		   			category = "Education";
		   			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p7);

		   						//p5.add(m);


		   			            jf.add(p7, BorderLayout.CENTER);
						p7.setBackground(new Color(179, 230, 184));
		} else if ( x == 8) {
			p8 = new JPanel();
						p8.setPreferredSize(new Dimension(600,600));
						p8.setLayout(new GridLayout(3, 1, 10, 10));
						category = "Environment";
						CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p8);

									//p5.add(m);


						            jf.add(p8, BorderLayout.CENTER);
						p8.setBackground(new Color(179, 230, 184));
		} else {
			p9 = new JPanel();
						p9.setPreferredSize(new Dimension(600,600));
						p9.setLayout(new GridLayout(3, 1, 10, 10));
						category = "Food";
						CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p9);
						;
									//p5.add(m);


						            jf.add(p9, BorderLayout.CENTER);
						p9.setBackground(new Color(179, 230, 184));
					}

	}

	public static void hidepanel() {

		p0.setVisible(false);
		p1.setVisible(false);
		p2.setVisible(false);
		p3.setVisible(false);
		p4.setVisible(false);
		p5.setVisible(false);
		p6.setVisible(false);
		p7.setVisible(false);
		p8.setVisible(false);
		panelBack.setVisible(true);



}

}



