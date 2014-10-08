package gui;

import javax.swing.*;
import java.awt.*;

public class SimpleAnimation {

    int x = 20;
    int y = 20;

    public static void main (String[] args) {
        SimpleAnimation gui = new SimpleAnimation();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawPanel drawPanel = new DrawPanel();

        frame.getContentPane().add(drawPanel);
        frame.setSize(400,400);
        frame.setVisible(true);

        for (int i = 0; i < 140; i++) {
            x++;
            y++;

            drawPanel.repaint();

            try {
                Thread.sleep(30);
            } catch(Exception ex) { }
        }
    }

    class DrawPanel extends JPanel {

        public void paintComponent(Graphics g) {
            g.setColor(Color.white);
            g.fillRect(0,0,this.getWidth(), this.getHeight());

            g.setColor(Color.darkGray);
            g.fillOval(x,y,40,40);
        }

    }

}
