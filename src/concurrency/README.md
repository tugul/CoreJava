

- Runnable interface 
functional interface which has one method void run() takes no argument.
used to defined a work/task that thread will execute

- Thread class
implements Runnable interface 
used to execute a thread
Executing task with thread is 2 step process 
- define Thread with corresponding task to be executed
- start the task by calling Thread.start()

There are 2 ways to define task and thread instance
1. provide Runnable object or lambda expression to Thread constructor (More common)

public class PrintData implements Runnable {
    public void run() {
        for(int i=0; i<3; i++)
            System.out.println("Printing record: "+i);
    }
    
    public static void main(String[] args) {
        (new Thread(new PrintData())).start();
    }
}

2. Subclass Thread and override run() method

public class ReadInventoryThread extends Thread {
    public void run() {
        System.out.println("Printing zoo inventory");
    }
    
    public static void main(String[] args) {
        (new ReadInventoryThread()).start();
    }
}


- Pause execution
Thread.sleep(long) pauses current thread to suspend its execution for certain period
Thread.sleep(long) throws checked exception, InterruptedExcetion

