package classes.nested;

/**
 * Inner class is non-static nested class defined in the same level as instance member of a top-level class
 * - can't have static members
 * - can access to all members of outer class (even privates)
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

    protected class InnerClass {
        String innerStr = "Inner";

        InnerClass(){}

        InnerClass(String innerStr) {
            this.innerStr = innerStr + "Str";
        }

        void printInnerStr(){
            System.out.println(innerStr);
        }
    }

    void printOuterStr(){
        System.out.println(outerStr);
    }

    void printInnerStr(){
        // Below 2 notations do same
        new InnerClass("Inner").printInnerStr();
        this.new InnerClass("Inner").printInnerStr();
    }

}

public class InnerClassExample {
    public static void main(String[] args) {
        OuterClass outerObj = new OuterClass();
        outerObj.printInnerStr();       // prints InnerStr twice

        OuterClass.InnerClass innerObj = outerObj.new InnerClass();
        innerObj.printInnerStr();       // prints Inner
    }
}
