package Exercises.Chapter10;

/**
 * Created by Gene on 7/20/2014.
 */
public class StaticTests {
    static int rand;

    static {
        rand = (int) (Math.random() * 6);
        System.out.println("static block " + rand);
    }

    StaticTests() {
        System.out.println("constructor");
    }

    public static void main(String [] args) {
        System.out.println("in main");
        StaticTests st = new StaticTests();
    }
}
