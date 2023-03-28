package practice.GUI;

import javax.swing.*;
import java.awt.*;

public class GraphicsPanel extends JPanel {
    GraphicsPanel(){
        this.setPreferredSize(new Dimension(500, 500));
    }

    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(3));
        g2D.setPaint(Color.orange);
        g2D.drawLine(0, 0, 500, 500);

        g2D.setPaint(Color.blue);
        g2D.fillRect(30, 30, 200, 300);
    }
}
