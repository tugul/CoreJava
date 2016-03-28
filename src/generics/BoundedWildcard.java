package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Bounded wildcard, we can limit the anonymity through inheritance:
 */
public class BoundedWildcard {

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
        numbers2.add(new Integer(4));                                // DOES NOT COMPILE, can't change value

        List<Integer>         integers1 = new ArrayList<Number>();  // DOES NOT COMPILE
        List<? super Integer> integers2 = new ArrayList<Number>();  // COMPILES
        List<? super Integer> integers3 = new ArrayList<Object>();  // COMPILES
        integers3.add(new Integer(4));                              // COMPILES, the lowest possible type
        integers3.add(new Object());                                // DOES NOT COMPILE, not the only possible type

    }
}
