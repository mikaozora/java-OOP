package practice.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerP extends JFrame implements KeyListener {

    JLabel label;
    ImageIcon image1;

    KeyListenerP() {

        image1 = new ImageIcon(new ImageIcon("src/practice/GUI/Assets/easy.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

        label = new JLabel();
        label.setBounds(20, 20, 100, 100);
        label.setIcon(image1);


        this.setSize(500, 500);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(this);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        this.add(label);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'w':
                label.setBounds(label.getX(), label.getY() - 15, label.getWidth(), label.getHeight());
                break;
            case 'a':
                label.setBounds(label.getX() - 15, label.getY(), label.getWidth(), label.getHeight());
                break;
            case 's':
                label.setBounds(label.getX(), label.getY() + 15, label.getWidth(), label.getHeight());
                break;
            case 'd':
                label.setBounds(label.getX() + 15, label.getY(), label.getWidth(), label.getHeight());
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        switch (e.getKeyChar()){
//            case 'w':
//                label.setBounds(label.getX(), label.getY()-5, label.getWidth(), label.getHeight());
//                break;
//            case 'a':
//                label.setBounds(label.getX()-5, label.getY(), label.getWidth(), label.getHeight());
//                break;
//            case 's':
//                label.setBounds(label.getX(), label.getY()+5, label.getWidth(), label.getHeight());
//                break;
//            case 'd':
//                label.setBounds(label.getX()+5, label.getY(), label.getWidth(), label.getHeight());
//                break;
//        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyChar());
    }

    public static void main(String[] args) {
        new KeyListenerP();
    }
}
