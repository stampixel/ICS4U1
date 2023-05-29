package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxes extends JFrame implements ActionListener {
    JComboBox comboBox;

    ComboBoxes() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        String[] animals = {"dog", "cat", "bird"}; // JComboBox doesn't work with primitive datatype

        comboBox = new JComboBox(animals);
        comboBox.addActionListener(this);

        comboBox.setEditable(true);
        System.out.println(comboBox.getItemCount());
        comboBox.addItem("chicken");
        comboBox.insertItemAt("pig", 0);
        comboBox.setSelectedIndex(0); // Selection of first run
//        comboBox.removeItem(0); IDK IF THIS WORKS
        comboBox.removeItem("cat");
        comboBox.removeItemAt(3);
        comboBox.removeAllItems();

        this.add(comboBox);
        this.pack();
        this.setVisible(true);
    }


    /**
     * JComboBox: A component that combines a button or editable field and a drop down list
     *
     * @param args
     */
    public static void main(String[] args) {
        new ComboBoxes();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboBox) {
//            System.out.println(comboBox.getSelectedItem());
            System.out.println(comboBox.getSelectedIndex());
        }
    }
}
