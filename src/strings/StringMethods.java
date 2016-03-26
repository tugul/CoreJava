package strings;

/**
 *
 * String substring(int start)
 * String substring(int start, int end) - startindex is inclusive, endindex is exclusive
 *
 */
public class StringMethods {
    public static void main(String[] args) {

        // substring
        // startIndex is always inclusive
        // substring(int start)          -> inclusive start index till end
        // substring(int start, int end) -> inclusive start till exclusive end
        String s = "hmm";
        System.out.println(s.substring(1, 2));  // prints just 'm'
        System.out.println(s.substring(1));     // prints 'mm'
        System.out.println(s.substring(1, 3));  // prints 'mm'
        System.out.println(s.substring(1, 4));  // Runtime exception : StringIndexOutOfBoundsException

        // PS: substring on StringBuilder returns String, not StringBuilder object
    }
}
