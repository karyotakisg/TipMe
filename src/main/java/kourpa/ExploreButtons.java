package kourpa;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExploreButtons {
	
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
	    		return new ImageIcon("src\\main\\resources\\science2.png");
	    	} else if (n == 1) {
	    		return new ImageIcon("src\\main\\resources\\sports2.png");
	    	} else if (n == 2) {
	    		return new ImageIcon("src\\main\\resources\\music2.png");
	    	} else if (n == 3) {
	    		return new ImageIcon("src\\main\\resources\\fashion2.png");
			} else if (n == 4) {
				return new ImageIcon("src\\main\\resources\\travel2.png");
			} else if (n == 5) {
				return new ImageIcon("src\\main\\resources\\fitness2.png");
			} else if (n == 6) {
				return new ImageIcon("src\\main\\resources\\art2.png");		
			} else if (n == 7) {
				return new ImageIcon("src\\main\\resources\\academic2.png");
	    	} else if (n == 8) {
	    		return new ImageIcon("src\\main\\resources\\environment2.png");
	    	} else if (n == 9) {
	    		return new ImageIcon("src\\main\\resources\\food2.png");
	    	} else {
	    		return null;
	    	}
		}

	
	

}