Fork/Join framework
---
introduced in Java 7 and it is specific implementation of Executor service and used 
to execute task that spawns additional tasks to be run parallel to solve problem recursively.
ForkJoinPool - extends ExecutorService and its instance is used to run all fork-join tasks in the whole program.
RecursiveTask<V> - generic class, its computation returns result
RecursiveAction - its computation doesn't return value

Usage
---
 Class should extend RecursiveAction or RecursiveTask
 RecursiveAction's void compute() to be overridden
 RecursiveTask<T>'s T compute() to be overridden with generic type
 Since compute() takes no arguments, the constructor of the class is often used to pass instructions to the task.
 invokeAll() method takes two instances of the fork/join class and does not return a result.
 fork() method causes a new task to be submitted to the pool and is similar to the thread executor submit() method.
 fork() method should be called before the current thread performs a compute() operation, with join() called to read the results afterward
 join() method is called after the fork() method and causes the current thread to wait for the results of a subtask.
 Unlike fork(), calling compute() within a compute() method causes the task to wait for the results of the subtask.
 

fork() is called before the current thread begins a subtask
join() is called after it finishes retrieving the results, in order for them to be done in parallel.
Double otherResult = otherTask.fork().join();