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
        try {
            Double operand1 = Double.parseDouble(tfNumber1.getText());
            Double operand2 = Double.parseDouble(tfNumber2.getText());
            String operator = (String) cbOperations.getSelectedItem();
            Double result;
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
                    if(result.isInfinite() || result.isNaN()) {
                        throw new ArithmeticException();
                    }
            }
            if(result == -0.00) {
                result = (double) 0;
            }
            lblResult.setText(String.format("%.2f", result));
        } catch(ArithmeticException e) {
            JOptionPane.showMessageDialog(panel1, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
            clear();
            System.out.println(e.getMessage());
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(panel1, "Input must be a number", "Error", JOptionPane.ERROR_MESSAGE);
            clear();
        }

    }

    void clear() {
        tfNumber1.setText("");
        tfNumber2.setText("");
    }
    public static void main(String[] args) {
        SimpleCalcGUI SimpleCalcGUI = new SimpleCalcGUI();
        SimpleCalcGUI.setTitle("Simple Calculator");
        SimpleCalcGUI.setLocationRelativeTo(null);
        SimpleCalcGUI.setSize(560, 250);
        SimpleCalcGUI.setContentPane(SimpleCalcGUI.panel1);
        SimpleCalcGUI.setDefaultCloseOperation(EXIT_ON_CLOSE);
        SimpleCalcGUI.setVisible(true);
    }
}
