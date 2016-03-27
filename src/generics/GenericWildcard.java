package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Wildcard (?) can be used to access any type
 * but can't change value of it.
 * With bounded wildcard, we can go over mismatching types of inherited class:
 *
 * refer: https://docs.oracle.com/javase/tutorial/extra/generics/wildcards.html
 */
public class GenericWildcard {

    public void printCollection1(Collection<Object> col) {
        for (Object o : col)
            System.out.println(o);
    }

    // Collection of unknown (?) that matches anything
    public void printCollection2(Collection<?> col) {
        // We can access ? by casting to Object as all objects are of Object type
        for (Object o : col)
            System.out.println(o);

        // but can't change or add anything due to unknown type
        col.add(new Object());     // DOES NOT COMPILE
    }

    // List of objects of Child class of Number can't be accepted, only Number objects
    public static void genericMethod01 (List<Number> numbers) {}
    // Bounded wildcard ? can overcome this problem, any child classes' object can pass
    public static void genericMethod02 (List<? extends Number> numbers) {}

    public static void main(String[] args) {
        genericMethod01(new ArrayList<Number>() {});
        genericMethod01(new ArrayList<Integer>() {});  // DOES NOT COMPILE
        genericMethod02(new ArrayList<Integer>() {});  // COMPILES

        List<Number>           numbers1 = new ArrayList<Integer>();  // DOES NOT COMPILE
        List<? extends Number> numbers2 = new ArrayList<Integer>();  // COMPILES

        List<Integer>         integers1 = new ArrayList<Number>();  // DOES NOT COMPILE
        List<? super Integer> integers2 = new ArrayList<Number>();  // COMPILES
    }
}
