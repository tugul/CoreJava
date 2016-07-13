package concurrency.thread;

/**
 * Many of built-in methods of Thread class check the interruption and throws InterruptedException
 *
 * So it is good practice to check if thread is interrupted inside a own created thread and
 * stop the execution or take similar action. Otherwise, the thread can't be stopped when requested to do so.
 *
 */
public class AboutInterruption {
    public static void main(String[] args) {
        Thread looper = new Thread(new Runnable() {
            @Override
            public void run() {
                int counter = 1;
                while(true){
                    System.out.println("Loop times: " + counter++);

                    // Without this check, this thread can't be stopped until JVM stops
                    if (Thread.interrupted())
                    {
                        System.out.println("Thread is interrupted");
                        break;
                    }
                }
            }
        });

        looper.start();

        try{
            // Let 'looper' thread run for some time until interrupted
            Thread.sleep(300);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt(); // Set back interrupted flag to True
            throw new RuntimeException(e);
        }

        // Want to stop the thread
        looper.interrupt();
    }
}
