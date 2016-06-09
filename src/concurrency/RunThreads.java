package concurrency;

/**
 *
 *
 */
public class RunThreads {
    public static void main(String[] args) {
        System.out.println("begin");
        (new PrinterThread()).start();
        (new Thread(new PrintNumbers())).start();
        (new PrinterThread()).start();
        System.out.println("end");
    }
}
