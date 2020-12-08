package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Add operation.
 */
public class Add implements Calculation{

    @Override
    public String calculate(int first, int second) {
        return first + second + "";
    }
}
