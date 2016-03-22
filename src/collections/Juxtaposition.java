package collections;

import java.util.*;

/**
 * Sort array       : Arrays.sort(T[] a);
 * Sort array list  : Collections.sort(List<T> a)
 *
 */
public class Juxtaposition {
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

        // Bothboth are mutable, value can be changed. Size can change in Arraylist only
        // Both have order and indexes
        System.out.println(new int[10].length);         // 10
        System.out.println(new ArrayList(10).size());   // 0

        new ArrayList().remove(0); // COMPILES, but throws Runtime exception



    }
}
