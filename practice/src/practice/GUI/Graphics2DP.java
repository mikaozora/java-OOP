package practice.GUI;

import javax.swing.*;
import java.awt.*;

public class Graphics2DP extends JFrame {
    GraphicsPanel panel;

    Graphics2DP(){

        panel = new GraphicsPanel();
        this.add(panel);

        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);


    }

    public static void main(String[] args) {
        new Graphics2DP();
    }
}
