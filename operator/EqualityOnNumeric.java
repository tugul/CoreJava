package operator;

/**
 * Equality on Wrapper classes and primitives
 * == operator not allowed to compare different types, even they are related class
 * For example, wrapper classes' object
 * == does reference check
 *
 * equals(Object o) takes any object or primitive as argument. But it checks
 * - first reference check
 * - value check
 */
public class EqualityOnNumeric {
    public static void main(String[] args) {
        Integer a = new Integer(10);
        Integer b = new Integer("10");
        int c = 10;
        long l = 10;

        System.out.println(a == b);         // false, different reference
        System.out.println(a.equals(b));    // true, same value
        System.out.println(a == c);         // true, a is un-boxed to int
        System.out.println(a.equals(c));    // true, c is autoboxed to Integer

        Double d = new Double(10);
        Double e = new Double(10.);
        Double f = new Double(10.0);
        double g = 10.000;

        System.out.println(d.equals(e));    // true
        System.out.println(d == f);         // false
        System.out.println(d == g);         // true

        // Compare different wrapper classes' object
        System.out.println(a == d);         // DOES NOT COMPILE, different types
        System.out.println(a.equals(d));    // false

        System.out.println("Numeric promotion rule applies in below: ");
        System.out.println(a == g);         // true, int promoted to double and they have same value
        System.out.println(a == 10f);       // true, int and float are promoted to double
        System.out.println(a == 10d);       // true, int promoted to double
        System.out.println(a == l);         // true, int promoted to long
        System.out.println(a == 10l);       // true, int promoted to long
    }
}
