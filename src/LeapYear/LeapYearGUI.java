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
        int year = Integer.parseInt(tfYear.getText());
        if ((year % 4 == 0 && year % 100 != 0 ) || (year % 400 == 0)) {
            JOptionPane.showMessageDialog(panel1, "Leap Year");
        } else {
            JOptionPane.showMessageDialog(panel1, "Not a leap Year");
        }
    }
    public static void main(String[] args) {
        LeapYearGUI LeapYearGUI = new LeapYearGUI();
        LeapYearGUI.setTitle("Leap Year Checker");
        LeapYearGUI.setContentPane(LeapYearGUI.panel1);
        LeapYearGUI.setSize(500, 250);
        LeapYearGUI.setDefaultCloseOperation(EXIT_ON_CLOSE);
        LeapYearGUI.setLocationRelativeTo(null);
        LeapYearGUI.setVisible(true);
    }
}
