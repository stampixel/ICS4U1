package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Checkboxes extends JFrame implements ActionListener {
    JButton button;
    JCheckBox checkBox;
    ImageIcon xIcon;
    ImageIcon checkIcon;

    Checkboxes() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        xIcon = new ImageIcon("catsmirk.png");
        checkIcon = new ImageIcon("chess.jpg");

        button = new JButton();
        button.setText("Submit");
        button.addActionListener(this);

        checkBox = new JCheckBox();
        checkBox.setText("I'm not a robot");
        checkBox.setFocusable(false);
        checkBox.setFont(new Font("JetBrains Mono", Font.PLAIN, 35));
        checkBox.setIcon(xIcon);
        checkBox.setSelectedIcon(checkIcon);

        this.add(button);
        this.add(checkBox);
        this.pack();
        this.setVisible(true);
    }

    /**
     * JTextBox: A GUI that can be selected or deselected
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.out.println(checkBox.isSelected());


        }
    }
}
