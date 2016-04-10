package casting;

/**
 * Any integral numbers are deemed as int
 * Any floating-points are deemed as double
 *
 * boolean  - 1 bit
 * char     - 8 bit
 * byte     - 8 bit
 * short    - 16 bit
 * int      - 32 bit
 * long     - 64 bit
 *
 * float    - 32 bit
 * double   - 64 bit
 *
 */
public class NumericLaterals {
    public static void main(String[] args) {
        long _long1 = 121;
        long _long2 = 3234234234;    // DOES NOT COMPILE, too large for int lateral
        long _long3 = 3234234234L;   // COMPILES

        float _float1 = 10.5;    // DOES NOT COMPILE, implicit double to float
        float _float2 = 10.5d;   // DOES NOT COMPILE, explicit double to float
        float _float3 = 10.5f;   // COMPILES

        int _int1 = 55f;            // DOES NOT COMPILE, float to int
        int _int2 = 55L;            // DOES NOT COMPILE, long to int
        int _int3 = (int)55f;       // COMPILES
        int _int4 = (int)55L;       // COMPILES

        byte _byte1 = 15;
        byte _byte2 = Byte.MAX_VALUE;       // 127
        byte _byte3 = Byte.MAX_VALUE+1;     // Over limit of byte

        short _short1 = 832;        // COMPILES, under short range, Short.MAX_VALUE = 32767
        short _short2 = 83232;      // DOES NOT COMPILE, int lateral over limit of short
        short _short3 = (short)83223; // COMPILES, explicit cast required

        int i = 100;
        float f = i;
        i = (int)f;         // Float to int requires explicit cast, but not int to float

        long l = 100;
        double d = l;
        l = (long)d;        // Double to long requires explicit cast, but not long to double

        // Binary integer, 0B......
        int a1 = 0B1011;
        int a2 = 0B2011;    // DOES NOT COMPILE, binary number digits must be 0 or 1
        int a3 = 0B111111111111111111111111111111111111111111111100000; // DOES NOT COMPILE, literal is too large for int
        int a4 = (int)0B111111111111111111111111111111111111111111111100000L;   // Add L mark and cast explicitly
        long b1 = 0B111111111111111111111111111111111111111111111100000; // DOES NOT COMPILE, literal is too large for int
        long b2 = 0B111111111111111111111111111111111111111111111100000L;// Add L mark

        // Octal integer, 0....
        int c1 = 08;                // DOES NOT COMPILE, octal number digits must be between 0-7
        int c2 = 0761276125422121;  // DOES NOT COMPILE, literal is too large for int
        long d1 = 0761276125422121; // DOES NOT COMPILE, literal is too large for int
        long d2 = 0761276125422121L;// Add L mark

        // Hexadecimal 0X....
        byte bt1 = 0xa;
        byte bt2 = 0xaB;            // DOES NOT COMPILE, literal is over byte limit
        byte bt3 = (byte)0xaB;      // explicitly cast to byte
        short s1 = 0xaB;            // can fit in short
        long lg1 = 0xabcdef123;     // DOES NOT COMPILE, literal is too large for int
        long lg2 = 0xabcdef123L;    // Add L mark
    }
}
