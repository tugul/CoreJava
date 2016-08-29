package lambdas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

/**
 * - Java 8's new API in Map
 * putIfAbsent(K key, V value) returns V
 * merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) returns V
 * computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) returns V
 * computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) returns V
 */
public class NewMethodsInMap {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("A", "***");
        hashMap.put("B", null);

        // putIfAbsent
        // add key/value if no value or null is associated with given key
        hashMap.putIfAbsent("A", "AAA");		// key A exist with non-null value, so don't touch
        hashMap.putIfAbsent("B", "BBB");		// key B exist but with null value, so update value
        hashMap.putIfAbsent("C", "CCC");		// key C does not exist, so put a pair in the map
        System.out.println(hashMap); 			// {A=***, B=BBB, C=CCC}

        // V merge(K, V, BiFunction<V, V, V>)
        // - Retrieve value associated with given key and apply given function on retrieved value and given value,
        // and the function's returned value will replace the value associated with that key
        // - If the function returns null, given key will be removed from map
        // - If no value or null is associated with given key, add key/value to map
        BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1: v2;
        Map<String, String> favoriteMaps = new HashMap<>();
        favoriteMaps.put("A", "123");
        favoriteMaps.put("B", "123");
        favoriteMaps.put("C", null);
        String a = favoriteMaps.merge("A", "12345", mapper);    // returns 12345, update value to 12345
        String b = favoriteMaps.merge("B", "12", mapper);       // returns 123
        String c = favoriteMaps.merge("C", "12", mapper);       // 12, C exists with null, add new pair: C, 12
        String d = favoriteMaps.merge("D", "25", mapper);       // 12, D does not exist, add new pair: D, 25
        System.out.println(favoriteMaps);                       // {A=12345, B=123, C=12, D=25}

        BiFunction<String, String, String> mapperNull = (v1, v2) -> null;
        c = favoriteMaps.merge("C", "12", mapperNull);          // returns null, key C is deleted
        c = favoriteMaps.merge("E", "19", mapperNull);          // returns null, E doesn't exist, so add it without running Func
        System.out.println(favoriteMaps);                       // {A=12345, B=123, D=250, E=19}

        // V computeIfPresent(K, BiFunction<K, V, V>)
        // runs given function and update value if requested key is found, and returns null if not found, or null exist in value
        Map<String, Integer> counts1 = new HashMap<>();
        counts1.put("A", 5);
        BiFunction<String, Integer, Integer> mapper1 = (k, v) -> v * 10;
        Integer intA = counts1.computeIfPresent("A", mapper1);  // 50
        Integer intB = counts1.computeIfPresent("B", mapper1);  // null
        System.out.println(counts1);                            // {A=50}

        // V computeIfAbsent(K, Function<K, V>)
        // runs given function if requested key is not found or value is null, and returns null if found or non-null
        Map<String, Integer> counts2 = new HashMap<>();
        counts2.put("A", 20);
        counts2.put(null, 20);
        counts2.put("B", null);
        Function<String, Integer> mapper2 = (k) -> 9;
        Integer intA2 = counts2.computeIfAbsent("A", mapper2); // 20, A exists with non-null value, so don't touch
        Integer intB2 = counts2.computeIfAbsent("B", mapper2); // 9, B exists, but with null value, so run Function
        Integer intC2 = counts2.computeIfAbsent("C", mapper2); // 9, C doesn't exist, so run Function
        System.out.println(counts2);                           // {null=20, A=20, B=9, C=9}
    }
}
