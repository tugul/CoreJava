package collections;

import java.util.ArrayList;
import java.util.List;

/**
 * - Size is dymanic, can be changed like StringBuilder
 * ArrayList implements interface List
 *
 */
public class AboutArrayList {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList(10); // initial capacity
        ArrayList list3 = new ArrayList(list2); // copy size and content
        list1.add("bird");
        list1.add(true);
        list1.add(10);
        System.out.println(list1); // [bird, true, 10]

        // Generic class
        ArrayList<String> list4 = new ArrayList<String>();
        ArrayList<String> list5 = new ArrayList<>(); // second part is not mandatory

        // ArrayList implements interface List
        List<Integer> numbers = new ArrayList<>();

        // Some methods


    }
}
