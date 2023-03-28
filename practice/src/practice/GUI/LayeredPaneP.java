package practice.GUI;

import javax.swing.*;
import java.awt.*;

public class LayeredPaneP extends JFrame {
    LayeredPaneP(){
        JLayeredPane layeredPane = new JLayeredPane();
//        this.setLayout(null);

        JLabel label1 = new JLabel();
        label1.setOpaque(true);
        label1.setBounds(10, 10, 100, 100);
        label1.setBackground(Color.red);

        JLabel label2 = new JLabel();
        label2.setOpaque(true);
        label2.setBounds(15, 15, 100, 100);
        label2.setBackground(Color.green);

        JLabel label3 = new JLabel();
        label3.setOpaque(true);
        label3.setBounds(20, 20, 100, 100);
        label3.setBackground(Color.blue);

        layeredPane.add(label1, Integer.valueOf(3)); // semakin besar angkanya, layernya paling atas
        layeredPane.add(label2, Integer.valueOf(1));
        layeredPane.add(label3, Integer.valueOf(2));


        this.add(layeredPane);

        this.setSize(500, 500);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(null);
        this.setLocationRelativeTo(null);


    }
    public static void main(String[] args) {
        new LayeredPaneP();
    }
}
