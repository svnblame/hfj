package Exercises.Chapter10;

class Player {
    /*
    The playerCount is initialized when the class is loaded. We explicitly
    initialized it to 0, but we don't need to since 0 is the default value
    for int. Static variables get default values just like instance variables.

    Default values for declared but uninitialized static and instance variables
    are the same:

    primitive integers (long, short, etc.): 0
    primitive floating points (float, double, etc.): 0.0
    boolean false
    object references: null
    */
    static int playerCount = 0;
    private String name;
    public Player(String n) {
        name = n;
        playerCount++;
    }
}

