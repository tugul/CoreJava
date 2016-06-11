package concurrency.thread;

/**
 * Two ways to define a task and a thread manually
 * - Provide Runnable object or lambda expression to Thread constructor (More common)
 * - Subclass Thread and override run() method
 *
 * NOTE: Use of ExecutorService is recommended in real application
 *
 */
public class RunThreads {
    public static void main(String[] args) {
        System.out.println("Main thread started");

        (new PrinterThread()).start();                                    // 2nd approach

        (new Thread(new TaskToPrint())).start();                          // 1st approach

        (new Thread(() -> System.out.println("Single task 1"))).start();  // 1st approach with lambda

        (new Thread(new Runnable() {                                      // 1st approach with anonymous implementation
            @Override
            public void run() {
                System.out.println("Single task 2");
            }
        })).start();

        (new PrinterThread()).start();                                    // 2nd approach

        System.out.println("Main thread finished");
    }
}

/* One possible output:

Main thread started
123456789
Main thread finished
Printing number: 1
Printing number: 2
Printing number: 3
Printing number: 4
Single task 1
Single task 2
123456789

*/

