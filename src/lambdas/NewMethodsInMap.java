package lambdas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

/**
 * - Java 8's new API in Map
 * putIfAbsent(K key, V value) returns V
 * merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) returns V
 * computeIfPresent()
 * computeIfAbsent()
 *
 *
 *
 */
public class NewMethodsInMap {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("A", "***");
        hashMap.put("B", null);

        // putIfAbsent
        // add key/value if no value or null is associated with given key
        hashMap.putIfAbsent("A", "AAA");
        hashMap.putIfAbsent("B", "BBB");
        hashMap.putIfAbsent("C", "CCC");
        System.out.println(hashMap); // {A=***, B=BBB, C=CCC}

        // merge
        // - Retrieve value associated with given key and apply given function on retrieved value and given value,
        // and the function's returned value will replace the value associated with that key
        // - If the function returns null, given key will be removed from map
        // - If no value or null is associated with given key, add key/value to map
        BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1: v2;
        Map<String, String> favoriteMaps = new HashMap<>();
        favoriteMaps.put("A", "123");
        favoriteMaps.put("B", "123");
        String a = favoriteMaps.merge("A", "12345", mapper);    // returns 12345
        String b = favoriteMaps.merge("B", "12", mapper);       // returns 123
        String c = favoriteMaps.merge("C", "12", mapper);       // 12
        System.out.println(favoriteMaps);                       // {A=12345, B=123, C=12}

        BiFunction<String, String, String> mapperNull = (v1, v2) -> null;
        c = favoriteMaps.merge("C", "12", mapperNull);          // returns null
        System.out.println(favoriteMaps);                       // {A=12345, B=123}

        // computeIfPresent
        // runs given function if requested key is found
        // /computeIfAbsent
        // runs given function if requested key is not found or value is null
        Map<String, Integer> counts1 = new HashMap<>();
        counts1.put("Jenny", 1);
        BiFunction<String, Integer, Integer> mapper1 = (k, v) -> v + 1;
        Integer jenny = counts1.computeIfPresent("Jenny", mapper1);
        Integer sam = counts1.computeIfPresent("Sam", mapper1);
        System.out.println(counts1); // {Jenny=2}
        System.out.println(jenny); // 2
        System.out.println(sam); // null

        Map<String, Integer> counts2 = new HashMap<>();
        counts2.put("Jenny", 15);
        counts2.put("Tom", null);
        Function<String, Integer> mapper2 = (key) -> 1;
        Integer ba = counts2.computeIfAbsent("Jenny", mapper2); // 15
        Integer bb = counts2.computeIfAbsent("Sam", mapper2); // 1
        Integer bc = counts2.computeIfAbsent("Tom", mapper2); // 1
        System.out.println(counts2); // {Tom=1, Jenny=15, Sam=1}
    }
}
