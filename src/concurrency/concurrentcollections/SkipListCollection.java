package concurrency.concurrentcollections;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * - SkipList collections
 * ConcurrentSkipListSet
 * ConcurrentSkipListMap
 *
 * They are concurrent alternatives of TreeSet and TreeMap, respectively.
 * Elements or keys are kept sorted in natural order and to be unique
 *
 * When its data is changed during loop operation, updates are
 * immediately reflected to original set on each iteration
 *
 */
public class SkipListCollection {
    public static void main(String[] args) {
        List<Integer> set = Arrays.asList(1, 2, 3);
        ConcurrentSkipListSet<Integer> ccSet = new ConcurrentSkipListSet<>(set);

        System.out.println("Adding duplicate number");
        for (Integer number: ccSet)
        {
            ccSet.add(3);
            System.out.println(number);
        }

        System.out.println("Adding unique number");
        for (Integer number: ccSet)
        {
            ccSet.add(4);
            System.out.println(number);
        }
    }
}
/*
Adding duplicate number
1
2
3
Adding unique number
1
2
3
4

*/
