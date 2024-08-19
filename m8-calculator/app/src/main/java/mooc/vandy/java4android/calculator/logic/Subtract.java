package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Subtract operation.
 */
public class Subtract {
    // TODO - add your solution here.
    private int mArgumentOne;
    private int mArgumentTwo;

    public Subtract(int argumentOne, int argumentTwo) {
        this.mArgumentOne = argumentOne;
        this.mArgumentTwo = argumentTwo;
    }

    public int result() {
        if (mArgumentOne > mArgumentTwo) {
            return mArgumentOne - mArgumentTwo;
        } else {
            return mArgumentTwo - mArgumentOne;
        }

    }
}
