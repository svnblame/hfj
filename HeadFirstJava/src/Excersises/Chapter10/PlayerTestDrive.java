package Excersises.Chapter10;

public class PlayerTestDrive {
    public static void main(String[] args) {
        System.out.println("Number of players: " + Player.playerCount);
        Player one = new Player("Tiger Woods");

        // Access a static variable just like a static method -- with the class name
        System.out.println("Number of players: " + Player.playerCount);
    }
}
