package practice.GUI;

import javax.swing.*;
import java.awt.*;

public class Animation2D extends JFrame {

    AnimationPanel panel;
    Animation2D(){
        panel = new AnimationPanel();
        this.add(panel);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Animation2D();
    }
}
