package mooc.vandy.java4android.diamonds.logic;

import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
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
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {
        // TODO -- add your code here
        int len = size * 2;
        mOut.println(head(len));
        int mid = (len-2) / 2;
        for (int i = 0; i <= len - 2; i++) {
            char c = i % 2 == 0 ? '=' : '-';
            String res;
            if (i < mid) {
                res = top(len, i, c);
            }
            else if (i == mid) {
                res = middle(len, c);
            }
            else {
                res = bottom(len, 2 * mid - i, c);
            }
            mOut.println(res);
        }
        mOut.println(head(len));
    }

    private String head(int len) {
        StringBuilder sb = new StringBuilder();
        sb.append("+");
        for (int i = 0; i < len; i++) {
            sb.append("-");
        }
        sb.append("+");
        return sb.toString();
    }

    private String top(int len, int count, char pic) {
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        int left = len / 2 -1, right = left+1;
        left -= count; right += count;
        for (int i = 0; i < len; i++) {
            if (i == left) {
                sb.append("/");
                while (++i < right) {
                    sb.append(pic);
                }
                sb.append('\\');
            }
            else {
                sb.append(" ");
            }
        }
        sb.append("|");
        return sb.toString();
    }

    private String middle(int len, char pic) {
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        sb.append("<");
        for (int i = 0; i < len-2; i++) {
            sb.append(pic);
        }
        sb.append(">");
        sb.append("|");
        return sb.toString();
    }

    private String bottom(int len, int count, char pic) {
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        int left = len / 2 -1, right = left+1;
        left -= count; right += count;
        for (int i = 0; i < len; i++) {
            if (i == left) {
                sb.append("\\");
                while (++i < right) {
                    sb.append(pic);
                }
                sb.append('/');
            }
            else {
                sb.append(" ");
            }
        }
        sb.append("|");
        return sb.toString();
    }

}
