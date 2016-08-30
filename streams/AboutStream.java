package streams;

import static java.util.Arrays.asList;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * new API introduced in Java 8
 *
 * Stream is a sequence of data on which stream pipeline (operations) run to produce a result
 * It is composed of 3 parts:
 * - source: input data
 * - intermediate operation: operations, which are executed when final operation runs
 * - terminal operation: last operation in pipeline and destroys the stream
 *
 */
public class AboutStream {
    public static void main(String[] args) {
        // ----------------------------
        // 1. Creating stream
        // ----------------------------
        Stream<Integer> empty = Stream.empty();
        Stream<Integer> stream123 = Stream.of(1, 2, 3); // accepts varargs
        Stream<Stream<Integer>> composedStream = Stream.of(Stream.of(1, 2, 3), Stream.of(4, 5, 6));

        // Create stream from Collection
        List<String> list = asList("Mars", "saturn", "EARTH");
        Stream<String> planetsFromList = list.stream();
        Stream<String> planetsFromListParallel = list.parallelStream(); // Unless using for huge list, no advantage

        // Create stream by generating
        // Stream<T> generate(Supplier<T>)
        // Stream<T> iterate(T, UnaryOperator<T>)
        Stream<Double> randomNumbers = Stream.generate(Math::random);
        Stream<Integer> evenNumbers = Stream.iterate(2, x -> x + 2);    // (starting value, lambda expression)

        // ----------------------------
        // 2. Terminal operations, produces a result
        // ----------------------------
        // long count() returns count of elements in a stream
        System.out.println(empty.count()); // 0

        // Optional<T> min/max(Comparator) 
        // once minimum value is found, stream is destroyed and no longer usable
        System.out.println(stream123.min((a1, a2) -> a1 - a2)); 	// Optional[1]

        // findAny(), findFirst() takes no argument and returns Optional<T>
        // mostly used after filter method
        // findFirst is restricted to return first occurrence, but findAny return any occurrence unexpectedly so it is faster
        planetsFromList.findAny().ifPresent(System.out::println);   // Mars
        Stream.generate(() -> "infinite").findFirst().ifPresent(System.out::println); // "infinite", terminates the infinite stream

        // find*** methods on primitive streams return primitive Optional classes(OptionalInt, OptionalLong or OptionalDouble)
        IntStream odds = IntStream.iterate(11, x -> x + 2);
        OptionalInt optFive = odds.filter(x -> x%5 == 0).findFirst();
        System.out.println(optFive.getAsInt());

        // allMatch(), anyMatch(), noneMatch() take Predicate as argument and returns boolean
        Predicate<String> isFirstUpperCase = x -> Character.isUpperCase(x.charAt(0));
        //System.out.println(planetsFromList.allMatch(isFirstUpperCase));  // IllegalStateException, stream has already closed
        System.out.println(list.stream().allMatch(isFirstUpperCase));    // false
        System.out.println(list.stream().anyMatch(isFirstUpperCase));    // true
        System.out.println(list.stream().noneMatch(isFirstUpperCase));   // false
        Stream<String> infiniteOnes = Stream.generate(()->"One");
        System.out.println(infiniteOnes.anyMatch(isFirstUpperCase));      // true

        // void forEach(Consumer)
        // void forEachOrdered(Consumer) - processes one element at a time, used in multi-threaded cases
        list.stream().forEach(System.out::println);

        // REDUCTION: reduce() - general purpose reduction method unlike sum, max, min ... 
        // particularly designed to work with immutable output objects (primitives, String ...) 
        // in other words, it always creates new value on iterating each element
        // T reduce(T t, BinaryOperator<T> operator)
        Stream<String> letters = Stream.of("a", "b", "c");
        System.out.println(letters.reduce("ABC: ", (s1, s2) -> s1 + s2));  				// "ABC: abc", using lambda
        System.out.println(Stream.of("a", "b", "c").reduce("ABC: ", String::concat));  	// "ABC: abc", using method reference

        // Optional<T> reduce(BinaryOperator<T> accumulator)
        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        Stream.of(1, 2, 3).reduce(multiply).ifPresent(System.out::println); // 6
        //Stream.empty().reduce(multiply).ifPresent(System.out::println); // DOES NOT COMPILE, mismatch type between Stream<Object> and BinaryOperator<Integer>
        Stream.<Integer>empty().reduce(multiply).ifPresent(System.out::println); // COMPILES, match between Stream<Integer> and BinaryOperator<Integer>
        
        Stream<Integer> emptyInts = Stream.empty();
        emptyInts.reduce(multiply).ifPresent(System.out::println);      // no output

        // REDUCTION: collect() - mutable version of reduce, i.e. designed to work with mutable objects
        // unlike reduce(), it modifies or mutates existing value
        // R collect(Collector)        
        // R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner)
        List<String> words = asList("cia", "bia", "aia", "aia");
        TreeSet<String> sortedSet1 = words.stream().collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        TreeSet<String> sortedSet2 = words.stream().collect(Collectors.toCollection(TreeSet::new));
        Set<String> set = words.stream().collect(Collectors.toSet());    // order is not guaranteed
        System.out.println(sortedSet1 + " " + sortedSet2 + ", " + set);  // [aia, bia, cia] [aia, bia, cia], [aia, cia, bia]

        // ----------------------------
        // 2. Intermediate operations, take stream/return stream
        // ----------------------------

        // filter
        // Stream<T> filter(Predicate<? super T> predicate)
        words.stream().filter(x -> x.startsWith("a")).forEach(System.out::println); // a
 
        // Stream<T> distinct() - uses equals() to compare
        words.stream().distinct().forEach(System.out::println);

        // Stream<T> limit(int maxSize) - set maximum size of stream
        // Stream<T> skip(int X) - skip first X number of element
        Stream<Integer> oddNumbers = Stream.iterate(1, x -> x + 2);
        oddNumbers.skip(2).limit(3).forEach(System.out::print); // 579

        // map creates one-to-one mapping by applying Function on each element
        // Stream<R> map(Function<? super T, ? extends R> mapper)
        words.stream().map(String::toUpperCase).forEach(System.out::println);  // Convert to stream whose elements are uppercase
        // flatMap - applies function on each single element of each element of Stream
        // Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
        List<Integer> together = Stream.of(asList(1, 2), asList(10, 11)) // Stream of List<Integer>
                .flatMap(numbers -> numbers.stream())
                .map(integer -> integer + 1)
                .collect(Collectors.toList());
        System.out.println(together); // [2, 3, 11, 12]

        // sorted - returns a stream with sorted elements
        // Stream<T> sorted() - sorts Comparable objects, otherwise exception is thrown
        // Stream<T> sorted(Comparator<? super T> comparator)
        words.stream().sorted().forEach(System.out::println);
        words.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        //words.stream().sorted(Comparator::reverseOrder).forEach(System.out::println); // DOES NOT COMPILE, reverseOrder is not functional method

        // peek - allows to perform operation without changing stream, useful for debugging
        // Stream<T> peek(Consumer<T>)
        // In below, call peek before filtering to see if flow is going correct
        Stream.iterate(1, x -> x + 1)
                .limit(6)
                .peek(System.out::print)
                .filter(x -> x % 2 == 0)
                .forEach(System.out::print);    // 122344566

        Stream.iterate(1, x -> x + 1)
                .filter(x -> x % 2 == 1)
                .peek(System.out::print)
                .limit(4)
                .forEach(System.out::print);    // 11335577

        // as an intermediate operation, peek will only run when there is terminal operation
        // so below will produce nothing
        Stream.iterate(1, x -> x + 1)
                .filter(x -> x % 2 == 1)
                .peek(System.out::print)
                .limit(4);                      // no output
    }
}
