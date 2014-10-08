package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// The main GUI class doesn't implement ActionListener now
public class TwoButtons {

    JFrame frame = new JFrame();
    JLabel label = new JLabel("I'm a label");

    // Make two instance variables in the main GUI class, for the
    // x and y coordinates of the circle
    int x = 30;
    int y = 30;

    public static void main (String[] args) {
        TwoButtons gui = new TwoButtons();
        gui.go();
    }

    public void go() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Change Label");
        // Instead of passing (this) to the button's listener registration
        // method, pass a new instance of the appropriate listener class
        labelButton.addActionListener(new LabelListener());

        JButton colorButton = new JButton("Change Circle");
        colorButton.addActionListener(new ColorListener());

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(600,600);
        frame.setVisible(true);

        for (int i = 0; i < 130; i++) {
            x++;
            y++;

            // Tell the panel to repaint itself (so we can see
            // the circle in the new location)
            drawPanel.repaint();

            try {
                // Slow it down a little (otherwise it will move so
                // quickly you won't SEE it move!)
                Thread.sleep(50);
            } catch(Exception ex) { }
        }
    }

    // Inner class
    class MyDrawPanel extends JPanel {

        public void paintComponent(Graphics g) {
            g.setColor(Color.orange);
            g.fillOval(x,y,40,40);
        }

    }

    // Inner class
    class LabelListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            label.setText("Ouch!");
        }
    }

    // Inner class
    class ColorListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            frame.repaint();
        }
    }

}

