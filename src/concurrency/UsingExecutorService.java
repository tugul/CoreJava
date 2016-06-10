package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * - ExecutorService
 * interface having methods to take/execute tasks and provides many useful features on thread
 * necessary to shut down the service instance, otherwise application will hang
 *
 * - Asynchronous
 * execute(Runnable) - returns nothing
 * submit(Callable<T>) - return Future<T>
 * - Synchronous ()
 * invokeAll() - waits until all given collection of tasks are completed and returns collection of result
 * invokeAny() - waits until any of given collection of tasks is completed and returns result of single completed task
 *
 *
 * - Future
 *
 *
 * - Callable
 *
 */
public class UsingExecutorService {
    public static void main(String[] args) {
        ExecutorService executor = null;
        try {
            executor = Executors.newSingleThreadExecutor();
            System.out.println("Started");

            executor.execute(() -> System.out.println("First execution task"));
            executor.execute(() -> {for(int i=0; i<5; i++)
                System.out.println("Printing number: "+i);}
            );
            executor.execute(() -> System.out.println("Second execution task"));

            System.out.println("Finished");
        } finally {
            if(executor != null)
                executor.shutdown();
        }

    }
}
