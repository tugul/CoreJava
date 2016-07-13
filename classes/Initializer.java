package classes;

/**
 *
 * Benefit of instance initializer is to initialize instance fields or do some calculation
 * and to avoid repeating them in constructors if there are many
 *
 * final static fields not initialized in declaration must be initialized in static initializer
 * final instance fields not initialized in declaration must be initialized in instance initializer or constructor
 *
 */
public class Initializer {
    static int one;
    // Final static fields
    static final int two;
    static final int three = 3;
    static final int four;  // DOES NOT COMPILE, final field not initialized even in static initializer

    static {
        one = 1;
        two = 2;
        three = 3;      // DOES NOT COMPILE, final field can't be reassigned
        two = 4;        // DOES NOT COMPILE, final field can't be reassigned
        ten = 10;       // DOES NOT COMPILE, instance member can't be accessed from static context
    }

    // Final instance fields
    final int eight;
    final int nine;
    final int ten;
    {
        one = 1;
        eight = 8;
        ten = 10;
        four = 4;
    }

    public Initializer() {
        nine = 9;
        ten = 10;       // DOES NOT COMPILE, final field can't be reassigned
    }
}
