package classes;

/**
 * Abstract class
 * - can't be instantiated, only to be subclassed
 * - Always public or default when a.m. is not specified. Making it final/private/protected won't compile
 * - can have abstract/non-abstract methods with any access modifiers
 * - can have non-static or non-final fields, unlike interface
 * - can implement interface without required implementation of its methods
 * - can be extended by another abstract class without implementation of its abstract methods
 *
 * Abstract method
 * - is declared with keyword abstract
 * - doesn't have a body
 * - exists only in abstract class
 * - can't be private or final
 *
 */

interface IFly {
    void fly();
}

abstract class Soul implements IFly{
    static int age;
    String name;

    private void sayMyName() { System.out.println("Soul"); }
    protected static void setAge(int age) { Soul.age = age; } // this.age -> wrong! 'this' is only for instance reference
    protected abstract void setMyName(String name);
}

public class AbstractClass extends Soul {

    public void fly(){ System.out.println(); }

    protected void setMyName(String name) { this.name = name; }

    public static void main(String[] args) {

    }
}
