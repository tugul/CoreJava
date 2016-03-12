package strings;

/**
 * == or equals do value check for String
 * == or equals do reference check for StringBuilder (because it doesn't override default behavour)
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

        StringBuilder sb4 = sb1.append("def");
        sb4.append("xyz");
        System.out.println(sb1 == sb4); // true, both refer to same object
        System.out.println(sb1);    // abcdefxyz
        System.out.println(sb4);    // abcdefxyz
    }
}
