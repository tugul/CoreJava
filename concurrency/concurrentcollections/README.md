Concurrent Collections
---
Synchronization protects data integrity at the price of performance. Concurrent collections provide performance enhancements that prevent unnecessary synchronizations. Read/write accesses to collection are synchronized so that data consistency is kept during multi-thread execution outside synchronized method or block. 

However, if all threads access to immutable or read-only collection, it is unnecessary to use concurrent collections. 

Concurrent collection classes
---
<ul>
<li>ConcurrentHashMap</li>
<li>ConcurrentLinkedDeque</li>
<li>ConcurrentLinkedQueue</li>
</ul>

<ul>
<li>ConcurrentSkipListMap</li>
<li>ConcurrentSkipListSet</li>
</ul>

<ul>
<li>CopyOnWriteArrayList</li>
<li>CopyOnWriteArraySet</li>
</ul>

<ul>
<li>LinkedBlockingDeque</li>
<li>LinkedBlockingQueue</li>
</ul>

**Blocking queue and deque**<br>
They are just like regular queue and deque except for their additional methods which wait for the specified amount of time 
to complete read/write action to collection. In other words, they block access (using lock) to data which comes at performance cost. They throw ___InterruptedException___ if the thread is interrupted while waiting.

***BlockingQueue***<br>
<i>offer(E e, long timeout, TimeUnit)</i> - add item waiting for specified time, returns false if timeout elapsed  
<i>poll(long timeout, TimeUnit)</i> - take/remove item from queue waiting for specified time, returns null if time elapsed. <br>

***BlockingDeque***<br>
<i>offerFirst(E e, long timeout, TimeUnit)</i><br>
<i>offerLast(E e, long timeout, TimeUnit)</i><br>
<i>pollFirst(long timeout, TimeUnit)</i><br>
<i>pollLast(long timeout, TimeUnit)</i><br>

Parallel stream
---
It is a stream that can process results simultaneously by using multiple threads. Although performance increase can be achieved, it can change the result unexpectedly if not used carefully. 

When using reduce() method on parallel streams, it is good to note that although the 1 and 2 argument reduce() methods support parallel processing, it is recommended to use the 3-argument version of reduce() when working with parallel streams. To do that, we have to define <b>Identity</b>, <b>Accumulator</b> or <b>Combiner</b> as a argument. Then using parallel stream will result consistent and ordered output. It is same for 3-argument version of collect() method.

