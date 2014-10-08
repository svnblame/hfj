package com.bizflowdesigns.musicapp;

import javax.sound.midi.*;

/**
 * Created by Gene on 8/28/2014.
 */
public class MiniMusicApp {

    public static void main(String[] args) {
        MiniMusicApp mini = new MiniMusicApp();
        mini.play();
    }

    public void play() {

        try {
            // Get a Sequencer and open it (so we can use it... a Sequencer
            // doesn't come already open)
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);

            // Ask the Sequence for a Track. Remember, the Track lives in the
            // Sequence and the MIDI data lives in the Track.
            Track track = seq.createTrack();

            // Put some MidiEvents into the Track.
            // The only thing we care about are the arguments to the setMessage()
            // method, and the arguments to the MidiEvent constructor.

            // Make a Message
            ShortMessage a = new ShortMessage();

            // Put the Instruction in the message
            // This message says, "start playing note 44"
            a.setMessage(144, 1, 20, 100);

            // Make a new MidiEvent using the Message
            // The instructions are in the message, but the MidiEvent adds the
            // moment in time the instruction should be triggered. This MidiEvent
            // says to trigger message 'a' at the first beat (beat 1).
            MidiEvent noteOn = new MidiEvent(a, 1);

            // Add the MidiEvent to the Track
            // A Track holds all the MidiEvent objects. The Sequence organizes them
            // according to when each event is supposed to happen, and then the
            // Sequencer plays them back in that order. You can have lots of
            // events happening at the exact same moment in time. For example,
            // you might want two notes played simultaneously, or even different
            // instruments playing different sounds at the same time.
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(192, 1, 102, 0);
            MidiEvent noteOff = new MidiEvent(b, 3);
            track.add(noteOff);

            // Give the Sequence to the Sequencer (like putting the CD in the
            // CD player.
            player.setSequence(seq);

            // Start() the Sequencer (like pushing PLAY)
            player.start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
