package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.DoubleStream;

/**
 * Order of the output can't be determined as all are printed separate threads
 *
 */

public class UsingThreadPoolSimple {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        DoubleStream.of(3.14159,2.71828) // b1
                .forEach(c -> service.submit( // b2
                        () -> System.out.println(10*c))); // b3
        service.execute(() -> System.out.println("Printed")); // b4
    }
}
