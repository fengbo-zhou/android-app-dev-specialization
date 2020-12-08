package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Subtract operation.
 */
public class Subtract implements Calculation{

    @Override
    public String calculate(int first, int second) {
        return first-second + "";
    }
}
