package Week12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;

public class Main extends JFrame implements ActionListener {

    private JLabel label = new JLabel("0");
    private String[] btn = new String[]{
            "AC", "x\u00b2", "%", "+",
            "7", "8", "9", "-",
            "4", "5", "6", "×",
            "1", "2", "3", "÷",
            "0", ".", "+-", "="
    };

    private JPanel panel = new JPanel(new GridLayout(5, 4, 5, 5));

    private HashMap<String, Operation> operations = new HashMap<>();

    private Operation pendingOperation = null;
    private Double oldValue = 0.0;

    Main(){
//        operations.put("+", new OperationBinary() {
//            @Override
//            public Double doOperation(Double a, Double b) {
//                return a + b;
//            }
//        });
        operations.put("+", (OperationBinary)(a, b) -> a + b);
        operations.put("-", (OperationBinary)(a, b) -> a - b);
        operations.put("×", (OperationBinary)(a, b) -> a * b);
        operations.put("÷", (OperationBinary)(a, b) -> a / b);
        operations.put("%", (OperationUnary)(a) -> a / 100);
        operations.put("x\u00b2", (OperationUnary)(a) -> a * a);


        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setFont(new Font("Poppins", Font.PLAIN, 20));
        this.add(label, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);

        for(String btn:btn){
            JButton button = new JButton(btn);
            button.setFocusable(false);
            button.addActionListener(this);
            button.setBackground(new Color(220, 220, 220));
            button.setForeground(Color.black);
            panel.add(button);
        }

        this.setSize(300, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton btn){
            String l = btn.getText();
            if(Character.isDigit(l.charAt(0))){
                setLabel(l);
            } else if(l.equals(".") && !label.getText().contains(".")) {
                setLabel(l);
            }else if(l.equals("=")) {
                Double newValue = Double.parseDouble(label.getText());
                Double result = 0.0;
                if (pendingOperation instanceof OperationBinary op) {
                    result = op.doOperation(oldValue, newValue);
                } else if (pendingOperation instanceof OperationUnary op) {
                    result = op.doOperation(oldValue);
                }
                label.setText(result.toString());
            }else if(l.equals("AC")){
                label.setText("0");
            }else{
                Operation op = operations.get(l);
                if(op instanceof OperationBinary){
                    pendingOperation = op;
                    oldValue = Double.parseDouble(label.getText());
                    label.setText("0");

                }else if(op instanceof OperationUnary opu){
                    Double newValue = Double.parseDouble(label.getText());
                    Double result = opu.doOperation(newValue);
                    label.setText(result.toString());
                }
            }
        }
    }

    void setLabel(String str){
        if(label.getText().equals("0") && !str.equals(".")){
            label.setText(str);
        }else{
            label.setText(label.getText() + str);
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}

interface Operation{
}

interface OperationUnary extends Operation{
    Double doOperation(Double a);
}

interface OperationBinary extends Operation{
    Double doOperation(Double a, Double b);
}
