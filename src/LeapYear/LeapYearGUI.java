package LeapYear;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeapYearGUI extends JFrame {
    private JPanel panel1;
    private JTextField tfYear;
    private JButton btnCheckYear;

    public LeapYearGUI() {
        btnCheckYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isLeapYear();
            }
        });
    }

    void isLeapYear() {
        try {
            int year = Integer.parseInt(tfYear.getText());
            if ((year % 4 == 0 && year % 100 != 0 ) || (year % 400 == 0)) {
                JOptionPane.showMessageDialog(panel1, "Leap Year");
            } else {
                JOptionPane.showMessageDialog(panel1, "Not a leap Year");
            }
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(panel1, "Invalid Argument", "Error", JOptionPane.ERROR_MESSAGE);
            tfYear.setText("");
        }
    }
    public static void main(String[] args) {
        LeapYearGUI LeapYearGUI = new LeapYearGUI();
        LeapYearGUI.setTitle("Leap Year Checker");
        LeapYearGUI.setSize(500, 250);
        LeapYearGUI.setLocationRelativeTo(null);
        LeapYearGUI.setContentPane(LeapYearGUI.panel1);
        LeapYearGUI.setDefaultCloseOperation(EXIT_ON_CLOSE);
        LeapYearGUI.setVisible(true);
    }
}
