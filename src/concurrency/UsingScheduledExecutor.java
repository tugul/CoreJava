package concurrency;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * - ScheduledExecutorService
 * used to schedule a task to execute after delay or repeatedly with time interval
 * extends ExecutorService interface
 * its instance is taken from factory method in Executors helper class
 *
 * - Methods to schedule a task
 * schedule(Callable, long delay, TimeUnit) - execute Runnable task after given delay
 * schedule(Runnable, long delay, TimeUnit) - execute Callable task after given delay
 * scheduleAtFixedRate(Runnable, long delay, long interval, TimeUnit) - execute a task after given delay and
 *                          repeatedly in interval without depending on previous task's execution
 * scheduleWithFixedDelay(Runnable, long delay, long interval, TimeUnit) - execute a task after given delay and
 *                          repeatedly with interval after previous task is completed
 *
 * scheduleAtFixedRate is equivalent to cronjob in Unix
 *
 */
public class UsingScheduledExecutor {
    public static void main(String[] args) throws InterruptedException, ExecutionException{
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        Runnable printOneToFive = () -> IntStream.rangeClosed(1,5).forEach(System.out::println);
        Callable<Integer> multiplyOneToFive = () -> IntStream.rangeClosed(1,5).reduce((a,b) -> a * b).getAsInt();

        Future<?> result1 = scheduler.schedule(printOneToFive, 5, TimeUnit.SECONDS);
        Future<Integer> result2 = scheduler.schedule(multiplyOneToFive, 2, TimeUnit.SECONDS);
        System.out.println(result2.get());

        scheduler.shutdown();
    }
}
