package interfaces;

/**
 * As introduced in Java 8, a method in interface can have a body and is called default method.
 * - Keyword 'default' used before return type
 * - Default method may only be declared in interface, not any class
 * - Method marked default must have body/implementation
 * - Like other interface method, it is assumed to be public
 * - Marking it abstract, static or final lead to compilation error
 * - Optional to override default method in implementing class
 */
interface ICan {
    int field = 10;     // must initialized, automatically public final static

    void implementIt(); // automatically public abstract
    default void doIt() { System.out.println("Just do it!"); }
}

public class DefaultMethod implements ICan {
    public void implementIt() { System.out.println("Implemented it"); }

    public static void main(String[] args) {
        System.out.println(field);                      // 10
        System.out.println(ICan.field);                 // 10
        System.out.println(DefaultMethod.field);        // 10
        System.out.println(new DefaultMethod().field);  // 10

        new DefaultMethod().doIt();         // default implementation executed
        new DefaultMethod().implementIt();  // overridden implementation executed
    }
}
