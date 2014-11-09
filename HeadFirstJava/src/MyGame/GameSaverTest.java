package MyGame;

import java.io.*;

public class GameSaverTest {
    public static void main(String[] args) {
        // Make some characters
        GameCharacter one = new GameCharacter(50, "Elf", "Wellington", new String[] {"bow", "sword", "dust"});
        GameCharacter two = new GameCharacter(200, "Troll", "Stroginoff", new String[] {"bare hands", "big axe"});
        GameCharacter three = new GameCharacter(120, "Magician", "Magellian", new String[] {"spells", "invisibility"});

        // code here that does things with the characters that might change their state values

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }

        // Set the character objects to null so we can't access the objects on the heap
        one = null;
        two = null;
        three = null;

        // Now read (de-serialize) them back from the file...
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));
            GameCharacter oneRestore = (GameCharacter) is.readObject();
            GameCharacter twoRestore = (GameCharacter) is.readObject();
            GameCharacter threeRestore = (GameCharacter) is.readObject();

            System.out.println("Character One: ");
            System.out.println("Name: " + oneRestore.getName() + ", Type: " + oneRestore.getType() + ", Power: "
                + oneRestore.getPower());
            System.out.println("Character Two: ");
            System.out.println("Name: " + twoRestore.getName() + ", Type: " + twoRestore.getType() + ", Power: "
                    + twoRestore.getPower());
            System.out.println("Character Three: ");
            System.out.println("Name: " + threeRestore.getName() + ", Type: " + threeRestore.getType() + ", Power: "
                    + threeRestore.getPower());
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
