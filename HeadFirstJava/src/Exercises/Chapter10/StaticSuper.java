package Exercises.Chapter10;

/**
 * Created by Gene on 7/20/2014.
 */
public class StaticSuper {
    static {
        System.out.println("super static block");
    }

    StaticSuper() {
        System.out.println("super constructor");
    }
}
