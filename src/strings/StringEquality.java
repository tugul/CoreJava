package strings;

/**
 * == does reference check, equals() does value check for String. So later is safest to use
 * == or equals() does reference check for StringBuilder (because it doesn't override default behavior)
 */
public class StringEquality {
    public static void main(String[] args) {
        String a = "abc";
        String b =  "abc";
        String c = new String("abc");
        System.out.println(a == b); // true
        System.out.println(b == c); // false

        StringBuilder sb1 = new StringBuilder("abc");
        StringBuilder sb2 = new StringBuilder("abc");
        StringBuilder sb3 = sb1;
        System.out.println(sb1 == sb2); // false
        System.out.println(sb1 == sb3); // true
        System.out.println(sb1 == a);   // DOES NOT COMPILE, mismatch types (String, StringBuilder)

        StringBuilder sb4 = sb1.append("def");
        sb4.append("xyz");
        System.out.println(sb1 == sb4); // true, both refer to same object
        System.out.println(sb1);    // abcdefxyz
        System.out.println(sb4);    // abcdefxyz

        // == operator on String checks object reference
        String world = " World";
        String helloWorld = "Hello World";

        System.out.println("Hello World" == helloWorld);            // true, both from string pool
        System.out.println("Hello World" == "Hello" + " World");    // true, calculated at compile (taken from string pool)
        System.out.println("Hello World" == "Hello" + world);       // false, concat. creates new object in runtime
        System.out.println("Hello World" == "Hello World".trim());  // true, trim does no change, remain same object
        System.out.println("Hello World" == helloWorld.trim());     // true, trim does no change, remain same object
        System.out.println("Hello World" == " Hello World".trim()); // false, trim changes and returns new object
        System.out.println("Hello World" == " Hello World".trim().intern());  // true, intern takes from string pool
    }
}
