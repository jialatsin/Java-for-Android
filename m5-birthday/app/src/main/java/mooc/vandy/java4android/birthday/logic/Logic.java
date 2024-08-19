package mooc.vandy.java4android.birthday.logic;

import java.util.Random;
import java.util.ArrayList;

import mooc.vandy.java4android.birthday.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early Android interactions.
 * Designing the assignments this way allows you to first learn key 'Java' features without
 * having to beforehand learn the complexities of Android.
 */
public class Logic
        implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface
     * [MainActivity.java].
     * <p>
     * It is called 'mOut' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'mOut' is good enough).
     */
    OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance
     * (which implements [OutputInterface]) to 'out'
     */
    public Logic(OutputInterface out) {
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labelled 'Process' is pressed.
     */
    public void process() {
        int groupSize = mOut.getSize();
        int simulationCount = mOut.getCount();

        if (groupSize < 2 || groupSize > 365) {
            mOut.println("Error: Group Size must be in the range 2-365.");
            return;
        }
        if (!(simulationCount >= 1 && simulationCount <= 100000)) {
            mOut.println("Error: Simulation Count must be in the range 1-100000.");
            return;
        }

        double percent = calculate(groupSize, simulationCount);

        // report results
        mOut.println("For a group of " + groupSize + " people, the percentage "
                + " of times that two people share the same birthday is "
                + String.format("%.2f%% of the time.", percent));

    }

    /**
     * This is the method that actually does the calculations.
     * <p>
     * We provide you this method that way we can test it with unit testing.
     */
    public double calculate(int size, int count) {
        // size: Size of group of people
        // count: number of simulations to be run
        // TODO -- add your code here
//        ArrayList<Boolean> simulation = new ArrayList<>();
        int matchingBirthdaysTrue = 0;
        int matchingBirthdaysFalse = 0;
        // for each simulation
        for (int i = 0; i < count; i++) {
            //generate a new Random object
            Random RandomObj = new Random();
            RandomObj.setSeed(i + 1);
            ArrayList<Integer> people = new ArrayList<>();
            Boolean foundBirthday = Boolean.FALSE;
            // randomly generate birthdays for 'size' number of people
            for (int j=0; j<size; j++) {
                int randomBirthday = RandomObj.nextInt(365);
                if (!people.contains(randomBirthday)) {
                    people.add(randomBirthday);
                } else {
//                    simulation.add(Boolean.True);
                    matchingBirthdaysTrue += 1;
                    foundBirthday = Boolean.TRUE;
                    break;
                }
            }
            if (foundBirthday == Boolean.FALSE) {
//                simulation.add(Boolean.FALSE);
                matchingBirthdaysFalse += 1;
            }
        }
        if (matchingBirthdaysTrue + matchingBirthdaysFalse == count) {
            return ((double) matchingBirthdaysTrue) / count * 100;
        }
        return -1;
    }


    // TODO -- add your helper methods here
    
}
