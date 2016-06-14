package classes.nested;

import java.io.Serializable;

/**
 * Inner class:
 * - non-static nested class defined in the same level as instance member of a top-level class
 * - can't have static members
 * - can access to all members of outer class (even privates) using <outer class name>.this.<member name>
 * - can extend any class or implement interfaces
 * - can be final or abstract
 * - can have any possible access modifier
 * - can be accessed only through instance of outer class from outside of outer class
 *
 * Usage:
 * - need to logically group classes used in one place
 * - empowers encapsulation and provides more maintainable code
 */
class OuterClass {
    private String outerStr = "OuterStr";

    private abstract class InnerAbstractClass {}

    protected class InnerClass extends InnerAbstractClass implements Serializable {
        String innerStr = "Inner";

        InnerClass(){}

        InnerClass(String innerStr) {
            this.innerStr = innerStr + " - Str";
        }

        void printInnerStr(){
            System.out.println(innerStr);
        }

        // Access to outer class's field
        void printOuterStr(){
            System.out.println(innerStr + " - " + OuterClass.this.outerStr);
        }

        // Access to outer class's method
        void callPrintOuterStr(){
            System.out.print(innerStr + " - ");
            OuterClass.this.printOuterStr();
        }
    }

    void printOuterStr(){
        System.out.println(outerStr);
    }

    void printInnerStr(){
        // Below 2 notations do same
        new InnerClass("Inner1").printInnerStr();
        this.new InnerClass("Inner2").printInnerStr();
        this.new InnerClass("Inner3").printOuterStr();
        this.new InnerClass("Inner4").callPrintOuterStr();
    }

}

public class InnerClassExample {
    public static void main(String[] args) {
        OuterClass outerObj = new OuterClass();
        outerObj.printInnerStr();

        OuterClass.InnerClass innerObj = outerObj.new InnerClass();
        innerObj.printInnerStr();       // prints Inner
    }
}

/* Output if the program:

Inner1 - Str
Inner2 - Str
Inner3 - Str - OuterStr
Inner4 - Str - OuterStr
Inner

*/
