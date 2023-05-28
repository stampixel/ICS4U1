package Swing;

import javax.swing.*;
import java.awt.*;

public class ExtendFrame extends JFrame {
    ExtendFrame() {
        this.setTitle("My Frame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit out of application when click "x" button, normally it is hide
        this.setResizable(false); // Prevent frame from being resized
        this.setSize(420, 420); // Sets width:height
        this.setVisible(true); // Make frame visible

//        ImageIcon image = new ImageIcon("Path"); // Create an image icon
//        frame.setIconImage(image.getImage()); // Change icon of frame
        this.getContentPane().setBackground(Color.magenta); // Change color of background
        this.getContentPane().setBackground(new Color(21, 100, 244)); // RGB example, can also use hexadecimals
    }

    public static void main(String[] args) {
        new ExtendFrame();
    }
}
