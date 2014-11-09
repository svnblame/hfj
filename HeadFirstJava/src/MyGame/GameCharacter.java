package MyGame;

import java.io.*;

public class GameCharacter implements Serializable {
    int power;
    String type;
    String name;
    String[] weapons;

    public GameCharacter(int p, String t, String n, String[] w) {
        power = p;
        type = t;
        name = n;
        weapons = w;
    }

    public int getPower() {
        return power;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getWeapons() {
        String weaponList = "";

        for (int i = 0; i < weapons.length; i++) {
            weaponList += weapons[i] + " ";
        }

        return weaponList;
    }
}

