package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Bounded wildcard, we can limit the anonymity through inheritance:
 * Keywords 'extends' and 'super' don't distinguish class or interface, scenarios like
 * class/interface extension or interface implementation
 *
 * ? extends T  : T is upper bound, covers any child of T
 * ? super T    : T is lower bound, covers any parent of T
 *
 * Note: Without bounded wildcard, types must match literally regardless of polymorphic relation
 */
class A {}
class B extends A {}
class C extends B {}
class D extends C {}

public class BoundedWildcard {

    // List of objects of Child class of Number can't be accepted, only Number objects
    public static void genericMethod(List<Number> numbers) {}

    // Bounded wildcard ? can overcome this problem, any child classes' object can pass
    public static void genericMethodBounded(List<? extends Number> numbers) {}

    public static void main(String[] args) {
        genericMethod(new ArrayList<Number>() {});
        genericMethod(new ArrayList<Integer>() {});        // DOES NOT COMPILE
        genericMethodBounded(new ArrayList<Integer>() {});

        List<Number> numbers1 = new ArrayList<Integer>();  // DOES NOT COMPILE
        List<? extends Number> numbers2 = new ArrayList<Integer>();
        numbers2.add(new Integer(4));                      // DOES NOT COMPILE, can't change in case of upper bound

        List<Integer> integers1 = new ArrayList<Number>(); // DOES NOT COMPILE, must match
        List<? super Integer> integers2 = new ArrayList<Number>();
        List<? super Integer> integers3 = new ArrayList<Object>();
        integers3.add(new Integer(4));
        integers3.add(new Object());                       // DOES NOT COMPILE, not the only possible type

        // Upper bound
        // can't add/remove/change collection except for add(null), clear() and get the iterator
        List<? extends B> a = new ArrayList<B>();
        a.add(new A());     // DOES NOT COMPILE
        a.add(new B());     // DOES NOT COMPILE
        a.add(new C());     // DOES NOT COMPILE
        a.add(new D());     // DOES NOT COMPILE
        a.add(null);

        // Lower bound
        // Contrary to upper bound, can add instance of lower bound type and its subtypes
        List<? super C> b = new ArrayList<C>();
        b.add(new A());     // DOES NOT COMPILE
        b.add(new B());     // DOES NOT COMPILE
        b.add(new C());
        b.add(new D());
        b.add(null);
    }
}
