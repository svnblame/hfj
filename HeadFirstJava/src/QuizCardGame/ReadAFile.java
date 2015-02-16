package QuizCardGame;
import java.io.*;

public class ReadAFile {
    public static void main(String[] args) {

        try {
            File myFile = new File("MyText.txt");
            // A FileReader is a connection stream for characters, that connects to a text file
            FileReader fileReader = new FileReader(myFile);

            // Chain the FileReader to a BufferedReader for more efficient reading.
            // It'll go back to the file to read only when the buffer is empty (because the program
            // has read everything in it)
            BufferedReader reader = new BufferedReader(fileReader);

            // Make a String variable to hold each line as the line is read
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
