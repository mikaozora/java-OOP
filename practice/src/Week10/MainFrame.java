package Week10;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class MainFrame extends JFrame implements ActionListener {
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenuItem loginMenuItem = new JMenuItem("Login");
    JMenuItem exitMenuItem = new JMenuItem("Exit");
    JDesktopPane desktopPane = new JDesktopPane();

    MainFrame() {
        menuBar.add(fileMenu);
        fileMenu.add(loginMenuItem);
        fileMenu.add(new JSeparator());
        fileMenu.add(exitMenuItem);
        loginMenuItem.addActionListener((this));
        exitMenuItem.addActionListener(this);
        setJMenuBar(menuBar);

        setContentPane(desktopPane);


        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
//        setExtendedState(MAXIMIZED_BOTH);
    }

    JInternalFrame frame = null;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(exitMenuItem)) {
            dispose(); // exit
        }
        if (e.getSource() instanceof JMenuItem menu) {
//            System.out.println(menu.getText());
            if (menu.getText().equals("Login")) {
//                JFrame frame = new JFrame("login");
//                frame.setVisible(true);
//                frame.setSize(500,500);
//                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

                if (frame == null || frame.isClosed()) {
                    frame = new JInternalFrame("internal", true, true, true, true);
                    Vector<String> header = new Vector<>();
                    header.add("Name");
                    header.add("Score");
                    Vector<Vector<String>> data = new Vector<>();
                    Vector<String> rowData = new Vector<>();
                    rowData.add("Budi");
                    rowData.add("100");
                    data.add(rowData);
                    rowData = new Vector<>();
                    rowData.add("Danil");
                    rowData.add("95");
                    data.add(rowData);
                    rowData = new Vector<>();
                    rowData.add("Agus");
                    rowData.add("75");
                    data.add(rowData);
                    DefaultTableModel dtm = new DefaultTableModel(data, header);
                    frame.add(new JTable(dtm));
                    desktopPane.add(frame);
                }
                frame.setVisible(true);
                frame.setBounds(0, 0, 400, 400);
            }
        }
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
