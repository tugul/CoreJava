package concurrency;

import java.util.concurrent.*;

/**
 * - ExecutorService
 * interface with methods to take/execute tasks and provides many useful features (thread pooling, scheduling etc.)
 * necessary to shut down the service instance, otherwise application will hang
 * extends functional interface Executor (with void execute(Runnable))
 *
 * - Methods to submit a task to a thread
 * Asynchronous (doesn't wait for given task to finish)
 * 1. execute(Runnable) - returns nothing
 * 2. submit(Runnable) - returns Future<?>
 * 3. submit(Callable<T>) - returns Future<T>
 * Synchronous (meaning that waits for given tasks to finish)
 * 4. invokeAll() takes a collection of Callable tasks and returns collection of Future objects once all are finished
 * 5. invokeAny() takes a collection of Callable tasks and returns single Future object once any of them is finished
 *
 * - Waiting for result
 * Once task is submitted, result is returned in single or collection of Future object which has following methods
 * get() infinitely waits for the task to complete and returns result once the task is finished
 * get(long, TimeUnit) waits for the result only for specified period and throws TimeOutException if hasn't got
 * cancel(boolean) attempts to cancel running task and returns boolean
 * isCancelled() returns true if the task is cancelled before completion
 * isDone() returns true if the task is completed
 *
 */
public class UsingExecutorService {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = null;
        try {
            executor = Executors.newSingleThreadExecutor();
            executor.execute(() -> System.out.println("Single execution task"));
            executor.execute(() -> {for(int i=0; i<5; i++)
                System.out.println("Printing number: "+i);}
            );

            Future<String> result = executor.submit(() -> "SimpleTask");
            System.out.println(result.get());       // can throw InterruptedException, ExecutionException

        } finally {
            if(executor != null)
                executor.shutdown();
        }

        if(executor != null){
            // Just wait for 5 seconds to complete
            boolean isTerminated = executor.awaitTermination(5, TimeUnit.SECONDS);

            if(executor.isTerminated())
                System.out.println("All tasks are completed");
            else
                // If still not completed, wait until it is finished
                while(!executor.awaitTermination(5, TimeUnit.SECONDS))
                {
                    System.out.println("At least 1 task running. Awaiting completion");
                }
        }
    }
}
