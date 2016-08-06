Thread class
------

represents a thread to execute a task and implements Runnable interface 

Executing a task with thread is a 2-step process: 

+ Define thread and corresponding task to be executed

+ Start task execution by calling start() on thread object

There are 2 ways to define a task and a thread manually (However, use of ExecutorService is recommended)

1. Provide Runnable object or lambda expression to Thread constructor (more common way)

2. Subclass Thread and override run() method
