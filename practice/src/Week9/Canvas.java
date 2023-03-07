package Week9;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JFrame {
    DrawPanel panel = new DrawPanel();
    public Canvas(){
        add(panel);

        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Canvas();
    }
}


class DrawPanel extends JPanel{
    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        draw(g);
    }

    void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(100,100, 50,50);
    }
}