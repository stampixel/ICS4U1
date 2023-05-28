package Swing;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class Labels {
    public static void main(String[] args) {

        // JLabel: GUI display area for a string of text, image, or both
        ImageIcon image = new ImageIcon("chess.jpg");
        Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);

        JLabel label = new JLabel(); // Create  a label
        label.setText("Kevin's Label"); // Set text of label
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER); // Set text left, center, or right of image icon
        label.setVerticalTextPosition(JLabel.TOP); // Set text top, center, or bottom of image icon
        label.setForeground(Color.MAGENTA); // Set font color of text
        label.setFont(new Font("JetBrains Mono", Font.BOLD, 50)); // Set font of text
        label.setIconTextGap(-12);
        label.setBackground(Color.CYAN); // Set background color
        label.setOpaque(true); // Display background color
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER); // Set vertical position of icon and text within label
        label.setHorizontalAlignment(JLabel.CENTER); // Set horizontal position of icon and text within label
//        label.setBounds(100, 100, 250, 250);


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(500, 500);
//        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(label);
        frame.pack();
    }
}
