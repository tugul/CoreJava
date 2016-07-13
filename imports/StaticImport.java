package imports;

/**
 * Static import is to import static member of class.
 * Like regular import, can use wildcard or import a specific member
 *
 * Useful when using a lot of constants in another class.
 * But overusing it in large program makes difficult to recognize from where every static member comes
 */

import java.util.*;
import static java.util.Arrays.asList;

import static java.time.Month.*;
import static java.time.Month.APRIL;

public class StaticImport {
    public static void main(String[] args) {
        List<String> list1 = asList("one", "two");
        List<String> list2 = Arrays.asList("one", "two");

        System.out.println(APRIL);
        System.out.println(MAY);
    }
}
