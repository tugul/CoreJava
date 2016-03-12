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
    }
}
