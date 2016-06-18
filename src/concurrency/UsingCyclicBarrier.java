package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * - CyclicBarrier
 * Allows executions of multi-threads to wait for each other at certain point in the code, a common barrier.
 * takes optional Runnable command which is run after all threads arrived and before they are released.
 * await()|await(int, TimeUnit) - waits for all threads and throws checked InterruptedException, BrokenBarrierException
 *
 * Note: The number of available threads should be at least as large as CyclicBarrier limit value
 *
 */
public class UsingCyclicBarrier {
    private static void actionOne() { System.out.println("Doing action 1"); }
    private static void actionTwo() { System.out.println("Doing action 2"); }
    private static void actionThree() { System.out.println("Doing action 3"); }

    public static void performTask(CyclicBarrier c1, CyclicBarrier c2) {
        try {
            actionOne();
            c1.await();
            actionTwo();
            c2.await();
            actionThree();
        } catch (InterruptedException | BrokenBarrierException e) {
            // To Handle checked exceptions
        }
    }

    public static void main(String[] args) {
        // Constructor takes a number of threads to wait
        CyclicBarrier cb1 = new CyclicBarrier(4);
        CyclicBarrier cb2 = new CyclicBarrier(4,
                () -> System.out.println("** All threads arrived, so all free to go now"));

        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(4);

            for(int i=0; i<4; i++)
                service.submit(() -> performTask(cb1, cb2));

        } finally {
            if(service != null)
                service.shutdown();
        }

    }
}
