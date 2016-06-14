Concurrency API(java.util.concurrent package) was initially introduced in Java 5 
to ease threads management and since then enriched so much with many classes and framework.  

Runnable 
----
functional interface used to defined a work/task that thread will execute 
has functional method void run() takes no argument.

Callable
----
functional interface used to defined a work/task that thread will execute 
has functional method call() takes no argument, returns Future object and can throw checked Exception

ExecutorService
----
interface with methods to take/execute tasks and provides many useful features (thread pooling, scheduling etc.)
extends functional interface Executor which has void execute(Runnable) method

Future class
----
represents a result of an asynchronous task completion
method get() infinitely waits for the task to complete and returns value resulted once the task is finished
method get(long, TimeUnit) waits for the result only for specified period and throws TimeOutException if didn't get
method cancel(boolean) attempts to cancel running task and returns boolean
method isCancelled() returns true if the task is cancelled before completed 
method isDone() returns true if the task is completed 

Shutting down Thread
----
It is necessary to shut down the service instance(call shutdown()), otherwise application will hang.
Once it is requested to shutdown, executor rejects new task requests and throws RejectedExecutionException and 
continues executing pending/ongoing tasks till completed. During this period, isShutdown() returns true and isTerminated()
 returns false. When ongoing tasks are completed, isShutdown() and isTerminated() methods return true and won't receive new tasks.
 shutDownNow() terminates all running/pending tasks and returns List<Runnable> which are not executed tasks.
 awaitTermination(long, TimeUnit) waits for specified period to complete ongoing tasks after shutdown request and returns
 true if executor terminated or false if timeout elapsed before termination. It doesn't do anything except for waiting.  
   
Scheduling Tasks
---
ScheduledExecutorService is used to schedule a task to execute after delay or repeatedly with time interval
It extends ExecutorService interface and its instance is taken from factory method in Executors helper class


Pause execution
----
Thread.sleep(long) pauses current thread to suspend its execution for certain period
It throws checked exception, InterruptedException if interrupt request is received while pausing

CyclicBarrier class 
---
used to force a set of threads to wait until they are at a certain stage of execution before continuing.

Threading problems
---
 Deadlock - two ore more processes are blocked forever, each waiting on the other
 Starvation - single thread is perpetually denied access to a shared resource or lock. 
              The thread is still active, but it is unable to complete its work as a result of other
              threads constantly taking the resource that they trying to access.
 Livelock - occurs when two or more threads are conceptually blocked forever, although they
            are each still active and trying to complete their task. Livelock is a special case of resource
            starvation in which two or more threads actively try to acquire a set of locks, are unable to
            do so, and restart part of the process.
 Race condition - It occurs when two threads execute at the same time, resulting in an unexpected outcome. 

 
 
