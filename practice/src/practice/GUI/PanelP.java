package practice.GUI;

import javax.swing.*;
import java.awt.*;

public class PanelP extends JFrame {

    PanelP(){
        ImageIcon image1 = new ImageIcon(new ImageIcon("src/practice/GUI/Assets/easy.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        ImageIcon image2 = new ImageIcon(new ImageIcon("src/practice/GUI/Assets/Jan.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        JLabel label1 = new JLabel();
        label1.setIcon(image1);

        JLabel label2 = new JLabel();
        label2.setIcon(image2);

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.RED);
        redPanel.setBounds(0, 0, 100, 100);
        redPanel.setLayout(new BorderLayout());
        redPanel.add(label1);
        label1.setHorizontalAlignment(0);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.BLUE);
        bluePanel.setBounds(100, 0, 100, 100);

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.GREEN);
        greenPanel.setBounds(0, 100, 200, 100);
        greenPanel.setLayout(null);
        greenPanel.add(label2);
        label2.setBounds(10, 20, 50, 50);

        this.setSize(500, 500);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        this.add(redPanel);
        this.add(bluePanel);
        this.add(greenPanel);
    }
    public static void main(String[] args) {
        new PanelP();
    }
}
