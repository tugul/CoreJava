package casting;

/**
 * - If two values are of different types, Java promotes them  to larger type.
 * - If one is integral and other is floating-point, Java promotes to the floating-point type
 * - Small data types (short, byte, char) are first promoted to int anytime they are used.
 * (except for unary operators, i.e. ++short => short)
 * - After all promotion(all become same type), resulting value will be as of the promoted data type
 */
public class NumericPromotionRule {
    public static void main(String[] args) {
        int _int = 10;
        byte _byte = 15;
        short _short = 20;

        byte _byteTwo = _int +_byte;        // DOES NOT COMPILE
        short _shortTwo = _short + _byte;   // DOES NOT COMPILE
        int _intTwo = _int + _byte;         // COMPILES

        float _float = 10;
        double _double = 10;
        _float = _float + _int;
        _float = _double + _float;          // DOES NOT COMPILE
    }
}
