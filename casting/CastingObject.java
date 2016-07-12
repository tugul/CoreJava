package casting;

/**
 * Casting Objects
 * - Casting object to superclass doesn't require explicit cast
 * - Casting object to subclass requires explicit cast
 *
 * - Type of object indicates what methods/fields exist within that object in memory 
 * - Type of reference to object indicates what methods/fields are accessible to Java application
 * 
 * Compiler can't allow casting between unrelated class,
 * It only allows related class, but not smart enough to identify actual instance
 */

class A { }

class B extends A { }

class C{ }

interface D {}

public class CastingObject {
    public static void main(String[] args) {
        A a1 = new A();
        B b1 = (B)a1;     // Compiler allows as they are related, But runtime throws java.lang.ClassCastException

        if (a1 instanceof B)    // It is safe to check if actual instance is of B
            b1 = (B)a1;

        A a2 = new B();
        B b2 = (B)a2;     // a2 refers to object of B class, so can reclaim

        C c1 = (C)a2;     // DOES NOT COMPILE, compiler knows they are unrelated
        D d1 = (D)b1;     // COMPILES bc compiler can't validate interface type casting,
                          // but if class B is final, compiler can tell it is inconvertable type
    }
}
