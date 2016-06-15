package concurrency.thread;

import java.util.stream.IntStream;

/**
 * Simple task is defined here.
 *
 */
public class TaskToPrint implements Runnable {
    public void run() {
        IntStream.range(1, 5)
            .forEach(x -> System.out.println("Printing number: "+x));
    }

    public static void main(String[] args) {
        (new Thread(new TaskToPrint())).start();
    }
}
