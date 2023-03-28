package practice.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class KeyBindingP extends JFrame {

    JLabel label;
    Action upAction;
    Action downAction;
    Action leftAction;
    Action rightAction;
    KeyBindingP(){

        label = new JLabel();
        label.setOpaque(true);
        label.setBounds(20,20,100,100);
        label.setBackground(Color.orange);

        upAction = new upAction();
        downAction = new downAction();
        leftAction = new leftAction();
        rightAction = new rightAction();

        label.getInputMap().put(KeyStroke.getKeyStroke('w'), "upAction");
        label.getActionMap().put("upAction", upAction);
        label.getInputMap().put(KeyStroke.getKeyStroke('s'), "downAction");
        label.getActionMap().put("downAction", downAction);
        label.getInputMap().put(KeyStroke.getKeyStroke('a'), "leftAction");
        label.getActionMap().put("leftAction", leftAction);
        label.getInputMap().put(KeyStroke.getKeyStroke('d'), "rightAction");
        label.getActionMap().put("rightAction", rightAction);

        this.setSize(500, 500);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        this.add(label);
    }



    public static void main(String[] args) {
        new KeyBindingP();
    }

    public class upAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setLocation(label.getX(), label.getY() - 10);
        }
    }
    public class downAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setLocation(label.getX(), label.getY() + 10);
        }
    }
    public class leftAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setLocation(label.getX() - 10, label.getY());
        }
    }
    public class rightAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setLocation(label.getX() + 10, label.getY());
        }
    }
}


