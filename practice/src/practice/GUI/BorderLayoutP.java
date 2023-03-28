package practice.GUI;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutP extends JFrame {

    BorderLayoutP(){
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.red);
        panel1.setPreferredSize(new Dimension(100, 50));

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.blue);
        panel2.setPreferredSize(new Dimension(100, 50));

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.green);
        panel3.setPreferredSize(new Dimension(100, 50));

        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.cyan);
        panel4.setPreferredSize(new Dimension(100, 50));

        JPanel panel5 = new JPanel();
        panel5.setBackground(Color.gray);
        panel5.setPreferredSize(new Dimension(100, 50));
        panel5.setLayout(new BorderLayout(50, 10));

        JPanel panel6 = new JPanel();
        panel6.setBackground(Color.orange);
        panel6.setPreferredSize(new Dimension(50, 50));

        JPanel panel7 = new JPanel();
        panel7.setBackground(Color.yellow);
        panel7.setPreferredSize(new Dimension(50, 50));

        JPanel panel8 = new JPanel();
        panel8.setBackground(Color.darkGray);
        panel8.setPreferredSize(new Dimension(50, 50));

        panel5.add(panel6, BorderLayout.SOUTH);
        panel5.add(panel7, BorderLayout.NORTH);
        panel5.add(panel8, BorderLayout.WEST);

        this.setSize(500, 500);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new BorderLayout(10, 10));
        this.setLocationRelativeTo(null);

        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.SOUTH);
        this.add(panel3, BorderLayout.EAST);
        this.add(panel4, BorderLayout.WEST);
        this.add(panel5, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new BorderLayoutP();
    }
}
