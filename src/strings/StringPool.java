package strings;

/**
 * - JVM stores all unique string literals in string pool (to reuse same immutable objects)
 * - Strings not in string pool are garbage collected like any other object
 * -
 */
public class StringPool {
    public static void main(String[] args) {
        // Below same strings refers to one object in string pool
        String str1 = "Hello";
        String str2 = "Hello";

        // It tells don't use string pool, creates new object, though less efficient
        String str3 = new String("Hello");

        System.out.println(str1 == str2);   // true
        System.out.println(str1 == str3);   // false

    }
}
