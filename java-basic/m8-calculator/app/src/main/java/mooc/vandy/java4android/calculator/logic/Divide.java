package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Divide operation.
 */
public class Divide implements Calculation{


    @Override
    public String calculate(int first, int second) {
        return second == 0 ? "error! attempting divide by zero" : first / second + " R: "  + (first % second);
    }
}
