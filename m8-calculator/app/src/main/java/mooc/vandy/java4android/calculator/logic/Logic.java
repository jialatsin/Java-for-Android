package mooc.vandy.java4android.calculator.logic;

import mooc.vandy.java4android.calculator.ui.ActivityInterface;

/**
 * Performs an operation selected by the user.
 */
public class Logic implements LogicInterface {

    private static final int ADDITION = 1;
    private static final int SUBTRACTION = 2;
    private static final int MULTIPLICATION = 3;
    private static final int DIVISION = 4;

    /**
     * Reference to the Activity output.
     */
    protected ActivityInterface mOut;

    
    /**
     * Constructor initializes the field.
     */
    public Logic(ActivityInterface out) {
        mOut = out;
        
    }

    

    /**
     * Perform the operation on argumentOne and argumentTwo.
     */
    public void process(int argumentOne, int argumentTwo, int operation) {
        // TODO - Put your code here.
        String res = "";
        switch (operation) {
            case ADDITION:
                Add addOperation = new Add(argumentOne, argumentTwo);
                mOut.print(res + addOperation.result());
                break;
            case SUBTRACTION:
                Subtract subtractOperation = new Subtract(argumentOne, argumentTwo);
                mOut.print(res + subtractOperation.result());
                break;
            case MULTIPLICATION:
                Multiply multiplyOperation = new Multiply(argumentOne, argumentTwo);
                mOut.print(res + multiplyOperation.result());
                break;
            case DIVISION:
                Divide divideOperation = new Divide(argumentOne, argumentTwo);
                if (divideOperation.checkArgumentZero()) {
                    mOut.print("Value Two cannot be zero!");
                    break;
                }
                mOut.print(res + divideOperation.result()[0] + " R: " + divideOperation.result()[1]);
                break;
        }
        
    }
}
