package practice.GUI;

import javax.swing.*;
import java.awt.*;

public class LabelP extends JFrame {

    public LabelP(){
        JLabel label = new JLabel();
        ImageIcon image = new ImageIcon("src/practice/GUI/Assets/easy.png");
        label.setText("Ini Label");
        label.setIcon(image);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setForeground(new Color(0, 123, 123));
        label.setFont(new Font("Poppins", Font.BOLD, 24));
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);

        this.add(label);
        this.setSize(500, 500);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setIconImage(image.getImage());
    }
    public static void main(String[] args) {
        new LabelP();
    }
}
