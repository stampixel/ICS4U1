package Swing;

import javax.swing.*;
import java.awt.*;

public class Frames {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("My Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit out of application when click "x" button, normally it is hide
        frame.setResizable(false); // Prevent frame from being resized
        frame.setSize(420, 420); // Sets width:height
        frame.setVisible(true); // Make frame visible

//        ImageIcon image = new ImageIcon("Path"); // Create an image icon
//        frame.setIconImage(image.getImage()); // Change icon of frame
        frame.getContentPane().setBackground(Color.magenta); // Change color of background
        frame.getContentPane().setBackground(new Color(21, 100, 244)); // RGB example, can also use hexadecimals


    }
}
