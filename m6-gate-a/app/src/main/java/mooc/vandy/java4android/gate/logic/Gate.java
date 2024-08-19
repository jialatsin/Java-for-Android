package mooc.vandy.java4android.gate;

/**
 * This file defines the Gate class.
 */
public class Gate {
    // TODO -- Fill in your code here
    public static final int IN = 1;
    public static final int OUT = -1;
    public static final int CLOSED = 0;
    private int mSwing = CLOSED;

    //Empty constructor?
    public Gate() {};

    public int getSwingDirection() {
        return mSwing;
    }

    public boolean setSwing(int direction) {
        switch (direction) {
            case 1:
                mSwing = IN;
                return true;
            case -1:
                mSwing = OUT;
                return true;
            case 0:
                mSwing = CLOSED;
                return true;
            default:
                return false;
        }
    }

    public boolean open(int direction) {
        if (direction == 1 || direction == -1) {
            setSwing(direction);
            return true;
        } else {
            return false;
        }
    }

    public void close() {
        setSwing(0);
    }

    public int thru(int count) {
        switch (this.mSwing) {
            case IN:
                return count;
            case OUT:
                return -count;
            default:
                return 0;
        }
    }

    public String toString() {
        switch (this.mSwing) {
            case CLOSED:
                return "This gate is closed";
            case IN:
                return "This gate is open and swings to enter the pen only";
            case OUT:
                return "This gate is open and swings to exit the pen only";
            default:
                return "This gate has an invalid swing direction";
        }
    }
}
