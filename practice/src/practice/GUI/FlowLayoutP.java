package practice.GUI;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutP extends JFrame {

    FlowLayoutP(){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setBackground(Color.gray);
        panel.setPreferredSize(new Dimension(100, 200));

        this.add(new JButton("1"));
        this.add(new JButton("1"));
        this.add(new JButton("1"));
        this.add(new JButton("1"));
        this.add(new JButton("1"));
        this.add(new JButton("1"));
        this.add(new JButton("1"));

        this.setSize(500, 500);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);

//        this.add(panel);
    }

    public static void main(String[] args) {
        new FlowLayoutP();
    }
}
