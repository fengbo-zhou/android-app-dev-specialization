package mooc.vandy.java4android.calculator.logic;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import mooc.vandy.java4android.calculator.constants.Operators;
import mooc.vandy.java4android.calculator.ui.ActivityInterface;

/**
 * Performs an operation selected by the user.
 */
public class Logic implements LogicInterface {
    /**
     * Reference to the Activity output.
     */
    protected ActivityInterface mOut;

    private Map<Integer, Calculation> ops;

    {
        ops = new HashMap<>();
        ops.put(Operators.ADD.getVal(), new Add());
        ops.put(Operators.SUB.getVal(), new Subtract());
        ops.put(Operators.MUL.getVal(), new Multiply());
        ops.put(Operators.DIV.getVal(), new Divide());
    }
    /**
     * Constructor initializes the field.
     */
    public Logic(ActivityInterface out) {
        mOut = out;
        
    }

    

    /**
     * Perform the operation on argumentOne and argumentTwo.
     */
    public void process(int argumentOne, int argumentTwo, int operation) {
        Calculation calculation = ops.get(operation);
        Log.v(this.getClass().getSimpleName(), (calculation == null) + "");
        if (calculation != null) {

            mOut.print(calculation.calculate(argumentOne, argumentTwo));
        }
    }
}
