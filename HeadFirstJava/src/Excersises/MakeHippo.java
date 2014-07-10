package Excersises;

public class MakeHippo {
    public static void main(String[] args) {
        // Make a Hippo, passing the name "Buffy" to the Hippo constructor.
        // Then call the Hippo's inherited getName() method.
        Hippo h = new Hippo("Buffy");
        System.out.println(h.getName());
    }
}
