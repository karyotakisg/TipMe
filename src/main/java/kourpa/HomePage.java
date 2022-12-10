<<<<<<< HEAD
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class HomePage {
    JFrame frame = new JFrame();
    JPanel feed = new JPanel();
    String [] publisher = {"V.Talos", "Redi", "KaryotakisG", "Jim_Douk", "Kourpa"};
    String [] posts = {"Messi = G.O.A.T", "Agapitou fermarei", "Messi>>>Siuu", "Estia mono", "Ollandia poulo"};
    String [] category ={"Sports", "General", "Sports", "General", "Sports"};

    HomePage() {
        feed.setBackground(new Color(153, 0, 0));
        feed.setLayout(null);
        Menu north = new Menu();
        JPanel south = new JPanel();
        JPanel east = new JPanel();
        JPanel west = new JPanel();
        JPanel center = new JPanel( new GridLayout(5, 1, 0, 10));
        
        

    
        JTextArea tip = new JTextArea();
        tip.setEditable(false);

        Font font = new Font("Verdana", Font.BOLD, 12);

        
        frame.setSize(1000, 1000);
        center.setBounds(100, 100, 800, 600 );
        

        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.add(feed);

        feed.add(north, BorderLayout.NORTH);
        feed.add(south, BorderLayout.SOUTH);
        feed.add(center, BorderLayout.CENTER);
        feed.add(west, BorderLayout.WEST);
        feed.add(east, BorderLayout.EAST);

        for (int i = 0; i <= 4; i++) {
            JTextArea post = new JTextArea();
            post.setText(publisher[i] + "         "  + category[i] + "\n" + "\n" +  posts[i] );
            post.setEditable(false);
            post.setFont(font);
            post.setForeground(Color.Black);
            center.add(post);
            
        }



    }

}





=======
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class HomePage {
    JFrame frame = new JFrame();
    JPanel feed = new JPanel();
    String [] publisher = {"V.Talos", "Redi", "KaryotakisG", "Jim_Douk", "Kourpa"};
    String [] posts = {"Messi = G.O.A.T", "Agapitou fermarei", "Messi>>>Siuu", "Estia mono", "Ollandia poulo"};
    String [] category ={"Sports", "General", "Sports", "General", "Sports"};

    HomePage() {
        feed.setBackground(new Color(153, 0, 0));
        feed.setLayout(null);
        Menu north = new Menu();
        JPanel south = new JPanel();
        JPanel east = new JPanel();
        JPanel west = new JPanel();
        JPanel center = new JPanel( new GridLayout(5, 1, 0, 10));
        
        

    
        JTextArea tip = new JTextArea();
        tip.setEditable(false);

        Font font = new Font("Verdana", Font.BOLD, 12);

        
        frame.setSize(1000, 1000);
        center.setBounds(100, 100, 800, 600 );
        

        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.add(feed);

        feed.add(north, BorderLayout.NORTH);
        feed.add(south, BorderLayout.SOUTH);
        feed.add(center, BorderLayout.CENTER);
        feed.add(west, BorderLayout.WEST);
        feed.add(east, BorderLayout.EAST);

        for (int i = 0; i <= 4; i++) {
            JTextArea post = new JTextArea();
            post.setText(publisher[i] + "         "  + category[i] + "\n" + "\n" +  posts[i] );
            post.setEditable(false);
            post.setFont(font);
            post.setForeground(Color.Black);
            center.add(post);
            
        }



    }

}





>>>>>>> 3690a546b0666944dacec51a8b7bacf9845afa64
