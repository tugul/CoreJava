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
        List<Integer> l1 = Arrays.asList(1,2,3);
        List<Integer> l2 = new CopyOnWriteArrayList<>(l1);
        Set<Integer> s3 = new ConcurrentSkipListSet<>();
        s3.addAll(l1);

        // It will iterate 3 times
        for(Integer item: l2)
            l2.add(4); // x1

        // It will iterate 4 times, because 5 is added only once to unique set
        for(Integer item: s3)
            s3.add(5); // x2

        // 3, 6, 4
        System.out.println(l1.size()+" "+l2.size()+" "+s3.size());

        // It will infinitely loop
        int i = 100;
        for(Integer item: s3)
            s3.add(i++);
    }
}


