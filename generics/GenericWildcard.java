package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Wildcard (?) can be used to access any type, but can't change value of it.
 *
 * refer: https://docs.oracle.com/javase/tutorial/extra/generics/wildcards.html
 */
public class GenericWildcard {

    public static void printCollection1(Collection<Object> col) {
        for (Object o : col)
            System.out.println(o);

        col.add(new Object());
    }

    // Collection of unknown (?) that matches anything
    public static void printCollection2(Collection<?> col) {
        // We can access ? by casting to Object as all objects are of Object type
        for (Object o : col)
            System.out.println(o);

        // but LIMITATION. It can't change or add anything due to unknown type
        col.add(new Object());     // DOES NOT COMPILE
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(35);

        printCollection1(list); // DOES NOT COMPILE, accepts collection of only Object
        printCollection2(list); // COMPILE, accepts collection of anything
    }
}
