package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtons extends JFrame implements ActionListener {
    JRadioButton pizzaButton;
    JRadioButton hamburgerButton;
    JRadioButton hotdogButton;
    ImageIcon pizzaIcon;
    ImageIcon hamburgerIcon;

    RadioButtons() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        pizzaIcon = new ImageIcon("chess.jpg");
        hamburgerIcon = new ImageIcon("catsmirk.png");

        pizzaButton = new JRadioButton("pizza");
        hamburgerButton = new JRadioButton("hamburger");
        hotdogButton = new JRadioButton("hotdog");

        ButtonGroup group = new ButtonGroup();
        group.add(pizzaButton);
        group.add(hamburgerButton);
        group.add(hotdogButton);

        pizzaButton.addActionListener(this);
        hamburgerButton.addActionListener(this);
        hotdogButton.addActionListener(this);

        pizzaButton.setIcon(pizzaIcon);
        hamburgerButton.setIcon(hamburgerIcon);

        this.add(pizzaButton);
        this.add(hamburgerButton);
        this.add(hotdogButton);

        this.pack();
        this.setVisible(true);
    }

    /**
     * JRadioButton: One or more buttons ina  group in which only 1 may be selected per group
     *
     * @param args
     */
    public static void main(String[] args) {
        new RadioButtons();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pizzaButton) {
            System.out.println("You ordered a Pizza!");
        } else if (e.getSource() == hamburgerButton) {
            System.out.println("You ordered a Hamburger!");
        } else {
            System.out.println("You ordered a Hot Dog");
        }

    }
}
