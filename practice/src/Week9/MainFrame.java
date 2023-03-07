package Week9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame implements ActionListener, WindowListener, MouseListener, MouseMotionListener {

    private JButton btn = new JButton("Click Me!");
    private JButton btn2 = new JButton("Footer");
    private JButton btn3 = new JButton("Header");
    private int count = 0;
    private ActionListener actionBtn3 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
//            JOptionPane.showMessageDialog(null, "Header");
            count++;
            btn3.setText("Header " + count);

        }
    };
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn) {
            JOptionPane.showMessageDialog(this, "hello world");
            int test = JOptionPane.showConfirmDialog(this, "are you sure?");
            System.out.println(test);
            String res = JOptionPane.showInputDialog(this,"Name");
            System.out.println("nama: " + res);
        }else if (e.getSource() == btn2){
            System.out.println("Click");
        }

    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("window open");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("window closing");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("window closed");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("window icon");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("window deicon");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("window active");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("window deactive");
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("x: " + e.getX() + ", y: " + e.getY());
    }

    public MainFrame() {
        btn.addActionListener(this);
//        btn.addMouseMotionListener(this);
        btn2.addActionListener(this);
        add(btn);
        add(btn2, BorderLayout.SOUTH);
        btn3.addActionListener(actionBtn3);
        add(btn3, BorderLayout.NORTH);
        addWindowListener(this);

        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MainFrame();

    }
}
