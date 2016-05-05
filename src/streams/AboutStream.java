package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Stream is a sequence of data on which stream pipeline (operations) run to produce a result
 * It is composed of 3 parts:
 * - source: input data
 * - intermediate operation: operations, which are executed when final operation runs
 * - terminal operation:
 *
 * Three primitive Streams:
 * - IntStream, specific functional interface IntSupplier
 * - LongStream, specific functional interface LongSupplier
 * - DoubleStream, specific functional interface DoubleSupplier
 * they have additional and math operations: range, rangeClosed, max, min, average, sum and summaryStatistics
 *
 */
public class AboutStream {
    public static void main(String[] args) {
        // 1. Creating stream
        Stream<Integer> empty = Stream.empty();
        Stream<Integer> stream123 = Stream.of(1, 2, 3); // accepts varargs

        // Create stream from Collection
        List<String> list = Arrays.asList("Mars", "Saturn", "Earth");
        Stream<String> planetsFromList = list.stream();
        Stream<String> planetsFromListParallel = list.parallelStream(); // Unless using for huge list, no advantage

        // Create stream by generating
        Stream<Double> randomNumbers = Stream.generate(Math::random);
        Stream<Integer> evenNumbers = Stream.iterate(2, x -> x + 2);    // (starting value, lambda expression)

        // Create IntStream
        IntStream oneToNine = IntStream.range(1,10);        // 1...9
        LongStream oneToTen = LongStream.rangeClosed(1,10); // 1...10, end value inclusive

        // 2. Terminal operations
        System.out.println(empty.count()); // 0

        // min/max accepts Comparator and returns Optional<T>
        System.out.println(stream123.min((a1, a2) -> a1 - a2));
        System.out.println(oneToNine.sum());     // 45

        // findAny, findFirst takes no argument and returns Optional<T>
        planetsFromList.findAny().ifPresent(System.out::println);   // Mars
        Stream.generate(() -> "infinite").findFirst().ifPresent(System.out::println); // infinite, terminates infinite stream




    }
}
