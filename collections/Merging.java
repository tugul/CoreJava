package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * - merge(key, value, BiFunction)
 * it allows logic to decide what to choose in case of conflict during merging
 * if key is not found or value is null for existing key, it simply takes new value by skipping logic 
 * if logic returns null, that key is removed from collection
 * 
 * TreeSet - unique and sorted items, adding null will compile, but will throw NullPointerException
 * TreeMap - unique and sorted keys, adding null as key will compile, but will throw NullPointerException
 *
 */
public class Merging {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(2, "a");
        treeMap.put(2, "a");
        treeMap.put(3, "b");
        treeMap.put(1, "c");
        treeMap.put(1, null);
        // null key is not allowed in map
        //treeMap.put(null, null);  // throws NullPointerException
        for(Object number : treeMap.keySet())
            System.out.println(treeMap.get(number));


        TreeSet<Integer> treeSet = new TreeSet<>();
        // TreeSet is sorted set so null can't be sorted
        //treeSet.add(null);  // throw NullPointerException
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
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(10, 55);
        map.put(20, 20);
        map.put(30, null);
        
        map.merge(10, 9, (a,b) -> null); // logic returns NULL, so key (10) will be removed
        map.merge(30, 8, (a,b) -> null); // null in existing key(3), so new value will directly taken
        
        System.out.println(map);	// {20=20, 30=8}
    }
}

/*
null
a
b
[2]
{1=null, 2=a, 3=bf}
{1=null, 2=x, 3=bf}
{1=null, 2=x, 3=bf}
{1=null, 2=x, 3=bf}
{20=20, 30=8}
*/

