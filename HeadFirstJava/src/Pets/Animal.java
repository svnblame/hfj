package Pets;

// Put ALL Animal related classes (abstract and concrete) here

public class Animal {
    //base definition of Animal
}

class Feline extends Animal {
    // Feline specific code here...
}

class Canine extends Animal {
    // Canine specific code here...
}

class Cat extends Feline {
    // Cat specific code here...
}

class Dog extends Canine implements Pet {
    public void beFriendly() { ; }
    public void play() { ; }

    public void roam() { ; }
    public void eat() { ; }
}
