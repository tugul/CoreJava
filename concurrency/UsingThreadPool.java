package concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * - To create single threaded executors
 * newSingleThreadExecutor()
 * newSingleThreadScheduledExecutor()
 *
 * - To create multi-threaded executors
 * newCachedThreadPool() - creates new thread as needed, also reuses already created idle threads
 * newFixedThreadPool(int) - creates given number of threads and reuse idle one among them
 * newScheduledThreadPool(int) - creates given number of scheduled threads and reuse idle one among them
 *
 * Note:
 * newCachedThreadPool() can create unlimited number of threads if threads are taking
 * time to finish given tasks so it is recommended to use it for quick-executing tasks
 *
 *
 */
public class UsingThreadPool {
    public static void main(String[] args) throws InterruptedException {
        int numberOfCPU = Runtime.getRuntime().availableProcessors();

        ExecutorService executor = Executors.newFixedThreadPool(numberOfCPU);

        // Create a task
        Callable<String> task = () -> {
            String name = Thread.currentThread().getName();
            System.out.println("Thread name: " + name);
            return name;
        };

        // Create list of 10 same task
        List<Callable<String>> taskList = IntStream.range(1, 10)
                .mapToObj(x -> task).collect(Collectors.toList());

        // Execute all tasks in thread pool
        executor.invokeAll(taskList);

        executor.shutdown();
    }
}

/* One possible output:
Thread name: pool-1-thread-3
Thread name: pool-1-thread-1
Thread name: pool-1-thread-2
Thread name: pool-1-thread-4
Thread name: pool-1-thread-4
Thread name: pool-1-thread-3
Thread name: pool-1-thread-4
Thread name: pool-1-thread-1
Thread name: pool-1-thread-2
*/