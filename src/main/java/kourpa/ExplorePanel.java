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

	public ExplorePanel(int x, JPanel jf, JPanel south, JPanel east, JPanel west, String u) {
        //jf.setLayout(new BorderLayout(5, 5));
          //jf.setLayout(new GridLayout(3, 2, 10, 10));

        panelBack = jf;
        HomePage hp = new HomePage();
        south.setPreferredSize(new Dimension(200, 5));
        east.setPreferredSize(new Dimension(135, 200));
		west.setPreferredSize(new Dimension(135, 200));
		if(x == 0) {
			p1 = new JPanel();
			p1.setLayout(new GridLayout(hp.getMessageCount(), 1, 7, 3));
			p1.setBackground(Color.BLACK);
			category = "Science";
			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p0);
			jf.add(p0, BorderLayout.CENTER);
			jf.add(hp.getScroll(p0), BorderLayout.CENTER);
		} else if(x == 1) {
			p1 = new JPanel();
			p1.setLayout(new GridLayout(hp.getMessageCount(), 1, 7, 3));
			p1.setBackground(Color.BLACK);
			category = "Sports";
			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p1);
			jf.add(p1, BorderLayout.CENTER);
			jf.add(hp.getScroll(p1), BorderLayout.CENTER);
			//p1.add(m);	            

		} else if(x == 2) {
			p2 = new JPanel();
			p2.setLayout(new GridLayout(hp.getMessageCount(), 1, 7, 3));
			p2.setBackground(Color.BLACK);
			category = "Music";
			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p2);
			jf.add(p2, BorderLayout.CENTER);
			jf.add(hp.getScroll(p2), BorderLayout.CENTER);

		} else if(x == 3) {
			p3 = new JPanel();
			p3.setLayout(new GridLayout(hp.getMessageCount(), 1, 7, 3));
			p3.setBackground(Color.BLACK);
			category = "Fashion";
			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p3);
			jf.add(p3, BorderLayout.CENTER);
			jf.add(hp.getScroll(p3), BorderLayout.CENTER);
		} else if(x == 4) {
			p4 = new JPanel();
			p4.setLayout(new GridLayout(hp.getMessageCount(), 1, 7, 3));
			p4.setBackground(Color.BLACK);
			category = "Travel";
			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p4);
			jf.add(p1, BorderLayout.CENTER);
		} else if(x == 5) {
			p5 = new JPanel();
			p5.setLayout(new GridLayout(hp.getMessageCount(), 1, 7, 3));
			p5.setBackground(Color.BLACK);
			category = "Travel";
			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p5);
			jf.add(p5, BorderLayout.CENTER);
		} else if (x == 6) {
			p6 = new JPanel();
			p6.setLayout(new GridLayout(hp.getMessageCount(), 1, 7, 3));
			p6.setBackground(Color.BLACK);
			category = "Art";
			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p6);
			jf.add(p6, BorderLayout.CENTER);
			jf.add(hp.getScroll(p6), BorderLayout.CENTER);
	   } else if (x == 7) {
		   	p7 = new JPanel();
			p7.setLayout(new GridLayout(hp.getMessageCount(), 1, 7, 3));
			p7.setBackground(Color.BLACK);
			category = "Education";
			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p7);
			jf.add(p7, BorderLayout.CENTER);
			jf.add(hp.getScroll(p7), BorderLayout.CENTER);
		} else if ( x == 8) {
			p8 = new JPanel();
			p8.setLayout(new GridLayout(hp.getMessageCount(), 1, 7, 3));
			p8.setBackground(Color.BLACK);
			category = "Nature";
			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p8);
			jf.add(p8, BorderLayout.CENTER);
			jf.add(hp.getScroll(p8), BorderLayout.CENTER);
		} else {
			p9 = new JPanel();
			p9.setLayout(new GridLayout(hp.getMessageCount(), 1, 7, 3));
			p9.setBackground(Color.BLACK);
			category = "Food";
			CustomizeMessageKourpa2 m = new CustomizeMessageKourpa2(u, category, p9);
			jf.add(p1, BorderLayout.CENTER);
			jf.add(hp.getScroll(p9), BorderLayout.CENTER);
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



