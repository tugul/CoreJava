package inheritance;

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
    void implementIt();

    default void doIt() {
        System.out.println("Just do it!");
    }
}

public class DefaultMethod implements ICan {
    public void implementIt() { System.out.println("Implemented it"); }

    public static void main(String[] args) {
        new DefaultMethod().doIt();         // Just do it!
        new DefaultMethod().implementIt();  // Implemented it
    }
}
