package Week8;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("ini frame");
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4, 3));
        JButton btn = new JButton("Button");
        centerPanel.add(btn);
//        frame.add(btn);
        JButton btn1 = new JButton("Button");
        centerPanel.add(btn1);
//        frame.add(btn1);
        for (int i = 0; i < 10; i++) {
            centerPanel.add(new JButton("button "+ i));
        }
        frame.add(centerPanel);


        JLabel label = new JLabel("label");
        frame.add(label, BorderLayout.NORTH);

        JTextField textField = new JTextField();
        frame.add(textField, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
