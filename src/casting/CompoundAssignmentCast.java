package casting;

/**
 * Compound assignment operator does implicit cast
 */
public class CompoundAssignmentCast {
    public static void main(String[] args) {
        long _long = 10;
        int _int = 10;
        short _short = 10;

        _int = _int + _long;    // DOES NOT COMPILE
        _int += _long;          // COMPILES

        _short = _short + 1;    // DOES NOT COMPILE
        _short += _long;        // COMPILES
        _short += _int;         // COMPILES
        _short ++;
    }
}
