package Excersises.Chapter10;

import java.util.ArrayList;

public class AutoBox {
    public static void doNumsNewWay() {
        ArrayList<Integer> listOfNubmers = new ArrayList<Integer>();

        listOfNubmers.add(3);

        int num = listOfNubmers.get(0);

        System.out.println("num = " + num);
    }

    public static void doNumsOldWay() {
        ArrayList listOfNubmers = new ArrayList();

        listOfNubmers.add(new Integer(3));

        Integer one = (Integer) listOfNubmers.get(0);

        int intOne = one.intValue();

        System.out.println("one = " + one + ", intOne = " + intOne);
    }

    public static void main(String[] args) {
        doNumsOldWay();
        doNumsNewWay();
    }
}



