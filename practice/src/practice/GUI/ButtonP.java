package practice.GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonP extends JFrame implements ActionListener {
    JButton button, button2;
    JLabel label2;
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            System.out.println("Clicked!");
            button2.setEnabled(false);
        }else if(e.getSource() == button2){
            System.out.println("Click button 2");
            button.setEnabled(false);
        }
    }

    ButtonP(){
        ImageIcon image2 = new ImageIcon(new ImageIcon("src/practice/GUI/Assets/Jan.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

        button = new JButton();
        button.setText("Click me!");
        button.setBounds(50, 50, 100, 100);
        button.setBackground(Color.orange);
        button.setForeground(Color.white);
        button.addActionListener(this);

        button2 = new JButton();
        button2.setText("Januari");
        button2.setIcon(image2);
        button2.setBounds(50, 160, 200, 100);
        button2.setFont(new Font("Montserrat", Font.PLAIN, 18));
        button2.setIconTextGap(20);
        button2.setBackground(Color.white);
        button2.setForeground(Color.orange);
        button2.setBorder(BorderFactory.createLineBorder(Color.orange, 2, true));
        button2.addActionListener(this);

        this.setSize(500, 500);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        this.add(button);
        this.add(button2);
    }

    public static void main(String[] args) {
        new ButtonP();
    }
}
