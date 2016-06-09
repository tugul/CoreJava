package concurrency;

import java.util.stream.IntStream;

/**
 *
 *
 */
public class PrintNumbers implements Runnable {
    public void run() {
        IntStream.range(1, 5)
            .forEach(x -> System.out.println("Printing number: "+x));
    }

    public static void main(String[] args) {
        (new Thread(new PrintNumbers())).start();
    }
}
