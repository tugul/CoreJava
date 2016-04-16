package collections;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class Test {
    public static void main(String[] args) {
        List<Boolean> a = new ArrayList<>();
        a.add(true);
        a.add(true);
        System.out.println("Contains Wrapper:");
        System.out.println(a.contains(true));
        System.out.println(a.contains(new Boolean(true)));

        List<StringBuilder> b = new ArrayList<>();
        b.add(new StringBuilder(""));
        b.add(new StringBuilder("a"));

        System.out.println("Contains StringBuilder");
        System.out.println(b.contains(new StringBuilder("")));
        System.out.println(b.contains(new StringBuilder("a")));

        List<String> c = new ArrayList<>();
        c.add("a");
        c.add("b");
        String f = "a";

        System.out.println("Contains String:");
        System.out.println(c.contains("a"));
        System.out.println(c.contains(f));

        System.out.println("Equals Wrapper: ");
        System.out.println(new Boolean(false).equals(false));
        System.out.println(new Integer("10").equals(10));

        int j = 1;
        for (int i = 0; i < 4 && j < 3; i++) {
            ++j;
            System.out.print(i+j);
        }
    }
}
