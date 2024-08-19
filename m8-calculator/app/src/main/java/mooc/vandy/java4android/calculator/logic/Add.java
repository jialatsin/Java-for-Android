package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Add operation.
 */
public class Add {
    // TODO - add your solution here.
    private int mArgumentOne;
    private int mArgumentTwo;

    public Add(int argumentOne, int argumentTwo) {
        this.mArgumentOne = argumentOne;
        this.mArgumentTwo = argumentTwo;
    }

    public int result() {
        return mArgumentOne + mArgumentTwo;
    }
}
