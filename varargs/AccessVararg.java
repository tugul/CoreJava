package varargs;

/**
 * Like an array, accessing to varargs goes with index
 */
public class AccessVararg {
    static void doIt(int ... nums){
        System.out.println(nums[1]);
    }

    public static void main(String[] args) {
        doIt(4,5,6); // Prints 5
    }
}
