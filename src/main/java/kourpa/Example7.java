package kourpa;

import java.awt.BorderLayout;

import javax.swing.*;

public class Example7 extends JFrame{

	public static void main(String [] args) {
		//ExplorePanel p1 = new ExplorePanel(0);
		ExploreKourpaTest k = new ExploreKourpaTest();
		k.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		k.setBounds(20, 20, 1000, 1500);
	    k.setVisible(true);
	    k.pack();

	}

}