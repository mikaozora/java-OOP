package practice.GUI;

import javax.swing.*;
import java.awt.*;

public class GridLayoutP extends JFrame {

    GridLayoutP(){

        this.add(new JButton("1"));
        this.add(new JButton("2"));
        this.add(new JButton("3"));
        this.add(new JButton("4"));
        this.add(new JButton("5"));
        this.add(new JButton("6"));
        this.add(new JButton("7"));
        this.add(new JButton("8"));
        this.add(new JButton("9"));

        this.setSize(500, 500);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new GridLayout(3, 3, 10, 10));
        this.setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        new GridLayoutP();
    }
}
