package inheritance;

/**
 *
 * In scenario where a class implementing or interface extending two interfaces which have same methods:
 * 1. Static methods with same signature won't conflict
 * 2. Default methods with same signature will conflict. Resolution is to override the method
 *
 */

interface IGo {
    default int doIt() { return 0; }
    static int goFor() { return 0; }
}

interface IDo {
    default int doIt() { return 1; }
    static int goFor() { return 0; }
}

interface IGoDo1 extends IGo, IDo {
    // DOES NOT COMPILE, default methods conflict
    // static methods don't conflict
}

interface IGoDo2 extends IGo, IDo {
    // Resolution is to override conflicting default method
    default int doIt() { return 2; }
}

public class ConflictingMethods {
    public static void main(String[] args) {

    }
}
