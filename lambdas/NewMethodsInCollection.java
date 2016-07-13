package lambdas;

import java.util.ArrayList;
import java.util.List;

/**
 * - Java 8's some of new API in collection
 *
 * removeIf(Predicate<? super E> filter)
 * replaceAll(UnaryOperator<E> operator)
 * forEach(Consumer<? super T> action)
 *
 */
public class NewMethodsInCollection {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("AA");
        list.add("AB");
        list.add("AC");
        System.out.println(list);   // [AA, AB, AC]

        // removeIf
        list.removeIf(x -> x.endsWith("C"));
        System.out.println(list);   // [AA, AB]

        // replaceAll
        list.replaceAll(x -> "D" + x);
        System.out.println(list);   // [DAA, DAB]

        // forEach
        list.forEach(x -> System.out.println(x));
    }
}
