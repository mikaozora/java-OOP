package Week8;

import javax.swing.*;
import java.awt.*;

public class practice {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Register Form");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.add(new Label("Register"), BorderLayout.NORTH);
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2,2));
        centerPanel.add(new Label("Name"));
        centerPanel.add(new JTextField(16));
        centerPanel.add(new Label("Password"));
        centerPanel.add(new JTextField(16));
        frame.add(centerPanel);
        frame.add(new JButton("Submit"), BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
