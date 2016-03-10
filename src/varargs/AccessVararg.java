package varargs;

/**
 * Accessing to varargs, same like array index
 */
public class AccessVararg {
    public static void doIt(int ... nums){
        System.out.println(nums[1]);
    }

    public static void main(String[] args) {
        // Prints 5
        doIt(4,5,6);
    }
}
