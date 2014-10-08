package gui;

// Import the swing package
import javax.swing.*;
// Import the event listener and handler package
import java.awt.*;
import java.awt.event.*;

// Implement the interface. This says, "an instance of
// SimpleGui1 IS-A ActionListener" i.e. The button will
// give events only to ActionListener implementers
public class SimpleGui1 implements ActionListener {

    JButton button;

    public static void main (String[] args) {
        SimpleGui1 gui = new SimpleGui1();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        button = new JButton("click me");

        // Register your interest in the button. This says
        // to the button, "Add me to your list of listeners."
        // The argument you pass MUST be an object from a class
        // that implements ActionListener!!
        button.addActionListener(this);

        frame.getContentPane().add(BorderLayout.CENTER, button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        button.setText("I've been clicked!");
    }

}


