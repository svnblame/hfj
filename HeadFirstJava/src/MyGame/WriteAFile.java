package MyGame;

// We need the java.io package to get the FileWriter class
import java.io.FileWriter;
import java.io.IOException;

public class WriteAFile {
    public static void main(String[] args) {

        // All the I/O stuff must be in a try/catch. Everything can throw an IOException!!
        try {
            // If the file "Foo.txt" does not exist, FileWriter will create it
            FileWriter writer = new FileWriter("Foo.txt");

            // The write() method takes a string
            writer.write("Hello Foo!");

            // Close it when your done!
            writer.close();

        } catch(IOException ex) {
            ex.printStackTrace();
        }

    }
}
