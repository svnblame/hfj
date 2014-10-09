package Exercises.Chapter11;

// import the javax.sound.midi package
import javax.sound.midi.*;

public class MusicTest1 {
    public void play() {

        /* We need a Sequencer object. It's the main part of the MIDI
           device/instrument we're using. It's the thing that
           sequences all the MIDI information into a 'song'.
           But we don't make a brand new one ourselves --
           we have to ask the MidiSystem to giv us one.
         */
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
        } catch(MidiUnavailableException ex) {
            /*
            The catch parameter has to be the 'right' exception. If we said
            'catch(FileNotFoundException f), the code would not compile,
            because polymorphically a MidiUnavailableException won't fit
            into a FileNotFoundException.
            Remember it's not enough to have a catch block... you have to
            catch the thing being thrown!
             */
            System.out.println("Bummer");
        }

        System.out.println("We got a sequencer");
    } // close play

    public static void main(String[] args) {
        MusicTest1 mt = new MusicTest1();
        mt.play();
    } // close main
} // close class

