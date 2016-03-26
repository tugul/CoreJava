package strings;

/**
 * - StringBuilderCapacity is mutable while String is immutable
 * - Capacity/size are same for String, but they can be different in StringBuilderCapacity object
 * - Unless capacity is given, StringBuilder create object with capacity of 16 empty elements (plus given string param)
 */
public class StringBuilderCapacity {
    public static void main(String[] args) {
        StringBuilder a = new StringBuilder("abc"); // 16 + 3
        StringBuilder b = new StringBuilder(50);    // 50
        StringBuilder c = new StringBuilder();      // 16
        a.append("defg");

        System.out.println(a);
        System.out.println("Length: " + a.length());        // abcdefg = 7
        System.out.println("Capacity a: " + a.capacity());  // default(16)  abc(3) = 19
        System.out.println("Capacity b: " + b.capacity());  // given size 50
        System.out.println("Capacity c: " + c.capacity());  // default(16)  empty = 16

        // String, StringBuilder both have length() method

/*
        Below is output

        abcdefg
        Length: 7
        Capacity a: 19
        Capacity b: 50
        Capacity c: 16
*/
    }

}
