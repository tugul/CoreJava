package strings;

/**
 * Quick facts:
 * - StringBuilder is mutable while String is immutable
 * - Capacity/size are same for String, but they can be different in StringBuilder object
 * - Unless capacity is given, StringBuilder create object with capacity of 16 empty elements (plus string size if string param is given)
 * - String, StringBuilder both have length() method
 */
public class StringBuilderCapacity {
    public static void main(String[] args) {
        StringBuilder a = new StringBuilder("abc"); // 16 + 3
        StringBuilder b = new StringBuilder(50);    // 50
        StringBuilder c = new StringBuilder();      // 16
        a.append("def");

        System.out.println(a);
        System.out.println("Capacity a: " + a.capacity());  // default(16) + abc(3) = 19
        System.out.println("Length a: " + a.length());      // abcdefg = 6
        System.out.println("Capacity b: " + b.capacity());  // given size 50
        System.out.println("Length b: " + b.length());      // empty content
        System.out.println("Capacity c: " + c.capacity());  // default is 16, empty means capacity is 16
        System.out.println("Length c: " + c.length());      // empty content

/*
        Below is output

        Capacity a: 19
        Length a: 6
        Capacity b: 50
        Length b: 0
        Capacity c: 16
        Length c: 0
*/
    }
}
