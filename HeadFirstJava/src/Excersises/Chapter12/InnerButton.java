package Excersises.Chapter12;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class InnerButton {

    JFrame frame;
    JButton b;

    public static void main(String[] args) {

        InnerButton gui = new InnerButton();
        gui.go();

    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b = new JButton("A");
        BListener listener = new BListener();
        b.addActionListener(listener);

        frame.getContentPane().add(BorderLayout.SOUTH, b);
        frame.setSize(200,100);
        frame.setVisible(true);
    }

    class BListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (b.getText().equals("A")) {
                b.setText("B");
            } else {
                b.setText("A");
            }
        }
    }

}
