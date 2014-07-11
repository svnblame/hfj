package Excersises.Chapter10;

public class ValueWrap {
    public static void main(String[] args) {
        /*
        When you need to treat a primitive like an object, wrap it. If you're using any
        version of Java before 5.0, you'll do this when you need to store a primitive
        value inside a collection like ArrayList or HashMap.

        There's a wrapper class for every primitive type, but watch out! The names aren't
        mapped exactly to the primitive types. The class names are fully spelled out:

        Boolean
        Character
        Byte
        Short
        Integer
        Long
        Float
        Double
         */

        // wrapping a value
        int i = 288;
        // Give the primitive to the wrapper constructor. That's it.
        Integer iWrap = new Integer(i);
        System.out.println("i = " + i + ", iWrap = " + iWrap);

        // unwrapping a value
        // All the wrappers work like this. Boolean has a booleanValue(), Character has a charValue(), etc.
        int unWrapped = iWrap.intValue();


    }
}
