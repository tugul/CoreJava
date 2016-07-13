package concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Callable and Runnable are functional interfaces used to define a task. However,
 * Callable has method call() throws Exception
 * Runnable has method run() throws no exception
 *
 * Below example shows this distinction
 *
 * NOTE: Thread.sleep(long) throws InterruptedException
 */
public class CallableVsRunnable {
    public static void main(String[] args) {
        ExecutorService service = null;
        try{
            service = Executors.newSingleThreadExecutor();

            // COMPILES
            // because JVM considers that it is submit(Callable) as it returns
            service.submit( () -> { Thread.sleep(500); return true; });

            // DOES NOT COMPILE
            // because JVM considers that it is submit(Runnable) as nothing is return
            // and Runnable.run() doesn't throw any exception, so it violates
            service.submit( () -> { Thread.sleep(500); });
        }
        finally {
            if (service != null)
                service.shutdown();
        }
    }
}
