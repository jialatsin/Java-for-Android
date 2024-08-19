package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Multiply operation.
 */
public class Multiply {
    // TODO - add your solution here.
    private int mArgumentOne;
    private int mArgumentTwo;

    public Multiply(int argumentOne, int argumentTwo) {
        this.mArgumentOne = argumentOne;
        this.mArgumentTwo = argumentTwo;
    }

    public int result() {
        return mArgumentOne * mArgumentTwo;
    }
}
