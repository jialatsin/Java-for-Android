package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Divide operation.
 */
public class Divide {
    // TODO - add your solution here.
    private int mArgumentOne;
    private int mArgumentTwo;

    public Divide(int argumentOne, int argumentTwo) {
        this.mArgumentOne = argumentOne;
        this.mArgumentTwo = argumentTwo;
    }

    public int[] result() {
        int quotient = mArgumentOne / mArgumentTwo;
        int remainder = mArgumentOne % mArgumentTwo;
        return new int[]{quotient, remainder};
    }

    public boolean checkArgumentZero() {
        return mArgumentTwo == 0;
    }
}
