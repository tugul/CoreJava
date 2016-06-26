package collections;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * TreeSet - unique and sorted items, adding null will compile, but will throw NullPointerException
 * TreeMap - unique and sorted keys, adding null as key will compile, but will throw NullPointerException
 *
 */
public class Test {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(2, "a");
        treeMap.put(2, "a");
        treeMap.put(3, "b");
        treeMap.put(1, "c");
        treeMap.put(1, null);
        //treeMap.put(null, null);  // throws NullPointerException
        for(Object number : treeMap.keySet())
            System.out.println(treeMap.get(number));


        TreeSet<Integer> treeSet = new TreeSet<>();
        // treeSet.add(null);  // throw NullPointerException
        treeSet.add(2);
        System.out.println(treeSet);

        // merge(key, value, BiFunction)
        treeMap.merge(3,"f", (v1,v2) -> v1 + v2);
        System.out.println(treeMap);
        // {1=null, 2=a, 3=bf}

        treeMap.merge(2,"x", (v1,v2) -> v1 = v2);
        System.out.println(treeMap);
        // {1=null, 2=x, 3=bf}

        treeMap.merge(2,"M", (v1,v2) -> v1);
        System.out.println(treeMap);
        // {1=null, 2=x, 3=bf}

        treeMap.merge(2,"M", (v1,v2) -> v1);
        System.out.println(treeMap);
        // {1=null, 2=x, 3=bf}
    }
}

/*
null
a
b
[2]
*/

