package concurrency.forkjoinpool;

import java.util.concurrent.*;
import java.util.stream.*;

/**
 *
 *
 *
 */

public class PrintConstants {
    public static void main(String[] args) {
        ExecutorService service = Executors.newScheduledThreadPool(10);
        DoubleStream.of(3.14159,2.71828) // b1
                .forEach(c -> service.submit( // b2
                        () -> System.out.println(10*c))); // b3
        service.execute(() -> System.out.println("Printed")); // b4
    }
}
