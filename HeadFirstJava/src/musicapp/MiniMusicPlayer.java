package musicapp;

import javax.sound.midi.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

// We need to listen for ControllerEvents, so wee implement
// the listener interface
public class MiniMusicPlayer {

    static JFrame f = new JFrame("My First Music Video");
    static MyDrawPanel ml;

    public static void main(String[] args) {
        MiniMusicPlayer mini = new MiniMusicPlayer();
        mini.go();
    }

    public void setUpGui() {
        ml = new MyDrawPanel();
        f.setContentPane(ml);
        f.setBounds(30,30,300,300);
        f.setVisible(true);
    }

    public void go() {

        setUpGui();

        try {

            // Make and open a sequencer
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            // Register for events with the sequencer. The event registration
            // takes the listener AND an int array representing the list
            // of ControllerEvents you want. We want only one event, #127.
            sequencer.addControllerEventListener(ml, new int[] {127});

            // Make a sequence and track
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            // Make a bunch of events to make the notes keep going up
            // (from piano note 5 to piano note 61)
            int r = 0;
            for (int i = 0; i < 60; i += 4) {

                r = (int) ((Math.random() * 50) + 1);

                // Call makeEvent() method to make the message and event,
                // then add the result (the MidiEvent returned from makeEvent())
                // to the track. These ar NOTE ON (144) and NOTE OFF (128) pairs.
                track.add(makeEvent(144,1,r,100,i));

                /* Here's how we pick up the beat -- we insert our OWN ControllerEvent
                * (176 says the event type is ControllerEvent) with an argument for
                * event number #127. This event will do NOTHING! We put it in JUST so
                * that we can get an event each time a note is played. In other words
                * its sole purpose is so that something will fire that WE can listen for
                * (we can't listen for NOTE ON/OFF events). Note that we're making this
                * event happen at the SAME tick as the NOTE ON. So when the NOTE ON event
                * happens, we'll know about it because OUR event will fire at the same time.*/
                track.add(makeEvent(176,1,127,0,i));

                track.add(makeEvent(128,1,r,100,i + 2));

            }

            // Start it running
            sequencer.setSequence(seq);
            sequencer.start();
            sequencer.setTempoInBPM(120);

        } catch (Exception ex) {ex.printStackTrace();}

    }

    public static MidiEvent makeEvent(int command, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(command, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) { e.printStackTrace(); }
        return event;
    }

    class MyDrawPanel extends JPanel implements ControllerEventListener {

        boolean msg = false;

        public void controlChange(ShortMessage event) {
            msg = true;
            repaint();
        }

        public void paintComponent(Graphics g) {

            if (msg) {

                int r = (int) (Math.random() * 250);
                int gr = (int) (Math.random() * 250);
                int b = (int) (Math.random() * 250);

                g.setColor(new Color(r,gr,b));

                int ht = (int) ((Math.random() * 120) + 10);
                int width = (int) ((Math.random() * 120) + 10);

                int x = (int) ((Math.random() * 40) + 10);
                int y = (int) ((Math.random() * 40) + 10);

                g.fillRect(x,y,ht,width);
                msg = false;

            }

        }

    }

}
