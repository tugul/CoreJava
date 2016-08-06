package concurrency.thread;

import java.util.stream.IntStream;

/**
 * Simple thread is defined with a own task to print 1-5
 *
 */
public class PrinterThread extends Thread {
    public void run() {
        IntStream.range(1,10).forEach(System.out::print);
        System.out.println();
    }

    public static void main(String[] args) {
        (new PrinterThread()).start();
    }
}
