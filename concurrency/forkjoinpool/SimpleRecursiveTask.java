package concurrency.forkjoinpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Simple recursive task
 *
 * RecursiveTask use invoke() method as it returns value
 */
public class SimpleRecursiveTask extends RecursiveTask<Integer> {
    private int work = 0;
    private static int threshold = 5;

    public SimpleRecursiveTask(int work) {
        this.work = work;
    }

    protected Integer compute() {
        //if work load is above threshold, break tasks up into smaller tasks
        if(this.work > threshold) {
            System.out.println("Splitting task : " + this.work);

            List<SimpleRecursiveTask> subTasks = new ArrayList<>();
            subTasks.add(new SimpleRecursiveTask(this.work / 2));
            subTasks.add(new SimpleRecursiveTask(this.work / 2));

            // Spawn sub tasks
            subTasks.forEach(task -> task.fork());

            // Collect/join the results, below 2 lambdas are doing same
            int result1 = subTasks.stream().mapToInt(task -> task.join()).sum();
            int result2 = subTasks.stream().map(task -> task.join()).reduce(0, (a,b) -> a+b);

//          Above 2 lambdas are doing same as below iteration
//            for(SimpleRecursiveTask subTask : subTasks)
//                result += subTask.join();

            return result1;
        }
        else {
            System.out.println("Doing the work myself: " + this.work);
            return work * 5;
        }
    }

    public static void main(String[] args) {
        SimpleRecursiveTask recursiveTask = new SimpleRecursiveTask(14);

        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        int mergedResult = forkJoinPool.invoke(recursiveTask);

        System.out.println("Collective result = " + mergedResult);
    }
}

/*
Splitting task : 14
Splitting task : 7
Splitting task : 7
Doing the work myself: 3
Doing the work myself: 3
Doing the work myself: 3
Doing the work myself: 3
Collective result = 60
*/
