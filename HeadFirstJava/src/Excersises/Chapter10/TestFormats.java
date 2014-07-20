package Excersises.Chapter10;

import java.util.Date;

public class TestFormats {

    public static void main (String[] args) {

        // Number formatting examples
        String s = String.format("%, d", 100000000);
        System.out.println(s);

        String bugs = String.format("I have %,.2f bugs to fix.", 476578.09876);
        System.out.println(bugs);

        String test = String.format("%,6.1f", 42.000);
        System.out.println(test);

        String asterisk = String.format("%c", 42); // The number 42 represents the char "*".
        System.out.println(asterisk);

        int one = 20456654;
        double two = 100567890.248907;
        String rank = String.format("The rank is %,d out of %,.2f", one, two);
        System.out.println(rank);

        // Date object formatting examples
        Date thisDate = new Date();

        // The complete date and time
        System.out.println(String.format("%tc", thisDate));

        // Just the time
        System.out.println(String.format("%tr", thisDate));

        System.out.println(String.format("%tA, %<tB %<td", thisDate));

    }

}
