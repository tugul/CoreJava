package concurrency.forkjoinpool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * This simple example finds minimum value of given number list
 * using ForkJoinPool by extending RecusiveTask class
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

            // With below 2 kinds of calls, current thread will be frozen until subTask is finished.
            // So we will loose parallelism 
            //int result = (int)subTask.fork().join();
            //int result = (int)subTask.compute();
            
            // It submits subTask to thread pool to use parallelism
            ForkJoinTask<Integer> firstPart = subTask.fork();

            return Math.min(new FindMinRecursiveTask(numbers, index3, index2).compute(), firstPart.join());
        }
    }

    public static void main(String[] args){
    	// Creating a thread pool
        int numberOfThreads = 5;
        ForkJoinPool fjPool = new ForkJoinPool(numberOfThreads);

        // Defining a task to be executed 
        Integer[] numbers = {99, 2, -44, 32, 34, 0, -62, 89};
        ForkJoinTask<Integer> task = new FindMinRecursiveTask(numbers, 0, numbers.length-1);

        // direct call without using parallelism
        int minValue1 = ((FindMinRecursiveTask)task).compute();
        
        // It uses thread pool
        int minValue2 = fjPool.invoke(task);            

        System.out.println(minValue2);   // -62
        System.out.println(minValue1);   // -62
    }
}
