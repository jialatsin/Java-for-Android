package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to manage a herd of snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class HerdManager {
    /**
     * Reference to the output.
     */
    private OutputInterface mOut;

    /**
     * The input Gate object.
     */
    private Gate mWestGate;

    /**
     * The output Gate object.
     */
    private Gate mEastGate;

    /**
     * Maximum number of iterations to run the simulation.
     */
    private static final int MAX_ITERATIONS = 10;

    /**
     * Constructor initializes the fields.
     */
    public HerdManager(OutputInterface out,
                       Gate westGate,
                       Gate eastGate) {
        mOut = out;

        mWestGate = westGate;
        mWestGate.open(Gate.IN);

        mEastGate = eastGate;
        mEastGate.open(Gate.OUT);
    }

    // TODO -- Fill your code in here
    public static final int HERD = 24;

    public void simulateHerd(Random rand) {
        int numSnails = HERD;

        mOut.println("There are currently " + numSnails + " snails in the pen and " + (HERD-numSnails) + " snails in the pasture");
        // run 10 simulations
        for (int i=0; i<MAX_ITERATIONS; i++) {
            // if all snails are out, move them IN
            if (numSnails == 0) {
                numSnails += mWestGate.thru(rand.nextInt(HERD) + 1);

            // if all snails are in, move them OUT
            } else if (numSnails == HERD) {
                numSnails += mEastGate.thru(rand.nextInt(HERD) + 1);

            } else {
                //select a random Gate
                int gateToMove = rand.nextInt(2);
                // move snails IN
                if (gateToMove == 0) {
                    //select random number of snails, number of snails limited to HERD - current snails
                    numSnails += mWestGate.thru(rand.nextInt(HERD - numSnails) + 1);
                } else {
                    //select random number of snails, number of snails limited to current snails
                    numSnails += mEastGate.thru(rand.nextInt(numSnails) + 1);
                }
            }

            mOut.println("There are currently " + numSnails + " snails in the pen and " + (HERD-numSnails) + " snails in the pasture");
        }
    }

    
}
