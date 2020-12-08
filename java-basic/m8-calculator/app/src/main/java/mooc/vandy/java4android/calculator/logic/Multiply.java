package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Multiply operation.
 */
public class Multiply implements Calculation{

    @Override
    public String calculate(int first, int second) {
        return first * second + "";
    }
}
