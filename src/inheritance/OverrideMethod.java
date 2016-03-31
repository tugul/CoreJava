package inheritance;

/**
 * Method overriding rule
 * - Overriding method must have same signature as method in parent class
 * - Overriding method must be same or more accessible than method in parent class
 * - Overriding method must not throw new or broader checked exception than exceptions thrown in parent method
 * - If method returns value, it must be same or subclass of that type returned in parent class
 *
 * For static method, it is called hiding method
 *  - Static method must remain static when overridden, same for non-static methods
 *
 * Calling Overridden method follows what object is called on
 * Calling Hidden method follows what reference is called on
 *
 * For class fields, it same as static method, they are hidden
 *
 */
class A {
    static void staticMethod() {
        System.out.println("Static method in A");
    }
    void instanceMethod(){
        System.out.println("Instance method in A");
    }
    private int getIntValue() {
        return 0;
    }
}

class B extends A {
    // It is hiding parent method
    static void staticMethod(){
        System.out.println("Static method in B");
    }

    // It is overriding
    void instanceMethod() {
        System.out.println("Instance method in B");
    }

    // It is overriding
    int getIntValue(){
        return 1;
    }
}

public class OverrideMethod {
    public static void main(String[] args) {
        A a = new B();
        a.instanceMethod();     // Instance method in B
        a.staticMethod();       // Static method in A

        new B().instanceMethod();                   // Instance method in B
        new B().staticMethod();                     // Static method in B
        System.out.println(new B().getIntValue());  // 1

        new A().instanceMethod();                   // Instance method in A
        new A().staticMethod();                     // Static method in A
        //System.out.println(new A().getIntValue());  // DOES NOT COMPILE, inaccessible as it is private
    }
}
