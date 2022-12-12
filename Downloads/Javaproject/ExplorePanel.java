import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class ExplorePanel {


	public ExplorePanel(int x, JPanel jf) {
        jf.setLayout(new BorderLayout(5, 5));

		if(x == 0) {
			JPanel p0 = new JPanel();
			p0.setPreferredSize(new Dimension(600,600));

            jf.add(p0, BorderLayout.CENTER);
			p0.setBackground(new Color(25, 100, 200));


			// ��� �� ���� � ����� ��� � ����� �� �����. ���������� �� ��������� �� �������� ��� ���������� 1. �� ��������� ��� ����� �� posts ��� �� ���� ����� ������� ��� ���������� //
		} else if(x == 1) {
			JPanel p1 = new JPanel();

			jf.add(p1);
		} else if(x == 2) {
			JPanel p2 = new JPanel();
			jf.add(p2);
		} else if(x == 3) {
			JPanel p3 = new JPanel();
			jf.add(p3);
		} else if(x == 4) {
			JPanel p4 = new JPanel();
			jf.add(p4);
		} else {
			JPanel p5 = new JPanel();
			jf.add(p5);
		}

	}

}



