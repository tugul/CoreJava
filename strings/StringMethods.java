package strings;

/**
 *
 * String substring(int startIndex)
 * String substring(int startIndex, int endIndex)
 *
 */
public class StringMethods {
    public static void main(String[] args) {

        // startIndex is always inclusive
        // 1. substring(int startIndex)                -> inclusive start index till end
        // 2. substring(int startIndex, int endIndex)  -> inclusive start till exclusive end
        String s = "hmm";
        System.out.println(s.substring(1, 2));  // prints just 'm'
        System.out.println(s.substring(1));     // prints 'mm'
        System.out.println(s.substring(1, 3));  // prints 'mm'
        System.out.println(s.substring(2, 1));  // Runtime exception : StringIndexOutOfBoundsException
        System.out.println(s.substring(1, 4));  // Runtime exception : StringIndexOutOfBoundsException

        // PS: substring on StringBuilder returns String, not StringBuilder object
    }
}
