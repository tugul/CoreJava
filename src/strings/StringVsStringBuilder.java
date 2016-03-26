package strings;

/**
 * String and StringBuilder's difference are highlighted
 * - Concatenation create new object in String, but not in StringBuilder
 * - String methods' return value must be used, otherwise new value is lost
 */
public class StringVsStringBuilder {
    public static void main(String[] args) {
        // 1.
        // Immutable class, create 27 new objects, garbage collector works busy to clean them
        // Mutable class, create only 1 object
        String str = "";
        for (char c='a'; c <= 'z'; c++)
            str += c;

        StringBuilder sb = new StringBuilder();
        for (char c='a'; c <= 'z'; c++)
            sb.append(c);

        // 2.
        // Immutable class method(i.e. concat) returns reference of newly concatenated
        // while Mutable class method(i.e. append) returns reference of the same object changed
        String a = "ab";
        a = a.concat("cd"); // abcd

        StringBuilder b = new StringBuilder("ab");
        b.append("cd");     // abcd
        b.append(true);
        b.append(5);
        b.append((String)null);
        b.append((StringBuilder)null);

        // Similarity is method chaining which can be done on both
        String st = " abc ".trim().toUpperCase().concat("D").substring(2);  // CD
        StringBuilder sbr = new StringBuilder().append("ABC").reverse();    // CBA
    }
}
