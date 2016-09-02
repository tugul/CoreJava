package streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * - Collector
 * Introduced in Java 8 as means to push stream into collected values (i.e. collection or single value)
 *
 * Collector  - interface Collector<T, A, R>
 * Collectors - final class Collectors (helper class)
 *
 */
public class AboutCollectors {
    public static void main(String[] args) {
        List<String> letters = Arrays.asList("d", "a", "y", "y", "s");

        // collect method of Stream -- terminal operation
        // <R, A> R collect(Collector<? super T, A,R> collector)
        TreeSet<String> sortedSet = letters.stream().collect(Collectors.toCollection(TreeSet::new)); // unique, ordered
        System.out.println(sortedSet);  // [a, d, s, y]

        Set<String> set = letters.stream().collect(Collectors.toSet()); // unique, but order is not guaranteed
        System.out.println(set);        // [a, s, d, y]

        // Collectors.joining returns Collector
        String joined = letters.stream().collect(Collectors.joining("-"));
        System.out.println(joined);     // d-a-y-y-s

        // Stream to collectedly average value
        List<String> message = Arrays.asList("Save", "the", "earth");
        Double averagedValue = message.stream().collect(Collectors.averagingInt(String::length));
        System.out.println(averagedValue); // 4.0

        // Stream to map
        // toMap take KeyMapper, ValueMapper (MergeFunction and mapSupplier)
        List<String> words = Arrays.asList("Save", "this", "earth");
        Map<String, Integer> mappedWords1 = words.stream().collect(Collectors.toMap(k -> k.toUpperCase(), String::length));
        System.out.println(mappedWords1);   // {EARTH=5, THIS=4, SAVE=4}

        // Throws RuntimeException: Duplicate key SAVE
//        Map<Integer, String> mappedWords2 = words.stream().collect(Collectors.toMap(String::length, k -> k.toUpperCase()));

        // Using mergeFunction to resolve duplicate key issue
        Map<Integer, String> mappedWords3 = words.stream()
                .collect(Collectors.toMap(String::length, k -> k, (k1, k2) -> k1 + ":" + k2));
        System.out.println(mappedWords3);   // {4=Save:this, 5=earth}

        // Using mergeFunction and mapSupplier
        TreeMap<Integer, String> mappedWords4 = words.stream()
                .collect(Collectors.toMap(String::length, k -> k, (k1, k2) -> k1 + ":" + k2, TreeMap::new));
        System.out.println(mappedWords4);   // {4=Save:this, 5=earth}

        //------------------------------------
        // Group, Partition and Map
        //------------------------------------
        
        // Collectors.groupingBy
        // Collector<T, Map> groupingBy(Function<T>)
        // Collector<T, Map> groupingBy(Function<T>, Collector<T>)
        // Collector<T, Map> groupingBy(Function<T>, Supplier<T>, Collector<T>)
        Map<Integer, List<String>> map1 = words.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(map1);  // {4=[Save, this], 5=[earth]}

        Map<Integer, Set<String>> map2 = words.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println(map2);  // {4=[this, Save], 5=[earth]}

        TreeMap<Integer, Set<String>> map3 = words.stream()
                .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
        System.out.println(map3);  // {4=[this, Save], 5=[earth]}

        // Collectors.partitioningBy
        // Collector<T, Map<Boolean, T>> partitioningBy(Predicate)
        // Collector<T, Map<Boolean, T>> partitioningBy(Predicate, Collector)
        Map<Boolean, List<String>> map4 = words.stream().map(x -> x.toString())
                .collect(Collectors.partitioningBy(x -> x.length() > 4));
        System.out.println(map4);  // {false=[Save, this], true=[earth]}

        // partitioningBy returns a map with always/only 2 boolean keys(true & false)
        // groupingBy returns a map with key which actually exists or are needed 
        // Below example shows difference between partitioningBy vs groupingBy in case of empty stream
        Map<Boolean, List<String>> map5 = Stream.empty().map(x -> (String)x)
                .collect(Collectors.partitioningBy(x -> x.startsWith("x")));
        System.out.println(map5); // {false=[], true=[]}

        Map<Boolean, List<String>> map6 = Stream.empty().map(x -> (String)x)
                .collect(Collectors.groupingBy(x -> x.startsWith("x")));
        System.out.println(map6); // {}

        // mapping, minBy, maxBy
        // Collector mapping(Function mapper, Collector)
        // Collector minBy(Comparator)
        // Collector maxBy(Comparator)
        Map<Integer, Optional<Character>> map7 = words.stream().collect(
                Collectors.groupingBy(String::length,
                        Collectors.mapping(s -> s.charAt(0), Collectors.minBy(Comparator.naturalOrder()))));
        System.out.println(map7); // {4=Optional[S], 5=Optional[e]}
    }
}
