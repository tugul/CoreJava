package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Generic types not declared in class must be declared in method declaration
 * - Multiple types can be allowed
 * - Any letter allowed upper or lower
 * - Generic type declared in class can not be used in static method or field
 * but of course, static method can define generic type in its own level
 */
public class GenericMethod <G> {
    public <X> boolean containsAll(Collection<X> c) { return true; }

    // second type(S) must be declared, either in the same method or in class declaration
    public <S, T, F extends S> T checkStat(T child){ return (T)child; }
    public <K, A> void genericMethod1() {}
    public        void genericMethod2(G g) {}
    public static void genericMethod3(G g) {}   // DOES NOT COMPILE
    public static G garag;                      // DOES NOT COMPILE, generic type can't be used in static context

    public static <Q> void fillMe(List<Q> list, Q value) {
        for (int i = 0; i < list.size(); i++)
            list.set(i, value);
    }

    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            ints.add(0);

        fillMe(ints, new Integer("900"));
        for (Integer each : ints)
            System.out.println(each);

        // Optional syntax for specifying types in generic method call
        GenericMethod gm = new GenericMethod();
        gm.checkStat("string");
        gm.<Number, String, Integer>checkStat("string"); // specifying types on method call
        gm.<String>checkStat("string");      // DOES NOT COMPILE, requires 3 generic types

        gm.containsAll(new ArrayList<>());
        gm.<String>containsAll(new ArrayList<>());
        gm.<List>containsAll(new ArrayList<>());

        gm.genericMethod1();
        gm.<String, Double>genericMethod1();

        gm.genericMethod2(new Object());
        gm.<Object>genericMethod2(new Object());
    }
}
