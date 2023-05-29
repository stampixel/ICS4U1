package Swing;

import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFields extends JFrame implements ActionListener {
    JButton button;
    JTextField textField;


    TextFields() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button = new JButton("Submit");
        button.addActionListener(this);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250, 40));
        textField.setFont(new Font("JetBrains Mono", Font.PLAIN, 35));
        textField.setForeground(new Color(0x00FF00));
        textField.setBackground(Color.BLACK);
        textField.setCaretColor(Color.white);
        textField.setText("username");
//        textField.setEditable(false); // Makes it no longer editable;

        this.add(button);
        this.add(textField);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        // JTextField: A GUI text box component that can be used to add, set, or get text
        TextFields frame = new TextFields();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.out.println("Welcome " + textField.getText());
            textField.setEditable(false);
            button.setEnabled(false);
        }
    }
}
