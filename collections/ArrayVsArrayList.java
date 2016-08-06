package collections;

import java.util.*;

/**
 * - Main differences between Array and ArrayList
 * Size: is mandatory and can't be changed for Array while ArrayList can be declared without size and is re-sizable.
 * Dimension: Array can be multi-dimensional while ArrayList is only single dimensional
 * Primitive: ArrayList can't store primitives, instead can store their wrapper objects 
 * Generics: ArrayList supports generics, so it is type-safe
 * Adding an element: Array element is added through asignment operator, while ArrayList use add() method 
 * Length: Array has length variable while ArraList has size() method
 * Performance: Array is faster while ArrayList is bit slower, especially when comparing
 * Sorting: 
 * 	Array      : Arrays.sort(T[] a);
 * 	ArrayList  : Collections.sort(List<T> a)
 *
 * - Similarities
 * Both are ordered(doesn't mean sorted) and use index to refer to their elements
 * Can contain duplicate elements and null values
 *
 */
public class ArrayVsArrayList {
    public static void main(String[] args) {
        // Sorting array and array list
        Random rand = new Random();
        int[] array = new int[5];
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++){
            array[i] = rand.nextInt(30) + 1;
            arrayList.add(rand.nextInt(30) + 1);
        }
        Arrays.sort(array);
        Collections.sort(arrayList);

        System.out.println(Arrays.toString(array));
        System.out.println(arrayList);

        // Both are mutable, value can be changed. But size can change in ArrayList only
        // Both have order and indexes
        System.out.println(new int[10].length);         // 10
        System.out.println(new ArrayList(10).size());   // 0

        new ArrayList().remove(0); // COMPILES, but throws Runtime exception

    }
}
