package com.bizflowdesigns.musicapp;

import javax.sound.midi.*;

/**
 * Created by Gene on 8/28/2014.
 */
public class MiniMiniMusicApp {

    public static void main(String[] args) {
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
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

            // Put some MidiEvents into the Track. This part is mostly
            // Ready-baked code. The only thing we care about are the
            // arguments to the setMessage() method, and the arguments to
            // the MidiEvent constructor.
            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, 44, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(b, 16);
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
