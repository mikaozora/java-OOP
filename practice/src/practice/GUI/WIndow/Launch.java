package practice.GUI.WIndow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Launch extends JFrame implements ActionListener{
    JButton button;
    String test;
    Launch(){
        button = new JButton("Open");
        button.setBounds(50, 50, 150, 150);
        button.addActionListener(this);

        this.setSize(500, 500);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        this.add(button);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            this.dispose();
            test = "characters";
            Main2 open = new Main2(test);
        }
    }

    public static void main(String[] args) {
        new Launch();
    }
}
