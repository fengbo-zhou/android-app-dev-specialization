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
     * size of the escargatoire
     */
    public static final int HERD = 24;

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

    public void simulateHerd(Random rand) {
        int snailsCountInHerd = HERD;
        mOut.println(helper(snailsCountInHerd));
        for (int i = 0; i < 10; i++) {
            Gate next;
            if (snailsCountInHerd == HERD) {
                next = mEastGate;
            }
            else if (snailsCountInHerd == 0) {
                next = mWestGate;
            }
            else {
                next = rand.nextInt(2) == 0 ? mWestGate : mEastGate;
            }
            if (next == mEastGate) {
                int count = rand.nextInt(snailsCountInHerd) + 1;
                next.thru(count);
                snailsCountInHerd -= count;
            }
            else {
                int count = rand.nextInt(HERD - snailsCountInHerd) +1;
                next.thru(count);
                snailsCountInHerd += count;
            }
            mOut.println(helper(snailsCountInHerd));
        }
    }

    public String helper(int snailsCountInHerd) {
        return String.format("There are currently %d snails in the pen and %d snails in the pasture", snailsCountInHerd, HERD-snailsCountInHerd);
    }
}
