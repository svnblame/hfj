package Exercises;

public abstract class Animal {
    // All animals (including subclasses) have a name
    private String name;

    // A getter method that Hippo inherits
    public String getName() {
        return name;
    }

    public Animal(String theName) {
        name = theName;
    }
}

