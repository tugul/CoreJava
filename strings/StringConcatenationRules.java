package strings;

/**
 * String is immutable,
 * - Any concatenation creates new object and returns its reference
 * - Concatenation goes from LEFT to RIGHT
 * - If both operands are numeric, + means numeric addition. If either one is String, + means concatenation
 */
public class StringConcatenationRules {
    public static void main(String[] args) {
        // + concantenation
        String str = null;
        str += true;
        str += 5;
        str += " it ";
        str += null;
        System.out.println(str); // nulltrue5 it null

        // concantenation order: left to right
        String b = 10 + 5 + "years old";    // 15years old
        String c = true + "love";           // truelove
        String d = false + true + "live";   // DOES NOT COMPILE, + can't be applied to booleans
        String e = 4 + Math.PI;             // DOES NOT COMPILE, other than string can't assign


        // concat(String str)
        String a = "globe";
        a.concat(" time");      // doesn't change a, but create new object
        System.out.println(a);  // still 'globe'

        a.concat(5);            // DOES NOT COMPILE, takes only string parameter
    }
}
