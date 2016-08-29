package classes.nested;

/**
 * - Anonymous inner class / Anonymous class
 * Is defined in a method and doesn't have name 
 * Either implements interface or extends class (abstract and concrete)
 * Can't have constructor, static members or static initializer
 * Can have instance initializer, local classes, new instance methods or fields, but not accessible from outside
 *
 * Usage:
 * - When no need to create separate class for implementing interface because it will be used only once
 * - Mainly for interface implementation to be used locally in a method
 */

interface A {
    void printMyName();
}

abstract class B {
    abstract void sayHi();

    void printMyName(){
        System.out.println("My name: abstract B");
    }
}

class C {
    void printMyName() {
        System.out.println("My name: C");
    }
}

public class AnonymousInnerClass {
    public static void main(String[] args) {
    	String myName = "My name: ";	// effectively final field
    	String hi = "Hi ";
    	hi = "Hello ";					// re-assigned, so no longer effectively final
    	
        // Anonymous class implementing interface
        A a = new A() {
            public void printMyName(){
                System.out.println(myName + "A"); 
            }
            void sayHi(){
                System.out.println(hi + "A");	// DOES NOT COMPILE, can access only to effectively final fields
            }
        };
        a.printMyName();    // My name: A
        a.sayHi();          // DOES NOT COMPILE, interface A doesn't define this method

        // Anonymous class extending abstract class
        B b = new B() {
            int value;
            static String name; // DOES NOT COMPILE, non-static type can't have static member
            public void printMyName(){
                System.out.println("My name: concrete B");
            }

            public void sayHi(){
                System.out.println("Hi B");
            }
        };
        b.printMyName();    // My name: concrete B
        b.sayHi();          // Hi B
        System.out.println(b.value);    // DOES NOT COMPILE, class B doesn't define this field

        // Extending a concrete class
        C c = new C(){
            void printMyName() {
                System.out.println("Hello C");
            }

            public void sayHi(){
                System.out.println("Hi C");
            }
        };
        c.printMyName();    // Hello C
        c.sayHi();          // DOES NOT COMPILE, class C doesn't define this method
    }
}
