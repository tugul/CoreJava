package concurrency.concurrentcollections;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * CopyOnWriteArrayList
 * CopyOnWriteArraySet
 *
 * They copy all of their elements to a new underlying structure anytime an element is
 * added, modified, or removed from the collection. This feature is especially useful
 * during iteration in multi-threaded scenario
 *
 * Although data is copied, underlying reference is not changed.
 *
 * - During iteration
 * CopyOnWriteArrayList - keep original elements and size
 * ConcurrentSkipListSet - immediately updates on each operation, so
 *
 */
public class CopyOnWriteArrayCollection {
    public static void main(String[] args) {
        List<Integer> arrayList = Arrays.asList(1,2,3);
        
        List<Integer> copyOneWriteArrayList = new CopyOnWriteArrayList<>(arrayList);
        Set<Integer> skipListSet = new ConcurrentSkipListSet<>();
        skipListSet.addAll(arrayList);

        // It will iterate 3 times because iteration goes through only original list
        // copy of the list is updated with 3 more new items
        // [1, 2, 3, 4, 4, 4]
        for(Integer item: copyOneWriteArrayList)
            copyOneWriteArrayList.add(4);
        
        // It will iterate 4 times, because set is updated during iteration.
        // And 5 is added only once as nature of set is uniqueness elements
        // [1, 2, 3, 5]
        for(Integer item: skipListSet)
            skipListSet.add(5);

        // Finally, sizes are all different
        System.out.println(arrayList.size()			// 3
        		+ " " +copyOneWriteArrayList.size()	// 6
        		+ " " +skipListSet.size());			// 4
        
        // Extra
        // It is INFINITE LOOP as on each iteration a new element is added 
        // and the skipList Set is updated accordingly 
        int i = 100;
        for(Integer item: skipListSet)
            skipListSet.add(i++);
    }
}


