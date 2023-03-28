package practice.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationPanel extends JPanel implements ActionListener {
    final int width = 500;
    final int height = 500;
    Timer timer;
    Image item;
    int xVelocity = 1;
    int yVelocity = 1;
    int x = (int) (Math.random()*500);
    int y = (int) (Math.random()*500);
    AnimationPanel(){
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.lightGray);
        item = new ImageIcon(new ImageIcon("src/practice/GUI/Assets/Jan.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)).getImage();
        timer = new Timer(1, this);
        timer.start();
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(item, x, y, null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(x >= width - item.getWidth(null) || x < 0){
            xVelocity = -xVelocity;
        }
        x = x + xVelocity;
        if(y >= height - item.getHeight(null) || y < 0){
            yVelocity = -yVelocity;
        }
        y = y + yVelocity;

        repaint();
    }
}
