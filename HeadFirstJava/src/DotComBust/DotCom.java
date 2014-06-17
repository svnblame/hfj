package DotComBust;

import java.util.ArrayList;

public class DotCom {
    // DotCom's instance variables:
    //  - an ArrayList of cell locations
    // - the DotCom's name
    private ArrayList<String> locationCells;
    private String name;

    /**
     * A setter method that updates the DotCom's location.
     * (Random location provided by the GameHelper placeDotCom() method).
     * @param loc ArrayList List of cell locations
     */
    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }

    /**
     * Set name property
     * @param n String
     */
    public void setName(String n) {
        name = n;
    }

    public String checkYourself(String userInput) {
        String result = "miss";

        // The ArrayList indexOf() method in action! If the user guess is one of the entries in the ArrayList,
        // indexOf() will return its ArrayList location. If not, indexOf() will return -1.
        int index = locationCells.indexOf(userInput);

        if (index >= 0) {
            // Using ArrayList's remove() method to delete an entry.
            locationCells.remove(index);

            if (locationCells.isEmpty()) {
                result = "kill";
                System.out.println("Ouch! You sunk " + name + "  : (");
            } else {
                result = "hit";
            } // close inner if
        } // close outer if
        // Return String: 'miss', 'hit', or 'kill'.
        return result;
    } // close checkYourself method
} // close DotCom class

