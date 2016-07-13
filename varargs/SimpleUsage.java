package varargs;

/**
 * Vararg example
 * Must be only one in parameter list
 * Must be only last one
 */
public class SimpleUsage {

    public void walk1(int... nums) { }
    public void walk2(int start, int... nums) { }

    // DOES NOT COMPILE
    //public void walk3(int... nums, int start) { }

    // DOES NOT COMPILE
    //public void walk4(int... start, int... nums) { }

}
