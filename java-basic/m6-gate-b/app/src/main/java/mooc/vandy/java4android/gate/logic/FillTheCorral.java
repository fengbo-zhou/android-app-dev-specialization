package mooc.vandy.java4android.gate.logic;

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

    public void setCorralGates(Gate[] gates, Random rand) {
        StringBuilder sb = new StringBuilder();
        sb.append("Initial gate setup:\n");

        for (Gate gate : gates) {
            gate.setSwing(rand.nextInt(3) - 1);
            sb.append(gate + "\n");
        }
        mOut.print(sb.toString());
    }

    public boolean anyCorralAvailable(Gate[] corral) {
        for (Gate gate : corral) {
            if (gate.getSwingDirection() == Gate.IN) {
                return true;
            }
        }
        return false;
    }

    public int corralSnails(Gate[] corral, Random rand) {
        int snailsInPasture = 5;
        int numOfSimulations = 0;
        while (snailsInPasture > 0) {
            int index = rand.nextInt(corral.length);
            int count = 0;
            if (corral[index].getSwingDirection() == Gate.IN) {
                count = rand.nextInt(snailsInPasture)+1;
                snailsInPasture -= corral[index].thru(count);
            }
            else if (corral[index].getSwingDirection() == Gate.OUT) {
                count = rand.nextInt(5-snailsInPasture) + 1;
                snailsInPasture -= corral[index].thru(count);
            }
            mOut.println(count + " are trying to move through corral " + index);
            numOfSimulations++;
        }
        mOut.println("It took " + numOfSimulations + "attempts to corral all of the snails.");
        return numOfSimulations;
    }

}
