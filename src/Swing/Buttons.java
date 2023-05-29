package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons extends JFrame implements ActionListener {
    JButton button;
    JLabel label;

    Buttons() {
        ImageIcon icon = new ImageIcon("catsmirk.png");
        ImageIcon chess = new ImageIcon("chess.jpg");

        label = new JLabel();
        label.setIcon(chess);
        label.setBounds(150, 250, 150, 150);
        label.setVisible(false);


        button = new JButton();
        button.setBounds(100, 100, 300, 150);
//        button.addActionListener(e -> System.out.println("Hello world")); // Lambda Expression
        button.addActionListener(this);
        button.setText("Click me!");
        button.setFocusable(false);
        button.setIcon(icon);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setFont(new Font("JetBrains Mono", Font.BOLD, 25));
        button.setIconTextGap(-15);
        button.setForeground(Color.cyan);
        button.setBackground(Color.lightGray);
        button.setBorder(BorderFactory.createEtchedBorder());
//        button.setEnabled(false); // Disables the button

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(button);
        this.add(label);
    }

    /**
     * JButton: a button that performs an action when clicked on
     *
     * @param args
     */
    public static void main(String[] args) {
        new Buttons();

    }

    /**
     * Lists for events
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.out.println("Hello, World!");
            label.setVisible(true);
        }
    }
}
