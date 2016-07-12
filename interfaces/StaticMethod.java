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
    static void sayMyName() { System.out.println("Interface One"); }
}

interface IHaveStatic2 {
    static void sayMyName() { System.out.println("Interface Two"); }
}

public class StaticMethod implements IHaveStatic1, IHaveStatic2 {
    public static void main(String[] args) {
        // No conflict of two methods with same signature
        // because they only belong to their own interfaces
        IHaveStatic1.sayMyName();   // Interface One
        IHaveStatic2.sayMyName();   // Interface Two
    }
}
