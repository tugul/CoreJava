package casting;

/**
 * Any integral numbers are deemed as int
 * Any floating-points are deemed as double
 */
public class NumericLaterals {
    public static void main(String[] args) {
        long _long1 = 121;
        long _long2 = 3234234234;    // DOES NOT COMPILE, too large for int lateral
        long _long3 = 3234234234L;   // COMPILES

        float _float1 = 10.5;    // DOES NOT COMPILE, double to float
        float _float2 = 10.5f;   // COMPILES

        int _int1 = 55f;            // DOES NOT COMPILE, float to int
        int _int2 = 55L;            // DOES NOT COMPILE, long to int
        int _int3 = (int)55f;       // COMPILES
        int _int4 = (int)55L;       // COMPILES

        short _short1 = 83232;      // DOES NOT COMPILE, int to short
        short _short2 = (short)83223; // COMPILES, explicit cast required

        // Binary integer
        int a1 = 0B1011;
        int a2 = 0B2011;    // DOES NOT COMPILE, binary number digits must be 0 or 1
        int a3 = 0B111111111111111111111111111111111111111111111100000; // DOES NOT COMPILE, Integer number too large
        int a4 = (int)0B111111111111111111111111111111111111111111111100000L;   // Add L mark and cast explicitly
        long b1 = 0B111111111111111111111111111111111111111111111100000L;

        // Octal integer
        int c1 = 08;                // DOES NOT COMPILE, octal number digits must be between 0-7
        int c2 = 0761276125422121;  // DOES NOT COMPILE, Integer number too large
        long d1 = 0761276125422121L;
    }
}
