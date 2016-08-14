Fork/Join framework
---
It is introduced in Java 7 as a specific implementation of Executor service and used to execute a task that spawns additional tasks to be run in parallel to solve recursively.<br>
<b>ForkJoinPool</b> - extends ExecutorService and its instance is used to run all fork-join tasks in the whole program.<br>
<b>RecursiveTask<V></b> - generic class, its computation returns result<br>
<b>RecursiveAction</b> - its computation doesn't return value

Notes on its usage
---
<ul>
<li>Class should extend RecursiveAction or RecursiveTask</li>
<li>RecursiveAction's void compute() to be overridden</li>
<li>RecursiveTask<T>'s T compute() to be overridden with generic type</li>
<li>Since compute() takes no arguments, the constructor of the class is often used to pass instructions to the task.</li>
<li>invokeAll() method takes two instances of the fork/join class and does not return a result.</li>
<li>fork() method causes a new task to be submitted to the pool and is similar to the thread executor submit() method.</li>
<li>fork() method should be called before the current thread performs a compute() operation, with join() called to read the results afterward</li>
<li>join() method is called after the fork() method and causes the current thread to wait for the results of a subtask.</li>
<li>Unlike fork(), calling compute() within a compute() method causes the task to wait for the results of the subtask.</li>
</ul>

<b>Subnote:</b>
<ul>
<li>fork() is called before the current thread begins a subtask</li>
<li>join() is called after it finishes retrieving the results, in order for them to be done in parallel.</li>
```java
Double otherResult = otherTask.fork().join();
```
<ul>