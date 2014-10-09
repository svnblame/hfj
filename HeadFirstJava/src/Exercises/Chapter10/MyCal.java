package Exercises.Chapter10;

import java.util.Calendar;

public class MyCal {
    public static void main(String[] args) {

        Calendar c = Calendar.getInstance();

        // Set time to Jan. 7, 2004 at 15:40 (Month is zero based)
        c.set(2004,0,7,15,40);

        // Convert to milliseconds
        long day1 = c.getTimeInMillis();

        day1 += 1000 * 60 * 60;

        // Add an hour's worth of millis, then update the time.
        c.setTimeInMillis(day1);

        System.out.println("new hour " + c.get(c.HOUR_OF_DAY));

        // Add 35 days to the date, which should move us into February
        c.add(c.DATE, 35);

        System.out.println("add 35 days " + c.getTime());

        // "Roll" 35 days onto this date. This "rolls" the date ahead 35 days,
        // but DOES NOT change the month!
        c.roll(c.DATE, 35);

        System.out.println("roll 35 days " + c.getTime());

        // We're not incrementing here, just doing a "set" of the date
        c.set(c.DATE, 1);

        System.out.println("set to 1 " + c.getTime());

    }
}
