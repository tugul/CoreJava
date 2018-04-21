package varargs;

/**
 * Although Java treats varargs as array, there is a small difference when calling
 */
public class VarargVsArray {
    // Both can't be compiled together
    // compiler sees they have same signature
    static void fly(int[] params){ }
    static void fly(int... params){ }

    public static void main(String[] args) {
        // calls only one with Vararg
        fly(1, 2, 3);

        // can call any of above two
        fly(new int[] {1, 2, 3});
    }
}
