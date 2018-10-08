package interfaces;

/**
 * Static method of interface
 * - Declared with static keyword
 * - Must have a body
 * - Assumed public
 * - Hidden from/not inherited to implementing classes
 * - Reference to the interface name must be used to use
 */
interface IHaveStatic1 {
    String name = "Interface One"
    static void sayMyName() { System.out.println(name); }
}

interface IHaveStatic2 {
    String name = "Interface Two"
    static void sayMyName() { System.out.println(name); }
}

public class StaticMethod implements IHaveStatic1, IHaveStatic2 {
    public static void main(String[] args) {
        // No conflict of two methods with same signature
        // because they only belong to their own interfaces
        IHaveStatic1.sayMyName();   // Interface One
        IHaveStatic2.sayMyName();   // Interface Two
    }
}
