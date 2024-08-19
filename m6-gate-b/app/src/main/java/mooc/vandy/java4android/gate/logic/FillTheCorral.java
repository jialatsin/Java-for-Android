package mooc.vandy.java4android.gate.logic;

import java.util.Arrays;
import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to fill the corral with snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class FillTheCorral {
    /**
     * Reference to the OutputInterface.
     */
    private OutputInterface mOut;

    /**
     * Constructor initializes the field.
     */
    FillTheCorral(OutputInterface out) {
        mOut = out;
    }

    // TODO -- Fill your code in here
    public void setCorralGates(Gate[] gate, Random rand) {
        mOut.println("Initial gate setup:");
        for (int i=0; i<gate.length; i++) {
            int direction = rand.nextInt(3) - 1;
            gate[i].setSwing(direction);
            mOut.println("Gate " + i + ": " + gate[i].toString());
        }
    }

    public boolean anyCorralAvailable (Gate[] gate) {
        for (Gate indivGate: gate) {
            if (indivGate.getSwingDirection() == Gate.IN) {
                return true;
            }
        }
        return false;
    }

    public int corralSnails (Gate[] corral, Random rand) {
        int numSnails = 5;
        int numIterations = 0;
        while (numSnails > 0) {
            int gateIndex = rand.nextInt(corral.length);
            int randomSnails = rand.nextInt(numSnails) + 1;
            int snailsToMove = corral[gateIndex].thru(randomSnails);
            numSnails -= snailsToMove;
            mOut.println(randomSnails + " are trying to move through corral " + (gateIndex));
            numIterations++;
        }
        mOut.println("It took " + numIterations + " attempts to corral all of the snails.");
        return numIterations;
    }
    
}
