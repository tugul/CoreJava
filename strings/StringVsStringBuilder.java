package strings;

/**
 * String and StringBuilder's difference are highlighted
 * - Concatenation create new object in String, but not in StringBuilder
 * - String methods' return value must be used, otherwise new value is lost
 */
public class StringVsStringBuilder {
    public static void main(String[] args) {
        /////////////////////////////////////////////
        // Difference 1:
        /////////////////////////////////////////////

        // Immutable class, create 27 new objects, garbage collector works busy to clean them
        String str = "";
        for (char c='a'; c <= 'z'; c++)
            str += c;

        // Mutable class, create only 1 object
        StringBuilder sb = new StringBuilder();
        for (char c='a'; c <= 'z'; c++)
            sb.append(c);

        /////////////////////////////////////////////
        // Difference 2:
        /////////////////////////////////////////////

        // Immutable class method(i.e. concat) returns reference of newly concatenated
        String a = "ab";
        a = a.concat("cd"); // abcd

        // while Mutable class method(i.e. append) returns reference of the same object changed
        StringBuilder b = new StringBuilder("ab");
        b.append("cd");     // abcd
        b.append(true);     // abcdtrue
        b.append(5);        // abcdtrue5
        b.append((String)null);         // requires explicit cast
        b.append((StringBuilder)null);  // requires explicit cast
        // RESULT: abcdtrue5nullnull

        // Similarity is method chaining which can be done on both
        String st = " abc ".trim().toUpperCase().concat("D").substring(2);  // CD
        StringBuilder sbr = new StringBuilder().append("ABC").reverse();    // CBA
    }
}
