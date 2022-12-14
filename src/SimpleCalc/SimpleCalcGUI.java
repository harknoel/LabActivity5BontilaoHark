package SimpleCalc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class SimpleCalcGUI extends JFrame {
    private JPanel panel1;
    private JTextField tfNumber1;
    private JComboBox cbOperations;
    private JButton btnCompute;
    private JTextField tfNumber2;
    private JTextField lblResult;

    public SimpleCalcGUI() {
        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compute();
            }
        });
    }

    void compute() {
        Double operand1 = Double.parseDouble(tfNumber1.getText());
        Double operand2 = Double.parseDouble(tfNumber2.getText());
        String operator = (String) cbOperations.getSelectedItem();
        double result;
        switch (Objects.requireNonNull(operator)) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            default:
                result = operand1 / operand2;
        }
        lblResult.setText(String.format("%.2f", result));
    }

    public static void main(String[] args) {
        SimpleCalcGUI SimpleCalcGUI = new SimpleCalcGUI();
        SimpleCalcGUI.setTitle("Simple Calculator");
        SimpleCalcGUI.setLocationRelativeTo(null);
        SimpleCalcGUI.setContentPane(SimpleCalcGUI.panel1);
        SimpleCalcGUI.setSize(560, 250);
        SimpleCalcGUI.setDefaultCloseOperation(EXIT_ON_CLOSE);
        SimpleCalcGUI.setVisible(true);
    }
}
