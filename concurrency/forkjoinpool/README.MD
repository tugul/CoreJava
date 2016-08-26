Fork/Join framework
---
It is introduced in Java 7 as a specific implementation of Executor service and used to execute a task that spawns additional tasks to be run in parallel to solve recursively.<br>
<b>ForkJoinPool</b> - concrete class implementing ExecutorService. Its instance is used to run all fork-join tasks in the whole program.<br>
<b>RecursiveAction</b> - abstract class, its computation doesn't return value<br>
<b>RecursiveTask\<V></b> - abstract generic class, its computation returns result<br>

Notes on its usage
---
<ul>
<li>Fork/join class should extend either <i>RecursiveAction</i> or <i>RecursiveTask</i> both of which implement interface ForkJoinTask</li>
<li>When extending RecursiveAction, <i>protected void compute()</i> to be overridden</li>
<li>When extending RecursiveTask&lt;T&gt;, <i>protected T compute()</i> to be overridden with generic type</li>
<li>Since <i>compute()</i> methods take no argument, the constructor of the class is often used to pass instructions to the task.</li>
</ul>
Things to remember inside <i>compute()</i> method, specially be careful to use <i>fork(), join()</i> methods:
<ul>
<li><i>static void invokeAll()</i> method takes varargs of fork/join class instances</li>
<li><i>invoke()</i> method takes no argument and returns a generic type.</li>
<li><i>fork()</i> method causes a new task to be submitted to the pool and similar to the thread executor <i>submit()</i> method.</li>
<li><i>fork()</i> method should be called before the current thread performs a compute-operation, with <i>join()</i> called to read the results afterward</li>
<li><i>join()</i> method is called after the <i>fork()</i> method and causes the current thread to wait for the results of a subtask.</li>
<li>Unlike <i>fork()</i>, calling <i>compute()</i> within a compute() method causes the task to wait for the results of the subtask.</li>
<li>So right order is to fork first part of the task (by submitting to the pool) and compute later part of task under current thread, and then call join method on first part of the task to get collected result. </li>
</ul>

<b>Side note</b>
<ul>
<li><i>fork()</i> is called before the current thread begins a subtask</li>
<li><i>join()</i> is called after it finishes retrieving the results, in order for them to be done in parallel.</li>
</ul>
```Java
// Calling join immediately after fork will make current thread to wait for it. 
// meaning that it will be executed in single thread manner
Double partialResult = firstPartialRecursiveTask.fork().join();

// Appropriate order to take advantage of parallelism should be as below:
firstPartialRecursiveTask.fork();
Double finalResult = secondPartialRecursiveTask.compute() + firstPartialRecursiveTask.join();
```
