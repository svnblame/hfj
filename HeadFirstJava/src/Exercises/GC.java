package Exercises;

public class GC {
    public static GC doStuff() {
        GC newGC = new GC();
        doStuff2(newGC);
        return newGC;
    }

    public static void doStuff2(GC copyGC) {
        GC localGC = copyGC;
    }

    public static void main(String[] args) {
        GC gc1;
        GC gc2 = new GC();
        GC gc3 = new GC();
        GC gc4 = gc3;
        gc1 = doStuff();

        // plug in code here
        //copyGC = null; // No - this line attempts to access a variable that is out of scope
        gc2 = null;    // OK - gc2 was the only reference variable referring to that object
        //newGC = gc3;   // No - another out of scope variable
        gc1 = null;    // OK - gc1 had the only reference because newGC is out of scope
        //newGC = null;  // No - newGC is out of scope
        gc4 = null;    // No - gc3 is still referring to that object
        gc3 = gc2;     // No - gc4 is still referring to that object
        gc1 = gc4;     // OK - Reassigning the only reference to that object
        gc3 = null;    // No = gc4 is still referring to that object

    }
}
