package Exercises.Chapter10;

public class Duck {
    private int size;
    // The static duckCount variable is initialized ONLY when the class is first
    // loaded, NOT each time a new instance is made
    private static int duckCount = 0;

    public Duck() {
        // Now it will keep incrementing each time the Duck contructor runs,
        // because duckCount is static and won't be reset to 0
        duckCount++;
    }

    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.setSize(25);
        System.out.println("Size of duck is " + duck.getSize());
    }

    public void setSize(int s) {
        size = s;
    }

    public int getSize() {
        return size;
    }
}
