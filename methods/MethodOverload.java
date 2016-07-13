package methods;

/**
 * - Method overload
 * When there are same named methods with different signature
 *
 * - Method signature
 * Parameter list and their order
 * But return type, access modifier, optional specifier or exception list are irrelevant
 *
 * - In case of autoboxing
 * Java call most specifically matching method. If can't find, it looks for next ONE level closer one
 * Generally, it follows below one of below step to match parameter:
 * : Exact match by parameter type
 * : Match with superclass type
 * : Convert to larger primitive type
 * : Convert to autoboxed type/Wrapper class
 * : Varargs
 */
public class MethodOverload {
    // Below are valid overloading of methods, except for last one
    public void run(int miles){}
    public void run(short miles){}
    public void run(long miles){}
    public boolean run(){ return true; }
    private void run(int mile, byte feet){ }
    private void run(byte feet, int mile){ }
    public void run(byte feet, int mile) throws Exception { } // DOES NOT COMPILE, exception list is irrelevant

    // Varargs
    void jump(int[] meter) {}
    void jump(int ... meter) {} // DOES NOT COMPILE, both accepts single int array

    // AutoBoxing
    static void fly(int miles) { System.out.println("10"); }
    static void fly(Integer miles) { System.out.println("30"); }
    static void fly(Long miles) { System.out.println("100"); }
    static void fly(Number miles) { System.out.println("600"); }
    static void fly(Object miles) { System.out.println("900"); }

    public static void main(String[] args) {
        fly(2);                 // 10  (int miles)
        fly(new Integer(1));    // 30  (Integer miles)
        fly(2L);                // 100 (Long miles) long --> Long
        fly(2f);                // 600 (Number miles) float --> Float (extends Number)
        fly("2");               // 900 (Object miles) String --> Object
        fly(true);              // 900 (Object miles) boolean --> Boolean (extends Object)
        fly(new int[]{});       // 900 (Object miles) Array --> Object
    }
}
