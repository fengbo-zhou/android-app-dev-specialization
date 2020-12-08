package mooc.vandy.java4android.calculator.constants;

public enum Operators {
    ADD(1), SUB(2), MUL(3), DIV(4);

    final int val;
    Operators(int val) {
        this.val = val;
    }

    public int getVal() {
        return this.val;
    }
}
