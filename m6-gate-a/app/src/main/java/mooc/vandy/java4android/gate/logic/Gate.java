package mooc.vandy.java4android.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {

    public static final int IN = 1;
    public static final int OUT = -1;
    public static final int CLOSED = 0;
    private int mSwing;

    public Gate(){
        mSwing = 0;
    }

    public boolean setSwing(int direction) {
        if (direction == IN) {
            mSwing = IN;
        }
        else if (direction == OUT) {
            mSwing = OUT;
        }
        else if (direction == CLOSED) {
            mSwing = CLOSED;
        }
        else {
            return false;
        }
        return true;
    }
    public int getSwingDirection() {
        return mSwing;
    }

    public boolean open(int direction) {
        if (direction == CLOSED) return false;
        return setSwing(direction);
    }

    public void close() {
        setSwing(CLOSED);
    }

    public int thru(int count) {
        return mSwing * count;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (mSwing != IN && mSwing != OUT && mSwing != CLOSED) {
            return "This gate has an invalid swing direction";
        }
        sb.append("This gate is ");
        if (mSwing == IN || mSwing == OUT) {
            sb.append("open and swings to " + (mSwing == IN ? "enter " : "exit ") + "the pen only");
        }
        else {
            sb.append("closed");
        }
        return sb.toString();
    }
}
