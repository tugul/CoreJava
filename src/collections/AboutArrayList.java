package collections;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * - Size is dynamic, can be changed like StringBuilder
 * - ArrayList implements interface List
 * - ArrayList has size() method while Array has length variable
 * - ArrayList overrides equals() method, so it will compare contents
 */
public class AboutArrayList {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList(10);    // initial capacity
        ArrayList list3 = new ArrayList(list2); // copy size and content

        // Generic class
        ArrayList<String> list4 = new ArrayList<String>();
        ArrayList<String> list5 = new ArrayList<>(); // second part is not mandatory
        ArrayList<String> list7 = new ArrayList();   // second part is not mandatory

        // ArrayList implements interface List
        List<Integer> numbers = new ArrayList<>();

        // Some methods
        list1.add("bird");
        list1.add(true);
        list1.add(10);
        list1.add(0, Month.APRIL);          // insert at the index and shift 1 back all backward elements
        list1.add(list1.size(), 's');       // insert at the end, same as just add(object);

        System.out.println(list1.size());   // 5
        System.out.println(list1);          // [APRIL, bird, true, 10, s]
        System.out.println(list1.get(1));   // bird

        list1.set(2, 4.5);
        System.out.println(list1);          // [APRIL, bird, 4.5, 10, s]
        System.out.println(list1.contains("bird"));   // true

        // forEach() is declared in ArrayList
        list1.forEach(System.out::println);

        list1.remove("bird");
        System.out.println(list1);          // [APRIL, 4.5, 10, s]
        list1.remove(1);
        System.out.println(list1);          // [APRIL, 10, s]

        // Equals() check contents, not reference
        ArrayList list6 = new ArrayList(100);
        System.out.println(list6.size());           // still 0, declared with initial capacity 10
        System.out.println(list2.equals(list6));    // true
        list2.add("aaa");
        list6.add("aaa");
        System.out.println(list2.equals(list6));    // true
    }
}
