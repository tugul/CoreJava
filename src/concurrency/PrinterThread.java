package concurrency;

/**
 *
 *
 */
public class PrinterThread extends Thread {
    public void run() {
        System.out.println("Printing zoo inventory");
    }

    public static void main(String[] args) {
        (new PrinterThread()).start();
    }
}
