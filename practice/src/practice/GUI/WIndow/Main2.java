package practice.GUI.WIndow;

import javax.swing.*;
import java.awt.*;

public class Main2 extends JFrame {
    Main2(String test){

        JLabel label = new JLabel(test);
        this.add(label);

        this.setSize(500, 500);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
    }
}
