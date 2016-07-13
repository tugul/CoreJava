package varargs;

/**
 * Although Java treats varargs as array, there is a small difference when calling:
 */
public class VarargVsArray {
    // Both method can't compiled together
    static void fly(int[] params){ }
    static void fly(int... params){ }

    public static void main(String[] args) {
        // calls Vararg
        fly(1, 2, 3);

        // can call both
        fly(new int[] {1, 2, 2});
    }
}
