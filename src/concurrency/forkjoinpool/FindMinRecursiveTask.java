package concurrency.forkjoinpool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * - RecursiveTask
 * extends abstract class ForkJoinTask
 *
 *
 */
public class FindMinRecursiveTask extends RecursiveTask<Integer> {
    private Integer[] numbers;
    private int index1;
    private int index2;

    public FindMinRecursiveTask(Integer[] numbers, int index1, int index2) {
        this.numbers = numbers;
        this.index1 = index1;
        this.index2 = index2;
    }

    @Override
    protected Integer compute() {
        if (index2 - index1 < 2)
            return Math.min(numbers[index1], numbers[index2]);
        else {
            int index3 = index1 + (index2-index1)/2;

            FindMinRecursiveTask subTask = new FindMinRecursiveTask(numbers, index1, index3);

            // What is the difference between below calls
            //int result = (int)subTask.fork().join();
            int result = (int)subTask.fork().join();
//            int result = (int)subTask.compute();

            return Math.min(result, new FindMinRecursiveTask(numbers, index3, index2).compute());
        }
    }

    public static void main(String[] args){
        int numberOfThreads = 5;
        ForkJoinPool fjPool = new ForkJoinPool(numberOfThreads);

        Integer[] numbers = {99, 2, -44, 32, 34, 0, -62, 89};
        ForkJoinTask<Integer> task = new FindMinRecursiveTask(numbers, 0, numbers.length-1);

        int minValue1 = ((FindMinRecursiveTask)task).compute();  // direct call without using parallelism
        int minValue2 = fjPool.invoke(task);            // It uses thread pool

        System.out.println(minValue2);   // -62
        System.out.println(minValue1);   // -62
    }
}
