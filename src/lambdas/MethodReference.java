package lambdas;

import java.util.*;
import java.util.function.*;

/**
 * - Method reference
 * New feature in Java 8 which makes lambda expression even easier to write
 * Short syntax containing no parameter declaration or implementation logic which are inferred by compiler
 * The implementation is defined in somewhere else, so it promotes code reuse
 *
 * - Syntax
 * Class name or object reference followed by (::) and method name
 * ClassName::StaticMethod
 * ContainingType::InstanceMethod
 * ObjectReference::InstanceMethod
 * ClassName::Constructor
 *
 * - 3 important functional interfaces
 * Predicate<T> - boolean test(T var1);
 * Consumer<T>  - void accept(T var1);
 * Supplier<T>  - T get();
 *
 */

public class MethodReference {
    void aa(Predicate a){}
    void ab(Consumer a){}
    void ac(Supplier a){}

    public static void main(String[] args) {
        // Calling static method
        Consumer<List<Integer>> methodRef1 = Collections::sort;
        Consumer<List<Integer>> lambdaExp1 = i -> Collections.sort(i);

        // Calling instance method on specific instance
        String strObj = "abc";
        Predicate<String> methodRef2 = strObj::startsWith;
        Predicate<String> lambdaExp2 = s -> strObj.startsWith(s);

        // Calling instance method on instance to be determined at runtime
        Predicate<List> methodRef3 = List::isEmpty;
        Predicate<List> lambdaExp3 = str -> str.isEmpty();

        // Calling constructor
        Supplier<LinkedList> methodRef4 = LinkedList::new;
        Supplier<LinkedList> lambdaExp4 = () -> new LinkedList();
    }
}
