Thread class
------

represents a thread to execute a task and implements Runnable interface 

Executing task with thread is 2 step process 

+ Define thread and corresponding task to be executed

+ Start the task by calling Thread.start()

There are 2 ways to define a task and a thread manually (However, ExecutorService is recommended)

1. Provide Runnable object or lambda expression to Thread constructor (More common)

2. Subclass Thread and override run() method
