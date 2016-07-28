package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Callable and Runnable are functional interfaces used to define a task. However,
 * Callable has a method: V call() throws Exception
 * Runnable has a method: void run()
 *
 * Callable is introduced later in Java 5.0 to handle cases which Runnable can't. 
 * Runnable remained for backward compatibility. Below example shows this distinction:
 *
 */
public class CallableVsRunnable {
    public static void main(String[] args) {
        ExecutorService service = null;
        try{
            service = Executors.newSingleThreadExecutor();

            // COMPILES
            // because JVM considers that it is submit(Callable) as it returns
            // and Callable can throw any exception
            service.submit( () -> { Thread.sleep(500); return true; });

            // DOES NOT COMPILE
            // because JVM considers that it is submit(Runnable) as nothing is returned
            // and Runnable.run() shouldn't throw any exception, but here that is violated
            // because Thread.sleep(long) throws InterruptedException, a checked exception
            service.submit( () -> { Thread.sleep(500); });
        }
        finally {
            if (service != null)
                service.shutdown();
        }
    }
}
