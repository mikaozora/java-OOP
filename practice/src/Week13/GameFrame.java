package Week13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFrame extends JFrame {

    public GameFrame() {
        add(new GamePanel());
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GameFrame();
    }
}

class GamePanel extends JPanel implements KeyListener {
    Point point = new Point(20, 20);

    public GamePanel() {
        addKeyListener(this);
        setFocusable(true);
        requestFocus();
        Timer t = new Timer(1000/60, (e) -> {
            reload();
        });
        t.start();
    }

    private void reload() {
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> {
                System.out.println("W");
                --point.y;
            }
            case KeyEvent.VK_A -> --point.x;
            case KeyEvent.VK_S -> ++point.y;
            case KeyEvent.VK_D -> ++point.x;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.orange);
        g2.fillRect(point.x*5, point.y*5, 20, 20);
    }
}
