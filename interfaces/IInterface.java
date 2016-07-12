package interfaces;

/**
 * Interface is abstract type, so cannot instantiated
 * Always 'abstract' and public or default when not specified. Making it final/private/protected won't compile
 * Can be nested into another interface or class. Nested interface can have any access modifier
 * Must not have any initializer
 * Like a class, only one public interface is allowed in single file and must match with file name
 *
 * Fields
 * Its all fields are always 'public static final' (constant), so must be initialized
 *
 * Methods
 * All methods of interface are 'public', automatically.
 * All non-default and non-static methods are 'abstract'. Making them final/private/protected won't compile
 */
interface IAnotherInterface {
    int val = 5;   // public static final
    int getVal();  // public abstract
}

public abstract interface IInterface {
    public static final int val = 5;    // Compiler adds 'public static final'
    public abstract int getVal();       // Compiler adds 'public abstract'
}

