package concurrency.forkjoinpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 *
 * Simple use of ForkJoin framework with RecursiveAction
 *
 * RecursiveAction calls invoke()/fork() method per each sub task or invokeAll() once  for list of sub tasks
 *
 */
public class SimpleRecursiveAction extends RecursiveAction {
    private long work = 0;
    private static int threshold = 5;

    public SimpleRecursiveAction(long work) {
        this.work = work;
    }

    @Override
    protected void compute() {
        //if work load is over threshold, break the given task up into smaller ones
        if(this.work > threshold) {
            System.out.println("Splitting the work: " + this.work);

            List<SimpleRecursiveAction> subTasks = new ArrayList<>();
            subTasks.add(new SimpleRecursiveAction(this.work / 2));
            subTasks.add(new SimpleRecursiveAction(this.work / 2));

            // 1. Invoke each task in loop
            subTasks.forEach((task) -> task.invoke());

            // 2. Invoke all tasks
            //invokeAll(subTasks);
        }
        else
            System.out.println("Doing the work myself: " + this.work);
    }

    public static void main(String[] args) {
        SimpleRecursiveAction recursiveAction = new SimpleRecursiveAction(32);

        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        forkJoinPool.invoke(recursiveAction);
    }
}

/*
Splitting the work: 32
Splitting the work: 16
Splitting the work: 8
Doing the work myself: 4
Doing the work myself: 4
Splitting the work: 8
Doing the work myself: 4
Doing the work myself: 4
Splitting the work: 16
Splitting the work: 8
Doing the work myself: 4
Doing the work myself: 4
Splitting the work: 8
Doing the work myself: 4
Doing the work myself: 4
*/
