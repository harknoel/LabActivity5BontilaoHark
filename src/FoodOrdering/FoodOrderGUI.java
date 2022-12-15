package FoodOrdering;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;


public class FoodOrderGUI extends JFrame {
    private JPanel panel1;
    private JCheckBox cPizza;
    private JRadioButton rbNone;
    private JButton btnOrder;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;
    private Hashtable<JCheckBox, Integer> bgFoods;
    private Hashtable<JRadioButton, Double> bgDiscounts;
    public FoodOrderGUI() {
        bgFoods = new Hashtable<>();
        bgFoods.put(cPizza, 100);
        bgFoods.put(cBurger, 80);
        bgFoods.put(cFries, 65);
        bgFoods.put(cSoftDrinks, 55);
        bgFoods.put(cTea, 50);
        bgFoods.put(cSundae, 40);

        bgDiscounts = new Hashtable<>();
        bgDiscounts.put(rbNone, 0.00);
        bgDiscounts.put(rb5, 0.05);
        bgDiscounts.put(rb10, 0.10);
        bgDiscounts.put(rb15, 0.15);

        rbNone.setSelected(true);
        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double result = sumOrderDiscount();
                    if (result == 0) {
                        throw new Exception();
                    }
                    JOptionPane.showMessageDialog(panel1, String.format("The total price is Php %.2f", result));
                    for (JCheckBox bgFood : bgFoods.keySet()) {
                        if (bgFood.isSelected()) {
                            bgFood.setSelected(false);
                        }
                    }
                    rbNone.setSelected(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel1, "No food items selected.", "Error", JOptionPane.ERROR_MESSAGE);
                    rbNone.setSelected(true);
                }

            }
        });
    }

    double sumOrderDiscount() {
        double sum = getSum();
        double discount = sum * getDiscount();
        return sum - discount;
    }

    double getDiscount() {
        double discount = 0;
        for(JRadioButton bgDiscount: bgDiscounts.keySet()) {
            if(bgDiscount.isSelected()) {
                discount = bgDiscounts.get(bgDiscount);
                break;
            }
        }
        return discount;
    }
    int getSum() {
        int sum = 0;
        for(JCheckBox bgFood: bgFoods.keySet()) {
            if(bgFood.isSelected()) {
                sum += bgFoods.get(bgFood);
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        FoodOrderGUI FoodOrderGUI = new FoodOrderGUI();
        FoodOrderGUI.setContentPane(FoodOrderGUI.panel1);
        FoodOrderGUI.setSize(500,500);
        FoodOrderGUI.setLocationRelativeTo(null);
        FoodOrderGUI.setTitle("Food Ordering System");
        FoodOrderGUI.setDefaultCloseOperation(EXIT_ON_CLOSE);
        FoodOrderGUI.setVisible(true);
    }
}
