package collections;

/**
 * static <T> List<T> asList(T... a)
 * - Resulted List called a backed list (can update content, but can't change size)
 * - Original array and resulted backed list point to same data store
 */
public class ConvertArrayToArrayList {
    public static void main(String[] args) {
        String[] array = {"Bos", "ton"};
        java.util.List<String> list = java.util.Arrays.asList(array);
        System.out.println(list);       // [Bos, ton]

        // Can update content
        list.set(0, "Dart");
        System.out.println(list);       // [Dart, ton]
        System.out.println(array[0]);   // Dart

        array[0] = "Hier";
        System.out.println(list);       // [Hier, ton]

        // Can't change size
        list.add("Dot");        // RuntimeException: UnsupportedOperationException
        list.remove(0);         // RuntimeException: UnsupportedOperationException
    }
}
