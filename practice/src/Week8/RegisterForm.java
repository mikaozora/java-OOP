package Week8;

import javax.swing.*;
import java.awt.*;

public class RegisterForm extends JFrame {

    JLabel headerLabel = new JLabel("Register");

    JPanel centerPanel = new JPanel();
    JLabel nameLabel = new JLabel("Name");
    JLabel passwordLabel = new JLabel("Password");
    JTextField nameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JPanel footer = new JPanel();
    JButton submitBtn = new JButton("Submit");
    public RegisterForm(){
        add(headerLabel, BorderLayout.NORTH);

        centerPanel.setLayout(new GridLayout(2,2));
        centerPanel.add(nameLabel);
        centerPanel.add(nameField);
        centerPanel.add(passwordLabel);
        centerPanel.add(passwordField);
        add(centerPanel);

        footer.add(submitBtn);
        add(footer, BorderLayout.SOUTH);

        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        new RegisterForm();
    }
}
